var $table = $('#table');
var played = 0;
var currentRow;
var $elementVal;
var showVideoPanel = 0;//右侧视频播放面板，1表示显示，0表示隐藏
$(document).ready(function () {
    historyQueryData();
});
function createNewOptionHQD(Obj, array) {
    for (var i = 0; i < array.length; i++) {
        var option = document.createElement('option');
        option.value = array[i].name;
        option.text = array[i].name;
        try {
            Obj.add(option, null); // standards compliant
        }
        catch (ex) {
            Obj.add(option); // IE only
        }
    }
}
window.operateEvents = {
    'click .Download': function (e, value, row, index) {
        layer.open({
            type: 2,
            title: $.i18n.prop('Download.Option'),
            shadeClose: true,
            closeBtn: 1,
            isOutAnim: false,
            shade: 0.5,
            zIndex: 1000,
            skin: 'layui-layer-rim', //加上边框
            maxmin: false, //开启最大化最小化按钮
            area: ['65%', '76%'],
            content: 'toDownload?callreference=' + row.callreference + '&type=' + row.calltype
        });
    },

    'click .audio': function (e, value, row, index) {
        checkAuthority(row, $("tr[data-index='" + index + "']"))
    },
    'click .screen': function (e, value, row, index) {
        window.open('../toScreenVideo?callReference=' + row.callreference + '&createTime=' + row.createtime);
    },'click .only-screen': function (e, value, row, index) {
        window.open('../toScreenVideo?callReference=' + row.callreference + '&createTime=' + row.createtime);
    },
    'click .video': function (e, value, row, index) {
        window.open('../toVideo?callReference=' + row.callreference + '&createTime=' + row.createtime);
    },
    'click .email': function (e, value, row, index) {
        layer.open({
            type: 2,
            title: $.i18n.prop('Send.Email'),
            shadeClose: true,
            closeBtn: 1,
            isOutAnim: false,
            shade: 0.5,
            zIndex: 1000,
            skin: 'layui-layer-rim', //加上边框
            maxmin: false, //开启最大化最小化按钮
            area: ['65%', '76%'],
            content: 'toEmail?callreference=' + row.callreference + '&type=AUDIO'
        });
    },
    'click .tag': function (e, value, row, index) {
        wavesurfer.pause();
        layer.open({
            type: 2,
            title: $.i18n.prop('Call-Tag'),
            shadeClose: true,
            isOutAnim: false,
            closeBtn: 1,
            shade: 0.5,
            zIndex: 1000,
            skin: 'layui-layer-rim', //加上边框
            maxmin: false, //开启最大化最小化按钮
            area: ['65%', '76%'],
            content: 'toCallTag?callreference=' + row.callreference + "&currentTime=" + wavesurfer.getCurrentTime(),
            end: function () {
                wavesurfer.playPause();
            }
        });
    },
    'click .transfer': function (e, value, row, index) {

    },
    'click .speechRec': function (e, value, row, index) {

    },
    //删除录音记录
    'click .remove': function (e, value, row, index) {
        layer.confirm($.i18n.prop('are.you.sure.to.delete.this.item'), {
                btn: [$.i18n.prop('yes'), $.i18n.prop('no')], //按钮
                shadeClose: true,
                isOutAnim: false,
                title: $.i18n.prop('confirm')
            }, function () {
                $.ajax
                ({
                    type: "DELETE",
                    url: "info/" + row.callreference,
                    async: false,
                    success: function (data) {
                        showToastr("success", $.i18n.prop('Record ') + row.callreference + $.i18n.prop('successfully.deleted'));
                        $table.bootstrapTable('refresh', {
                            url: $("advanceFormId").attr('action')
                        });
                        layer.closeAll();
                    },
                    error: function () {
                        showToastr("warning", $.i18n.prop('Record ') + row.callreference + $.i18n.prop('failed.deleted'));
                    }
                });

            }
        )

    }
};


/*table url参数*/
function queryParams(finalParams) {
    var $form = $("#advanceFormId");
    var wholeTimeStamp = $('#time-range span').text();
    var fromTimeStampVal = wholeTimeStamp.substring(0, 16) + ":00";
    var toTimeStampVal = wholeTimeStamp.substring(19, 35) + ":59";
    var data = $form.serializeArray(10);
    var exts = $('#extensionsText').val();
    var agents = $('#agentsText').val();
    var navSelect = $("#nav-select").val();
    var radiosE = $('input[name="optionsRadiosE"]:checked').val()
    var radiosA = $('input[name="optionsRadiosA"]:checked').val()
    var groupIdE = $('#groupsE option:selected').val();
    var groupE = $('#groupsE option:selected').text();
    var groupIdA = $('#groupsA option:selected').val();
    var groupA = $('#groupsA option:selected').text();
    // var agent = new Array(0);
    // var extension = new Array(0);

    // var allCheckedAgent = $.jstree.reference('#agent-container').get_bottom_checked(true);
    // var allCheckedAgent = null;
    // var allCheckedExt = $.jstree.reference('#ext-container').get_bottom_checked(true);
    // var allCheckedExt = null;
    // var extActive = $("#ext-tab").hasClass("active");
    // var agentActive = $("#agent-tab").hasClass("active");
    //
    // if (extActive) {
    //     allCheckedExt.forEach(function (value, index, array) {
    //         var extName = value.text;
    //         extension.push(extName);
    //
    //     });
    // }
    // if (agentActive) {
    //     allCheckedAgent.forEach(function (value, index, array) {
    //         var agentName = value.text;
    //         agent.push(agentName);
    //     });
    // }
    var params = "{";
    for (var i = 0; i < data.length; i++) {
        if (data[i].value != null && data[i].value != undefined && data[i].value != "") {
            params = params + "\"" + data[i].name + "\"" + ":" + "\"" + data[i].value + "\"";
            if (i < data.length - 1) {
                params += ",";
            }
        }
    }
    var lastChar = params.charAt(params.length - 1);
    if (',' == lastChar) {
        params = params.substring(0, params.lastIndexOf(","));
    }
    params += "}";
    var jsonData = JSON.parse(params);
    jsonData.navSelect = navSelect;
    if ("ext" == navSelect) {
        jsonData.exts = exts;
        jsonData.radio = radiosE;
        jsonData.group = groupE;
        jsonData.groupId = groupIdE;
    } else if ("age" == navSelect) {
        jsonData.agents = agents;
        jsonData.radio = radiosA;
        jsonData.group = groupA;
        jsonData.groupId = groupIdA;
    }
    // jsonData.ext = extension;
    // jsonData.agent = agent;
    jsonData.minStartTime = fromTimeStampVal;
    jsonData.maxStartTime = toTimeStampVal;
    jsonData.order = finalParams.order;
    jsonData.offset = finalParams.offset;
    jsonData.limit = finalParams.limit;
    jsonData.sort = finalParams.sort;
    finalParams = jsonData;
    return finalParams; // body data
}


function detailFormatter(index, row) {
    var html = [];
    $.each(row, function (key, value) {
        if ('callreference' == key || 'voiceid' == key || 'channelId' == key || 'deviceId' == key) {
            if ('callreference' == key) {
                key = 'ReferenceID'
            } else if ('voiceid' == key) {
                key = 'ServerID'
            } else if ('channelId' == key) {
                key = ''
            } else if ('deviceId' == key) {
                key = ''
            }
            html.push('<p><b>' + key + ':</b> ' + value + '</p>');
        }
    });
    return html.join('');
}
function typeFormatter(index, row) {
    var typeContent;
    switch (row.calltype) {
        case 1://录音
            typeContent = '<a class="audio" href="javascript:void(0)" title="' + $.i18n.prop('Audio.Record') + '">' +
                '<i class="fa fa-phone fa-lg"></i>' +
                '</a>';
            break;
        case 2://录屏通话
            typeContent = '<a class="screen" href="javascript:void(0)" title="' + $.i18n.prop('Screen.Record') + '">' +
                '<i class="fa fa-desktop "></i>' +
                '</a>';
            break;
        case 3://视频通话
            typeContent = '<a class="video" href="javascript:void(0)" title="' + $.i18n.prop('Video.Record') + '">' +
                '<i class="fa fa-film"></i>' +
                '</a>';
            break;
        case 6://录屏无通话
            typeContent = '<a class="only-screen" href="javascript:void(0)" title="' + $.i18n.prop('OnlyScreen.Record') + '">' +
                '<i class="fa fa-laptop"></i>' +
                '</a>';
            break;
        case 99://艺赛旗
            typeContent = '<a class="screen" href="javascript:void(0)" title="' + $.i18n.prop('Screen.Record') + '">' +
                '<i class="fa fa-desktop "></i>' +
                '</a>';
            break;
        default:
            typeContent = '<a class="audio" href="javascript:void(0)" title="' + $.i18n.prop('Audio.Record') + '">' +
                '<i class="fa fa-phone fa-lg"></i>' +
                '</a>';
            break;
    }
    return [typeContent].join('');
}


function getRowSelections() {//返回选择的checkbox对应的media
    return $.map($table.bootstrapTable('getSelections'), function (row) {
        return row;
    });
}

function getSelectionsrowIndex() {//返回选择的checkbox对应的rowIndex
    var index = [];
    $('input[name="btSelectItem"]:checked').each(function () {
        index.push($(this).data('index'));
    });
    return index;
}


$("#play").click(function () {
    $("tr.success").removeClass('success');
    var currentSelection = getSelectionsrowIndex();
    var currentSelectionRow = getRowSelections();
    if (currentSelection.length == 0) {
        console.log("Please select media")
        return;
    }
    checkAuthority(currentSelectionRow[0], $("tr[data-index='" + currentSelection[0] + "']"));

})

$("#advanceId").click(function () {
    layer.open({
        type: 1,
        title: $.i18n.prop('Advance.Search'),
        shadeClose: true,
        shade: 0.5,
        isOutAnim: false,
        zIndex: 1000,
        skin: 'layui-layer-rim', //加上边框
        maxmin: false, //开启最大化最小化按钮
        area: ['80%', '93%'],
        content: $("#advanceModal")
    });
    GroupData();
    SystemData();
    // historyQueryData();
})



//监听export
$("#export").click(function () {
    $('[data-action="hide-topsBtn"]').tooltip('hide')
    $("tr.success").removeClass('success');
    var currentSelectionRow = getRowSelections();
    if (currentSelectionRow != null && currentSelectionRow.length > 0) {
        mediaExport(currentSelectionRow);
    } else {
        console.info("not selected")
    }
})
function mediaExport(row) {//发送export请求
    //先清空waveform
    wavesurfer.empty();
    var mediaIds = new Array();
    var mediaId;
    for (currIndex = 0; row.length > 0 && (currIndex + 1) <= row.length; currIndex++) {
        mediaId = row[currIndex].callreference;
        mediaIds.push(mediaId);
    }
    $.ajax({
        url: "../call/export?mediaIds=" + mediaIds + "&mediaType=MP3",
        type: "post",
        dataType: "json",
        success: function (data) {
            if (data == null || data == '' || data == undefined || data == 'null') {
                return;
            }
            if (data.location.length > 0) {
                for (var i = 0; i < data.location.length; i++) {
                    submitFrom(data.location[i]);
                }
            }
        },
        error: function () {
            showToastr("warning", $.i18n.prop('The.download.failed.to.load.resources'));
        }
    })
    // window.location =
}
function submitFrom(data) {
    // var $form = $('<form method="GET"></form>');
    // $form.attr('action', data);
    // $form.appendTo($('body'));
    // $form.submit();
    // window.location.href = data.location[i]
    window.open(data);
}

function directionFormatter(value, row, index) {
    if (row.direction == 'O' || row.direction == 'o' || row.direction == "2") {
        return '<i class="glyphicon glyphicon-log-out"></i>'
        // + "OUTGOING"
    } else if (row.direction == 'I' || row.direction == 'i' || row.direction == "1") {
        return '<i class="glyphicon glyphicon-log-in"></i>'
        // + "INCOMING"
    } else if (row.direction == 'U') {
        return "U";
    }
    else {
        return;
    }
}

function createFormatter(value, row, index) {
    return parseTime(row.createtime, 1);
}
function commonTimeFormatter(value, row, index) {
    return parseTime(row.cleartime, 0);
}

function durationformatter(value, row, index) {
    return parseDuration(row.duration);
}

function parseTime(time, type) {//return yyyy/mm/dd hh:mm:ss
    var time = new Date(time);
    var day = moment(time);
    var result = day.format("YYYY-MM-DD HH:mm:ss");
    var sWeek = day.format('dddd');//星期几
    if (type == 1) {
        switch (sWeek) {
            case 'Monday':
                sWeek = 'Mon.';
                break;
            case 'Tuesday':
                sWeek = 'Tues.';
                break;
            case 'Wednesday':
                sWeek = 'Wed.';
                break;
            case 'Thursday':
                sWeek = 'Thur.';
                break;
            case 'Friday':
                sWeek = 'Fri.';
                break;
            case 'Saturday':
                sWeek = 'Sat.';
                break;
            case 'Sunday':
                sWeek = 'Sun.';
                break;
            default:
                break;
        }
        result = result + " (" + sWeek + ")";
    }
    return result;

    /* var date = time.getFullYear() + "-" + parseZero(time.getMonth() + 1) + "-" + parseZero(time.getDate()) + " " + parseZero(time.getHours()) + ":" + parseZero(time.getMinutes()) + ":" + parseZero(time.getSeconds())
     return date;*/
}

function parseDuration(time) { //return hh:mm:ss
    curH = Math.floor(time / 60 / 60);
    curM = Math.floor((time - curH * 60 * 60) / 60);
    curS = Math.round(time - curH * 60 * 60 - curM * 60);
    if (curH < 10) {
        curH = '0' + curH;
    }
    if (curM < 10) {
        curM = '0' + curM;
    }
    if (curS < 10) {
        curS = '0' + curS;
    }
    return curH + ":" + curM + ":" + curS;
}

function parseZero(data) {
    if (data < 10) {
        return "0" + data;
    } else {
        return data;
    }
}


var cb = function (start, end, label) {
    $('#time-range span').html(start.format('YYYY-MM-DD HH:mm') + ' - ' + end.format('YYYY-MM-DD HH:mm'));
};
//            初始化国际化内容

var optionSet1 = {
    startDate: moment().startOf('Day'),
    endDate: moment().endOf('Day'),
    showDropdowns: true,
    showWeekNumbers: true,
    timePicker: true,
    timePickerIncrement: 1,
    alwaysShowCalendars: true,
    timePicker12Hour: false,
    // ranges: {
    //     'Today': [moment().startOf('Day'), moment().endOf('Day')],
    //     'Yesterday': [moment().subtract(1, 'days').startOf('Day'), moment().subtract(1, 'days').endOf('Day')],
    //     'Last 7 Days': [moment().subtract(6, 'days').startOf('Day'), moment().endOf('Day')],
    //     'Last 30 Days': [moment().subtract(29, 'days').startOf('Day'), moment().endOf('Day')],
    //     'This Month': [moment().startOf('month'), moment().endOf('month')],
    //     'Last Month': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
    // },
    opens: 'right',
    buttonClasses: ['btn btn-default'],
    applyClass: 'btn-sm btn-primary',
    cancelClass: 'btn-sm',
    format: 'MM/DD/YYYY',
    separator: ' to ',
};
$('#time-range span').html(moment().startOf('Day').format('YYYY-MM-DD HH:mm') + ' - ' + moment().endOf('Day').format('YYYY-MM-DD HH:mm'));

$('#time-range').daterangepicker(optionSet1, cb);

$('#time-range').on('show.daterangepicker', function () {
    console.log("show event fired");
});
$('#time-range').on('hide.daterangepicker', function () {
    $table.bootstrapTable('refresh', {
        url: $("advanceFormId").attr('action')
    });
});
$('#time-range').on('apply.daterangepicker', function (ev, picker) {
    $('#time-range3 span').html(picker.startDate.format('YYYY-MM-DD HH:mm') + " - " + picker.endDate.format('YYYY-MM-DD HH:mm'));
    $("#clickRange").attr("value", getCalendarTime(picker));
    console.log("apply event fired, start/end dates are "
        + picker.startDate.format('YYYY-MM-DD HH:mm')
        + " to "
        + picker.endDate.format('YYYY-MM-DD HH:mm')
    );
});
$('#time-range').on('cancel.daterangepicker', function (ev, picker) {
    console.log("cancel event fired");
});

function getCalendarTime(picker) {
    if (moment(picker.startDate).isSame(moment().startOf('Day')) && moment(picker.endDate).isSame(moment().endOf('Day'))) {
        return "Today"
    } else if (moment(picker.startDate).isSame(moment().subtract(1, 'days').startOf('Day')) && moment(picker.endDate).isSame(moment().subtract(1, 'days').endOf('Day'))) {
        return "Yesterday";
    } else if (moment(picker.startDate).isSame(moment().subtract(6, 'days').startOf('Day')) && moment(picker.endDate).isSame(moment().endOf('Day'))) {
        return "Last 7 Days";
    } else if (moment(picker.startDate).isSame(moment().subtract(29, 'days').startOf('Day')) && moment(picker.endDate).isSame(moment().endOf('Day'))) {
        return "Last 30 Days";
    } else if (moment(picker.startDate).isSame(moment().startOf('month')) && moment(picker.endDate).isSame(moment().endOf('month'))) {
        return "This Month";
    } else if (moment(picker.startDate).isSame(moment().subtract(1, 'month').startOf('month')) && moment(picker.endDate).isSame(moment().subtract(1, 'month').endOf('month'))) {
        return "Last Month";
    } else {
        return "Custom";
    }
    ;
}

//播放器


var wavesurfer;
var trueTimeline,tagObj;
var startTime = "2019-04-23 10:08:38";
window.onload = function () {
    wavesurfer = WaveSurfer.create({
        container: document.querySelector('#waveform'),
        splitChannels: true,
        // waveColor: 'purple',
        waveColorArr: ['red','purple'],
        responsive:true,
        hideScrollbar:true,
        height:50,
        plugins: [
            WaveSurfer.timeline.create({
                container: "#wave-timeline",
            }),
            WaveSurfer.timeline1.create({
                container: "#wave-trueTimeline",
                formatTimeCallback: formatTimeCallback
            })
        ]
    });

    if(lang=='zh'){
        WaveSurfer.prototype.tag.fields=['时刻','标签','说明']
    }
    //加载tag插件
    tagObj = wavesurfer.tag.initTable({
        container:'.tag-container',
        waveSurfer:wavesurfer,
        hideFirstField:true,
    })/*.load(
        [
            {time:'10.1',tags:['good'],comments:'It work'},
            {time:'30',tags:['good','beautiful'],comments:'It work'},
            {time:'50',tags:['good','beautiful'],comments:'It work'},
            {time:'55',tags:['good','beautiful'],comments:'It work'},
            {time:'70',tags:['good','beautiful'],comments:'It work'},
            {time:'78',tags:['good','beautiful'],comments:'It work'},
            {time:'140',tags:['good','beautiful'],comments:'It work'},
            {time:'170',tags:['good','beautiful'],comments:'It work'},
            {time:'190',tags:['good','beautiful'],comments:'It work'},
        ]
    )*/;


    wavesurfer.on('ready', function () {
        $(".waveContent").slideDown();
        $(window).trigger("resize");
        wavesurfer.drawBuffer();
        wavesurfer.play();
        played = 1;
    });

    // Do something when the clip is over
    wavesurfer.on('finish', function () {
        playNextAudio();
    });


    function playNextAudio() {//逻辑:如果当前录音只有一个media,那么选择下一行录音继续;如果有多个media文件,则播放下一个media,直到media都播完,选择下一行录音继续
        var curRow = $("tr.success").attr('data-index');//得到当前播放过的行下标
        var rows = getRowSelections();//得到所有选中的callId  [111,222,333,444,555]
        var index = $.inArray(Number(curRow), getSelectionsrowIndex());//当前播放在选中的位置
        // console.log("rows:" + rows.length);
        if (rows == "") {//双击执行播放,播放完
            return;
            /*   if (allMedias.length > 1 && (currIndex + 1) < allMedias.length) {
             currIndex++;
             /!*  if (allMedias[currIndex].mp3Name != null && allMedias[currIndex].mp3Name.length > 0) {
             justFindMediaToPlay();//虚拟路径下找media
             } else {
             generateMediaThenPlay(currRow);//生成media并播放
             }*!/
             }*/
        } else {//选择checkbox执行播放,播放完
            /*   var nextIndex;
             if (index == -1) {//当前播放未选中
             index = 0;
             }
             */
            var nextIndex = index + 1;//列表下条播放的index
            if (nextIndex >= rows.length) {
                return;
            }
            var nextRow = rows[nextIndex];
            var nextTrElement = $("tr[data-index='" + getSelectionsrowIndex()[nextIndex] + "']");
            //播放下一跳
            checkAuthority(nextRow, nextTrElement);
        }
    }


    //自适应
    var responsiveWave = wavesurfer.util.debounce(function () {
        wavesurfer.drawBuffer();
    }, 150);


    window.addEventListener('resize', responsiveWave);


    $table.bootstrapTable({
        height: getHeight()
    });
    $(window).resize(function () {
        $table.bootstrapTable('resetView', {
            height: getHeight()
        });

        var $tagBox = $('.tagBox');
        var $content = $('.table-view');
        resizeContent($tagBox, $content);

    });


    // $(".waveContent").slideDown();
    var $tagBox = $('.tagBox');
    var $content = $('.table-view');
    resizeContent($tagBox, $content);
    event();

}

function resizeContent($tagBox, $content) {
    var tagBoxWidth = $tagBox.width();
    var bodyWidth = $('body').width();
    var newContentWidth = (bodyWidth - tagBoxWidth) / bodyWidth * 100;
    $content.width(newContentWidth + '%');

    $table.bootstrapTable('resetView', {
        height: getHeight(),
    });
    // wavesurfer.drawBuffer();
}

function toggleTag(e){
    $('.tagBox').toggleClass('no-width');
    var $tagBox = $('.tagBox');
    var $content = $('.table-view');
    resizeContent($tagBox, $content);
    wavesurfer.drawBuffer();
}

var tagResizing = false;
function event() {
    $('.L').on('mousedown', function (e) {
        tagResizing = true;
        $('body').css('cursor','w-resize');
    })

    $(document).on('mouseup', function (e) {
        tagResizing = false;
        wavesurfer.drawBuffer();
        $('body').css('cursor','default');
    })
    $(document).on('mousemove', function (e) {
        if (tagResizing) {
            var pointX = e.pageX;
            var bodyWidth = $('body').width();
            var newTagWidth = bodyWidth - pointX;
            var $tagBox = $('.tagBox');
            $tagBox.width(newTagWidth);
            var $content = $('.table-view');
            resizeContent($tagBox, $content);
        }
    });

}






// Video 控制
var $table = $('#table');
var right = $("tb-right");
var $waveContent = $("#waveContent");
var sizeControle = $("#sizeControle");

//控制call 页面左右显示
var left = $(".tb-left");
var right = $(".tb-right");
var rightBody = $(".tb-pre-scrollable");

//控制视屏面板显示(加载视屏)/隐藏（关闭视屏）
function toggleLeftRight() {
    if (right.hasClass("hidden")) {//右侧视屏Pannel 已经隐藏，需要显示，并且压缩左侧
        showInitVideoPanel();
    } else {//右侧视屏Pannel 已经显示，需要隐藏，并且左侧最大化
        hideVideoPanel();
        $table.bootstrapTable({
            height: getHeight()
        });
    }

}

//右侧视屏处于隐藏状态，需要显示，并且左侧table 压缩
function showInitVideoPanel() {
    left.removeClass("col-lg-12").removeClass("col-md-12 hidden").addClass("col-lg-9").addClass("col-md-9");
    right.removeClass("hidden");
    rightBody.css("max-height", getHeight() - 70 + "px");
    $(window).trigger("resize");
    showVideoPanel = 1;
    //播放加载视屏
    loadVideo();
}

//隐藏videoPanel,table 部分最大化
function hideVideoPanel() {
    //TODO 停止播放视屏
    left.removeClass("col-lg-9").removeClass("col-md-9 hidden").addClass("col-lg-12").addClass("col-md-12");
    right.attr('class', function (i, cls) {
        return cls.replace(/class-\d+ /g, '');
    });
    right.addClass("hidden").addClass("col-lg-3 col-md-3");
    rightBody.css("max-height", getHeight() - 70 + "px");
    $table.bootstrapTable({
        height: getHeight()
    });
    $(window).trigger("resize");
    showVideoPanel = 0;


}

//展示videoPanel,table 宽度总宽度占比9/12
function showNormalVideoPanel() {
    right.removeClass("col-lg-12 col-md-12").addClass("col-lg-3 col-md-3");
    sizeControle.removeClass("glyphicon glyphicon-resize-small").addClass("glyphicon glyphicon-resize-full");
    sizeControle.attr("Enlarge");
    left.removeClass("hidden");
    rightBody.css("max-height", getHeight() - 70 + "px");
    $(window).trigger("resize");
    showVideoPanel = 1;

}
//恢复显示videoPanel,table 宽度总宽度占比9/12
function shwoMaxVideoPanel() {
    left.addClass("hidden");
    right.removeClass("col-lg-3 col-md-3").addClass("col-lg-12 col-md-12");
    sizeControle.removeClass("glyphicon glyphicon-resize-full").addClass("glyphicon glyphicon-resize-small");
    sizeControle.attr("Restore");
    rightBody.css("max-height", getHeight() - 70 + "px");
    $(window).trigger("resize");
    showVideoPanel = 1;
}


//    全屏设置
function toggleVideoPanel() {
    if (right.hasClass("col-lg-12")) {//video 已经最大化，需要还原到col-lg-3 col-md-3
        showNormalVideoPanel();
    } else {
        shwoMaxVideoPanel()

    }
}

function getHeight() {
    if ($waveContent.css("display") == 'none') {
        return $(window).height()
    } else {
        // console.log("tableHeight-165::" + ($(window).height() - 165));
        return $(window).height() - 165;
    }

}


function loadVideo() {
    var callreference = currentRow.callreference;
    $.ajax
    ({
        type: "GET",
        url: "info/" + callreference + "/info/video",
        async: true,
        success: function (data) {
            if (data == null || data == '' || data == undefined || data == 'null') {
                console.log("loadVideo::no video found...")
                return;
            }

            var $videoPanel = $("#panelBody");
            $videoPanel.html("");
            for (var key in data) {
                for (j = 0, len = data[key].length; j < len; j++) {
                    var videoInfo = data[key][j];
                    console.log("loadVideo::" + videoInfo);
                    $videoPanel.append("<div class='col-sm-12'><div class='contact-box'><div class='col-sm-12'>" +
                        " <h3><strong>" + key +
                        "</strong></h3>" +
                        "<video class='vcVideo' id='video" + key +
                        "' src='" + videoInfo.videoUrl +
                        "' controls='true'></video></div></div> <div class='clearfix'></div></div>"
                    )
                }
            }
        },
        error: function (data) {
            showToastr("warning", $.i18n.prop('The.player.failed.to.load.resources'));
        }
    });
}

//Video 控制结束

/**
 * 双击指定行
 */
$table.on('dbl-click-row.bs.table', function (e, row, $element) {//2个参数,用来处理逻辑
    checkAuthority(row, $element);
});

/**
 * 切换显示行数，重构页面布局
 */
$table.on('page-change.bs.table', function (number, size) {//2个参数,用来处理逻辑
    $(window).trigger("resize");
});
function checkAuthority(row, $element) {
    $elementVal = $element;
    currentRow = row;
    $.ajax({ // 请求 看session中的权限是否够
        url: "checkAuthority?extension=" + row.extension,
        dataType: "json",
        type: "get",
        success: function (data) {
            if (data.success) {
                playAudio(row, $element);
            } else {
                $('#validateExt').val(row.extension);
                $('#passwordId').val("");
                layer.open({
                    type: 1,
                    title: $.i18n.prop('validate'),
                    shadeClose: true,
                    shade: 0.5,
                    isOutAnim: false,
                    zIndex: 1000,
                    skin: 'layui-layer-rim', //加上边框
                    maxmin: false, //开启最大化最小化按钮
                    area: ['35%', '25%'],
                    content: $("#validateModal")
                });
            }
        }
    })
}
function playAudio(row, $element) {
    // currentRow = row;
    $('[data-action="hide-topsBtn"]').tooltip('hide')
    $("tr.success").removeClass('success');
    $($element).addClass('success');
    $(".tableContent").addClass('wavetale');
    // $(".waveContent").addClass('waveShow');
    // trueTimeline.params.createtime = row.createtime;

    $.ajax
    ({
        type: "POST",
        url: "info/" + row.callreference + "/audio",
        async: true,
        success: function (data) {
            if (data == null || data == '' || data == undefined || data == 'null') {
                // playNextAudio();

            }
            // var peaks = [data.peaks.peak0, data.peaks.peak1];
            // wavesurfer.load(data.location, peaks);
            if(data.success){
                if(data.location){
                    wavesurfer.load(data.location);
                }
            }else{
                showToastr("warning", $.i18n.prop('The.player.failed.to.load.resources'));
            }
            if(data.tagData)tagObj.load(data.tagData);


        },
        error: function (data) {
            showToastr("warning", $.i18n.prop('The.player.failed.to.load.resources'));
        }
    });
}
function selectCondition() {
    var conditionName = $("#selectTest2").val();
    $.ajax({
        url: "../historyQuery/selectHistoryQueryDataByName?conditionName=" + conditionName + "&time=" + new Date().getTime(),
        type: "GET",
        dataType: "json",
        success: function (data) {
            console.info("select Name selectCondition Data success.1" + data.length)
            if (data != null) {
                console.info("select Name selectCondition Data success.2")
                setTimeRange(data.calendarTime, data.minStartTime, data.maxStartTime);
                $("#direction").val(data.callBo.direction);
                $("#callType").val(data.callBo.calltype);
                $("#callerId").val(data.callBo.callerid);
                $("#calledId").val(data.callBo.calledid);
                $("#referenceId").val(data.callBo.callreference);
                $("#callTagValue").val(data.callTagValue);
                $("#durationS").val(data.durationS);
                $("#durationE").val(data.durationE);
                if ("ext" == data.navSelect) {
                    $("#nav-select").val("ext");
                    $('#advanceTab a[href="#ext-tab"]').tab('show');
                    $('#radio' + data.radio + 'E').prop('checked', true);
                    $('#radio' + data.radio + 'E').click();
                    if ("Extension" == data.radio) {
                        $("#extensionsText").val(data.extensions);
                    } else if ("Group" == data.radio) {
                        $("#groupsE").val(data.groupId);
                    }
                } else if ("age" == data.navSelect) {
                    $("#nav-select").val("age");
                    $('#advanceTab a[href="#agent-tab"]').tab('show');
                    $('#radio' + data.radio + 'A').prop('checked', true);
                    $('#radio' + data.radio + 'A').click();
                    if ("Agent" == data.radio) {
                        $("#agentsText").val(data.agents);
                    } else if ("Group" == data.radio) {
                        $("#groupsA").val(data.groupId);
                    }
                }
                $.ajax({
                    url: "getCalls",
                    data: JSON.stringify(data),
                    dataType: "json",
                    type: "POST",
                    success: function (data) {
                        $table.bootstrapTable('refresh', null);
                    },
                    error: function () {
                        console.log("error occur.")
                    }
                });
            }
        },
        error: function () {
            console.info("select Name selectCondition Data Error.")
        }
    })


}

function formatTimeCallback(seconds, pxPerSec) {
    seconds = Number(seconds);
    if (startTime) {
        var trueTime = ""
        var date = moment(startTime, "YYYY-MM-DD HH:mm:ss").add(seconds, "seconds");
        trueTime +=parseZero( date.hour())  + ":" + parseZero(date.minute() )+ ":" + parseZero(date.second());
        return trueTime;
    } else {
        if (seconds / 60 > 1) {
            // calculate minutes and seconds from seconds count
            var minutes = parseInt(seconds / 60, 10);
            seconds = parseInt(seconds % 60, 10); // fill up seconds with zeroes

            seconds = seconds < 10 ? '0' + seconds : seconds;
            return "".concat(minutes, ":").concat(seconds);
        }
        return Math.round(seconds * 1000) / 1000;
    }
}

function parseZero(data) {
    if (data < 10) {
        return "0" + data;
    } else {
        return data;
    }

}




