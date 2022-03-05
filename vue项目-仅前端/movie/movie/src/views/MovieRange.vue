<template>
    <div class="movie-range">
        <header class="movierange-header-nav">
            <!--整体头部div-->
            <div class="ui-container">
                <div class="header-nav-left">
                    <ul>
                        <li><router-link to="/Home" class="a">首页</router-link></li>

                        <li><router-link to="/Show" class="a">在线观影</router-link></li>

                        <li><router-link to="/MovieRange" class="a">排行榜</router-link></li>
                    </ul>
                </div>
                <div class="header-nav-right">

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
        <div class="range-page">
            <h1>热播排行榜</h1>
            <hr>

            <div class="movie-list">


                <div class="movie-item">
                    <div class="movie-item-range">
                        <p>#1</p>
                    </div>
                    <div class="movie-item-img">

                        <router-link to="/FilmDetail2">
                            <img src="../static/images/film7.jpg" alt=""/>
                        </router-link>
                    </div>
                    <div class="movie-item-info">

                        <h2 class="title">冰雪奇缘2</h2>

                        <div class="info">
                            <router-link to="/Show">
                                <i class="el-icon-video-play" style="font-size: 30px;float: left;margin-left: 20px"></i>
                            </router-link>
                            <p class="info1">
                                <span class="beizhu">动画巨制再续传奇</span>
                            </p>
                            <p class="info2">

                                <span class="pingfen">8.3</span>
                            </p>
                        </div>


                    </div>
                </div>
                <div class="movie-item">
                    <div class="movie-item-range">
                        <p>#2</p>
                    </div>
                    <div class="movie-item-img">

                        <router-link to="/FilmDetail1">
                            <img src="../static/images/film6.jpg" alt=""/>
                        </router-link>
                    </div>
                    <div class="movie-item-info">

                        <h2 class="title">天 火</h2>

                        <div class="info">
                            <router-link to="/Show">
                                <i class="el-icon-video-play" style="font-size: 30px;float: left;margin-left: 20px"></i>
                            </router-link>
                            <p class="info1">
                                <span class="beizhu">王学圻昆凌绝境冒险</span>
                            </p>
                            <p class="info2">

                                <span class="pingfen">8.2</span>
                            </p>
                        </div>


                    </div>
                </div>
                <div class="movie-item">
                    <div class="movie-item-range">
                        <p>#3</p>
                    </div>
                    <div class="movie-item-img">

                        <router-link to="/FilmDetail3">
                            <img src="../static/images/film8.jpg" alt=""/>
                        </router-link>
                    </div>
                    <div class="movie-item-info">

                        <h2 class="title">天使陷落</h2>

                        <div class="info">
                            <router-link to="/Show">
                                <i class="el-icon-video-play" style="font-size: 30px;float: left;margin-left: 20px"></i>
                            </router-link>
                            <p class="info1">
                                <span class="beizhu">落难英雄绝境重生</span>
                            </p>
                            <p class="info2">

                                <span class="pingfen">8.2</span>
                            </p>
                        </div>


                    </div>
                </div>
                <div class="movie-item">
                    <div class="movie-item-range">
                        <p>#4</p>
                    </div>
                    <div class="movie-item-img">

                        <router-link to="/FilmDetail4">
                            <img src="../static/images/film9.jpg" alt=""/>
                        </router-link>
                    </div>
                    <div class="movie-item-info">

                        <h2 class="title">星际探索</h2>

                        <div class="info">
                            <router-link to="/Show">
                                <i class="el-icon-video-play" style="font-size: 30px;float: left;margin-left: 20px"></i>
                            </router-link>
                            <p class="info1">
                                <span class="beizhu">布拉德皮特月球枪战</span>
                            </p>
                            <p class="info2">

                                <span class="pingfen">7.0</span>
                            </p>
                        </div>


                    </div>
                </div>

                <div class="movie-item">
                    <div class="movie-item-range">
                        <p>#5</p>
                    </div>
                    <div class="movie-item-img">

                        <router-link to="/FilmDetail5">
                            <img src="../static/images/film10.jpg" alt=""/>
                        </router-link>
                    </div>
                    <div class="movie-item-info">

                        <h2 class="title">鲨海逃生</h2>

                        <div class="info">
                            <router-link to="/Show">
                                <i class="el-icon-video-play" style="font-size: 30px;float: left;margin-left: 20px"></i>
                            </router-link>
                            <p class="info1">
                                <span class="beizhu">嗜血盲鲨绝境虐杀</span>
                            </p>
                            <p class="info2">

                                <span class="pingfen">6.3</span>
                            </p>
                        </div>


                    </div>

                </div>
                <div class="movie-item">
                    <div class="movie-item-range">
                        <p>#6</p>
                    </div>
                    <div class="movie-item-img">

                        <router-link to="/FilmDetail1">
                            <img src="../static/images/film12.jpg" alt=""/>
                        </router-link>
                    </div>
                    <div class="movie-item-info">

                        <h2 class="title">听风者</h2>

                        <div class="info">
                            <router-link to="/Show">
                                <i class="el-icon-video-play" style="font-size: 30px;float: left;margin-left: 20px"></i>
                            </router-link>
                            <p class="info1">
                                <span class="beizhu">周迅梁朝伟虐心四角恋</span>
                            </p>
                            <p class="info2">

                                <span class="pingfen">6.1</span>
                            </p>
                        </div>


                    </div>
                </div>
                <el-button type="primary" style="border:white;width:140px;margin-left:180px;margin-top:5px;background: -webkit-linear-gradient(bottom,#444,gray,white) no-repeat;">
                    加载更多影片<i class="el-icon-arrow-down el-icon--right"></i>
                </el-button>


        </div>
        </div>

        <footer class="movierange-footer-nav">

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
    export default {
        name: "MovieRange"
    }
</script>

<style scoped>
    .movie-range{
        width:1510px;
        height:850px;
        background: -webkit-linear-gradient(bottom,#444,gray,white) no-repeat;
    }
    a{
        text-decoration: none;
    }
    .movierange-header-nav{
        width: 100%;
        height: 60px;
        /*background-color:gray;*/
        background: -webkit-linear-gradient(bottom,#444,gray,white) no-repeat;
        position: fixed;
        z-index: 80;
        top: 0;
        /*阴影*/
        box-shadow: 10px 0px 20px gray;
    }
    /*头部  左侧导航栏*/
    .header-nav-left{
        width: 600px;
        height: 60px;
        float: left;
    }
    /*头部右侧导航栏*/
    .header-nav-right{
        width: 600px;
        height: 60px;
        float: right;
        background: -webkit-linear-gradient(bottom,#444,gray,white) no-repeat;
    }
    /*头部左侧ul 处理*/
    .header-nav-left ul{
        list-style: none;
        width: 500px;
        height: 30px;
        text-align: center;
    }
    /*头部 左侧li处理*/
    .header-nav-left ul li{
        width: 100px;
        height: 30px;
        float: left;
        font-size: 20px;
        line-height: 30px;
        /*color: white;*/

    }

    /*头部左侧ul 处理*/
    .header-nav-right ul{
        list-style: none;
        width: 500px;
        height: 30px;
        text-align: center;
    }
    /*头部 左侧li处理*/
    .header-nav-right ul li{
        width: 100px;
        height: 30px;
        float: left;
        font-size: 20px;
        line-height: 30px;
        text-decoration-color:white ;

    }

    .movierange-footer-nav{
        width: 1510px;
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
    .range-page{
        height:780px;
        width:700px;
        margin-left: 420px;
        background: -webkit-linear-gradient(bottom,#444,gray,white) no-repeat;
    }

    .movie-list{
        display: flex;
        flex-wrap:wrap;
        padding: 7px;
        justify-content: space-between;
        width:500px;
        height:700px;
        margin-top: 10px;
        margin-left: 90px;
        background: -webkit-linear-gradient(bottom,#444,gray,white) no-repeat;

    }
    .movie-item{
        height: 100px;
        width: 500px;
        /*background: -webkit-linear-gradient(bottom,#444,gray,white) no-repeat;*/
        display: flex;
        border: 1px #444 dotted;


    }
    .movie-item-range{
        width:50px;
        height:90px;

        margin: 5px 5px 5px 5px;
    }
    .movie-item-range p{
        font-size: 30px;
        color: deepskyblue;
    }
    .movie-item-img{
        width:80px;
        height:90px;

        margin: 5px 5px 5px 5px;
    }
    .movie-item-img img{
        width:80px;
        height: 90px;
    }
    .movie-item-info{
        width:300px;
        height:90px;

        margin: 5px 5px 5px 5px;
    }
    .title{


        margin-top: 15px;
        margin-bottom: 0px;
        font-size: 20px;

    }
    .info{

        display: flex;
        justify-content: space-between;

    }
    .info p{
        margin: 0;
        padding: 5px;
    }
    .pingfen{
        color: red;
        font-size:20px;
        font-weight: bold;
    }
    .beizhu{
        color: black;
        font-size: 10px;
        font-weight: bold;
    }

</style>