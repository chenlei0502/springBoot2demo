$(function () {
    var search = $("#search-btn");
    search.click(function () {
        var name = $("#name");
        if (name.val() === null || name.val() === '') {
            alert("请输入查询关键字~");
            return;
        }
        search.submit();
    })
});