<template>


    <div class="movie-item">
        <div class="movie-item-range">
            <p>1</p>
        </div>
        <div class="movie-item-img">

            <router-link to="/FilmDetail1">
                <img src="../static/images/film6.jpg" alt=""/>
            </router-link>
        </div>
        <div class="movie-item-info">

            <h2 class="title">天 火</h2>

            <div class="info">
                <router-link to="/FilmDetail1">
                    <i class="el-icon-video-play" style="font-size: 30px;float: left;margin-left: 20px"></i>
                </router-link>
                <p class="info1">
                    <span class="beizhu">无神论者的“出埃及记”</span>
                </p>
                <p class="info2">

                    <span class="pingfen">8.5</span>
                </p>
            </div>


        </div>
    </div>

    <!--<router-link to="/FilmDetail1">-->
        <!--<img src="../static/images/film6.jpg" alt=""/>-->
    <!--</router-link>-->


</template>

<script>
    export default {
        name: "Test1",
        data() {
            return {

            }
        }


    }
</script>


<style scoped>
    .movie-item{
        height: 100px;
        width: 490px;
        /*background: -webkit-linear-gradient(bottom,#444,gray,white) no-repeat;*/
        display: flex;

    }
    .movie-item-range{
        width:50px;
        height:90px;

        margin: 5px 5px 5px 5px;
    }
    .movie-item-range p{
        font-size: 30px;
        color: red;
    }
    .movie-item-img{
        width:80px;
        height:90px;

        margin: 5px 5px 5px 5px;
    }
    .movie-item-img img{
        width:80px;
        height: 90px;
    }
    .movie-item-info{
        width:300px;
        height:90px;

        margin: 5px 5px 5px 5px;
    }
    .title{


        margin-top: 15px;
        margin-bottom: 0px;
        font-size: 20px;

    }
    .info{

        display: flex;
        justify-content: space-between;

    }
    .info p{
        margin: 0;
        padding: 5px;
    }
    .pingfen{
        color: red;
        font-size:20px;
        font-weight: bold;
    }
    .beizhu{
        color: gray;
        font-size: 10px;
        font-weight: bold;
    }
    .way{
        color: orange;
        font-size:10px;
        font-weight: bold;
    }

</style>






