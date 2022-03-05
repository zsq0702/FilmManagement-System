import Vue from "vue";
import Router from "vue-router";
import Login from "../views/Login";
import Regist from "../views/Regist";
import Home from "../views/Home";
import Test from "../views/Test";
import JoinUs from "../views/JoinUs";
import UpLoad from "../views/UpLoad";
import FilmManage from "../views/FilmManage";
// import AdminHome from "../views/AdminHome";
import HistoryView from "../views/HistoryView";
import FilmDetail1 from "../views/FilmDetail1";
import Show from "../views/Show";
import FilmDetail2 from "../views/FilmDetail2";
import FilmDetail3 from "../views/FilmDetail3";
import FilmDetail4 from "../views/FilmDetail4";
import FilmDetail5 from "../views/FilmDetail5";
import Show2 from "../views/Show2";
import Show3 from "../views/Show3";
import Show4 from "../views/Show4";
import Show5 from "../views/Show5";
import Test1 from "../views/Test1";
import UserManage from "../views/UserManage";
import MovieRange from "../views/MovieRange";



Vue.use(Router);

export default new Router({
    routes: [
        // {
        //     path: "/",
        //     component: Home
        // },
        {
            path:'/',
            name:'zhuye',
            redirect:'/Login'
        },
        {
            path:'/Login',
            name:'Login',
            component:Login,
        },
        {
            path:'/Regist',
            name:'Regist',
            component:Regist,
        },
        {
            path:'/Home',
            name:'Home',
            component:Home,
            meta:{
                requireAuth:true,
            }
        },
        {
            path:'/Test',
            name:'Test',
            component:Test,
        },
        {
            path:'/Test1',
            name:'Test1',
            component:Test1,
        },
        // {
        //     path:'/HistoryView',
        //     name:'HistoryView',
        //     component:HistoryView,
        // },
        {
            path:'/JoinUs',
            name:'JoinUs',
            component:JoinUs,
        },
        {
            path:'/UpLoad',
            name:'UpLoad',
            component:UpLoad,
        },
        {
            path:'/FilmManage',
            name:'FilmManage',
            component:FilmManage,

        },
        {
            path:'/UserManage',
            name:'UserManage',
            component:UserManage,

        },

        // {
        //     path:'/AdminHome',
        //     name:'AdminHome',
        //     component:AdminHome,
        // },
        {
            path:'/HistoryView',
            name:'HistoryView',
            component:HistoryView,
        },
        {
            path:'/FilmDetail1',
            name:'FilmDetail1',
            component:FilmDetail1,
        },
        {
            path:'/FilmDetail2',
            name:'FilmDetail2',
            component:FilmDetail2,
        },
        {
            path:'/FilmDetail3',
            name:'FilmDetail3',
            component:FilmDetail3,
        },
        {
            path:'/FilmDetail4',
            name:'FilmDetail4',
            component:FilmDetail4,
        },
        {
            path:'/FilmDetail5',
            name:'FilmDetail5',
            component:FilmDetail5,
        },
        {
            path:'/Show',
            name:'Show',
            component:Show,
        },
        {
            path:'/Show2',
            name:'Show2',
            component:Show2,
        },
        {
            path:'/Show3',
            name:'Show3',
            component:Show3,
        },
        {
            path:'/Show4',
            name:'Show4',
            component:Show4,
        },
        {
            path:'/Show5',
            name:'Show5',
            component:Show5,
        },
        {
            path:'/MovieRange',
            name:'MovieRange',
            component:MovieRange,
        },

    ]
});