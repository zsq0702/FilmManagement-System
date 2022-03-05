<template>
    <div class="history">
        <div class="historypage-header">
            <el-page-header @back="goBack" content="观看历史">
            </el-page-header>
        </div>
        <hr>
        <div class="history-table">
            <el-table
                    :data="tableData"
                    style="width: 100%"
            >
                <el-table-column
                        prop="title"
                        label="片名"
                        sortable
                        width="180">
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

                <!--<el-table-column-->
                        <!--prop="name"-->
                        <!--label="发布人"-->
                        <!--sortable-->
                        <!--width="180">-->
                <!--</el-table-column>-->
                <el-table-column
                        prop="date"
                        label="观看时间"
                        sortable
                        width="180">
                </el-table-column>
                <el-table-column
                        prop="time"
                        label="观影时长"
                        sortable
                        width="180">
                </el-table-column>
                <el-table-column label="操作">
                    <template slot-scope="scope">

                        <el-button
                                size="mini"
                                type="danger"
                                @click="handleDelete(scope.$index, scope.row)">删除</el-button>
                    </template>
                </el-table-column>
            </el-table>

            <el-button type="primary" style="margin-right: 300px;
            margin-top:10px;width:140px;color: black;background-color: white;border: white">
                加载更多<i class="el-icon-arrow-down el-icon--right"></i>
            </el-button>
        </div>
    </div>
</template>

<script>
    export default {
        name: "History",data() {
            return {
                tableData: [{

                    date: '2019-12-23',
                    time:'1:30:24',
                    // name: '王伟',
                    title: '毒战',
                    pictures: require('../static/images/film11.jpg')
                },
                    {
                        date: '2020-01-19',
                        time:'1:13:02',
                        // name: '艾莎',
                        title: '听风者',
                        pictures: require('../static/images/film12.jpg')
                    },
                    {
                        date: '2020-03-21',
                        time:'0:46:35',
                        // name: '迈克·班宁',
                        title: '十二公民',
                        pictures:require('../static/images/film13.jpg')
                    },
                    {
                        date: '2020-01-12',
                        time:'1:45:21',
                        // name: '罗伊',
                        title: '意外',
                        pictures :require('../static/images/film14.jpg')
                    },
                    {
                        date: '2019-12-11',
                        time:'0:56:37',
                        // name: 'Grant',
                        title: '窃听风云3',
                        pictures :require('../static/images/film15.jpg')
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
            },
            handleDelete(index, row) {
                console.log(index, row);
                this.tableData.splice(index, 1);
            }
        },
    }
</script>

<style scoped>
.history{
    width:1520px;
    height:900px;
}
.historypage-header{
    width:700px;
    height: 50px;

    position: fixed;
    z-index: 80;
    top: 20px;
    /*background-color: darkorange;*/
}
.history-table{
    width:1400px;
    height:300px;
    margin-left: 50px;
}
</style>