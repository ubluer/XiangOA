<template>
    <div>
        <mt-header :title="customer?customer.name:'添加客户'">
            <router-link to="/crm/my-customer" slot="left">
                <mt-button icon="back">返回</mt-button>
            </router-link>
            <mt-button slot="right"><i class="fa fa-edit fa-2x"></i></mt-button>
        </mt-header>

        <div>
            <div>editor</div>
            <mt-cell title="客户名称" label="描述信息" is-link></mt-cell>
        </div>
    </div>
</template>
<script type="text/babel">
    import {customers} from 'vuex-store/faker'
    export default {
        data(){
            return {}
        },
        methods: {},
        computed: {
            customer(){
                return customers[this.$route.params.id];
            }
        }
    };
</script>