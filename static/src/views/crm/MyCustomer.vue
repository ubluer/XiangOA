<style lang="scss">

</style>
<template>
    <div>
        <div class="tile is-ancestor">
            <div class="tile is-parent">
                <article class="tile is-child box">
                    <h4 class="title">客户管理</h4>
                    <mt-loadmore :top-method="loadTop" @top-status-change="handleTopChange">
                        <ul>
                            <li v-for="item in list">{{ item }}</li>
                        </ul>
                        <div slot="top" class="mint-loadmore-top">
                            <span v-show="topStatus !== 'loading'" :class="{ 'rotate': topStatus === 'drop' }">↓</span>
                            <span v-show="topStatus === 'loading'">Loading...</span>
                        </div>
                    </mt-loadmore>
                </article>
            </div>
        </div>

    </div>
</template>
<script>
    export default {
        data() {
            return {
                topStatus: '',
                list:[1,2,3,4,5,6,7]
            };
        },
        methods: {
            handleTopChange(status) {
                this.topStatus = status;
            },
            // ...
        },
        // ...
    };
</script>
