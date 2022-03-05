<template>
    <div class="user-manage-page">
        <div class="page-header">
            <el-page-header @back="goBack" content="用户管理">
            </el-page-header>
        </div>
        <hr>
        <div class="user-manage-table">
            <el-table
                    :data="tableData"
                    style="width: 100%"
            >
                <el-table-column
                        prop="uId"
                        label="用户编号"
                        sortable
                        width="180px">
                    <template slot-scope="{row,$index}">
                        <input class="edit-cell" v-if="showEdit[$index]"    v-model="row.uId">
                        <span v-if="!showEdit[$index]">{{row.uId}}</span>
                    </template>
                </el-table-column>


                <el-table-column
                        prop="uName"
                        label="用户名"
                        sortable
                        width="180">
                    <template slot-scope="{row,$index}">
                        <input class="edit-cell" v-if="showEdit[$index]"    v-model="row.uName">
                        <span v-if="!showEdit[$index]">{{row.uName}}</span>
                    </template>
                </el-table-column>
                <el-table-column
                        prop="uBirth"
                        label="出生日期"
                        sortable
                        width="180">
                    <template slot-scope="{row,$index}">
                        <input class="edit-cell" v-if="showEdit[$index]"    v-model="row.uBirth">
                        <span v-if="!showEdit[$index]">{{row.uBirth}}</span>
                    </template>
                </el-table-column>
                <el-table-column
                        prop="uMobile"
                        label="用户电话"
                        sortable
                        width="180">
                    <template slot-scope="{row,$index}">
                        <input class="edit-cell" v-if="showEdit[$index]"    v-model="row.uMobile">
                        <span v-if="!showEdit[$index]">{{row.uMobile}}</span>
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
        name: "UserManage",
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
                    uBirth: '1999-03-20',
                    uName: '张雨',
                    uId:'1',
                    uMobile:'1871341516'
                },
                    {
                        uBirth: '1987-03-14',
                        uName: '李图',
                        uId:'2',
                        uMobile:'15151978787'
                    },
                    {
                        uBirth: '2000-02-01',
                        uName: '吴宁',
                        uId:'3',
                        uMobile:'15101981432'
                    },
                    {
                        uBirth: '1998-02-16',
                        uName: '罗丽',
                        uId:'4',
                        uMobile:'13222373212'
                    },
                    {
                        uBirth: '1997-03-15',
                        uName: '周舟',
                        uId:'5',
                        uMobile:'15366532375'
                    },
                    {
                        uBirth: '2001-04-16',
                        uName: '李磊',
                        uId:'6',
                        uMobile:'17497681002'
                    },
                    {
                        uBirth: '1999-02-25',
                        uName: '张数',
                        uId:'7',
                        uMobile:'15377851652'
                    },
                    {
                        uBirth: '2002-05-26',
                        uName: '周玉',
                        uId:'8',
                        uMobile:'18366171986'
                    },
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

<style scoped>
    .user-manage-page{
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
    .user-manage-table{
        width:1400px;
        height:300px;
        margin-left: 50px;

    }
</style>