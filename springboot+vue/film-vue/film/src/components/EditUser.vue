<template>
    <div>
        <el-dialog title="修改用户" :visible.sync="dialogEdit.show">
            <el-form :model="formUserData" label-width="100px" ref="editUserForm" :rules="formRules">
                <!--电影id-->
                <el-form-item label="用户编号" prop="uId">
                    <el-input v-model="formUserData.uId" readonly="true"></el-input>
                </el-form-item>
                <!--电影名-->
                <el-form-item label="用户名" prop="uName">
                    <el-input v-model="formUserData.uName"></el-input>
                </el-form-item>
                <!--上映时间-->

                <el-form-item label="用户电话" prop="uMobile">
                    <el-input v-model="formUserData.uMobile"></el-input>
                </el-form-item>


            </el-form>
            <!--修改页面按钮-->
            <div id="edit-option">
                <el-button type="primary" @click="updateUser('editUserForm')">修改</el-button>
                <!--取消按钮  实际上  就是  将  当前的 组件 隐藏 -->
                <el-button @click="dialogEdit.show=false">取消</el-button>
            </div>

        </el-dialog>
    </div>
</template>

<script>
    export default {
        name: "EditUser",
        props:{
            dialogEdit:Object,   //用于显示
            formUserData:Object, //父类发送过来的表单数据
        },
        data(){
            return{
                formRules:{
                    uName:[{required:true,message:"用户不能为空",trigger:"blur"}],
                },
                formData:{
                    uId:'',
                    uName:'',
                    uPwd:'',
                    uBirth:'',
                    uMobile:'',
                },
            }
        },
        methods:{
            //更新电影方法    仿照  AddFilm中  新增电影方法   编写服务器  修改方法，并执行
            updateUser(editUserForm){

                this.$refs[editUserForm].validate((valid)=>{
                    if(valid){//校验成功
                        console.log("校验成功！");
                        console.log("修改！");
                        //验证成功后  进行  修改操作
                        let path = `http://localhost:8090/film/json/user/updateUser/`;
                        this.axios.post(path,this.formUserData).then(res=>{
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
            // handleAvatarSuccess(res, file) {
            //     console.log("信息:");
            //     console.log(res);
            //     console.log("文件:");
            //     if(res=="success"){//上传成功
            //         this.formUserData.filmImageMain = URL.createObjectURL(file.raw);
            //     }else{
            //         this.formFilmData.filmImageMain = require('../../static/image/error.jpg');
            //     }
            //     console.log(this.formFilmData.filmImageMain);
            //     // this.imageUrl = URL.createObjectURL(file.raw);
            // },
            // handleAvatarSuccess2(res, file) {
            //     console.log("信息:");
            //     console.log(res);
            //     console.log(res.data[0]);
            //     console.log("文件:");
            //     if(res.code==8888){//上传成功
            //         //用服务器发送回的  图片存的地址  替换  原始的图片数据
            //         this.formFilmData.filmImageMain = res.data[0].filmImageMain;
            //     }else{
            //         this.formFilmData.filmImageMain = require('../../static/image/error.jpg');
            //     }
            //     console.log(this.formFilmData.filmImageMain);
            //     // this.imageUrl = URL.createObjectURL(file.raw);
            // },
            //图片上传之前  检测
            // beforeAvatarUpload(file) {
            //     console.log(file);//上传完成之前  获取到的文件
            //
            //     const isJPG = file.type === 'image/jpeg';
            //     const isLt2M = file.size / 1024 / 1024 < 2;
            //
            //     if (!isJPG) {
            //         this.$message.error('上传头像图片只能是 JPG 格式!');
            //     }
            //     if (!isLt2M) {
            //         this.$message.error('上传头像图片大小不能超过 2MB!');
            //     }
            //     return isJPG && isLt2M;
            // },


        },
    }
</script>

<style scoped>
    /*.avatar{*/
        /*float: left;*/
        /*width: 200px;*/
        /*height: 200px;*/
        /*display: block;*/
        /*border-radius: 3px;*/
    /*}*/

</style>