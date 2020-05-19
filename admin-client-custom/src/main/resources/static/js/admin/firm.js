/**
 * firm页面下拉框事件
 * author:kekee0724
 */
$(function () {
    $("#selectFirmId").change(function () {
        var cid = $("#selectFirmId").val();
        var url = "/admin/deletFirm/" + cid;
        window.location.href = url;
    })
});