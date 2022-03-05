<template>
    <div id="main-UserManager">
        <h1>用户管理中心</h1>
        <el-row>
            <el-col :span="20" :push="2">
                <!--用户查询-->
                <div id="user-manager-nav">
                    <el-form>
                        <!--查询输入框-->
                        <el-form-item style="float: left;" label="查询用户:">
                            <el-input v-model="keyUser" placeholder="请输入要查询的用户..."
                                      @click.enter.native="searchUser(keyUser)"></el-input>
                            <!--这里的添加事件只是用来将AddFilm这个组件写的对话框 在当前页面显示出来-->
                        </el-form-item>
                        <!--新增按钮-->
                        <el-form-item style="float: right">
                            <el-button type="primary" size="small" icon="el-icon-edit-outline"
                                       @click="handleAdd">
                                添加
                            </el-button>
                            <!--对话框  -->
                            <el-dialog
                                    title="提示"
                                    :visible.sync="dialogVisible"
                                    width="30%"
                                    :before-close="handleClose"
                            >
                                <span>这是一段信息</span>
                                <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
  </span>
                            </el-dialog>

                        </el-form-item>
                    </el-form>
                </div>
                <!--用户信息  表格     -->
                <div id="film-table">
                    <el-table
                            :data="searchUser(keyUser)"
                            border
                            style="width: 100%">
                        <el-table-column
                                prop="uId"
                                label="用户编号"
                                width="200px">
                        </el-table-column>
                        <el-table-column
                                prop="uName"
                                label="用户名"
                                width="200px">
                        </el-table-column>
                        <el-table-column
                                prop="uPwd"
                                label="用户密码"
                                width="200px">
                        </el-table-column>
                        <el-table-column
                                prop="uBirth"
                                label="出生日期"
                                width="200px"
                                :formatter="formatDate">
                        </el-table-column>
                        <el-table-column
                                prop="uMobile"
                                label="用户电话"
                                width="200px">
                        </el-table-column>

                        <!--操作栏-->
                        <el-table-column label="操作" width="200px">
                            <template scope="scope">
                                <!--编辑按钮-->
                                <el-button type="primary" icon="el-icon-edit" circle
                                           @click="handleEdit(scope.$index,scope.row)"></el-button>
                                <!--删除按钮-->
                                <el-button type="danger" icon="el-icon-delete" circle
                                           @click="handleDel(scope.row.uId)"></el-button>
                            </template>
                        </el-table-column>
                    </el-table>
                    <!--分页处理-->
                    <el-pagination
                            background
                            layout="prev, pager, next"
                            :current-page="currPage"
                            :page-size="user.size"
                            :total="user.totalElements"
                            @current-change="handleCurrentPage">
                    </el-pagination>
                </div>
            </el-col>

        </el-row>
        <AddUser :dialogAdd="dialogAdd" @update="getData"></AddUser>
        <EditUser :dialogEdit="dialogEdit" :formUserData="formUserData"
                  @updateEdit="getData"></EditUser>
    </div>
</template>

<script>
    import {makeDate} from "@/components/common/dateformat";
    import  AddUser from './AddUser';
    import EditUser from "./EditUser";
    export default {
        name: "UserManager",
        components:{AddUser,EditUser},
        data(){
            return {
                //当前页面需要的数据，在这里改造
                user:{},//用于接收服务器发送的所有电影数据
                currPage: 1,//当前页码  默认第一页
                dialogVisible: false, //对话框 不显示
                keyUser:"",//实现输入电影名  查询  关键字的  数据
                dialogAdd:{    //用于 新增电影 对话框的显示
                    show:false
                },
                dialogEdit:{    //用于 修改电影  对话框的显示
                    show:false
                },
                //用于发送当前行的表单数据
                formUserData:{
                    uId:'',
                    uName:'',
                    uPwd:'',
                    uBirth:'',
                    uMobile:'',

                },
            }
        },
        methods:{
            //获取后台数据
            getData(){
                let path = `http://localhost:8090/film/json/user/showUsers/${this.currPage}`;
                this.axios.post(path).then(res=>{
                    console.log("success");
                    console.log(res);
                    this.user = res.data;
                });
            },
            //处理日期
            formatDate(row,colum){
                let date = row[colum.property];
                if(date==undefined){
                    return "";
                }
                return makeDate(date);
            },
            //查询用户
            searchUser(keyUser){
                return this.user.content.filter((user)=>{
                    if(user.uName.includes(keyUser)){
                        return user;
                    }
                });
            },
            //删除方法
            handleDel(uId){
                let path = `http://localhost:8090/film/json/user/delUser/${uId}`;
                this.axios.get(path).then(res=>{
                    if(res.data=="success"){
                        this.$message({
                            message:'删除成功',
                            type:'success',
                        });
                    }else{
                        this.$message({
                            message:'删除失败',
                            type:'error',
                        });
                    }
                    this.currPage = 1;
                    this.getData();
                });
            },
            //分页页码处理
            handleCurrentPage(val){
                this.currPage = val;//当前页码变化   Data存的  currPage会变化
                this.getData();  //从服务器接收数据中   currPage也会变化
            },
            //显示  新增页面
            handleAdd(){
                console.log("执行了新增按钮方法");
                this.dialogAdd.show = true;
            },
            //测试 关闭当前  对话框方法
            handleClose(done) {
                this.$confirm('确认关闭？')
                    .then(_ => {
                        done();
                    })
                    .catch(_ => {});
            },
            //处理修改
            handleEdit(index,row){
                console.log("修改方法");
                //将当前页面，你选中行的数据  获取到  放入到 formFilmData  中
                this.formUserData = {
                    uId:row.uId,
                    uName:row.uName,
                    uMobile:row.uMobile,
                };
                console.log(row);
                //将修改对话框在当前页面显示
                this.dialogEdit.show = true;
            },
        },
        //在页面加载时，进行的操作  一般会进行服务器访问
        created(){
            this.getData();//调用获取后台数据的方法
        },
    }
</script>

<style scoped>
    #main-UserManager{
        margin-top: 100px;
        height: 600px;
    }
</style>