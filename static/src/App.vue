<template>
    <div id="app">
        <a>ffff</a>
        <!--<nprogress-container></nprogress-container>-->
        <NavHeader :show="true"></NavHeader>
        <!--<sidebar :show="sidebar.opened && !sidebar.hidden"></sidebar>-->
        <!--<app-main></app-main>-->
        <!--<footer-bar></footer-bar>-->
    </div>
</template>

<script>
//    import NprogressContainer from 'vue-nprogress/src/NprogressContainer'
    import {NavHeader} from 'components/layout/'
    import { mapGetters, mapActions } from 'vuex'

    export default {
        components: {
            NavHeader
        },

        beforeMount () {
            const { body } = document;
            const WIDTH = 768;
            const RATIO = 3;

            const handler = () => {
                if (!document.hidden) {
                    let rect = body.getBoundingClientRect();
                    let isMobile = rect.width - RATIO < WIDTH;
                    this.toggleDevice(isMobile ? 'mobile' : 'other');
                    this.toggleSidebar(!isMobile)
                }
            }

            document.addEventListener('visibilitychange', handler);
            window.addEventListener('DOMContentLoaded', handler);
            window.addEventListener('resize', handler)
        },

        computed: mapGetters({
            sidebar: 'sidebar'
        }),

        methods: mapActions([
            'toggleDevice',
            'toggleSidebar'
        ])
    }
</script>

<style lang="scss">


</style>
