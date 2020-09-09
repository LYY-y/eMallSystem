$(function() {
    $.ajax({
        url: "commodity/allShow",
        data: null,
        contentType: "application/json;charset=UTF-8", //发送数据的格式
        type: "get",
        dataType: "json",
        success: function(data) {
            console.log(data)
            var html='';
            $.each(data,function (i,d) {
                html = '<div class="col-sm-3" style="padding-bottom: 15px" id="template'+i+'">'+
                    '<div class="card">'+
                    '<img class="card-img-top" id="main_pic" src="'+d["main_pic"]+'" alt="商品图片">'+
                    '<div class="card-body">'+
                    '<h5 class="card-title text-truncate">'+d["title"]+'</h5>'+
                    '<p class="card-text text-truncate">'+d["description"]+'</p>'+
                    '<p class="card-text text-truncate">价格： '+d["promotion_price"]+'元 </p>'+
                    '<p class="card-text text-truncate">销量：'+d["sale"]+'件   库存 '+d["stock"]+'件 </p>'+
                    '</div>'+
                    '<div class="card-footer">'+
                    '<button  id="pay" style="border: none; background: transparent" onclick="pay('+i+')" aria-hidden="true">直接购买</button>' +
                    '<button class="fa fa-shopping-cart" id="add_to_cart" type="button" onclick="add_to_cart('+i+')" style="border: none; background: transparent" aria-hidden="true">加入购物车</button>'+
                    '</div>'+
                    '<input id="cid'+i+'"value="' +d["cid"]+ '"hidden>'+
                    '</div>'+
                    '</div>'
                $("#card-deck").append(html);
            })
        },
        error: function() {
            alert("失败了")
        }
    });
})

function pay(i) {
    var cid = document.getElementById("cid"+i)["value"]
    var cids = new Array();
    cids.push(cid);
    console.log(cid)
    $.ajax({
        type: "post",
        url: "order/check",
        data: JSON.stringify(cids),
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
            console.log(error)
        }
    })
}

function add_to_cart(i) {
    var cid = document.getElementById("cid"+i)["value"]
    console.log(cid)
    $.ajax({
        type: "post",
        url: "cart/add",
        data: {"cid": cid},
        success:function (data) {
            if (data['state']=='success'){
                alert("已成功添加至购物车！")
            }else if (data['state']=='fail'){
                alert("添加购物车失败！")
            }
        },
        error:function (error) {
            alert("未知原因导致添加购物车失败！")
        }
    })
}


