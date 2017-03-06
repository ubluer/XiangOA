import Vue from 'vue'
import axios from 'axios'
import NProgress from 'vue-nprogress'
import {sync} from 'vuex-router-sync'
import App from './App.vue'
import router from './router'
import store from './store'
import * as filters from './filters'
import {TOGGLE_SIDEBAR} from 'vuex-store/mutation-types'
import MintUI from 'mint-ui'
import 'mint-ui/lib/style.css'
import 'font-awesome/css/font-awesome.css'

Vue.prototype.$http = axios;
Vue.axios = axios;
Vue.use(NProgress);
Vue.use(MintUI);

// Enable devtools
Vue.config.devtools = true;

sync(store, router);

// const nprogress = new NProgress({parent: '.nprogress-container'});

const {state} = store;

// router.beforeEach((route, redirect, next) => {
//     if (state.app.device.isMobile && state.app.sidebar.opened) {
//         store.commit(TOGGLE_SIDEBAR, false)
//     }
//     next()
// });

Object.keys(filters).forEach(key => {
    Vue.filter(key, filters[key])
});

const app = new Vue({
    router,
    store,
    // nprogress,
    ...App
});

export {app, router, store}
