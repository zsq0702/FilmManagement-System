<template>
    <div class="hello">
        <button @click="limitClick(1)">点击设置上传数量：2</button>
        <button @click="limitClick(0)">点击取消上传数量</button>
        <div>目前可上传数量限制：<span v-if="!limit">无</span><span v-if="limit">{{limit}}</span></div>
        <div class="upload">
            <div class="upload_warp">
                <div class="upload_warp_left" @click="fileClick">
                    <img src="../static/images/upload.png">
                </div>
                <div class="upload_warp_right" @drop="drop($event)" @dragenter="dragenter($event)" @dragover="dragover($event)">
                    或者将文件拖到此处
                </div>
            </div>
            <div class="upload_warp_text">
            选中{{imgList.length}}张文件，共{{bytesToSize(this.size)}}
        </div>
            <input @change="fileChange($event)" type="file" id="upload_file" multiple style="display: none"/>
            <!--<div class="upload_warp_img" v-show="imgList.length!=0">-->
                <!--<div class="upload_warp_img_div" v-for="(item,index) in imgList"-->
                     <!--v-dragging="{ item: item, list: imgList, group: 'color' }"-->
                     <!--:key="index"-->
                <!--&gt;-->
                    <!--<div class="upload_warp_img_div_top">-->
                        <!--<div class="upload_warp_img_div_text">-->
                            <!--{{item.file.name}}-->
                        <!--</div>-->
                        <!--<img src="../static/images/film7.jpg" class="upload_warp_img_div_del" @click="fileDel(index)">-->
                    <!--</div>-->
                    <!--<img :src="item.file.src">-->
                <!--</div>-->
            <!--</div>-->
        </div>
        <div v-for="(item,index) in imgList" :key="index" style="text-align: left">
            {{index}}：{{item.file.name}}
        </div>
    </div>
</template>

<script>
    export default {
        name: 'hello',
        data() {
            return {
                imgList: [],
                size: 0,
                limit:undefined,
            }
        },
        methods: {
            //设置
            limitClick(state) {
                this.imgList = [];
                if (state)
                    this.limit = 2;
                else
                    this.limit = undefined;
            },
            fileClick() {
                document.getElementById('upload_file').click()
            },
            fileChange(el) {
                if (!el.target.files[0].size) return;
                this.fileList(el.target);
                el.target.value = ''
            },
            fileList(fileList) {
                let files = fileList.files;
                for (let i = 0; i < files.length; i++) {
                    //判断是否为文件夹
                    if (files[i].type != '') {
                        this.fileAdd(files[i]);
                    } else {
                        //文件夹处理
                        this.folders(fileList.items[i]);
                    }
                }
            },
            //文件夹处理
            folders(files) {
                let _this = this;
                //判断是否为原生file
                if (files.kind) {
                    files = files.webkitGetAsEntry();
                }
                files.createReader().readEntries(function (file) {
                    for (let i = 0; i < file.length; i++) {
                        if (file[i].isFile) {
                            _this.foldersAdd(file[i]);
                        } else {
                            _this.folders(file[i]);
                        }
                    }
                })
            },
            foldersAdd(entry) {
                let _this = this;
                entry.file(function (file) {
                    _this.fileAdd(file)
                })
            },
            fileAdd(file) {
                if (this.limit !== undefined) this.limit--;
                if (this.limit !== undefined && this.limit < 0) return;
                //总大小
                this.size = this.size + file.size;
                //判断是否为图片文件
                if (file.type.indexOf('image') == -1) {
                    file.src = 'wenjian.png';
                    this.imgList.push({
                        file
                    });
                } else {
                    let reader = new FileReader();
                    let image = new Image();
                    let _this=this;
                    reader.readAsDataURL(file);
                    reader.onload = function () {
                        file.src = this.result;
                        image.onload=function(){
                            let width = image.width;
                            let height = image.height;
                            file.width=width;
                            file.height=height;
                            _this.imgList.push({
                                file
                            });
                            console.log( _this.imgList);
                        };
                        image.src= file.src;
                    }
                }
            },
            fileDel(index) {
                this.size = this.size - this.imgList[index].file.size;//总大小
                this.imgList.splice(index, 1);
                if (this.limit !== undefined) this.limit = this.imgList.length;
            },
            bytesToSize(bytes) {
                if (bytes === 0) return '0 B';
                let k = 1000, // or 1024
                    sizes = ['B', 'KB', 'MB', 'GB', 'TB', 'PB', 'EB', 'ZB', 'YB'],
                    i = Math.floor(Math.log(bytes) / Math.log(k));
                return (bytes / Math.pow(k, i)).toPrecision(3) + ' ' + sizes[i];
            },
            dragenter(el) {
                el.stopPropagation();
                el.preventDefault();
            },
            dragover(el) {
                el.stopPropagation();
                el.preventDefault();
            },
            drop(el) {
                el.stopPropagation();
                el.preventDefault();
                this.fileList(el.dataTransfer);
            }
        }
    }
</script>
<style scoped>
    .upload_warp_img_div_del {
        position: absolute;
        top: 6px;
        width: 16px;
        right: 4px;
    }
    .upload_warp_img_div_top {
        position: absolute;
        top: 0;
        width: 100%;
        height: 30px;
        background-color: rgba(0, 0, 0, 0.4);
        line-height: 30px;
        text-align: left;
        color: #fff;
        font-size: 12px;
        text-indent: 4px;
    }
    .upload_warp_img_div_text {
        white-space: nowrap;
        width: 80%;
        overflow: hidden;
        text-overflow: ellipsis;
    }
    .upload_warp_img_div img {
        max-width: 100%;
        max-height: 100%;
        vertical-align: middle;
    }
    .upload_warp_img_div {
        position: relative;
        height: 100px;
        width: 120px;
        border: 1px solid #ccc;
        margin: 0px 30px 10px 0px;
        float: left;
        line-height: 100px;
        display: table-cell;
        text-align: center;
        background-color: #eee;
        cursor: pointer;
    }
    .upload_warp_img {
        border-top: 1px solid #D2D2D2;
        padding: 14px 0 0 14px;
        overflow: hidden
    }
    .upload_warp_text {
        text-align: left;
        margin-bottom: 10px;
        padding-top: 10px;
        text-indent: 14px;
        border-top: 1px solid #ccc;
        font-size: 14px;
    }
    .upload_warp_right {
        float: left;
        width: 57%;
        margin-left: 2%;
        height: 100%;
        border: 1px dashed #999;
        border-radius: 4px;
        line-height: 130px;
        color: #999;
    }
    .upload_warp_left img {
        margin-top: 32px;
    }
    .upload_warp_left {
        float: left;
        width: 40%;
        height: 100%;
        border: 1px dashed #999;
        border-radius: 4px;
        cursor: pointer;
    }
    .upload_warp {
        margin: 14px;
        height: 130px;
    }
    .upload {
        border: 1px solid #ccc;
        background-color: #fff;
        width: 650px;
        box-shadow: 0px 1px 0px #ccc;
        border-radius: 4px;
    }
    .hello {
        width: 650px;
    }
</style>
<!--&lt;!&ndash; 单文件上传组件 &ndash;&gt;-->
<!--<template>-->
    <!--<div>-->
        <!--<input type="file" id="file" hidden @change="fileChange" :accept="accept">-->
        <!--<div v-if="upMode=='url'" style="width: 100%;display:inline-flex;">-->
            <!--<el-input :value="path" disabled></el-input>-->
            <!--<el-button size="small" type="primary" @click="btnChange">{{autoUpload?label:'选择文件'}}</el-button>-->
            <!--<el-button v-if="!autoUpload && loadButton" size="small" type="success" @click="uploadClick">{{label}}</el-button>-->
        <!--</div>-->
        <!--<div v-else-if="upMode=='head'" class="upmode-head">-->
            <!--<div class="el-upload el-upload&#45;&#45;picture-card" @click="btnChange">-->
                <!--<i v-if="path==''" class="el-icon-plus"></i>-->
                <!--<img v-else :src="path">-->
            <!--</div>-->
            <!--<el-button v-if="!autoUpload && loadButton" size="small" type="success" @click="uploadClick">{{label}}</el-button>-->
        <!--</div>-->
        <!--<div v-else-if="upMode=='variable'" class="el-upload-dragger" @click="btnChange">-->
            <!--<div v-if="path==''">-->
                <!--<i class="el-icon-upload"></i><div class="el-upload__text"><em>{{label}}</em></div>-->
            <!--</div>-->
            <!--<img v-else :src="path">-->
        <!--</div>-->

    <!--</div>-->
<!--</template>-->

<!--<script>-->
    <!--import glob from '@/utils/global.js'-->
    <!--export default {-->
        <!--model: {-->
            <!--prop: 'path',-->
            <!--event: 'onsuccess'-->
        <!--},-->
        <!--props: {-->
            <!--label: {type: String, default: '上传'},//按钮文字-->
            <!--accept: {String,default:'image/jpeg,image/png,image/x-icon'},//预选文件类型-->
            <!--autoUpload:{type:Boolean, default:true},//是否自动上传-->
            <!--loadButton:{type:Boolean, default:true},//手动上传时是否生成上传按钮-->
            <!--path:String,//回显地址-->
            <!--action: {type: String, default: '/api/upload/img'},//传入action可以调用不同接口适应不同文件类型上传-->
            <!--upMode:{type: String, default: 'url'},//上传控件模式url,head,variable-->
        <!--},-->
        <!--methods: {-->
            <!--btnChange() {-->
                <!--var file = document.getElementById('file');-->
                <!--file.click();-->
            <!--},-->
            <!--fileChange(e){-->
                <!--try {-->
                    <!--const fu = this.getFile();-->
                    <!--if(fu==null)return;-->
                    <!--if(!this.beforeUpload(fu))return;-->
                    <!--if(this.autoUpload){-->
                        <!--this.submit(fu);-->
                    <!--}else{-->
                        <!--if(this.upMode=='url')return;-->
                        <!--//本地预览-->
                        <!--var reader = new FileReader();-->
                        <!--reader.readAsDataURL(fu);-->
                        <!--reader.onload = function(e) {-->
                            <!--var src = this.result;-->
                            <!--var str = '<img src="'+src+'">';-->
                            <!--var target=this.upMode=='head'?'.el-upload&#45;&#45;picture-card':'.el-upload-dragger';-->
                            <!--var nim = document.querySelector(target);-->
                            <!--if(nim) {-->
                                <!--nim.innerHTML='';-->
                                <!--nim.insertAdjacentHTML("beforeEnd", str)-->
                            <!--}-->
                        <!--};-->
                    <!--}-->

                <!--} catch (error) {-->
                    <!--console.debug('choice file err:',error);-->
                <!--}-->
            <!--},-->
            <!--beforeUpload(f) {-->
                <!--const maxSzie = glob.Config.UploadSize;-->
                <!--if (f.size/1024/1024 > maxSzie) {-->
                    <!--this.$message.error('上传文件大小不能超过'+maxSzie+'M.');-->
                    <!--return false;-->
                <!--}-->
                <!--var types = glob.Config.UploadType;-->
                <!--for (let i = 0; i < types.length; i++) {-->
                    <!--if(types[i]===f.type) return true;-->
                <!--}-->
                <!--this.$message.error('上传文件格式不允许!');-->
                <!--return false;-->
            <!--},-->
            <!--uploadClick(e){-->
                <!--this.submit();-->
            <!--},-->
            <!--submit(file){-->

                <!--try {-->
                    <!--if(!file) file = this.getFile();-->
                    <!--if(file==null)return;-->
                    <!--var isUpload =true;-->
                    <!--this.$emit('onbefore', file);-->
                    <!--if(!isUpload)return;-->
                    <!--const url =process.env.Store_API + this.action;-->
                    <!--var fd = new window.FormData();-->
                    <!--// 配置post请求的参数。参数名fileType，值为category（看后端的具体要求）-->
                    <!--fd.append('fileType', 'category');-->
                    <!--fd.append('file', file);-->
                    <!--var xhr = new XMLHttpRequest();-->
                    <!--xhr.open('POST', url, true);-->
                    <!--xhr.send(fd);-->
                    <!--xhr.onload = () => {-->
                        <!--if (xhr.status === 200) {-->
                            <!--var res = JSON.parse(xhr.responseText);-->
                            <!--if(res.code==1) {-->
                                <!--var imgurl = glob.StaticStoreHost+res.data;-->
                                <!--this.$emit('onsuccess', imgurl);-->
                            <!--}else{-->
                                <!--this.$message(res.message);-->
                            <!--}-->
                        <!--}-->
                    <!--}-->
                <!--} catch (error) {-->
                    <!--console.debug('upload file err:',error);-->
                <!--}-->
            <!--},-->
            <!--getFile(){-->
                <!--var file = document.getElementById('file');-->
                <!--if(file.files.length==0){-->
                    <!--this.$message('没有选择文件');-->
                    <!--return null;-->
                <!--}-->
                <!--return file.files[0];-->
            <!--},-->
        <!--},-->

    <!--}-->
<!--</script>-->
<!--&lt;!&ndash;&lt;!&ndash;<template>&ndash;&gt;&ndash;&gt;-->
    <!--&lt;!&ndash;&lt;!&ndash;<div class="movie-list">&ndash;&gt;&ndash;&gt;-->

        <!--&lt;!&ndash;&lt;!&ndash;<div class="movie-item">&ndash;&gt;&ndash;&gt;-->
            <!--&lt;!&ndash;&lt;!&ndash;<a href="#"><img src="../static/images/film1.jpg" alt=""/> </a>&ndash;&gt;&ndash;&gt;-->
            <!--&lt;!&ndash;&lt;!&ndash;<h2 class="title">叶问4</h2>&ndash;&gt;&ndash;&gt;-->
            <!--&lt;!&ndash;&lt;!&ndash;<div class="info">&ndash;&gt;&ndash;&gt;-->
                <!--&lt;!&ndash;&lt;!&ndash;<p class="info1">&ndash;&gt;&ndash;&gt;-->
                    <!--&lt;!&ndash;&lt;!&ndash;<span class="beizhu">热映中</span>&ndash;&gt;&ndash;&gt;-->
                <!--&lt;!&ndash;&lt;!&ndash;</p>&ndash;&gt;&ndash;&gt;-->
                <!--&lt;!&ndash;&lt;!&ndash;<p class="info2">&ndash;&gt;&ndash;&gt;-->

                    <!--&lt;!&ndash;&lt;!&ndash;<span class="pingfen">8.1</span>&ndash;&gt;&ndash;&gt;-->
                <!--&lt;!&ndash;&lt;!&ndash;</p>&ndash;&gt;&ndash;&gt;-->
            <!--&lt;!&ndash;&lt;!&ndash;</div>&ndash;&gt;&ndash;&gt;-->
        <!--&lt;!&ndash;&lt;!&ndash;</div>&ndash;&gt;&ndash;&gt;-->
        <!--&lt;!&ndash;&lt;!&ndash;<div class="movie-item">&ndash;&gt;&ndash;&gt;-->
            <!--&lt;!&ndash;&lt;!&ndash;<a href="#"><img src="../static/images/film1.jpg" alt=""/> </a>&ndash;&gt;&ndash;&gt;-->
            <!--&lt;!&ndash;&lt;!&ndash;<h2 class="title">叶问4</h2>&ndash;&gt;&ndash;&gt;-->
            <!--&lt;!&ndash;&lt;!&ndash;<div class="info">&ndash;&gt;&ndash;&gt;-->
                <!--&lt;!&ndash;&lt;!&ndash;<p class="info1">&ndash;&gt;&ndash;&gt;-->
                    <!--&lt;!&ndash;&lt;!&ndash;<span class="beizhu">热映中</span>&ndash;&gt;&ndash;&gt;-->
                <!--&lt;!&ndash;&lt;!&ndash;</p>&ndash;&gt;&ndash;&gt;-->
                <!--&lt;!&ndash;&lt;!&ndash;<p class="info2">&ndash;&gt;&ndash;&gt;-->

                    <!--&lt;!&ndash;&lt;!&ndash;<span class="pingfen">8.1</span>&ndash;&gt;&ndash;&gt;-->
                <!--&lt;!&ndash;&lt;!&ndash;</p>&ndash;&gt;&ndash;&gt;-->
            <!--&lt;!&ndash;&lt;!&ndash;</div>&ndash;&gt;&ndash;&gt;-->
        <!--&lt;!&ndash;&lt;!&ndash;</div>&ndash;&gt;&ndash;&gt;-->
        <!--&lt;!&ndash;&lt;!&ndash;<div class="movie-item">&ndash;&gt;&ndash;&gt;-->
            <!--&lt;!&ndash;&lt;!&ndash;<a href="#"><img src="../static/images/film1.jpg" alt=""/> </a>&ndash;&gt;&ndash;&gt;-->
            <!--&lt;!&ndash;&lt;!&ndash;<h2 class="title">叶问4</h2>&ndash;&gt;&ndash;&gt;-->
            <!--&lt;!&ndash;&lt;!&ndash;<div class="info">&ndash;&gt;&ndash;&gt;-->
                <!--&lt;!&ndash;&lt;!&ndash;<p class="info1">&ndash;&gt;&ndash;&gt;-->
                    <!--&lt;!&ndash;&lt;!&ndash;<span class="beizhu">热映中</span>&ndash;&gt;&ndash;&gt;-->
                <!--&lt;!&ndash;&lt;!&ndash;</p>&ndash;&gt;&ndash;&gt;-->
                <!--&lt;!&ndash;&lt;!&ndash;<p class="info2">&ndash;&gt;&ndash;&gt;-->

                    <!--&lt;!&ndash;&lt;!&ndash;<span class="pingfen">8.1</span>&ndash;&gt;&ndash;&gt;-->
                <!--&lt;!&ndash;&lt;!&ndash;</p>&ndash;&gt;&ndash;&gt;-->
            <!--&lt;!&ndash;&lt;!&ndash;</div>&ndash;&gt;&ndash;&gt;-->
        <!--&lt;!&ndash;&lt;!&ndash;</div>&ndash;&gt;&ndash;&gt;-->
        <!--&lt;!&ndash;&lt;!&ndash;<div class="movie-item">&ndash;&gt;&ndash;&gt;-->
            <!--&lt;!&ndash;&lt;!&ndash;<a href="#"><img src="../static/images/film1.jpg" alt=""/> </a>&ndash;&gt;&ndash;&gt;-->
            <!--&lt;!&ndash;&lt;!&ndash;<h2 class="title">叶问4</h2>&ndash;&gt;&ndash;&gt;-->
            <!--&lt;!&ndash;&lt;!&ndash;<div class="info">&ndash;&gt;&ndash;&gt;-->
                <!--&lt;!&ndash;&lt;!&ndash;<p class="info1">&ndash;&gt;&ndash;&gt;-->
                    <!--&lt;!&ndash;&lt;!&ndash;<span class="beizhu">热映中</span>&ndash;&gt;&ndash;&gt;-->
                <!--&lt;!&ndash;&lt;!&ndash;</p>&ndash;&gt;&ndash;&gt;-->
                <!--&lt;!&ndash;&lt;!&ndash;<p class="info2">&ndash;&gt;&ndash;&gt;-->

                    <!--&lt;!&ndash;&lt;!&ndash;<span class="pingfen">8.1</span>&ndash;&gt;&ndash;&gt;-->
                <!--&lt;!&ndash;&lt;!&ndash;</p>&ndash;&gt;&ndash;&gt;-->
            <!--&lt;!&ndash;&lt;!&ndash;</div>&ndash;&gt;&ndash;&gt;-->
        <!--&lt;!&ndash;&lt;!&ndash;</div>&ndash;&gt;&ndash;&gt;-->

        <!--&lt;!&ndash;&lt;!&ndash;<div class="movie-item">&ndash;&gt;&ndash;&gt;-->
            <!--&lt;!&ndash;&lt;!&ndash;<a href="#"><img src="../static/images/film1.jpg" alt=""/> </a>&ndash;&gt;&ndash;&gt;-->
            <!--&lt;!&ndash;&lt;!&ndash;<h2 class="title">叶问4</h2>&ndash;&gt;&ndash;&gt;-->
            <!--&lt;!&ndash;&lt;!&ndash;<div class="info">&ndash;&gt;&ndash;&gt;-->
                <!--&lt;!&ndash;&lt;!&ndash;<p class="info1">&ndash;&gt;&ndash;&gt;-->
                    <!--&lt;!&ndash;&lt;!&ndash;<span class="beizhu">热映中</span>&ndash;&gt;&ndash;&gt;-->
                <!--&lt;!&ndash;&lt;!&ndash;</p>&ndash;&gt;&ndash;&gt;-->
                <!--&lt;!&ndash;&lt;!&ndash;<p class="info2">&ndash;&gt;&ndash;&gt;-->

                    <!--&lt;!&ndash;&lt;!&ndash;<span class="pingfen">8.1</span>&ndash;&gt;&ndash;&gt;-->
                <!--&lt;!&ndash;&lt;!&ndash;</p>&ndash;&gt;&ndash;&gt;-->
            <!--&lt;!&ndash;&lt;!&ndash;</div>&ndash;&gt;&ndash;&gt;-->
        <!--&lt;!&ndash;&lt;!&ndash;</div>&ndash;&gt;&ndash;&gt;-->

    <!--&lt;!&ndash;&lt;!&ndash;</div>&ndash;&gt;&ndash;&gt;-->

<!--&lt;!&ndash;&lt;!&ndash;</template>&ndash;&gt;&ndash;&gt;-->
<!--&lt;!&ndash;<template>&ndash;&gt;-->
    <!--&lt;!&ndash;&lt;!&ndash;<el-carousel height="520px" :interval="3000" arrow="always">&ndash;&gt;&ndash;&gt;-->
        <!--&lt;!&ndash;&lt;!&ndash;<el-carousel-item>&ndash;&gt;&ndash;&gt;-->
            <!--&lt;!&ndash;&lt;!&ndash;<img src="../static/images/film1.jpg" alt="">&ndash;&gt;&ndash;&gt;-->
        <!--&lt;!&ndash;&lt;!&ndash;</el-carousel-item>&ndash;&gt;&ndash;&gt;-->
        <!--&lt;!&ndash;&lt;!&ndash;<el-carousel-item>&ndash;&gt;&ndash;&gt;-->
            <!--&lt;!&ndash;&lt;!&ndash;<img src="../static/images/film13.jpg" alt="">&ndash;&gt;&ndash;&gt;-->
        <!--&lt;!&ndash;&lt;!&ndash;</el-carousel-item>&ndash;&gt;&ndash;&gt;-->
        <!--&lt;!&ndash;&lt;!&ndash;<el-carousel-item>&ndash;&gt;&ndash;&gt;-->
            <!--&lt;!&ndash;&lt;!&ndash;<img src="../static/images/film12.jpg" alt="">&ndash;&gt;&ndash;&gt;-->
        <!--&lt;!&ndash;&lt;!&ndash;</el-carousel-item>&ndash;&gt;&ndash;&gt;-->
    <!--&lt;!&ndash;&lt;!&ndash;</el-carousel>&ndash;&gt;&ndash;&gt;-->
    <!--&lt;!&ndash;<el-backtop target=".page-component__scroll .el-scrollbar__wrap" :bottom="100">&ndash;&gt;-->
        <!--&lt;!&ndash;<div&ndash;&gt;-->
                <!--&lt;!&ndash;style="{&ndash;&gt;-->
        <!--&lt;!&ndash;height: 100%;&ndash;&gt;-->
        <!--&lt;!&ndash;width: 100%;&ndash;&gt;-->
        <!--&lt;!&ndash;background-color: #f2f5f6;&ndash;&gt;-->
        <!--&lt;!&ndash;box-shadow: 0 0 6px rgba(0,0,0, .12);&ndash;&gt;-->
        <!--&lt;!&ndash;text-align: center;&ndash;&gt;-->
        <!--&lt;!&ndash;line-height: 40px;&ndash;&gt;-->
        <!--&lt;!&ndash;color: #1989fa;&ndash;&gt;-->
      <!--&lt;!&ndash;}"&ndash;&gt;-->
        <!--&lt;!&ndash;&gt;&ndash;&gt;-->

        <!--&lt;!&ndash;</div>&ndash;&gt;-->
    <!--&lt;!&ndash;</el-backtop>&ndash;&gt;-->
    <!--&lt;!&ndash;&lt;!&ndash;<el-backtop target=".page-component__scroll .el-scrollbar__wrap"></el-backtop>&ndash;&gt;&ndash;&gt;-->
<!--&lt;!&ndash;</template>&ndash;&gt;-->

<!--&lt;!&ndash;<script>&ndash;&gt;-->
    <!--&lt;!&ndash;export default {&ndash;&gt;-->
        <!--&lt;!&ndash;name: "Test",&ndash;&gt;-->
        <!--&lt;!&ndash;// data: function () {&ndash;&gt;-->
        <!--&lt;!&ndash;//     return {&ndash;&gt;-->
        <!--&lt;!&ndash;//         imgs: [&ndash;&gt;-->
        <!--&lt;!&ndash;//             {url: require('../static/images/film1.jpg'), link: '/content1'},&ndash;&gt;-->
        <!--&lt;!&ndash;//             {url: require('../static/images/film2.jpg'), link: '/content1'},&ndash;&gt;-->
        <!--&lt;!&ndash;//             {url: require('../static/images/film3.jpg'), link: '/content1'},&ndash;&gt;-->
        <!--&lt;!&ndash;//             {url: require('../static/images/film4.jpeg'), link: '/content1'},&ndash;&gt;-->
        <!--&lt;!&ndash;//             {url: require('../static/images/film5.jpg'), link: '/content1'}&ndash;&gt;-->
        <!--&lt;!&ndash;//         ]&ndash;&gt;-->
        <!--&lt;!&ndash;//     }&ndash;&gt;-->
        <!--&lt;!&ndash;// },&ndash;&gt;-->
    <!--&lt;!&ndash;}&ndash;&gt;-->
<!--&lt;!&ndash;</script>&ndash;&gt;-->
<!--&lt;!&ndash;<style>&ndash;&gt;-->

    <!--&lt;!&ndash;/*.el-carousel__item h3 {*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*color: #475669;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*font-size: 18px;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*opacity: 0.75;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*line-height: 300px;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*margin: 0;*/&ndash;&gt;-->
    <!--&lt;!&ndash;/*}*/&ndash;&gt;-->
    <!--&lt;!&ndash;/*.el-carousel__item:nth-child(2n) {*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*background-color: black;*/&ndash;&gt;-->
    <!--&lt;!&ndash;/*}*/&ndash;&gt;-->

    <!--&lt;!&ndash;/*.el-carousel__item:nth-child(2n+1) {*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*background-color: black;*/&ndash;&gt;-->
    <!--&lt;!&ndash;/*}*/&ndash;&gt;-->
    <!--&lt;!&ndash;/*.el-carousel__item img {*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*text-align: center;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*height: 400px;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*width:770px;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*margin: 0 auto;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*display: block;*/&ndash;&gt;-->
    <!--&lt;!&ndash;/*}*/&ndash;&gt;-->
    <!--&lt;!&ndash;/*.movie-list{*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*display: flex;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*flex-wrap:wrap;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*padding: 7px;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*justify-content: space-between;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*width:1130px;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*height:350px;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*margin-left: 200px;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*background-color: yellow;*/&ndash;&gt;-->
    <!--&lt;!&ndash;/*}*/&ndash;&gt;-->
    <!--&lt;!&ndash;/*.movie-item{*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*border:5px solid white;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*box-shadow: 0 0 8px gray;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*margin: 4px 0;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*!*background-color: yellow;*!*/&ndash;&gt;-->

    <!--&lt;!&ndash;/*}*/&ndash;&gt;-->
    <!--&lt;!&ndash;/*.movie-item img{*/&ndash;&gt;-->

        <!--&lt;!&ndash;/*width:210px;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*height: 280px;*/&ndash;&gt;-->


    <!--&lt;!&ndash;/*}*/&ndash;&gt;-->

    <!--&lt;!&ndash;/*.title{*/&ndash;&gt;-->

        <!--&lt;!&ndash;/*margin-top: 0px;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*margin-bottom: 0px;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*font-size: 20px;*/&ndash;&gt;-->

    <!--&lt;!&ndash;/*}*/&ndash;&gt;-->
    <!--&lt;!&ndash;/*.info{*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*background-color: #eee;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*display: flex;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*justify-content: space-between;*/&ndash;&gt;-->

    <!--&lt;!&ndash;/*}*/&ndash;&gt;-->
    <!--&lt;!&ndash;/*.info p{*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*margin: 0;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*padding: 5px;*/&ndash;&gt;-->
    <!--&lt;!&ndash;/*}*/&ndash;&gt;-->
    <!--&lt;!&ndash;/*.pingfen{*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*color: red;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*font-size:15px;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*font-weight: bold;*/&ndash;&gt;-->
    <!--&lt;!&ndash;/*}*/&ndash;&gt;-->
    <!--&lt;!&ndash;/*.beizhu{*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*color: gray;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*font-size: 10px;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*font-weight: bold;*/&ndash;&gt;-->
    <!--&lt;!&ndash;/*}*/&ndash;&gt;-->
    <!--&lt;!&ndash;/*#main_img ul{*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*list-style: none;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*!*float: left;*!*/&ndash;&gt;-->

        <!--&lt;!&ndash;/*display: flex;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*!*width: 500px;*!*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*!*height: 30px;*!*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*!*text-align: center;*!*/&ndash;&gt;-->
    <!--&lt;!&ndash;/*}*/&ndash;&gt;-->
    <!--&lt;!&ndash;/*!*!*头部 左侧li处理*!*!*/&ndash;&gt;-->
    <!--&lt;!&ndash;/*#main_img ul li{*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*!*width: 100px;*!*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*!*height: 30px;*!*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*float: left;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*!*font-size: 20px;*!*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*!*line-height: 30px;*!*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*!*color: white;*!*/&ndash;&gt;-->

    <!--&lt;!&ndash;/*}*/&ndash;&gt;-->
    <!--&lt;!&ndash;/*#main_img ul li img {*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*!*text-align: center;*!*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*height: 280px;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*width:210px;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*margin-left: 10px;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*!*margin: 0 auto;*!*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*!*display: block;*!*/&ndash;&gt;-->
    <!--&lt;!&ndash;/*}*/&ndash;&gt;-->
    <!--&lt;!&ndash;/*#main_img1{*/&ndash;&gt;-->
       <!--&lt;!&ndash;/*width:230px;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*height: 300px;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*background-color: yellow;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*margin-left: 10px;*/&ndash;&gt;-->
    <!--&lt;!&ndash;/*}*/&ndash;&gt;-->
    <!--&lt;!&ndash;/*#main_img1 li{*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*!*width: 100px;*!*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*!*height: 30px;*!*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*float: left;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*!*font-size: 20px;*!*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*!*line-height: 30px;*!*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*!*color: white;*!*/&ndash;&gt;-->

    <!--&lt;!&ndash;/*}*/&ndash;&gt;-->
    <!--&lt;!&ndash;/*#main_img1 li img {*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*!*text-align: center;*!*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*height: 280px;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*width:210px;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*margin-left: 10px;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*!*margin: 0 auto;*!*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*!*display: block;*!*/&ndash;&gt;-->
    <!--&lt;!&ndash;/*}*/&ndash;&gt;-->
    <!--&lt;!&ndash;/*#main_img2{*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*width:230px;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*height: 300px;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*background-color: yellow;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*margin-left: 10px;*/&ndash;&gt;-->
    <!--&lt;!&ndash;/*}*/&ndash;&gt;-->
    <!--&lt;!&ndash;/*#main_img2 li{*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*!*width: 100px;*!*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*!*height: 30px;*!*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*float: left;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*!*font-size: 20px;*!*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*!*line-height: 30px;*!*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*!*color: white;*!*/&ndash;&gt;-->

    <!--&lt;!&ndash;/*}*/&ndash;&gt;-->
    <!--&lt;!&ndash;/*#main_img2 li img {*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*!*text-align: center;*!*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*height: 280px;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*width:210px;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*margin-left: 10px;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*!*margin: 0 auto;*!*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*!*display: block;*!*/&ndash;&gt;-->
    <!--&lt;!&ndash;/*}*/&ndash;&gt;-->
    <!--&lt;!&ndash;/*#main_img3{*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*width:230px;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*height: 300px;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*background-color: yellow;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*margin-left: 10px;*/&ndash;&gt;-->
    <!--&lt;!&ndash;/*}*/&ndash;&gt;-->
    <!--&lt;!&ndash;/*#main_img3 li{*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*!*width: 100px;*!*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*!*height: 30px;*!*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*float: left;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*!*font-size: 20px;*!*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*!*line-height: 30px;*!*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*!*color: white;*!*/&ndash;&gt;-->

    <!--&lt;!&ndash;/*}*/&ndash;&gt;-->
    <!--&lt;!&ndash;/*#main_img3 li img {*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*!*text-align: center;*!*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*height: 280px;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*width:210px;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*margin-left: 10px;*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*!*margin: 0 auto;*!*/&ndash;&gt;-->
        <!--&lt;!&ndash;/*!*display: block;*!*/&ndash;&gt;-->
    <!--&lt;!&ndash;/*}*/&ndash;&gt;-->
<!--&lt;!&ndash;</style>&ndash;&gt;-->