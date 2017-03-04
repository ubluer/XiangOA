<template>
    <div id="app">
        <!--<nprogress-container></nprogress-container>-->
        <xy-header :show="true"></xy-header>
        <!--<sidebar :show="sidebar.opened && !sidebar.hidden"></sidebar>-->
        <app-main></app-main>
        <xy-tabbar></xy-tabbar>
    </div>
</template>

<script>
    //    import NprogressContainer from 'vue-nprogress/src/NprogressContainer'
    import {XyHeader, XyTabbar, AppMain} from 'components/layout/'
    import {mapGetters, mapActions} from 'vuex'

    export default {
        components: {
            XyHeader,
            XyTabbar,
            AppMain
        },

        beforeMount () {
            const {body} = document;
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
