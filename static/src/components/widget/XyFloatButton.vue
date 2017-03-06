<template>
    <div :style="'width:'+width+'px;height:'+width+'px;line-height:'+width+'px'"
         style="position:fixed;right:30px;bottom:80px;border:none;border-radius: 50%;background-color:#26a2ff;color:#fff"
         @click="handleClick">
        <div style="text-align: center">
            <slot></slot>
        </div>
    </div>
</template>
<script>

    export default {
        props: [
            'radius'
        ],
        computed: {
            width(){
                return this.radius ? this.radius * 2 : 50;
            }
        },
        methods:{
            handleClick(evt) {
                this.$emit('click', evt);
            }
        }
    };
</script>

