var playbackRate = 1;
var volume = 10;
var showContent;
function showPlayMsg(content) {
    layer.msg(showContent, {
        time: 2000, //2秒关闭（如果不配置，默认是3秒）
        offset: '5px'
    });
}

var GLOBAL_ACTIONS = {
    'play': function () {
        wavesurfer.playPause();
        var playing = wavesurfer.isPlaying();

        if (playing) {
            // $('[data-action="play"]').attr("data-original-title", "Playing").tooltip('show');
            showContent = "Playing";
        } else {
            // $('[data-action="play"]').attr("data-original-title", "Paused").tooltip('show');
            showContent = "Paused";
        }
        showPlayMsg(showContent);
    },


    'back': function () {
        wavesurfer.skipBackward();
        showContent = "Backward 2 Second";
        // $('[data-action="back"]').attr("data-original-title", "Backward Play").tooltip('show');
        showPlayMsg(showContent)
    },

    'forth': function () {
        wavesurfer.skipForward();
        showContent = "Forward 2 Second";
        showPlayMsg(showContent);
        // $('[data-action="forth"]').attr("data-original-title", "Forth Play").tooltip('show');

    },
    'fast-backward': function () {
        if (playbackRate > 0.5) {
            playbackRate -= 0.1;
        }
        wavesurfer.setPlaybackRate(playbackRate);
        showContent = "Speed x" + playbackRate.toFixed(1);
        showPlayMsg(showContent);
        /* $('[data-action="fast-backward"]').attr("data-original-title", "speed x" + playbackRate).tooltip('show');
         $('[data-action="fast-forward"]').attr("data-original-title", "speed x" + playbackRate)*/
    },
    'fast-forward': function () {
        if (playbackRate < 1.8) {
            playbackRate += 0.1;
        }
        wavesurfer.setPlaybackRate(playbackRate);
        showContent = "Speed x" + playbackRate.toFixed(1);
        showPlayMsg(showContent);
        /*  $('[data-action="fast-forward"]').attr("data-original-title", "speed x" + playbackRate).tooltip('show');
         $('[data-action="fast-backward"]').attr("data-original-title", "speed x" + playbackRate)*/
    },

    'volume-up': function () {
        if (volume < 10) {
            volume += 1;
        }
        wavesurfer.setVolume(volume / 10);
        showContent = "Volume:" + volume * 10 + "%";
        showPlayMsg(showContent);
        /* $('[data-action="volume-up"]').attr("data-original-title", "volume:" + volume * 10 + "%").tooltip('show');
         $('[data-action="volume-down"]').attr("data-original-title", "volume:" + volume * 10 + "%")*/
    },

    'volume-down': function () {
        if (volume > 0) {
            volume -= 1;
        }
        wavesurfer.setVolume(volume / 10);
        showContent = "Volume:" + volume * 10 + "%";
        showPlayMsg(showContent);
        /* $('[data-action="volume-up"]').attr("data-original-title", "volume:" + volume * 10 + "%");
         $('[data-action="volume-down"]').attr("data-original-title", "volume:" + volume * 10 + "%").tooltip('show')*/
    },

    'toggle-mute': function () {
        wavesurfer.toggleMute();
        showContent = "Volume:" + 0 + "%";
        showPlayMsg(showContent);
        /*  $('[data-action="volume-up"]').attr("data-original-title", "volume:" + volume * 10 + "%");
         $('[data-action="volume-down"]').attr("data-original-title", "volume:" + volume * 10 + "%")*/
    },

    'channel-l-ch': function () {//left
        wavesurfer.setChannel(0);
        showContent = "Left Chanel";
        showPlayMsg(showContent);
        // $('[data-action="volume-up"]').attr("data-original-title", "volume:" + volume * 10 + "%");

    },
    'channel-r-ch': function () {//right
        showContent = "Right Chanel";
        showPlayMsg(showContent);
        wavesurfer.setChannel(1);
    },
    'channel-s-ch': function () {//stereo
        showContent = "Stereo";
        showPlayMsg(showContent);
        wavesurfer.setChannel(-1);
    },
    'showVideo': function () {//视屏播放Panel 控制
        toggleLeftRight();

    },
    'hide-player': function () {//视屏播放Panel 控制
        wavesurfer.stop();
        $(".waveContent").slideUp(function () {
            hideVideoPanel();
        });
        $('.tagBox').addClass('no-width');
        var $tagBox = $('.tagBox');
        var $content = $('.content');
        resizeContent($tagBox, $content);
    }


};


// Bind actions to buttons and keypresses
document.addEventListener('DOMContentLoaded', function () {
    document.addEventListener('keydown', function (e) {
        var map = {
            32: 'play',       // space
            37: 'back',       // left
            38: 'volume',       // up
            39: 'forth',     // right
            40: 'volume-down'       // down
        };
        var action = map[e.keyCode];
        if (action in GLOBAL_ACTIONS) {
            if (document == e.target || document.body == e.target) {
                e.preventDefault();
            }
            GLOBAL_ACTIONS[action](e);
        }
    });

    [].forEach.call(document.querySelectorAll('[data-action]'), function (el) {
        el.addEventListener('click', function (e) {
            var action = e.currentTarget.dataset.action;
            if (action in GLOBAL_ACTIONS) {
                e.preventDefault();
                GLOBAL_ACTIONS[action](e);
            }
        });
    });
});


// Misc
document.addEventListener('DOMContentLoaded', function () {
    /*// Web Audio not supported
     if (!window.AudioContext && !window.webkitAudioContext) {
     var demo = document.querySelector('#demo');
     if (demo) {
     demo.innerHTML = '<img src="/example/screenshot.png" />';
     }
     }


     // Navbar links
     var ul = document.querySelector('.nav-pills');
     var pills = ul.querySelectorAll('li');
     var active = pills[0];
     if (location.search) {
     var first = location.search.split('&')[0];
     var link = ul.querySelector('a[href="' + first + '"]');
     if (link) {
     active = link.parentNode;
     }
     }
     active && active.classList.add('active');*/
    // console.log("Sorry , IE does not support the media player .")
});




