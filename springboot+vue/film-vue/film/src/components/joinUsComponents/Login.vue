<template>
    <div id="main-login">

        <!--<form id="login-form">-->
            <!--<input v-model="userName" type="text" placeholder="请输入用户名"></input><br/>-->
            <!--<input v-model="userPwd" type="password" placeholder="请输入密码"></input><br/>-->
            <!--<input  type="button" @click="login" value="登录"></input><br/>-->
        <!--</form>-->
        <div>
            <h3>亲爱的用户，欢迎您！</h3>

            <input type="text" placeholder="请输入用户名" v-model="userName" /><br/>

            <input type="password" placeholder="请输入密码" v-model="userPwd" /><br/>
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

<script>
    export default {
        name: "Login",
        data(){
          return{
              userName:'',
              userPwd:'',
          }
        },
        methods:{
          login(){
              let user = {
                  userName: this.userName,
                  userPwd: this.userPwd,
              };
              //使用axios 进行后台登录验证   如果成功  返回success  之后将 user值放入
              //localStorage
              //调用全局方法 $addStorageEvent    向localStorage中注入 user 对象
              this.$addStorageEvent(1,'user',JSON.stringify(user));
              //登录成功  进行页面跳转
              this.$router.push('/Index');//登录后跳转  到电影管理页面
          }
        },
    }
</script>

<style scoped>
    input {
        display: block;
        width: 250px;
        height: 40px;
        line-height: 40px;
        margin: 0 auto;
        margin-bottom: 5px;
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
</style>