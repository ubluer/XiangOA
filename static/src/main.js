import Vue from 'vue'
import VueRouter from 'vue-router'
import ElementUi from 'element-ui'
import 'element-ui/lib/theme-default/index.css'

import CrmIndex from './crm/crm-index.vue'
import Customer from './crm/customer/customer.vue'

// 0. 如果使用模块化机制编程，導入Vue和VueRouter，要调用 Vue.use(VueRouter)
Vue.use(VueRouter);
Vue.use(ElementUi);

// 1. 定义（路由）组件。
// 可以从其他文件 import 进来
const Foo = {template: '<div>foo</div>'};
const Bar = {template: '<div>bar</div>'};

// 2. 定义路由
// 每个路由应该映射一个组件。 其中"component" 可以是
// 通过 Vue.extend() 创建的组件构造器，
// 或者，只是一个组件配置对象。
// 我们晚点再讨论嵌套路由。
const routes = [
    {path: '/foo', component: Foo},
    {path: '/bar', component: Bar},
    {
        path: '/crm', component: CrmIndex,
        children: [{path:'customer',component:Customer}]
    }
];

// 3. 创建 router 实例，然后传 `routes` 配置
// 你还可以传别的配置参数, 不过先这么简单着吧。
const router = new VueRouter({
    routes // （缩写）相当于 routes: routes
});

// 4. 创建和挂载根实例。
// 记得要通过 router 配置参数注入路由，
// 从而让整个应用都有路由功能
const app = new Vue({
    router,
    data: {
        isBlur: false
    },
    mounted(){
        //确保页面浏览器刷新时，如果不是首页，不显示菜单
        this.isBlur = !location.href.endsWith('#/');
    },
    watch: {
        '$route' (to, from) {
            // 跳转时控制菜单显示和隐藏
            this.isBlur = to.path != '/';
        }
    },
    method: {}
}).$mount('#app');
