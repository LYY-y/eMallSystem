$.ajax({
    type: "get",
    url: "cart/show",
    success:function (data) {
        console.log(data);
        var html = '';
        $.each(data,function (i,d) {
            var html = '<label class="btn btn-light">\n' +
                '                <input type="checkbox" name="checkBox" id="'+d['cid']+'" autocomplete="off">'+d['title'] +
                '        </label>';
            $("#cartList").prepend(html);
        })

    },
    error:function (error) {
        alert("失败！");
    }
})

function buy() {
    var orderList = new Array();
    $("input[name='checkBox']").each(function () {
        if ($(this).prop('checked')){
            orderList.push($(this).attr("id"));
        }
    })
    console.log(JSON.stringify(orderList));
    $.ajax({
        type: "post",
        url: "order/check",
        data: JSON.stringify(orderList),
        contentType: "application/json;charset=UTF-8",
        success:function (data) {
            if (data['state']=='success') {
                console.log(data['uniqueId'])
                window.location.href = "orderDisplay.html?id="+data['uniqueId']+"";
            }else if (data['state']=='fail'){
                alert("下单失败！")
            }else {
                alert("其他错误导致下单失败！")
            }
        },
        error:function (error) {
            alert("失败！");
        }
    })
}

function resetChecked() {
    $("input[name='checkBox']").each(function () {
       $(this).prop('checked',false);
    })
}