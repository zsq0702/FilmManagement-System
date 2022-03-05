<template>
    <div class="joinus-page">
        <div class="page-header">
            <el-page-header @back="goBack" content="加入我们">
            </el-page-header>
        </div>

        <hr>
        <div class="joinus-movie">
            <div class="joinus-movie-header">
                <p>个人信息</p>

            </div>


            <el-form ref="form" :model="form" label-width="80px">
                <el-form-item label="姓名">
                    <el-input v-model="form.name"></el-input>
                </el-form-item>
                <el-form-item label="性别">
                    <el-radio-group v-model="form.resource">
                        <el-radio label="男"></el-radio>
                        <el-radio label="女"></el-radio>
                    </el-radio-group>
                </el-form-item>
                <el-form-item label="上映时间">
                    <el-col :span="11">
                        <el-date-picker type="date" placeholder="选择日期" v-model="form.date1" style="width: 100%;"></el-date-picker>
                    </el-col>
                </el-form-item>
                <el-form-item label="移动电话">
                    <el-input v-model="form.name"></el-input>
                </el-form-item>
                <el-form-item label="电子邮箱">
                    <el-input v-model="form.name"></el-input>
                </el-form-item>
                <el-form-item label="学历">
                    <el-select v-model="form.region" placeholder="请选择学历">
                        <el-option label="小学" value="shanghai"></el-option>
                        <el-option label="初中" value="beijing"></el-option>
                        <el-option label="高中" value="shanghai"></el-option>
                        <el-option label="大专" value="beijing"></el-option>
                        <el-option label="本科" value="shanghai"></el-option>
                        <el-option label="硕士" value="beijing"></el-option>
                        <el-option label="博士" value="beijing"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="专业">
                    <el-input v-model="form.name"></el-input>
                </el-form-item>
                <el-form-item label="毕业学校">
                    <el-input v-model="form.name"></el-input>
                </el-form-item>
                <el-form-item label="毕业时间">
                    <el-col :span="11">
                        <el-date-picker type="date" placeholder="选择日期" v-model="form.date1" style="width: 100%;"></el-date-picker>
                    </el-col>
                </el-form-item>

                <div class="joinus-movie-header">
                    <p>工作经历</p>

                </div>
                <el-form-item label="起止时间">
                    <el-col :span="11">
                        <el-date-picker type="date" placeholder="选择日期" v-model="form.date1" style="width: 100%;"></el-date-picker>
                    </el-col>
                    <el-col class="line" :span="2">-</el-col>
                    <el-col :span="11">
                        <el-date-picker type="date" placeholder="选择日期" v-model="form.date1" style="width: 100%;"></el-date-picker>
                    </el-col>
                </el-form-item>
                <el-form-item label="企业名称">
                    <el-input v-model="form.name"></el-input>
                </el-form-item>
                <el-form-item label="所在部门">
                    <el-input v-model="form.name"></el-input>
                </el-form-item>
                <el-form-item label="职位名称">
                    <el-input v-model="form.name"></el-input>
                </el-form-item>

                <el-form-item label="工作描述">
                    <el-input type="textarea" v-model="form.desc"></el-input>
                </el-form-item>

                <div class="joinus-movie-header">
                    <p>项目经验</p>

                </div>
                <el-form-item label="起止时间">
                    <el-col :span="11">
                        <el-date-picker type="date" placeholder="选择日期" v-model="form.date1" style="width: 100%;"></el-date-picker>
                    </el-col>
                    <el-col class="line" :span="2">-</el-col>
                    <el-col :span="11">
                        <el-date-picker type="date" placeholder="选择日期" v-model="form.date1" style="width: 100%;"></el-date-picker>
                    </el-col>
                </el-form-item>
                <el-form-item label="项目名称">
                    <el-input v-model="form.name"></el-input>
                </el-form-item>

                <el-form-item label="项目描述">
                    <el-input type="textarea" v-model="form.desc"></el-input>
                </el-form-item>
                <el-form-item label="责任描述">
                    <el-input type="textarea" v-model="form.desc"></el-input>
                </el-form-item>

                <div class="joinus-movie-header">
                    <p>语言能力</p>

                </div>

                <el-form-item label="语言描述">
                    <el-input type="textarea" v-model="form.desc"></el-input>
                </el-form-item>

                <div class="joinus-movie-header">
                    <p>专业技能</p>

                </div>

                <el-form-item label="技能描述">
                    <el-input type="textarea" v-model="form.desc"></el-input>
                </el-form-item>

                <el-form-item>
                    <el-button type="primary" @click="onSubmit" style="border:white;background: -webkit-linear-gradient(bottom,#444,gray,white) no-repeat; ">上传简历</el-button>
                    <el-button>取消</el-button>
                </el-form-item>

            </el-form>
        </div>

    </div>
</template>

<script>
    export default {
        name: "JoinUs",
        data() {
            return {

                form: {
                    name: '',
                    region: '',
                    date1: '',
                    date2: '',
                    delivery: false,
                    type: [],
                    resource: '',
                    desc: ''
                },

            }
        },
        methods: {
            onSubmit() {
                console.log('submit!');
                this.$message({
                    message:'上传成功！',
                    type:'success',
                });
            },
            goBack() {
                console.log('go back');
                this.$router.go(-1);
            },
            handleRemove(file, fileList) {
                console.log(file, fileList);
            },
            handlePreview(file) {
                console.log(file);
            }
        }
    }
</script>

<style scoped>
    .joinus-page{
        width:1510px;
        height:1820px;
        background: -webkit-linear-gradient(bottom,#444,gray,white) no-repeat;
        /*background-color: gray;*/
    }
    .joinus-movie{
        width: 700px;
        height:1790px;
        margin-left: 400px;
        border:1px solid black;
        padding: 5px;

        background-color: #eee;
        border-radius: 5px;
    }
    .page-header{
        width:700px;
        height: 50px;

        position: fixed;
        z-index: 80;
        top: 20px;
        /*background-color: darkorange;*/
    }
    .joinus-movie-header{
        height: 25px;
        background-color: gray;
        margin-bottom: 5px;
        border-radius: 5px;
    }
    .joinus-movie-header p{
        font-size: 15px;
        color: black;
        margin-top: 10px;
        /*float: left;*/
    }

</style>