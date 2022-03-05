<template>
    <div class="img1">
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

        <div>
        <h3>亲爱的用户，欢迎您！</h3>

        <input type="text" placeholder="请输入用户名" v-model="userName" />

        <input type="password" placeholder="请输入密码" v-model="userPwd" />
        <button v-on:click="login" style="border-radius: 5px;background: -webkit-linear-gradient(bottom,#444,gray,white) no-repeat;">登录</button>

        <p >
            <router-link to="/Regist" style="color: red">没有账号？马上注册</router-link>
        </p>
        <!-- <p v-on:click="ToRegister">没有账号？马上注册</p> -->
        <br />
        <!-- <router-link to="/">返回</router-link> -->
    </div>
    </div>
</template>
<script type="text/javascript">

    export default{
        data(){
            return{
                userName:'',
                userPwd:''
            }
        },
        methods:{
            login(){

                let user={
                    userName: this.userName,
                    userPwd: this.userPwd,
                };
                this.$addStorageEvent(1,'user',JSON.stringify(user));

                this.$message({
                    message:'登录成功！',
                    type:'success',
                });
                this.$router.push('./Home')

            }
        },
    }
</script>
<style>
    .login-wrap {
        text-align: center;
    }
    h3 {
        text-align: center;
        color: white;
    }
    span {
        text-align: center;
    }
    input {
        display: block;
        width: 250px;
        height: 40px;
        line-height: 40px;
        margin: 0 auto;
        margin-bottom: 10px;
        outline: none;
        border: 1px solid #888;
        padding: 10px;
        box-sizing: border-box;
    }

    p {
        color: red;
        text-align: center;
    }

    button {
        display: block;
        width: 250px;
        height: 40px;
        line-height: 40px;
        margin: 0 auto;
        border: none;
        background-color: #41b883;
        color: #fff;
        font-size: 16px;
        margin-bottom: 5px;
    }

    span {
        cursor: pointer;
    }

    span:hover {
        color: #41b883;
    }
    #film-header-nav{
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
    #header-nav-left{
        width: 600px;
        height: 60px;
        float: left;
    }
    /*头部右侧导航栏*/
    #header-nav-right{
        width: 550px;
        height: 60px;
        float: right;
        background: -webkit-linear-gradient(bottom,#444,gray,white) no-repeat;
    }
    /*头部左侧ul 处理*/
    #header-nav-left ul{
        list-style: none;
        width: 500px;
        height: 30px;
        text-align: center;
    }
    /*头部 左侧li处理*/
    #header-nav-left ul li{
        width: 100px;
        height: 30px;
        float: left;
        font-size: 20px;
        line-height: 30px;
        /*color: white;*/

    }

    /*头部左侧ul 处理*/
    #header-nav-right ul{
        list-style: none;
        width: 500px;
        height: 30px;
        text-align: center;
    }
    /*头部 左侧li处理*/
    #header-nav-right ul li{
        width: 100px;
        height: 30px;
        float: left;
        font-size: 20px;
        line-height: 30px;
        text-decoration-color:white ;

    }
    .img1{
        background-size: 100% 100%;
        background-image: url("../static/images/beijing.jpg");
        backgroundRepeat: "no-repeat";

        height: 100%;
        position:absolute;
        width: 100%;
        margin-left: 0px;
        /*opacity: 0.6;*/

    }

</style>