/*
* 定制化编写的wavesurfer扩展功能,用于展示不同时刻存在的tag信息
*
* 其他组件依赖:jquery.js wavesurfer.js bootstrap.css wavesurfer.tag.css
* */
(function(){
    var waveSurfer ;
    /**
     * 属性
     * container:tag组件容器dom对象
     * table:生成的table dom对象
     * data:当前应用的tag数据
     * @type {{fields: string[], initTable: (function(*): WaveSurfer.prototype.tag), load: (function(*): WaveSurfer.prototype.tag)}}
     */
    WaveSurfer.prototype.tag={
        fields:['Time','Tag','Comments'],
        /**
         params参数样例：{
                            container:'.tag-container',
                            waveSurfer:wavesurfer,
                            fields:['Time','Tags','Comments'],
                            hideFirstField:true,
                        }
         */
        initTable:function (params){
            // params.waveSurfer.play();
            if(!(params.waveSurfer)){
                console.error('Disappear WaveSurfer object')
                return;
            }
            waveSurfer = params.waveSurfer;
            this.container = 'string' == typeof params.container ? document.querySelector(params.container) : params.container;
            if (!this.container) {
                throw Error('No container for TAG');
            }
            var fields = this.fields;

            //create table
            var table = this.table = document.createElement('table');
            table.className = 'tag-table table table-striped table-hover';
            if(params.hideFirstField){
                table.classList.add('hide-first-field')
            }
            // head
            var thead = document.createElement('thead');
            var headRow = document.createElement('tr');
            thead.appendChild(headRow);
            table.appendChild(thead);
            fields.forEach(function (field,index) {
                var th = document.createElement('th');
                th.textContent = field;
                switch(index){
                    case 0:th.className='field-time'
                        break;
                    case 1:th.className='field-tags';
                        break;
                    case 2:th.className='field-comments'
                        break;
                }
                headRow.appendChild(th);
            });
            // body
            var tbody = document.createElement('tbody');
            tbody.id='table-body'
            table.appendChild(tbody);

            this.container.innerHTML = '';
            this.container.appendChild(table);
            this.tableBody = document.getElementById('table-body');
            this.table = table;
            // console.log('创建表格');

            //监听播放进度
            var _this = this;
            wavesurfer.on('audioprocess', function () {
                _selectTagRow(wavesurfer.getCurrentTime(),_this.data);
            });
            wavesurfer.on('seek', function () {
                _selectTagRow(wavesurfer.getCurrentTime(),_this.data);
            });
            return this;
        },
        load:function(data){
            if(!this.table){
                console.error("Please call method 'initTable' first.")
                return;
            }
            this.data=data;
            this.refresh();
            return this;
        },
        addTag:function (tagObj) {
            if(!this.data)this.data=new Array();
            this.data.push(tagObj);
            this.refresh();
        },
        refresh:function () {
            var tbody = this.tableBody
            tbody.innerHTML=''
            if(this.data){
                this.data.sort(_tagSort)
                this.data.forEach(function (row,index) {
                    var bodyRow = document.createElement('tr');
                    bodyRow.id='tag-row-'+index;
                    tbody.appendChild(bodyRow);
                    _appendRow(bodyRow,row);
                    _initEvent(bodyRow);
                });
            }
        }


    }

    function _appendRow(bodyRow,row){
        if(isNaN(row.time)){
            console.warn("The property of 'time' must be number format.")
            return ;
        }
        var time = row.time;
        var tags = row.tags?row.tags:[];
        var comments = 'string' == typeof row.comments? row.comments:'-';
        bodyRow.dataset.time=time;
        var time_th = document.createElement('td');
        time_th.className = 'tag-time'
        time_th.textContent = (Math.floor(parseFloat(time) * 100) / 100).toFixed(2);
        bodyRow.appendChild(time_th);

        var tags_th = document.createElement('td');
        tags.forEach(function (tag) {
            var span = document.createElement("span");
            span.className='item-tag';
            span.textContent=tag;
            tags_th.appendChild(span);
        });
        // tags_th.textContent = JSON.stringify(tags);
        tags_th.className='tag-tags'
        bodyRow.appendChild(tags_th);

        var comments_th = document.createElement('td');
        comments_th.textContent = comments;
        comments_th.className = 'tag-comments'
        bodyRow.appendChild(comments_th);
    };

    function _initEvent(bodyRow){
        bodyRow.onclick=function (e) {
            /*var time = this.dataset['time']
            waveSurfer.setCurrentTime(parseInt(time));*/
        }
        bodyRow.ondblclick=function (e) {
            var time = this.dataset['time']
            waveSurfer.setCurrentTime(parseFloat(time));
            // waveSurfer.play();
        }
    }

    function _tagSort(a,b){
        var a_time = parseFloat(a.time);
        var b_time = parseFloat(b.time);
        return a_time-b_time;
    }

    function _selectTagRow(time,data){
        if(data){
            var tagRow,index=data.length ;
            var time = parseFloat(time);
            for (var i in data){
                var item = data[i];
                var itemTime = parseFloat(item.time);
                if(time>=itemTime){
                    index = i;
                }else break;
            }
            tagRow = document.querySelector("#tag-row-"+index);
            if(tagRow){
                if(tagRow==waveSurfer.currentRow) return;
                if(waveSurfer.currentRow&&waveSurfer.currentRow!=tagRow){
                    waveSurfer.currentRow.classList.remove('success');
                }
                tagRow.classList.add('success')
                waveSurfer.currentRow = tagRow;

                var before= tagRow.previousSibling;
                if(before){
                    $(waveSurfer.tag.tableBody).scrollTop(before.offsetTop-before.offsetHeight)
                }else{
                    $(waveSurfer.tag.tableBody).scrollTop(0);
                }
            }else{
                if(waveSurfer.currentRow){
                    waveSurfer.currentRow.classList.remove('success');
                    waveSurfer.currentRow=undefined;
                }
            }

        }
    }
})()