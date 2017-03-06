<template>
    <div>
        <mt-header title="我的客户">
            <router-link to="/crm" slot="left">
                <mt-button icon="back">返回</mt-button>
            </router-link>
            <mt-button icon="more" slot="right"></mt-button>
        </mt-header>
        <xy-float-button :radius = "25">aaaa</xy-float-button>
        <mt-loadmore :top-method="loadTop" :bottom-method="loadBottom" :bottom-all-loaded="allLoaded" ref="loadmore">
            <ul>
                <li v-for="item in list">{{ item }}
                    <router-link :to="'/crm/customer/'+item.id">go</router-link>
                </li>
            </ul>
        </mt-loadmore>
    </div>
</template>
<script type="text/babel">
    import {myCustomers} from 'vuex-store/faker'
    import {XyFloatButton} from 'components/widget'
    import {mapGetters, mapActions} from 'vuex'

    export default {
        components:{
            XyFloatButton
        },
        data(){
            return {
                n: 5,
                list: myCustomers,
                allLoaded: false
            }
        },
        methods: {
            loadTop(){
                this.list.push(++this.n);
                this.$refs.loadmore.onTopLoaded();
            },
            loadBottom(){
                this.list.push(--this.n);
                this.$refs.loadmore.onBottomLoaded();
            },
            addCustomer(){
                alert(v);
            }

        }
    };
</script>