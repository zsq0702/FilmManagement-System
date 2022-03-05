<template>
    <div id="main-regist">

        <div>
            <h3>亲爱的用户，请先注册！</h3>

            <input type="text" placeholder="请输入用户名" v-model="newUsername" /><br/>
            <input type="password" placeholder="请输入密码" v-model="newPassword" /><br/>
            <input type="text" placeholder="请输入手机号" v-model="newUsernumber" /><br/>

            <button v-on:click="regist" style="border-radius: 5px;background: -webkit-linear-gradient(bottom,#444,gray,white) no-repeat;">注册</button>

            <!-- <p v-on:click="ToLogin">已有账号？马上登录</p> -->
            <p>
                <router-link to="/Login" style="color: red">已有账号？马上登录</router-link>
            </p>
            <br />
            <!-- <router-link to="/">返回</router-link> -->
        </div>

    </div>
</template>

<script>
    export default {
        name: "Regist",
        data(){
            return{

            }
        },
        methods:{
            //注册方法1
            regist(){
                this.$message({
                    message:'注册成功！',
                    type:'success',
                });
                this.$router.push('/Login');
                // let path = `http://localhost:8090/springboot/user/json/regist`;
                // this.axios.post(path,{
                //         name:this.name,
                //         pwd:this.pwd,
                // }).then(res=>{
                //     console.log("服务器发送回的数据:");
                //     console.log(res);
                //     console.log(res.data);//注册结果    根据前台页面，进行操作
                //     if(true==res.data){
                //         this.$router.push('/Index');//借助路由，跳转到  主页
                //     }
                // });
            },
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