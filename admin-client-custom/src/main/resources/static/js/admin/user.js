/**
 * user页面下拉框事件
 * author:kekee0724
 */
$(function () {
    $("#selectUserId").change(function () {
        var uid = $("#selectUserId").val();
        var url = "/admin/deletUser/" + uid;
        window.location.href = url;
    })
});