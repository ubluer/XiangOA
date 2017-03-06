<template>
    <div>
        <mt-header :title="customer.name">
            <router-link to="/crm/my-customer" slot="left">
                <mt-button icon="back">返回</mt-button>
            </router-link>
            <mt-button slot="right"><i class="fa fa-edit fa-2x"></i></mt-button>
        </mt-header>
        <div>{{$route.params.id}}:{{customer}}</div>
        <div><router-link :to="'/crm/customer-edit/'+$route.params.id">btt</router-link></div>
        <div>跟进列表</div>
        <div>
            <ul>
                <li>1</li>
                <li>1</li>
                <li>1</li>
                <li>1</li>
                <li>1</li>
                <li>1</li>
                <li>1</li>
            </ul>
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