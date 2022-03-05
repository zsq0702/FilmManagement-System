<template>

    <div id="home-page">

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
        <div id="imgbox">
        <el-carousel :interval="4000" type="card" height="400px" >
            <el-carousel-item v-for="item in imgs" v-bind:key="item.url" >
                <router-link :to="{ path: item.link }"><img :src="item.url"/></router-link>

            </el-carousel-item>
        </el-carousel>
        </div>
        <div id="main">

            <el-dropdown>
                <el-button type="primary" style="margin-top:5px;border:white;background: -webkit-linear-gradient(bottom,#444,gray,white) no-repeat;">
                    选地区<i class="el-icon-arrow-down el-icon--right"></i>
                </el-button>
                <el-dropdown-menu slot="dropdown">
                    <el-dropdown-item>大丰区</el-dropdown-item>
                    <el-dropdown-item>阜宁县</el-dropdown-item>
                    <el-dropdown-item>滨海县</el-dropdown-item>
                    <el-dropdown-item>响水县</el-dropdown-item>
                    <el-dropdown-item>亭湖区</el-dropdown-item>
                </el-dropdown-menu>
            </el-dropdown>
            <el-dropdown>
                <el-button type="primary" style="margin-top:5px;border:white;background: -webkit-linear-gradient(bottom,#444,gray,white) no-repeat;">
                    选影院<i class="el-icon-arrow-down el-icon--right"></i>
                </el-button>
                <el-dropdown-menu slot="dropdown">
                    <el-dropdown-item>润生影院</el-dropdown-item>
                    <el-dropdown-item>皇家影院</el-dropdown-item>
                    <el-dropdown-item>益林金字塔影院</el-dropdown-item>
                    <el-dropdown-item>人民剧场影院</el-dropdown-item>
                    <el-dropdown-item>盐城爱圣堡影院</el-dropdown-item>
                </el-dropdown-menu>
            </el-dropdown>
            <el-dropdown>
                <el-button type="primary" style="margin-right: 20px;margin-top:5px;border:white;background: -webkit-linear-gradient(bottom,#444,gray,white) no-repeat;">
                    选电影<i class="el-icon-arrow-down el-icon--right"></i>
                </el-button>
                <el-dropdown-menu slot="dropdown">
                    <el-dropdown-item>花木兰</el-dropdown-item>
                    <el-dropdown-item>唐人街探案3</el-dropdown-item>
                    <el-dropdown-item>勇敢者游戏2</el-dropdown-item>
                    <el-dropdown-item>万万没想到</el-dropdown-item>
                    <el-dropdown-item>红海行动</el-dropdown-item>
                </el-dropdown-menu>
            </el-dropdown>

            <div id="daohang">
            <el-breadcrumb class="daohang1" separator="/" style="margin-top: 15px">
                <el-breadcrumb-item :to="{ path: '/Login' }">全部</el-breadcrumb-item>
                <el-breadcrumb-item :to="{ path: '/' }">3D</el-breadcrumb-item>
                <el-breadcrumb-item :to="{ path: '/' }">IMAX</el-breadcrumb-item>
                <el-breadcrumb-item :to="{ path: '/' }">科幻</el-breadcrumb-item>
                <el-breadcrumb-item :to="{ path: '/' }">悬疑</el-breadcrumb-item>
                <el-breadcrumb-item :to="{ path: '/' }">喜剧</el-breadcrumb-item>
                <el-breadcrumb-item :to="{ path: '/' }">动作</el-breadcrumb-item>
                <el-breadcrumb-item :to="{ path: '/' }">惊悚</el-breadcrumb-item>
                <el-breadcrumb-item :to="{ path: '/' }">爱情</el-breadcrumb-item>
                <el-breadcrumb-item :to="{ path: '/' }">青春</el-breadcrumb-item>
                <el-breadcrumb-item :to="{ path: '/' }">枪战</el-breadcrumb-item>
                <el-breadcrumb-item :to="{ path: '/' }">...</el-breadcrumb-item>
            </el-breadcrumb>

                <input type="text" placeholder="请输入影片名" v-model="title" style="margin-top: 10px;border-radius:5px;"/>
                <el-button style="margin-right:150px;margin-top: 10px;width: 160px;height:40px;background: -webkit-linear-gradient(bottom,#444,gray,white) no-repeat;border: white" type="primary" icon="el-icon-search">搜索影片</el-button>
            </div>

            <el-dialog title="收费" :visible.sync="dialogFormVisible" style="width:900px;margin-left: 300px;">
                <el-form :model="form">

                    <el-form-item label="收费标准" :label-width="formLabelWidth">
                        <el-radio-group v-model="form.resource">
                            <el-radio label="用券"></el-radio>
                            <el-radio label="VIP半价"></el-radio>
                            <el-radio label="普通用户6元"></el-radio>
                        </el-radio-group>
                    </el-form-item>
                </el-form>
                <div slot="footer" class="dialog-footer">
                    <el-button @click="dialogFormVisible = false" style="width: 160px;height:40px;">取 消</el-button>
                    <el-button type="primary" @click="dialogFormVisible = false" style="width: 160px;height:40px;background: -webkit-linear-gradient(bottom,#444,gray,white) no-repeat;border: white">确 定</el-button>
                </div>
            </el-dialog>
            <!--<h1>正在热映</h1>-->
            <hr class="main-hr">
            <el-breadcrumb  class="daohang2" separator="/">
                <el-breadcrumb-item :to="{ path: '/' }">最新上线</el-breadcrumb-item>
            </el-breadcrumb>
            <div class="movie-list">


                <div class="movie-item">
                    <router-link to="/FilmDetail1">
                    <img src="../static/images/film6.jpg" alt=""/>
                    </router-link>

                    <h2 class="title">天 火</h2>
                    <div class="info">
                        <p class="info1">
                            <span class="beizhu">王学圻昆凌绝境冒险</span>
                        </p>
                        <p class="info2">
                            <span class="pingfen">8.2</span>
                        </p>
                    </div>
                </div>
                <div class="movie-item">
                    <router-link to="/FilmDetail2">
                        <img src="../static/images/film7.jpg" alt=""/> </router-link>
                    <h2 class="title" @click="dialogFormVisible = true">冰雪奇缘2</h2>
                    <div class="info">
                        <p class="info1">
                            <span class="beizhu">动画巨制再续传奇</span>
                        </p>
                        <p class="info2">

                            <span class="way">付费</span>
                        </p>
                        <p class="info3">

                            <span class="pingfen">8.3</span>
                        </p>
                    </div>

                </div>
                <div class="movie-item">
                    <router-link to="/FilmDetail3">
                        <img src="../static/images/film8.jpg" alt=""/> </router-link>
                    <h2 class="title">天使陷落</h2>
                    <div class="info">
                        <p class="info1">
                            <span class="beizhu">落难英雄绝境重生</span>
                        </p>
                        <p class="info2">

                            <span class="pingfen">8.2</span>
                        </p>
                    </div>
                </div>
                <div class="movie-item">
                    <router-link to="/FilmDetail4">
                        <img src="../static/images/film9.jpg" alt=""/> </router-link>
                    <h2 class="title">星际探索</h2>
                    <div class="info">
                        <p class="info1">
                            <span class="beizhu">布拉德皮特月球枪战</span>
                        </p>
                        <p class="info2">

                            <span class="way">VIP</span>
                        </p>
                        <p class="info3">

                            <span class="pingfen">7.0</span>
                        </p>
                    </div>
                </div>

                <div class="movie-item">
                    <router-link to="/FilmDetail5">
                        <img src="../static/images/film10.jpg" alt=""/> </router-link>
                    <h2 class="title">鲨海逃生</h2>
                    <div class="info">
                        <p class="info1">
                            <span class="beizhu">嗜血盲鲨绝境虐杀</span>
                        </p>
                        <p class="info2">

                            <span class="way">VIP</span>
                        </p>
                        <p class="info3">

                            <span class="pingfen">6.2</span>
                        </p>
                    </div>
                </div>

            </div>



            <hr class="main-hr">
            <el-breadcrumb  class="daohang2" separator="/">
                <el-breadcrumb-item :to="{ path: '/' }">高分华语悬疑片</el-breadcrumb-item>
            </el-breadcrumb>
            <div class="movie-list">


                <div class="movie-item">
                    <router-link to="/FilmDetail1">
                        <img src="../static/images/film11.jpg" alt=""/> </router-link>
                    <h2 class="title" >毒战</h2>
                    <div class="info">
                        <p class="info1">
                            <span class="beizhu">老杜首导内地警匪题材</span>
                        </p>
                        <p class="info2">

                            <span class="way">VIP</span>
                        </p>
                        <p class="info3">

                            <span class="pingfen">8.8</span>
                        </p>
                    </div>
                </div>
                <div class="movie-item">
                    <router-link to="/FilmDetail1">
                        <img src="../static/images/film12.jpg" alt=""/> </router-link>
                    <h2 class="title">听风者</h2>
                    <div class="info">
                        <p class="info1">
                            <span class="beizhu">周迅梁朝伟虐心四角恋</span>
                        </p>
                        <p class="info2">

                            <span class="pingfen">8.8</span>
                        </p>
                    </div>

                </div>
                <div class="movie-item">
                    <router-link to="/FilmDetail1">
                        <img src="../static/images/film13.jpg" alt=""/> </router-link>
                    <h2 class="title" @click="dialogFormVisible = true">十二公民</h2>
                    <div class="info">
                        <p class="info1">
                            <span class="beizhu">高分国产悬疑佳作</span>
                        </p>
                        <p class="info2">

                            <span class="way">用券</span>
                        </p>
                        <p class="info3">

                            <span class="pingfen">8.8</span>
                        </p>
                    </div>

                </div>
                <div class="movie-item">
                    <router-link to="/FilmDetail1">
                        <img src="../static/images/film14.jpg" alt=""/> </router-link>
                    <h2 class="title">意外</h2>
                    <div class="info">
                        <p class="info1">
                            <span class="beizhu">古天乐设计暗杀任贤齐</span>
                        </p>
                        <p class="info2">

                            <span class="pingfen">8.7</span>
                        </p>
                    </div>
                </div>

                <div class="movie-item">
                    <router-link to="/FilmDetail1">
                        <img src="../static/images/film15.jpg" alt=""/> </router-link>
                    <h2 class="title">窃听风云3</h2>
                    <div class="info">
                        <p class="info1">
                            <span class="beizhu">巨星云集卖萌基情</span>
                        </p>
                        <p class="info2">

                            <span class="pingfen">8.7</span>
                        </p>
                    </div>
                </div>

            </div>

            <hr class="main-hr">
            <el-breadcrumb  class="daohang2" separator="/">
                <el-breadcrumb-item :to="{ path: '/' }" >奇幻电影大冒险</el-breadcrumb-item>
            </el-breadcrumb>
            <div class="movie-list">


                <div class="movie-item">
                    <router-link to="/FilmDetail1">
                        <img src="../static/images/film16.jpg" alt=""/> </router-link>
                    <h2 class="title">博物馆奇妙夜3</h2>
                    <div class="info">
                        <p class="info1">
                            <span class="beizhu">威廉姆斯音容笑貌仍在</span>
                        </p>
                        <p class="info2">

                            <span class="way">VIP</span>
                        </p>
                        <p class="info3">

                            <span class="pingfen">8.8</span>
                        </p>
                    </div>
                </div>
                <div class="movie-item">
                    <router-link to="/FilmDetail1">
                        <img src="../static/images/film17.jpg" alt=""/> </router-link>
                    <h2 class="title" @click="dialogFormVisible = true">哈利波特7</h2>
                    <div class="info">
                        <p class="info1">
                            <span class="beizhu">十年一梦 年少完结</span>
                        </p>
                        <p class="info2">

                            <span class="way">付费</span>
                        </p>
                        <p class="info3">

                            <span class="pingfen">9.0</span>
                        </p>
                    </div>

                </div>
                <div class="movie-item">
                    <router-link to="/FilmDetail1">
                        <img src="../static/images/film18.jpg" alt=""/> </router-link>
                    <h2 class="title" @click="dialogFormVisible = true">精灵旅社2</h2>
                    <div class="info">
                        <p class="info1">
                            <span class="beizhu">史上最萌怪物大联欢</span>
                        </p>
                        <p class="info2">

                            <span class="way">用券</span>
                        </p>
                        <p class="info3">

                            <span class="pingfen">8.9</span>
                        </p>
                    </div>

                </div>
                <div class="movie-item">
                    <router-link to="/FilmDetail1">
                        <img src="../static/images/film19.jpg" alt=""/> </router-link>
                    <h2 class="title">法老与众神</h2>
                    <div class="info">
                        <p class="info1">
                            <span class="beizhu">无神论者的“出埃及记”</span>
                        </p>
                        <p class="info2">

                            <span class="pingfen">8.5</span>
                        </p>
                    </div>
                </div>

                <div class="movie-item">
                    <router-link to="/FilmDetail1">
                        <img src="../static/images/film20.jpg" alt=""/>

                    </router-link>
                    <h2 class="title" @click="dialogFormVisible = true">查理与巧克力工厂</h2>
                    <div class="info">
                        <p class="info1">
                            <span class="beizhu">巧克力世界的童趣旅程</span>
                        </p>
                        <p class="info2">

                            <span class="way">V/F</span>
                        </p>
                        <p class="info3">

                            <span class="pingfen">9.0</span>
                        </p>

                    </div>


                </div>

            </div>


        </div>

        <footer id="movie-footer-nav">

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

            <!--<div id="footer2">-->
                <!--<li><router-link to="/Index" class="a"><p id="footer-font3">加入我们</p></router-link></li>-->
                <!--<li><router-link to="/JoinUs" class="a"><p id="footer-font4">联系我们</p></router-link></li>-->
                <!--<li><router-link to="/FilmManager" class="a"><p id="footer-font5">隐私政策</p></router-link></li>-->

            <!--</div>-->

            <div id="footer-di">
                <p>北京动艺时光网络科技有限公司Copyright 2006-2020 Mtime.com Inc. All rights reserved.</p>
                <p>京ICP证050715号 网络视听许可证0108265号网络文化经营许可证广播电视节目制作经营许可证(京)字第1435号京公网安备：110105000744号</p>
            </div>
        </footer>
    </div>

</template>

<script>
    export default {
        name: "Home",
        data: function () {
            return {
                dialogTableVisible: false,
                dialogFormVisible: false,
                form: {

                },
                formLabelWidth: '100px',
                // tableData: [{
                //     date: '2016-05-02',
                //     name: '王小虎',
                //     address: '上海市普陀区金沙江路 1518 弄'
                // }, {
                //     date: '2016-05-04',
                //     name: '王小虎',
                //     address: '上海市普陀区金沙江路 1517 弄'
                // }, {
                //     date: '2016-05-01',
                //     name: '王小虎',
                //     address: '上海市普陀区金沙江路 1519 弄'
                // }, {
                //     date: '2016-05-03',
                //     name: '王小虎',
                //     address: '上海市普陀区金沙江路 1516 弄'
                // }],
                imgs: [
                    {url: require('../static/images/film1.jpg'), link: '/Show'},
                    {url: require('../static/images/film2.jpg'),  link: '/Show2'},
                    {url: require('../static/images/film3.jpg'),  link: '/Show3'},
                    {url: require('../static/images/film4.jpeg'),  link: '/Show4'},
                    {url: require('../static/images/film5.jpg'),  link: '/Show5'}
                ]
            }

        },
        methods:{
            visible:function(){
                this.seen = true;
            },
            invisible:function(){
                this.seen = false;
            }
            // goUrl(){
            //     if(idx==0){
            //         window.location.href='/FileDetail1'
            //     }
            // }
            // visible:function () {
            //     this.seen=true;
            // },
            // display:function () {
            //     this.seen=false;
            //
            // }
        }

    }
</script>

<style scoped>
    #home-page{


    }
    a{
        text-decoration: none;
    }
    .main-hr{
        margin-left: 180px;
        margin-right: 150px;
    }
    .el-carousel__item h3 {
        color: #475669;
        font-size: 18px;
        opacity: 0.75;
        line-height: 300px;
        margin: 0;
    }

    .el-carousel__item:nth-child(2n) {
        background-color: black;
    }

    .el-carousel__item:nth-child(2n+1) {
        background-color: black;
    }
    .el-carousel__item img {
        text-align: center;
        height: 400px;
        width:770px;
        margin: 0 auto;
        display: block;
    }
    .a{
        text-decoration: none;

    }
    #imgbox {
        height: 420px;
        width: 1510px;
        background-color: #444;
        /*box-shadow: 10px 10px 20px #444;*/
        /*overflow: hidden;*/
    }
    #main{
        height: 1420px;
        width: 1510px;
        background: -webkit-linear-gradient(bottom,#444,gray,white) no-repeat;
        /*background-color: white;*/
    }
    .el-dropdown {
        vertical-align: top;
    }
    .el-dropdown + .el-dropdown {
        margin-left: 15px;
    }
    .el-icon-arrow-down {
        font-size: 12px;
    }
    #movie-footer-nav{
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

    /*#footer2{*/
        /*background-color: yellow;*/
        /*list-style: none;*/
        /*width: 100px;*/
        /*height:60px;*/
        /*margin-left: 600px;*/
        /*margin-bottom: 100px;*/
        /*font-size: 15px;*/
        /*position: absolute;*/
    /*}*/

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
    /*.footer.li{*/
        /*float: left;*/
        /*display: flex;*/
    /*}*/
    /*#footer-font{*/
        /*color: white;*/
    /*}*/

    /*#footer-font1{*/
        /*color: white;*/
    /*}*/
    /*#footer-font2{*/
        /*color: white;*/
    /*}*/
    /*#footer-font3{*/
        /*color: white;*/
    /*}*/

    /*#footer-font4{*/
        /*color: white;*/
    /*}*/
    /*#footer-font5{*/
        /*color: white;*/
    /*}*/
    #footer-di{
        margin-bottom: 0px;
        background-color: black;
        width:100%;
        height:50px;
    }
    #footer-di p{
        color: white;

        font-size: 10px;

    }
    .daohang1{
        margin-left: 220px;
        margin-top: 10px;
        position: center;
        font-size: 20px;

    }
    .daohang2{
        margin-left: 220px;
        margin-top: 10px;
        position: center;
        font-size: 30px;
    }
    #daohang{
        display: flex;
    }

    /*.el-table{*/
        /*margin-left: 360px;*/
        /*margin-top: 10px;*/
        /*position: center;*/
    /*}*/
    #main_img{
        margin-left: 150px;
    }
    #main_img ul{
        list-style: none;
        /*width: 500px;*/
        /*height: 30px;*/
        /*text-align: center;*/
    }
    /*头部 左侧li处理*/
    #main_img ul li{
        /*width: 100px;*/
        /*height: 30px;*/
        float: left;
        /*font-size: 20px;*/
        /*line-height: 30px;*/
        /*color: white;*/

    }
    #main_img ul li img {
        /*text-align: center;*/
        height: 280px;
        width:210px;
        margin-top: 10px;
        margin-left: 10px;
        /*margin: 0 auto;*/
        /*display: block;*/
    }
    .movie-list{
        display: flex;
        flex-wrap:wrap;
        padding: 7px;
        justify-content: space-between;
        width:1130px;
        height:350px;
        margin-top: 10px;
        margin-left: 200px;
        background-color: white;

    }
    .movie-item{
        border:5px solid white;
        box-shadow: 0 0 8px gray;
        margin: 4px 0;
        /*background-color: yellow;*/

    }
    .movie-item img{

        width:210px;
        height: 280px;


    }

    .title{

        background-color: #eee;
        margin-top: 0px;
        margin-bottom: 0px;
        font-size: 20px;

    }
    .info{
        background-color: #eee;
        display: flex;
        justify-content: space-between;

    }
    .info p{
        margin: 0;
        padding: 5px;
    }
    .pingfen{
        color: red;
        font-size:15px;
        font-weight: bold;
    }
    .beizhu{
        color: gray;
        font-size: 12px;
        font-weight: bold;
    }
    .way{
        color: orange;
        font-size:15px;
        font-weight: bold;
    }

</style>