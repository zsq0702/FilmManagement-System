<template>
<div class="upload-page">
    <div class="page-header">
        <el-page-header @back="goBack" content="上传影片">
        </el-page-header>
    </div>

    <hr>
    <div class="upload-movie">


    <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="电影名称">
            <el-input v-model="form.name"></el-input>
        </el-form-item>
        <el-form-item label="上映地区">
            <el-select v-model="form.region" placeholder="请选择电影上映地区">
                <el-option label="盐城市" value="shanghai"></el-option>
                <el-option label="阜宁县" value="beijing"></el-option>
                <el-option label="滨海县" value="shanghai"></el-option>
                <el-option label="大有县" value="beijing"></el-option>
                <el-option label="响水县" value="shanghai"></el-option>
                <el-option label="小尖镇" value="beijing"></el-option>
            </el-select>
        </el-form-item>
        <el-form-item label="上映时间">
            <el-col :span="11">
                <el-date-picker type="date" placeholder="选择日期" v-model="form.date1" style="width: 100%;"></el-date-picker>
            </el-col>
            <el-col class="line" :span="2">-</el-col>
            <el-col :span="11">
                <el-time-picker placeholder="选择时间" v-model="form.date2" style="width: 100%;"></el-time-picker>
            </el-col>
        </el-form-item>
        <el-form-item label="上线通知">
            <el-switch v-model="form.delivery"></el-switch>
        </el-form-item>
        <el-form-item label="电影类型">
            <el-checkbox-group v-model="form.type">
                <el-checkbox label="科幻" name="type"></el-checkbox>
                <el-checkbox label="悬疑" name="type"></el-checkbox>
                <el-checkbox label="喜剧" name="type"></el-checkbox>
                <el-checkbox label="动作" name="type"></el-checkbox>
                <el-checkbox label="爱情" name="type"></el-checkbox>
                <el-checkbox label="其他" name="type"></el-checkbox>
            </el-checkbox-group>
        </el-form-item>
        <el-form-item label="收费标准">
            <el-radio-group v-model="form.resource">
                <el-radio label="免费"></el-radio>
                <el-radio label="用券"></el-radio>
                <el-radio label="VIP免费"></el-radio>
                <el-radio label="普通用户6元/VIP半价"></el-radio>
            </el-radio-group>
        </el-form-item>
        <el-form-item label="影片介绍">
            <el-input type="textarea" v-model="form.desc"></el-input>
        </el-form-item>
        <el-form-item label="电影剧照" prop="image">
            <el-upload
                    class="upload-demo"
                    action="https://jsonplaceholder.typicode.com/posts/"
                    :on-preview="handlePreview"
                    :on-remove="handleRemove"
                    :file-list="fileList"
                    list-type="picture">
                <el-button size="max" style="border:white;width: 150%;background: -webkit-linear-gradient(bottom,#444,gray,white) no-repeat;" type="primary" >点击上传</el-button>
                <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
            </el-upload>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="onSubmit" style="border:white;background: -webkit-linear-gradient(bottom,#444,gray,white) no-repeat; ">立即上传</el-button>
            <el-button>取消</el-button>
        </el-form-item>

    </el-form>
    </div>

</div>
</template>

<script>
    export default {
        name: "UpLoad",
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
    .upload-page{
        width:1510px;
        height:825px;
        /*background-color: gray;*/
        background: -webkit-linear-gradient(bottom,#444,gray,white) no-repeat;
    }
.upload-movie{
    width: 700px;
    height:800px;
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


</style>