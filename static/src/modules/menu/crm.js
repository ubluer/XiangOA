/**
 * @author Xiang.Yu
 * @version 0.0.1
 * @date 2017/3/1
 * @description crm
 */
import lazyLoading from './lazyLoading'

export default {
    path: 'crm',
    meta: {
        icon: 'fa-building-o',
        expanded: false,
        label: '客户管理'
    },
    component: lazyLoading('crm', true),

    children: [
        {
            name: '客户',
            path: 'customer',
            meta: {
                description: '客户列表',
                repository: '',
                link: 'crm/customer.vue'
            },
            component: lazyLoading('crm/customer')
        }
    ]
}
