$(document).ready(function () {
    $(".dropdown-item").click(function () {
        var com_category = $(this).text();
        $("#com_category").val(com_category);
    });
});
