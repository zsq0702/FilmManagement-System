<template>
    <div>
        <el-dialog title="添加用户" :visible.sync="dialogAdd.show">
            <el-form :model="formData" label-width="100px" ref="addUserForm" :rules="formRules">
                <el-form-item label="用户名" prop="uName">
                    <el-input v-model="formData.uName"></el-input>
                </el-form-item>
                <el-form-item label="用户密码" prop="uPwd">
                    <el-input v-model="formData.uPwd"></el-input>
                </el-form-item>

                <el-form-item label="用户电话" prop="uMobile">
                    <el-input v-model="formData.uMobile"></el-input>
                </el-form-item>
            </el-form>
            <div id="add-option">
                <el-button type="primary" @click="addUser2('addUserForm')">确定</el-button>
                <!--取消按钮  实际上  就是  将  当前的 组件 隐藏 -->
                <el-button @click="dialogAdd.show=false">取消</el-button>
            </div>
        </el-dialog>
    </div>
</template>

<script>
    export default {
        name: "AddUser",
        props:{
            dialogAdd:Object    //用于接收父组件传递过来的参数
        },
        data(){
            return{
                formData:{
                    uId:'',
                    uName:'',
                    uPwd:'',
                    uBirth:'',
                    uMobile:'',
                },
                formRules:{
                    uName:[{required:true,message:"用户名不能为空",trigger:"blur"}],
                },
                pickerOptions: {
                    shortcuts: [{
                        text: '今天',
                        onClick(picker) {
                            picker.$emit('pick', new Date());
                        }
                    }, {
                        text: '昨天',
                        onClick(picker) {
                            const date = new Date();
                            date.setTime(date.getTime() - 3600 * 1000 * 24);
                            picker.$emit('pick', date);
                        }
                    }, {
                        text: '一周前',
                        onClick(picker) {
                            const date = new Date();
                            date.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
                            picker.$emit('pick', date);
                        }
                    },{   //自定义标签
                        text:'两天前',
                        onClick(picker){
                            const date = new Date();
                            date.setTime(date.getTime() - 3600 * 1000 * 24 * 2);
                            picker.$emit('pick', date);
                        }
                    }]
                },


            }
        },
        methods:{
            addUser(){
                console.log("执行添加功能！");
                let path = `http://localhost:8090/film/json/user/addUser/`;
                this.axios.post(path,this.formData).then(res=>{
                    console.log(res);
                    if(res.data=="success"){
                        this.$message({
                            message:'添加成功！',
                            type:'success',
                        });
                        this.dialogAdd.show = false;//添加成功  关闭添加窗口
                        this.$emit('update');//执行父组件中 @update方法  用于 刷新后台数据
                    }else{
                        this.$message({
                            message:'添加失败！',
                            type:'error',
                        });
                    }
                    //需要将数据清空，否则  可能上一次添加结果 还会显示
                    this.formData = "";//清空当前页面数据
                });
            },
            //添加电影2
            addUser2(addUserForm){
                this.$refs[addUserForm].validate((valid)=>{
                    if(valid){//校验成功
                        console.log("校验成功！");

                        let path = `http://localhost:8090/film/json/user/addUser/`;
                        this.axios.post(path,this.formData).then(res=>{
                            console.log(res);
                            if(res.data=="success"){
                                this.$message({
                                    message:'添加成功！',
                                    type:'success',
                                });
                                this.dialogAdd.show = false;//添加成功  关闭添加窗口
                                this.$emit('update');//执行父组件中 @update方法  用于 刷新后台数据
                            }else{
                                this.$message({
                                    message:'添加失败！',
                                    type:'error',
                                });
                            }
                            //需要将数据清空，否则  可能上一次添加结果 还会显示
                            this.formData = "";//清空当前页面数据
                        });


                    }else{
                        console.log("校验失败！");
                    }
                })
            },
        },
    }
</script>

<style scoped>

</style>