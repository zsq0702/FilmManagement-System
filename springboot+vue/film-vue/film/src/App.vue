<template>
  <div id="app">
    <!--主页面头部内容  保持不变-->
    <header id="film-header-nav">
      <!--整体头部div-->
      <div id="ui-container">
        <div id="header-nav-left">
          <ul>
            <li><router-link to="/Index">首页</router-link></li>
            <li><router-link to="/JoinUs">加入我们</router-link></li>
            <li><router-link to="/FilmManager">电影管理</router-link></li>
            <li><router-link to="/UserManager">用户管理</router-link></li>
            <li><router-link to="/Show">在线观看</router-link></li>
          </ul>
        </div>
        <div id="header-nav-right">
            <div v-show="logoutFlag">
              <span>欢迎,</span><span>{{userName}}</span><span>,登录!</span>
              <input type="button" value="登出" @click="logout"></input>
            </div>
        </div>
      </div>
    </header>
    <!--路由替换内容-->
    <router-view/>
    <!--底部内容   保持不变-->
    <footer id="film-footer-nav">

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
  name: 'App',
  components: {

  },
  data(){
    return{
      logoutFlag: false,//默认情况下   登出的div 不显示
      userName:'',//用于接收用户名
      user:{},//用于接收   后台返回的用户信息
    }
  },
  methods:{
    logout(){
      this.logoutFlag = false;//隐藏  登录的div
      localStorage.removeItem('user');//登出后 将存储的user 信息  清空
      this.userName = '';
      this.user  ={};
      this.$router.push('/Index');//通过路由跳转到主页
    },
    //用于检查 localStorage 中是否存在内容
    checkStatus(){
      console.log("检查localStorage");
      if(localStorage.user){
        console.log("存在！");
        this.logoutFlag = true;//用户存在 相当于 已经登录过，显示登出的div
        this.userName = JSON.parse(localStorage.user).userName;//获取用户名
        this.user = JSON.parse(localStorage.user);//直接将json 对象 给user
        console.log(this.user);
      }
    },
  },
  //触发方法  写在 mounted中
  mounted(){
    //通过如下方法   监听  其他组件的变化    当登录页面  发生操作后会触发我们写的全局监听
    //根据监听  获取内容
    window.addEventListener('setItem',(e)=>{
      console.log("监听setItem事件");
      console.log(e);
      if('user'===e.key){
        this.logoutFlag = true;//监听到事件  满足条件   则显示登出的div
        // 重构  页面中的数据   由于  有双向绑定，  数据动态变则  这里data 变化
        this.userName = JSON.parse(localStorage.user).userName;//获取用户名
        this.user = JSON.parse(localStorage.user);//直接将json 对象 给user
      }
    })
  },
  //页面加载时  调用  checkStatus方法
  created(){
    this.checkStatus();
  },
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
a{
  text-decoration: none;
}
#film-header-nav{
  width: 100%;
  height: 80px;
  background: -webkit-linear-gradient(bottom,#444,gray,white) no-repeat;
  position: fixed;
  z-index: 80;
  top: 0;
  /*阴影*/
  box-shadow: 10px 0px 20px gray;
}
#film-footer-nav{
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

/*头部  左侧导航栏*/
#header-nav-left{
  width: 600px;
  height: 80px;
  float: left;
}
/*头部右侧导航栏*/
#header-nav-right{
  width: 400px;
  height: 80px;
  float: right;
  background: -webkit-linear-gradient(bottom,#444,gray,white) no-repeat;
}
/*头部左侧ul 处理*/
#header-nav-left ul{
  list-style: none;
  width: 500px;
  height: 50px;
  text-align: center;
}
/*头部 左侧li处理*/
#header-nav-left ul li{
  width: 100px;
  height: 50px;
  float: left;
  font-size: 20px;
  line-height: 50px;
}


</style>
