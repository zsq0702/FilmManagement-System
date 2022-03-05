import Vue from 'vue'
import Router from 'vue-router'
import Index from "@/components/Index";
import JoinUs from "../components/JoinUs";
import Login from "@/components/joinUsComponents/Login";
import Regist from "@/components/joinUsComponents/Regist";
import FilmManager from "@/components/FilmManager";
import Show from "@/components/Show";
import UserManager from "../components/UserManager";


Vue.use(Router);

export default  new Router({
   routes:[
        //1.Index 组件路由注册
       {
           path:'/Index',
           name:'Index',
           component:Index,
       },
       //2.加入我们 组件路由注册
       {
           path:'/JoinUs',
           name:'JoinUs',
           component:JoinUs,
           //子路由
           children:[
               //登录页面  子路由注册
               {
                   path:'/Login',
                   name:'Login',
                   component:Login,
               },
               //注册页面  子路由注册
               {
                   path:'/Regist',
                   name:'Regist',
                   component:Regist,
               },
               //将Regist页面  作为   JoinUs 的默认页面
               {
                   path:'/',
                   name:'JoinUsIndex',
                   redirect: '/Regist',
               },
           ],
       },
       //3.将Index页面 直接作为主页   当地址栏直接访问/的时候，重定向到/Index页面
       {
         path:'/',
         name:'FilmIndex',
         redirect:'/Index'
       },
       //4.电影管理路由
       {
         path:'/FilmManager',
         name:'FilmManager',
         component:FilmManager,
         //如果  某个路由后的页面  需要验证，那么   需要在路由配置中进行设置
         meta:{
             requireAuth:true,  //认证
         }
       },
       {
           path:'/UserManager',
           name:'UserManager',
           component:UserManager,
       },

       //5.展示页面 路由
       {
           path:'/Show',
           name:'Show',
           component:Show,
       },
   ]
});