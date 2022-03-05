<template>
    <div>
        <el-dialog title="修改电影" :visible.sync="dialogEdit.show">
            <el-form :model="formFilmData" label-width="100px" ref="editFilmForm" :rules="formRules">
                <!--电影id-->
                <el-form-item label="电影编号" prop="filmId">
                    <el-input v-model="formFilmData.filmId" readonly="true"></el-input>
                </el-form-item>
                <!--电影名-->
                <el-form-item label="电影名" prop="filmName">
                    <el-input v-model="formFilmData.filmName"></el-input>
                </el-form-item>
                <!--上映时间-->
                <el-form-item label="上映时间" prop="filmReleaseTime">
                    <el-date-picker
                        style="float: left;width: 100%"
                        v-model="formFilmData.filmReleaseTime"
                        type="datetime"
                        placeholder="请选择日期"
                    ></el-date-picker>
                </el-form-item>
                <!--图片信息显示-->
                <!--<el-form-item label="预览图" prop="filmImageMain">-->
                    <!--<el-image-->
                        <!--style="width: 200px;height: 200px;float: left;"-->
                        <!--:src="formFilmData.filmImageMain"-->
                    <!--&gt;</el-image>-->
                <!--</el-form-item>-->

                <!--图片显示  结合 上传功能  -->
                <el-form-item label="预览图">
                    <el-upload
                            class="avatar-uploader"
                            :action="'http://localhost:8090/film/json/film/uploadFilmImageMain2/'+formFilmData.filmId"
                            :show-file-list="false"
                            :on-success="handleAvatarSuccess2"
                            :before-upload="beforeAvatarUpload">
                        <img v-if="formFilmData.filmImageMain" :src="formFilmData.filmImageMain"
                             class="avatar">
                        <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                    </el-upload>
                </el-form-item>
                <!--测试通过服务器地址  显示图片-->
                <el-form-item label="测试图片">
                    <img width="200px" height="200px"
                     src="http://localhost:8090/film/image/film7.jpg">
                </el-form-item>
            </el-form>
            <!--修改页面按钮-->
            <div id="edit-option">
                <el-button type="primary" @click="updateFilm('editFilmForm')">修改</el-button>
                <!--取消按钮  实际上  就是  将  当前的 组件 隐藏 -->
                <el-button @click="dialogEdit.show=false">取消</el-button>
            </div>

        </el-dialog>
    </div>
</template>

<script>
    export default {
        name: "EditFilm",
        props:{
            dialogEdit:Object,   //用于显示
            formFilmData:Object, //父类发送过来的表单数据
        },
        data(){
          return{
            formRules:{
              filmName:[{required:true,message:"电影名不能为空",trigger:"blur"}],
            },
              formData:{
                  filmId:'',
                  filmName:'',
                  filmReleaseTime:'',
                  filmImageMain:'',
              },
          }
        },
        methods:{
            //更新电影方法    仿照  AddFilm中  新增电影方法   编写服务器  修改方法，并执行
            updateFilm(editFilmForm){

                this.$refs[editFilmForm].validate((valid)=>{
                    if(valid){//校验成功
                        console.log("校验成功！");
                        console.log("修改！");
                        //验证成功后  进行  修改操作
                        let path = `http://localhost:8090/film/json/film/updateFilm/`;
                        this.axios.post(path,this.formFilmData).then(res=>{
                            console.log(res);
                            if(res.data="success"){
                                this.$message({
                                message:'修改成功！',
                                type:'success',
                            });
                            this.dialogAdd.show = false;//添加成功  关闭添加窗口
                            this.$emit('update');//执行父组件中 @update方法  用于 刷新后台数据
                        }else{
                            this.$message({
                                message:'修改失败！',
                                type:'error',
                            });
                        }
                    })


                    }else{
                        console.log("校验失败！");
                    }
                });
            },
            //上传图片  完成后  处理
            handleAvatarSuccess(res, file) {
                console.log("信息:");
                console.log(res);
                console.log("文件:");
                if(res=="success"){//上传成功
                    this.formFilmData.filmImageMain = URL.createObjectURL(file.raw);
                }else{
                    this.formFilmData.filmImageMain = require('../../static/image/error.jpg');
                }
                console.log(this.formFilmData.filmImageMain);
                // this.imageUrl = URL.createObjectURL(file.raw);
            },
            handleAvatarSuccess2(res, file) {
                console.log("信息:");
                console.log(res);
                console.log(res.data[0]);
                console.log("文件:");
                if(res.code==8888){//上传成功
                    //用服务器发送回的  图片存的地址  替换  原始的图片数据
                    this.formFilmData.filmImageMain = res.data[0].filmImageMain;
                }else{
                    this.formFilmData.filmImageMain = require('../../static/image/error.jpg');
                }
                console.log(this.formFilmData.filmImageMain);
                // this.imageUrl = URL.createObjectURL(file.raw);
            },
            //图片上传之前  检测
            beforeAvatarUpload(file) {
                console.log(file);//上传完成之前  获取到的文件

                const isJPG = file.type === 'image/jpeg';
                const isLt2M = file.size / 1024 / 1024 < 2;

                if (!isJPG) {
                    this.$message.error('上传头像图片只能是 JPG 格式!');
                }
                if (!isLt2M) {
                    this.$message.error('上传头像图片大小不能超过 2MB!');
                }
                return isJPG && isLt2M;
            },


        },
    }
</script>

<style scoped>
    .avatar{
        float: left;
        width: 200px;
        height: 200px;
        display: block;
        border-radius: 3px;
    }

</style>