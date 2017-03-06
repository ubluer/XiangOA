<template>
    <div v-if="show">
        <mt-header title="标题过长会隐藏后面的内容啊哈哈哈哈" fixed>
            <router-link to="/" slot="left">
                <mt-button icon="back">返回</mt-button>
            </router-link>
            <mt-button icon="more" slot="right"></mt-button>
        </mt-header>
    </div>
</template>

<script>
    import {mapGetters, mapActions} from 'vuex'

    export default {

        props: {
            show: Boolean
        }
    }
</script>

<style lang="scss">

</style>
