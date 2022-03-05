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
// import VideoPlayer from 'vue-video-player'
import VideoPlayer from 'vue-video-player'

Vue.config.productionTip = false

//使用axios
Vue.use(VueAxios,axios);
//使用ElementUI
Vue.use(ElementUI);
Vue.use(VideoPlayer);
require('video.js/dist/video-js.css');
require('vue-video-player/src/custom-theme.css');

router.beforeEach((to,from,next)=>{
  if(to.meta.requireAuth){
    console.log(localStorage.user);
    if(localStorage.user){
      next();
    }else{
      next({
        path:'/Login',
        query:{redirect:to.fullPath}
      });
    }
  }else{
    next();
  }
})

Vue.prototype.$addStorageEvent=function (type,key,data) {
  if(type==1){
    var newStorageEvent =document.createEvent('StorageEvent');
    const storage={
      setItem:function (k,val) {
        localStorage.setItem(k,val);
        newStorageEvent.initStorageEvent('setItem',false,false,k,null,val,null,null);
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
