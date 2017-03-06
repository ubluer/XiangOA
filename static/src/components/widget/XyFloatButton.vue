<template>
    <div>
        <div>hehe{{radius}}</div>
        <slot></slot>
    </div>
</template>
<script>

    export default {
        props:[
            'radius'
        ]
    };
</script>