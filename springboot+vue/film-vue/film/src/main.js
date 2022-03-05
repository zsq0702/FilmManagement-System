import Vue from 'vue'
import App from './App.vue'
//引入路由
import  router from './router'
//引入axios
import axios from 'axios'
import VueAxios from 'vue-axios'
//引入Element UI
import  ElementUI from 'element-ui'
//引入element 主题
import 'element-ui/lib/theme-chalk/index.css'
//引入video 插件
import VideoPlayer from 'vue-video-player'

Vue.config.productionTip = false

//使用axios
Vue.use(VueAxios,axios);
//使用ElementUI
Vue.use(ElementUI);
//使用video
Vue.use(VideoPlayer);

require('video.js/dist/video-js.css');
require('vue-video-player/src/custom-theme.css');


//结合路由首尾  进行跳转之前验证
router.beforeEach((to,from,next)=>{
  if(to.meta.requireAuth){
    console.log(localStorage.user);//获取localStorage中存的用户信息
    //如果没有用户信息   那么 我们认为没有登录  则跳转到登录页面
    if(localStorage.user){
      next();//放行
    }else{
      next({
        path:'Login',
        query:{redirect:to.fullPath}
      });
    }
  }else{
    next();//放行
  }
})


//添加全局事件监控方法
Vue.prototype.$addStorageEvent = function (type,key,data) {

  if(type===1){
    //创建一个StorageEvent事件
    var newStorageEvent = document.createEvent('StorageEvent');
    const  storage = {
      setItem:function (k,val) {
        localStorage.setItem(k,val);
        //初始化创建事件
        newStorageEvent.initStorageEvent('setItem',false,false,k,null,val,null,null);
        //派发对象
        window.dispatchEvent(newStorageEvent)
      }
    }
    return storage.setItem(key,data);
  }

}

new Vue({
  render: h => h(App),
  router,//加载路由
}).$mount('#app')
