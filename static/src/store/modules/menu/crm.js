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
            name: '客户管理',
            path: '/crm',
            component: require('views/crm/CustomerInfo')
        },
        {
            name: '我的客户',
            path: '/crm/my-customer',
            component: require('views/crm/MyCustomer')
        },
        {
            name: '客户',
            path: '/crm/customer/:id',
            component: require('views/crm/Customer')
        },
        {
            name: '添加客户',
            path: '/crm/customer-add',
            meta: {
                link: 'crm/CustomerAdd.vue'
            },
            component: require('views/crm/CustomerAdd')
        },
        {
            name: '客户信息编辑',
            path: '/crm/customer-edit/:id',
            meta: {
                link: 'crm/CustomerEdit.vue'
            },
            component: require('views/crm/CustomerEdit')
        }
    ]
}
