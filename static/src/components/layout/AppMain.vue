<template>
    <div class="page-navbar">
        <router-view></router-view>
    </div>

</template>

<script>
    export default {
        name: 'page-navbar',
        data() {
            return {
                selected: '1'
            };
        }
    };
</script>

<style lang="scss">


</style>
