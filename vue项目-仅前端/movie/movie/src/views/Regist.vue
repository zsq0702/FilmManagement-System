<template>
    <div class="img2">
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
        <h3>亲爱的用户，请先注册！</h3>
        <input type="text" placeholder="请输入手机号" v-model="newUsernumber" />
        <input type="text" placeholder="请输入用户名" v-model="newUsername" />
        <input type="password" placeholder="请输入密码" v-model="newPassword" />

        <button v-on:click="register" style="border-radius: 5px;background: -webkit-linear-gradient(bottom,#444,gray,white) no-repeat;">注册</button>

        <!-- <p v-on:click="ToLogin">已有账号？马上登录</p> -->
        <p>
            <router-link to="/Login" style="color: red">已有账号？马上登录</router-link>
        </p>
        <br />
        <!-- <router-link to="/">返回</router-link> -->
    </div>
    </div>
</template>
<script type="text/javascript">

    export default{
        methods:{
            register(){
                this.$message({
                    message:'注册成功！',
                    type:'success',
                });
                this.$router.push('./Login')
            }
        }
    }
</script>
<style>
    .login-wrap {
        text-align: center;
    }

    h3 {
        text-align: center;
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
    .img2{
        background-size: 100% 100%;
        background-image: url("../static/images/beijing.jpg");
        backgroundRepeat: "no-repeat";
        height: 100%;
        position:absolute;
        width: 100%;

    }
</style>