<template>
    <div id="main-index">
        <div id="imgbox">
            <el-carousel :interval="4000" type="card" height="400px" >
                <el-carousel-item v-for="item in imgs" v-bind:key="item.url" >
                    <router-link :to="{ path: item.link }"><img :src="item.url"/></router-link>

                </el-carousel-item>
            </el-carousel>
        </div>




    </div>
</template>

<script>
    export default {
        name: "Index",
        //每个组件如果需要操作数据（接收数据并形成绑定）
        data(){
          return{
              radio1: '上海',
              uid:1001,
              uName:"刘", //单个值   数据
              user:{          //单个对象  数据
                uName:"Neu",
                uPwd:"123",
                uId:1001,
                uBalance:888.88,
                uBirth:"2000-1-1",
              },
              users:[    //多个对象  集合
                  {
                      uName:"张三",
                      uAge:20,
                  }, {
                      uName:"李四",
                      uAge:25,
                  },
              ],
              divState:true,   //定义div 的状态  包含了属性true
              imgs: [
                  {url: require('../../static/image/film1.jpg'), link: '/Show'},
                  {url: require('../../static/image/film2.jpg'),  link: '/Show'},
                  {url: require('../../static/image/film3.jpg'),  link: '/Show'},
                  {url: require('../../static/image/film4.jpeg'),  link: '/Show'},
                  {url: require('../../static/image/film5.jpg'),  link: '/Show'}
              ],
          }
        },
        methods:{
          //在该区域中  定义vue的方法   类似于 JQuery或者 JS 的方法的使用
            //点击按钮事件
            clickBtn(){
                console.log("点击了按钮！");
                this.divState=false;

            },
        },
        //监听器配置、计算属性、页面加载前加载内容处理、   vue的生命周期函数
    }
</script>

<style scoped>
    #main-index{
        margin-top: 80px;
        height:800px;
        width: 1510px;
        background: -webkit-linear-gradient(bottom,#444,gray,white) no-repeat;
    }

    #imgbox {
        height: 420px;
        width: 1510px;
        background-color: #444;
        /*box-shadow: 10px 10px 20px #444;*/
        /*overflow: hidden;*/
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
</style>