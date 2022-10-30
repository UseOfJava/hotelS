function getUrlParam(name) {
//构造一个含有目标参数的正则表达式对象
    let reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
//匹配目标参数
    let r = window.location.search.substr(1).match(reg);
//返回参数值
    if (r != null) {
        return decodeURI(r[2]);
    }
    return null;
}

$text.append(getUrlParam('code') + "：30天内的使用情况");

$.ajax({
    url: "order/getroomorder",
    data: {room_id: getUrlParam('id')},
    /* async=true  {表示异步}  */
    /* async=false {表示同步}  */
    async: false,
    /* 1 == room_id */
    success: function (result) {
        orderinfo = JSON.stringify(result);
    }
});


for (let i = 0; i < 30; i++) {
    let date = new Date();

    date = date.setDate(date.getDate() + i);
    date = new Date(date);

    let year = date.getFullYear();
    let month = date.getMonth() + 1;
    let day = date.getDate();

    let date_text = year + "-" + month + "-" + day;

    let index = orderinfo.indexOf(date_text);

    if (index === -1) {
        $content.append("<div class='item'><font class='font'>" + date_text + "</font></div>");
    } else {
        $content.append("<div class='item1'><font class='font1'>" + date_text + "</font></div>");
    }

}