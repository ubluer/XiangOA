import Vue from 'vue'
import ElementUi from 'element-ui'
import 'element-ui/lib/theme-default/index.css'

import router from './router'
import App from './App.vue'

Vue.use(ElementUi);

// 4. 创建和挂载根实例。
// 记得要通过 router 配置参数注入路由，
// 从而让整个应用都有路由功能
const app = new Vue({
    router,
    ...App
}).$mount('#app');
