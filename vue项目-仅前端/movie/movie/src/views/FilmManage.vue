<template>

        <div class="manage-page">
            <div class="page-header">
                <el-page-header @back="goBack" content="影片管理">
                </el-page-header>
            </div>

            <hr>
            <div class="manage-table">
                <el-table
                        :data="tableData"
                        style="width: 100%"
                >
                    <el-table-column
                            prop="title"
                            label="片名"
                            sortable
                            width="180">
                        <template slot-scope="{row,$index}">
                            <input class="edit-cell" v-if="showEdit[$index]"    v-model="row.title">
                            <span v-if="!showEdit[$index]">{{row.title}}</span>
                        </template>
                    </el-table-column>

                    <el-table-column
                            prop="pictures"
                            header-align="center"
                            align="center"
                            width="250px"
                            label="影片">
                        <template slot-scope="scope">
                            <el-popover
                                    placement="right"
                                    title=""
                                    trigger="hover">
                                <img :src="scope.row.pictures" style="height: 280px;width: 210px"/>
                                <img slot="reference" :src="scope.row.pictures" :alt="scope.row.pictures" style="height: 120px;width: 100px">
                            </el-popover>
                        </template>
                    </el-table-column>

                    <el-table-column
                            prop="name"
                            label="发布人"
                            sortable
                            width="180">
                        <template slot-scope="{row,$index}">
                            <input class="edit-cell" v-if="showEdit[$index]"    v-model="row.name">
                            <span v-if="!showEdit[$index]">{{row.name}}</span>
                        </template>
                    </el-table-column>
                    <el-table-column
                            prop="date"
                            label="发布时间"
                            sortable
                            width="180">
                        <template slot-scope="{row,$index}">
                            <input class="edit-cell" v-if="showEdit[$index]"    v-model="row.date">
                            <span v-if="!showEdit[$index]">{{row.date}}</span>
                        </template>
                    </el-table-column>
                    <el-table-column label="操作">
                        <template slot-scope="scope">
                            <el-button
                                    size="mini"
                                    @click="handleEdit(scope.$index, scope.row)"
                                    v-if="!showBtn[$index]">编辑</el-button>
                            <el-button
                                    size="mini"
                                    type="danger"
                                    @click="handleDelete(scope.$index, scope.row)">删除</el-button>
                        </template>
                    </el-table-column>
                </el-table>

                <el-pagination

                        layout="prev, pager, next"
                        :total="50"
                >
                </el-pagination>

            </div>


        </div>

</template>

<script>
    export default {
        name: "FilmManage",
        data() {
            return {
                showEdit: [], //显示编辑框
                showBtn: [],
                showBtnOrdinary: true,
                //编辑界面数据
                // editForm: {
                //     date: '2020-03-20',
                //     name: '李文涛',
                //     title: '天火',
                //
                // },

                tableData: [{
                    date: '2020-03-20',
                    name: '李文涛',
                    title: '天火',
                    pictures: require('../static/images/film6.jpg')
                },
                    {
                        date: '2020-03-14',
                        name: '艾莎',
                        title: '冰雪奇缘2',
                        pictures: require('../static/images/film7.jpg')
                    },
                    {
                        date: '2020-02-01',
                        name: '迈克·班宁',
                        title: '天使陷落',
                        pictures:require('../static/images/film8.jpg')
                    },
                    {
                        date: '2020-02-16',
                        name: '罗伊',
                        title: '星际探索',
                        pictures :require('../static/images/film9.jpg')
                    },
                    {
                        date: '2020-03-15',
                        name: 'Grant',
                        title: '鲨海逃生',
                        pictures :require('../static/images/film10.jpg')
                    }
                ]
            }
        },


        methods: {
            onSubmit() {
                console.log('submit!');
            },
            goBack() {
                console.log('go back');
                this.$router.go(-1);
            },
            handleEdit(index, row) {
                console.log(index, row);
                this.showEdit[index] = true;
                this.showBtn[index] = true;
                this.$set(this.showEdit,row,true);
                this.$set(this.showBtn,row,true);

            },
            handleDelete(index, row) {
                console.log(index, row);
                this.tableData.splice(index, 1);
            },

        },
    }
</script>

<style>
    .manage-page{
        width:1520px;
        height:880px;
        /*background-color: gray;*/

    }
    .page-header{
        width:700px;
        height: 50px;

        position: fixed;
        z-index: 80;
        top: 20px;
        /*background-color: darkorange;*/
    }
    .manage-table{
        width:1400px;
        height:300px;
        margin-left: 50px;

    }

</style>