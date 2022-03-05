<template>
    <div id="main-show">

        <div class="film-container">

            <!--视频播放-->
            <div class="player" >
                <video-player class="video-player vjs-custom-skin"
                    ref="videoPlayer"
                :playsinline="true"
                :options="playerOptions"
                @play="onPlayerPlay($event)"
                @pause="onPlayerPause($event)">

                </video-player>
            </div>
        </div>
    </div>
</template>

<script>
    import {videoPlayer} from "vue-video-player"
    export default {
        name: "Show",
        components:{
          videoPlayer
        },
        data(){
          return{
              //保存或接收 视频地址  及   视频图片
              videoUrl:[{"name":"视频1","url":require('../../static/video/mv4.mp4')
                      ,"image":require('../../static/image/film4.jpeg')}],
              //进行video按钮设置
              playerOptions:{
                  playbackRates:[0.7,1.0,1.5,2.0],//播放速度
                  autoplay: false, //如果true,浏览器准备好时开始回放。
                  muted: false, // 默认情况下将会消除任何音频。
                  loop: false, // 导致视频一结束就重新开始。
                  preload: 'auto', // 建议浏览器在<video>加载元素后是否应该开始下载视频数据。auto浏览器选择最佳行为,立即开始加载视频（如果浏览器支持）
                  language: 'zh-CN',
                  aspectRatio: '16:9', // 将播放器置于流畅模式，并在计算播放器的动态大小时使用该值。值应该代表一个比例 - 用冒号分隔的两个数字（例如"16:9"或"4:3"）
                  fluid: true, // 当true时，Video.js player将拥有流体大小。换句话说，它将按比例缩放以适应其容器。
                  sources: [{
                      type: "video/mp4",//这里的种类支持很多种：基本视频格式、直播、流媒体等，具体可以参看git网址项目
                      src: require('../../static/video/mv4.mp4') //url地址
                  }],
                  poster: require('../../static/image/film4.jpeg'), //你的封面地址
                  // width: document.documentElement.clientWidth, //播放器宽度
                  notSupportedMessage: '此视频暂无法播放，请稍后再试', //允许覆盖Video.js无法播放媒体源时显示的默认信息。
                  controlBar: {
                      timeDivider: true,
                      durationDisplay: true,
                      remainingTimeDisplay: false,
                      fullscreenToggle: true  //全屏按钮
                  }
              },

              filmId:'',//用于录入电影编号，查询
              filmInfo:{},//用于接收  数据
          }
        },
        methods:{
          //点击事件
            searchFilm(){
                console.log(this.filmId);
                let path = `http://localhost:8090/film/json/film/showFilm/${this.filmId}`;
                console.log("获取数据");
                this.axios.get(path).then(res=>{
                    console.log("success");
                    console.log(res);
                    //如果后台返回结果 不一样，那么  res. 的内容 根据情况而变
                    this.filmInfo = res.data;//由于数据在data 里，直接将所有返回信息给filmInfo对象
                    console.log(this.filmInfo);
                    //由于axios 是异步加载   那么  代码块如果在 then 之外  可能会同时加载，导致数据读取为空
                    console.log(this.filmInfo.filmVideoUrl);
                    console.log(this.filmInfo.filmImageMain);
                    //通过axios 获取到服务器数据后，切换显示内容
                    this.playerOptions.sources[0].src = this.filmInfo.filmVideoUrl;
                    this.playerOptions.poster=this.filmInfo.filmImageMain;

                });

            }
        },
    }
</script>

<style scoped>
#main-show{
    margin-top: 100px;
    height: 600px;
    width: 1510px;
    background: -webkit-linear-gradient(bottom,#444,gray,white) no-repeat;
}
    .player{
        width: 60%;
        height: 300px;
        margin-left: 300px;
    }
</style>