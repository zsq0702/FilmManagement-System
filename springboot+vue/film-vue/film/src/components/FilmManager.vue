<template>
    <div id="main-filmManager">
        <h1>电影管理页面</h1>
        <!--<div>{{filmInfo}}</div>-->
        <el-row>
            <el-col :span="20" :push="2">
                <!--电影管理导航栏-->
                <div id="film-manager-nav">
                    <el-form>
                        <!--查询输入框-->
                        <el-form-item style="float: left;" label="查询电影:">
                            <el-input v-model="keyFilm" placeholder="请输入要查询的电影..."
                            @click.enter.native="searchFilm(keyFilm)"></el-input>
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

        <!--电影信息  表格     searchFilm(keyFilm)    filmInfo.content-->
        <div id="film-table">
            <el-table
                :data="searchFilm(keyFilm)"
                border
                style="width: 100%"
            >
                <!--电影编号-->
                <el-table-column
                        prop="filmId"
                        label="电影编号"
                        width="180px">
                </el-table-column>
                <!--电影名-->
                <el-table-column
                        prop="filmName"
                        label="电影名称"
                        width="180px">
                </el-table-column>
                <!--图片处理 -->
                <el-table-column
                        prop="filmName"
                        label="预览图片"
                       >
                    <template scope="scope">
                        <el-image
                            style="width: 100px;height: 100px"
                            :src="scope.row.filmImageMain"></el-image>
                    </template>
                </el-table-column>
                <!--电影上映时间-->
                <el-table-column
                        prop="filmReleaseTime"
                        label="上映时间"
                        width="180px"
                        :formatter="formatDate">
                </el-table-column>
                <!--操作栏-->
                <el-table-column label="操作" width="200px">
                    <template scope="scope">
                        <!--编辑按钮-->
                        <el-button type="primary" icon="el-icon-edit" circle
                        @click="handleEdit(scope.$index,scope.row)"></el-button>
                        <!--删除按钮-->
                        <el-button type="danger" icon="el-icon-delete" circle
                        @click="handleDel(scope.row.filmId)"></el-button>
                    </template>
                </el-table-column>
            </el-table>
            <!--分页处理-->
            <el-pagination
                    background
                    layout="prev, pager, next"
                    :current-page="currPage"
                    :page-size="filmInfo.size"
                    :total="filmInfo.totalElements"
                    @current-change="handleCurrentPage">

            </el-pagination>
        </div>
            </el-col>
        </el-row>
        <AddFilm :dialogAdd="dialogAdd" @update="getData"></AddFilm>
        <EditFilm :dialogEdit="dialogEdit" :formFilmData="formFilmData"
        @updateEdit="getData"></EditFilm>
    </div>
</template>

<script>
    //引入dateformat.js
    import {makeDate} from "@/components/common/dateformat";
    //引入电影添加路由
    import  AddFilm from './AddFilm'
    import EditFilm from "./EditFilm";
    export default {
        name: "FilmManager",
        components:{EditFilm, AddFilm},
        //数据处理
        data(){
            return{
                //当前页面需要的数据，在这里改造
                filmInfo:{},//用于接收服务器发送的所有电影数据
                currPage: 1,//当前页码  默认第一页
                dialogVisible: false, //对话框 不显示
                keyFilm:"",//实现输入电影名  查询  关键字的  数据
                dialogAdd:{    //用于 新增电影 对话框的显示
                    show:false
                },
                dialogEdit:{    //用于 修改电影  对话框的显示
                  show:false
                },
                //用于发送当前行的表单数据
                formFilmData:{
                  filmId:'',
                  filmName:'',
                  filmReleaseTime:'',
                  filmImageMain:'',
                  //如果  当前行中还有别的数据，记得绑定
                  filmVideo:'',
                },
            }
        },
        //方法
        methods:{
          //定义方法
            //1.获取后台数据
            getData(){
                //查询服务器所有电影信息  url
                let path = `http://localhost:8090/film/json/film/showFilms/${this.currPage}`;
                console.log("获取数据");
                this.axios.post(path).then(res=>{
                   console.log("success");
                   console.log(res);
                   //如果后台返回结果 不一样，那么  res. 的内容 根据情况而变
                   this.filmInfo = res.data;//由于数据在data 里，直接将所有返回信息给filmInfo对象
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
            //删除方法
            handleDel(filmId){
              console.log("电影编号:"+filmId);
              let path = `http://localhost:8090/film/json/film/delFilm/${filmId}`;
              console.log("删除方法");
              this.axios.get(path).then(res=>{
                 console.log(res);
                 //根据后台返回的结果   进行页面处理  （数据重新获取）
                  if(res.data=="success"){
                      //删除成功 提示框
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
                  //无论是否删除成功，最终  页面跳转到第一页
                  this.currPage = 1;
                  //数据重新加载   我们自定义的getData 方法  可以实现  电影信息重新加载
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
            //根据关键字  查询操作    这里的方法   只是根据你输入的  keyFilm 去
            //分页的数据中   进行查询  比对   如果 关键字  与  分页数据的  电影名 有重合部分，则显示该数据
            searchFilm(keyFilm){
              return this.filmInfo.content.filter((film)=>{
                  //注意:  本身查询信息  一页只显示2条，那么过滤的话  也只可能有2条数据过滤
                  //如果  想要实现，在当前页面  模糊查询   应该与后台结合
                  if(film.filmName.includes(keyFilm)){
                      return film;
                  }
              });
            },
            //处理修改
            handleEdit(index,row){
                console.log("修改方法");
                //将当前页面，你选中行的数据  获取到  放入到 formFilmData  中
                this.formFilmData = {
                    filmId:row.filmId,
                    filmName:row.filmName,
                    filmReleaseTime:row.filmReleaseTime,
                    filmImageMain:row.filmImageMain,
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
    #main-filmManager{
        margin-top: 100px;
        height:800px;
    }
</style>