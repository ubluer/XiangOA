/**
 * @author Xiang.Yu
 * @version 0.0.1
 * @date 2017/3/2
 * @description crm.js
 */
import lazyLoading from './lazyLoading'

export default {
    meta: {
        label: '客户管理',
        icon: 'fa-group',
        expanded: false
    },

    children: [
        {
            name: '我的客户',
            path: '/my-customer',
            meta: {
                link: 'crm/MyCustomer.vue'
            },
            component: lazyLoading('crm/MyCustomer')
        }
    ]
}
