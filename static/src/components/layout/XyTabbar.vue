<template>
    <div class="page-tabbar">

        <mt-tabbar v-model="selected" fixed>
            <mt-tab-item id="customer">
                <i slot="icon" class="fa fa-university fa-1x"/>
                客户管理
            </mt-tab-item>
            <mt-tab-item id="订单">
                <img slot="icon" src="assets/logo.png">
                订单
            </mt-tab-item>
            <mt-tab-item id="发现">
                <img slot="icon" src="assets/logo.png">
                发现
            </mt-tab-item>
            <mt-tab-item id="我的">
                <img slot="icon" src="assets/logo.png">
                我的
            </mt-tab-item>
        </mt-tabbar>
    </div>
</template>

<script>
    export default {
        name: 'page-tabbar',
        data() {
            return {
                selected: 'customer'
            };
        }
    };
</script>

<style>
    .page-tabbar {
        overflow: hidden;
    }
</style>