/*
  mysql  datetime 日期格式 转换
 */
function makeDate(date) {
    try {
        var newDate = new Date(date);
        //在小于10月  前面补0
        var month = eval(newDate.getMonth()+1)<10?'0'+ eval(newDate.getMonth()+1): eval(newDate.getMonth()+1);
        //在小于10的日期前 补0
        var day = newDate.getDate()<10?'0'+newDate.getDate():newDate.getDate();
        //小于10的小时前补0
        var hours = newDate.getHours()<10?'0'+newDate.getHours():newDate.getHours();
        //小于10的分钟前
        var minutes = newDate.getMinutes()<10?'0'+newDate.getMinutes():newDate.getMinutes();
        //小于10的秒前
        var seconds = newDate.getSeconds()<10?'0'+newDate.getSeconds():newDate.getSeconds();
        //拼接时间
        var stringDate = newDate.getFullYear()+'-'+month+'-'+day+' '+hours+':'+minutes+':'+seconds;
    }catch (e) {
         stringDate = "0000-00-00 00:00:00";
    }
        return stringDate;

}

export {
    makeDate,
}
