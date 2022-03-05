<template>
    <div id="main-join">

        <!--引入路由   通过router-view  显示子路由内容  -->
        <router-view/>
    </div>
</template>

<script>
    export default {
        name: "JoinUs"
    }
</script>

<style scoped>
#main-join{
    height: 600px;
    margin-top: 100px;
}

</style>