<template>
    <div class="filmdetail">

        <header class="filmdetail-header-nav">
            <!--整体头部div-->
            <div class="ui-container">
                <div class="header-nav-left">
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


        <div class="filmdetail-body">
            <div class="movie-list">

                <div class="movie-item">
                    <a href="#"><img src="../static/images/film9.jpg" alt=""/> </a>
                </div>

                <div class="filmdetail-info">
                    <h1 class="title">星际探索</h1>
                    <div class="filmdetail-date">
                        <p>124分钟-冒险/剧情/悬疑-2019年12月5日中国上映</p>
                    </div>


                    <div class="info">
                        <p class="info1">
                            <span class="beizhu">布拉德皮特月球枪战</span>
                        </p>
                        <p class="info2">

                            <span class="pingfen">7.0</span>
                        </p>
                    </div>
                    <div class="filmdetail-more">
                        <p>16个视频  77张图片  182位演职员  541条影评 55条新闻</p>
                    </div>
                    <div class="filmdetail-info-body">

                        <div class="filmdetail-info-body1">
                            <ul>
                                <li>导演：詹姆士·格雷</li>
                                <li>编剧：詹姆士·格雷 Ethan Gross</li>
                                <li>主演：布拉德·皮特  汤米·李·琼斯 鲁丝·内伽</li>
                                <li>国家地区：美国 | 中国</li>
                                <li>发行公司：华特·迪士尼电影工作室</li>

                            </ul>

                        </div>
                        <div class="filmdetail-info-body2">
                            <p>剧情介绍</p>
                            <p>地球上接连出现神秘怪象，科学家发现某种失控的反物质反应正在威胁整个太阳系，人类生存极度堪忧……地球生死攸关之际，天才航天工程师罗伊（布拉德·皮特 饰）被派往外太空，试图揭开谜团拯救人类。</p>

                        </div>
                    </div>
                </div>
            </div>
            <div class="filmdetail-comment">

                <div class="filmdetail-comment1">

                    <el-form>
                        <el-input
                                type="textarea"
                                :rows="2"
                                placeholder="请输入内容"
                                v-model="textarea">
                        </el-input>
                        <el-form-item>

                            <el-button >取消</el-button>
                            <el-button type="primary" @click="onSubmit" style="border:white;background: -webkit-linear-gradient(bottom,#444,gray,white) no-repeat;">发表评论</el-button>
                        </el-form-item>
                        <el-rate
                                v-model="value"
                                show-text>
                        </el-rate>
                    </el-form>

                </div>
                <h2 style="color:#eee"> 精彩评论(81)</h2>
                <ul class="list-group">
                    <li class="list-group-item" v-for="item in list" :key="item.id">
                        <span class="badge">{{ item.user }} :  </span>
                        {{ item.content }}
                    </li>
                </ul>
                <el-button type="primary" style="border:white;margin-right: 300px;width:140px;background: -webkit-linear-gradient(bottom,#444,gray,white) no-repeat;">
                    加载更多评论<i class="el-icon-arrow-down el-icon--right"></i>
                </el-button>
                <!--<div class="filmdetail-comment2">-->

                <!--</div>-->
            </div>

        </div>
        <footer class="filmdetail-footer-nav">

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
        name: "FilmDetail4",
        data() {
            return {
                textarea: '',
                value: null,
                list: [
                    {id: Date.now(), user:'寂寞-走直线', content: '有外星人么？相信有好奇心的人类一直有这样的疑问。'},
                    {id: Date.now(), user:'穿越屏幕', content:'既没能呈现与投资相匹配的视觉奇观，对严肃主题的讨论也并不出彩。'},
                    {id: Date.now(), user:'羽仙', content:'在浩瀚的宇宙中总能感到个体的渺小和孤独。'}
                ],

            }
        },
        methods: {
            onSubmit() {
                console.log('submit!');
                this.$message({
                    message:'发表成功！',
                    type:'success',
                });
            },
        }
    }
</script>

<style scoped>
    a{
        text-decoration: none;
    }

    .el-button{
        margin-top: 10px;
        width:100px;
        height:40px;
        font-size: 15px;
        float: right;
        margin-left: 5px;
    }
    .filmdetail-header-nav{
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
        width: 500px;
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

    .filmdetail-body{
        height:880px;
        width:1510px;
        background: -webkit-linear-gradient(bottom,#444,gray,white) no-repeat;
    }



    .filmdetail-footer-nav{
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

    .movie-list{
        display: flex;
        flex-wrap:wrap;
        padding: 7px;
        justify-content: space-between;
        width:750px;
        height:350px;
        margin-top: 10px;
        margin-left: 400px;
        /*background-color: white;*/

    }
    .movie-item{
        border:5px solid white;
        box-shadow: 0 0 8px gray;
        margin: 4px 0;
        height:350px;
        /*background-color: yellow;*/

    }
    .filmdetail-info{
        border:5px solid white;
        box-shadow: 0 0 8px gray;
        margin: 4px 0;
        width: 500px;
        height:350px;
        background: -webkit-linear-gradient(bottom,#444,gray,white) no-repeat;
    }
    .filmdetail-date{
        width:450px;
        background: -webkit-linear-gradient(bottom,deepskyblue,deepskyblue,white) no-repeat;
        height:32px;
        border-radius:5px;
        margin-left: 25px;
        justify-content: center;

    }
    .filmdetail-date p {
        font-size: 20px;
        color: white;
    }

    .filmdetail-more{
        width:500px;
        background: -webkit-linear-gradient(bottom,deepskyblue,deepskyblue,white) no-repeat;
        height:35px;
        border-radius:5px;
        margin-top: 0px;
        /*display: flex;*/
        justify-content: center;


    }
    .filmdetail-more p {
        font-size: 20px;
        color: white;
        margin: 0;
        padding: 5px;
    }

    .filmdetail-info-body{
        height:180px;

        margin-top: 5px;
        display: flex;

    }
    .filmdetail-info-body1{
        width:300px;

        margin: 5px 5px 5px 15px;
        height:170px;
        border:1px dotted black;

    }
    .filmdetail-info-body1 ul{

        padding:5px;

        margin:0;
    }
    .filmdetail-info-body1 ul li{
        list-style: none;
        text-align: left;
        color: black;
        font-size:15px;
        line-height: 25px;

    }
    .filmdetail-info-body2{
        width:160px;

        border:1px dotted black;
        height:170px;
        margin: 5px 5px 5px 5px;

        /*margin-right: 5px;*/
    }
    .filmdetail-info-body2 p{
        padding: 5px;
        color: black;
        font-size: 10px;
    }
    .filmdetail-comment{
        width: 750px;
        height: 500px;
        background: -webkit-linear-gradient(bottom,#444,gray,white) no-repeat;
        margin-top: 20px;
        margin-left: 405px;
    }
    .filmdetail-comment1{
        width:730px;
        padding: 5px;
        height:200px;
        margin: 5px 5px 5px 5px;

    }
    .filmdetail-comment2{
        width:730px;
        margin: 5px 5px 5px 5px;
        padding: 5px;
        height:200px;

    }
    .movie-item img{

        width:210px;
        height: 350px;


    }

    .title{

        /*background-color: #eee;*/
        margin-top: 0px;
        margin-bottom: 0px;
        font-size: 30px;
        height: 25px;

    }
    .info{
        /*background-color: #eee;*/
        display: flex;
        justify-content: space-between;
        line-height: 25px;

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
    .beizhu{
        color: gray;
        font-size: 15px;
        font-weight: bold;
    }
    .list-group-item{
        list-style: none;
        font-size: 17px;
        color: white;
        display: flex;
        margin-left: 10px;
        line-height: 40px;

    }

</style>