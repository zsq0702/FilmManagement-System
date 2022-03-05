<template>
    <div class="main-show">
        <header id="film-header-nav">
            <!--整体头部div-->
            <div id="ui-container">
                <div id="header-nav-left">
                    <ul>
                        <li><router-link to="/Home" class="a">首页</router-link></li>

                        <li><router-link to="/Show" class="a">在线观影</router-link></li>
                        <li><router-link to="/MovieRange" class="a">排行榜</router-link></li>
                    </ul>
                </div>
                <div id="header-nav-right">

                    <ul>
                        <li><router-link to="/UserManage" class="a">用户管理</router-link></li>
                        <li><router-link to="/FilmManage" class="a">影片管理</router-link></li>
                        <li><router-link to="/UpLoad" class="a">上传</router-link></li>
                        <li><router-link to="/HistoryView" class="a">观看历史</router-link></li>
                        <li><router-link to="/JoinUs" class="a">加入我们</router-link></li>
                    </ul>
                </div>
            </div>
        </header>

        <div class="movie-container">
            <video-player class="video-player vjs-custom-skin"
                          ref="videoPlayer"
                          :playsinline="true"
                          :options="playerOptions"
                          @play="onPlayerPlay($event)"
                          @pause="onPlayerPause($event)">

            </video-player>
            <!--<div class="movie-container-right">-->


            <!--</div>-->
        </div>
        <div class="movie-show-title">

            <h2 class="title">反贪风暴4</h2>
            <div class="info">
                <p class="info2">
                    <span class="pingfen">待上映</span>
                </p>
            </div>
            <el-tag>电影</el-tag>
            <el-tag>华语</el-tag>
            <el-tag>香港地区</el-tag>

            <el-rate v-model="value"></el-rate>

        </div>
        <div class="movie-show-comment">

            <el-form>
                <el-input
                        type="textarea"
                        :rows="2"
                        placeholder="请输入内容"
                        v-model="textarea"
                        style="width:900px;margin-top: 10px;"
                >
                </el-input>
                <el-form-item style="margin-right:200px;">

                    <el-button >取消</el-button>
                    <el-button type="primary" @click="onSubmit" style="border:white;background: -webkit-linear-gradient(bottom,#444,gray,white) no-repeat;">发表评论</el-button>
                </el-form-item>

            </el-form>
            <h2 style="color:#eee"> 精彩评论(76)</h2>
            <ul class="list-group">
                <li class="list-group-item" v-for="item in list" :key="item.id">
                    <span class="badge">{{ item.user }} :  </span>
                    {{ item.content }}
                </li>
            </ul>
            <el-button type="primary" style="border:white;margin-right: 560px;width:140px;background: -webkit-linear-gradient(bottom,#444,gray,white) no-repeat;">
                加载更多评论<i class="el-icon-arrow-down el-icon--right"></i>
            </el-button>

        </div>
        <footer class="movieshow-footer-nav">

            <div class="footer">
                <a href="#"><p class="footer-p"><span class="footer-span">
                    公司介绍
                </span>
                </p>
                </a>
                <a href="#"><p class="footer-p"><span class="footer-span">
                    新闻动态
                </span>
                </p>
                </a>
                <a href="#"><p class="footer-p"><span class="footer-span">
                    联系方式
                </span>
                </p>
                </a>
                <a href="#"><p class="footer-p"><span class="footer-span">
                    用户协议
                </span>
                </p>
                </a>
                <a href="#"><p class="footer-p"><span class="footer-span">
                    帮助中心
                </span>
                </p>
                </a>
                <a href="#"><p class="footer-p"><span class="footer-span">
                    隐私政策
                </span>
                </p>
                </a>
                <a href="#"><p class="footer-p"><span class="footer-span">
                    About Us
                </span>
                </p>
                </a>

            </div>


            <div class="footer-di">
                <p>北京动艺时光网络科技有限公司Copyright 2006-2020 Mtime.com Inc. All rights reserved.</p>
                <p>京ICP证050715号 网络视听许可证0108265号网络文化经营许可证广播电视节目制作经营许可证(京)字第1435号京公网安备：110105000744号</p>
            </div>
        </footer>
    </div>
</template>

<script>
    import {videoPlayer} from "vue-video-player"

    export default {
        name: "Show5",
        components:{
            videoPlayer
        },
        data(){
            return{
                videoUrl:[{"name":"视频5","url":require('../static/video/mv5.mp4'),
                    "image":require('../static/images/film5.jpg')}],
                playerOptions : {
                    playbackRates: [0.5, 1.0, 1.5, 2.0], //播放速度
                    autoplay: false, //如果true,浏览器准备好时开始回放。
                    muted: false, // 默认情况下将会消除任何音频。
                    loop: false, // 导致视频一结束就重新开始。
                    preload: 'auto', // 建议浏览器在<video>加载元素后是否应该开始下载视频数据。auto浏览器选择最佳行为,立即开始加载视频（如果浏览器支持）
                    language: 'zh-CN',
                    aspectRatio: '16:9', // 将播放器置于流畅模式，并在计算播放器的动态大小时使用该值。值应该代表一个比例 - 用冒号分隔的两个数字（例如"16:9"或"4:3"）
                    fluid: true, // 当true时，Video.js player将拥有流体大小。换句话说，它将按比例缩放以适应其容器。
                    sources: [{
                        type: "video/mp4",//这里的种类支持很多种：基本视频格式、直播、流媒体等，具体可以参看git网址项目
                        src: require('../static/video/mv5.mp4') //url地址
                    }],
                    poster: require('../static/images/film5.jpg'), //你的封面地址
                    // width: document.documentElement.clientWidth, //播放器宽度
                    notSupportedMessage: '此视频暂无法播放，请稍后再试', //允许覆盖Video.js无法播放媒体源时显示的默认信息。
                    controlBar: {
                        timeDivider: true,
                        durationDisplay: true,
                        remainingTimeDisplay: false,
                        fullscreenToggle: true  //全屏按钮
                    }
                },
                list: [
                    {id: Date.now(), user:'Kris馨儿', content: '本来没抱什么希望，但看完之后觉得还行，依旧一贯风格。'},
                    {id: Date.now(), user:'L罗大王', content:'“坐牢，是香港年轻人唯一的出路” 真是讽刺。'},
                    {id: Date.now(), user:'包子', content:'典型港片的套路，但是还是看得很开心，熟悉的TVB黄金配角们，每一个眼神都那么入戏。'}
                ],
            }

        },
    }
</script>

<style scoped>

    .main-show{
        padding: 0px;
        background: -webkit-linear-gradient(bottom,#444,gray,white) no-repeat;
        width:1510px;


    }
    .el-button{
        margin-top: 10px;
        width:100px;
        height:40px;
        font-size: 15px;
        float: right;
        margin-left: 5px;
    }
    .el-tag{
        color: black;
        margin: 15px 5px 5px 5px;
    }
    .el-rate{
        margin: 20px 5px 5px 15px;
    }
    .movie-container{
        width:1260px;
        height:570px;
        display: flex;
        background-color: black;
        margin-left: 120px;
        margin-top: 5px;


    }
    .video-player{
        width: 1000px;
        height:565px;

        margin: 5px 130px 5px 130px;
    }
    .movie-show-title{
        height:60px;
        width:1260px;
        margin-left: 120px;
        background-color: #444;
        display: flex;
    }
    .title{

        background-color: #444;
        /*margin-top: 0px;*/
        /*margin-bottom: 0px;*/
        margin: 5px 5px 5px 5px;
        font-size: 30px;
        color: #eee;

    }
    .info{
        background-color: #444;
        margin: 10px 5px 5px 5px;

    }
    .info p{
        margin: 0;
        padding: 5px;
    }
    .pingfen{
        color: red;
        font-size:25px;
        font-weight: bold;
    }

    .movie-show-comment{
        height:400px;
        width:1260px;
        margin-left: 120px;
        background-color: black;
    }


    /*.movie-container-right{*/
    /*width:250px;*/
    /*height: 560px;*/
    /*background-color: #444;*/
    /*margin: 5px 5px 5px 0px;*/
    /*}*/
    .movieshow-footer-nav{
        width: 1528px;
        height: 50px;
        background-color: black;
        /*position: absolute;*/
        z-index: 80;
        bottom: 0;
        /*阴影*/
        box-shadow: 10px 10px 20px black;
        text-align: center;
        position: relative;
        margin-bottom: 0px;
    }
    .footer{
        background-color: black;
        /*list-style: none;*/
        width: 1000px;
        height:40px;
        margin-left: 300px;
        /*font-size: 15px;*/
        display: flex;
        /*float: left;*/
        justify-content: space-between;


    }
    .footer-p{
        text-decoration: none;
    }
    .footer-span{
        color: white;
        font-size: 15px;
        /*text-decoration: none;*/
    }
    .footer-di{
        margin-bottom: 0px;
        background-color: black;
        width:100%;
        height:50px;
    }
    .footer-di p{
        color: white;

        font-size: 10px;

    }

    .list-group-item{
        list-style: none;
        font-size: 17px;
        color: white;
        display: flex;
        margin-left: 150px;
        line-height: 40px;

    }

</style>