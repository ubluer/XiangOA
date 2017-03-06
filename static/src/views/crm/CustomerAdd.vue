<template>
    <div>
        <mt-header :title="customer?customer.name:'添加客户'">
            <router-link to="/crm/my-customer" slot="left">
                <mt-button icon="back">返回</mt-button>
            </router-link>
            <mt-button slot="right">保存</mt-button>
        </mt-header>

        <div>
            <mt-field label="客户名称" placeholder=""></mt-field>
            <div class="v-space" style="height: 5px"></div>
            <mt-field label="邮箱" placeholder="请输入邮箱" type="email"></mt-field>
            <mt-field label="密码" placeholder="请输入密码" type="password"></mt-field>
            <mt-field label="手机号" placeholder="请输入手机号" type="tel"></mt-field>
            <mt-field label="网站" placeholder="请输入网址" type="url"></mt-field>
            <mt-field label="数字" placeholder="请输入数字" type="number"></mt-field>
            <mt-field label="生日" placeholder="请输入生日" type="date"></mt-field>
            <mt-field label="自我介绍" placeholder="自我介绍" type="textarea" rows="4"></mt-field>
        </div>
    </div>
</template>
<script type="text/babel">
    import {customers} from 'vuex-store/faker'
    export default {
        data(){
            return {

            }
        },
        methods: {
            main_log(val) {
                console.log('main_log', val);
            },
            sub_log(val) {
                console.log('sub_log', val);
                this.$refs.target_1.collapse();
            }
        },
        computed: {
            customer(){
                return customers[this.$route.params.id];
            }
        }
    };
</script>