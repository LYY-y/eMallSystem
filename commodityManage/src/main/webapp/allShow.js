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
                                '<img class="card-img-top" id="main_pic" src="'+d["main_pic"]+'" alt="Card image cap">'+
                                '<div class="card-body">'+
                                    '<h5 class="card-title text-truncate">'+d["title"]+'</h5>'+
                                    '<p class="card-text text-truncate">'+d["description"]+' </p>'+
                                    '<p class="card-text text-truncate"> '+d["promotion_price"]+'元 </p>'+
                                    '<p class="card-text text-truncate">销量：'+d["sale"]+'件  库存 '+d["stock"]+'件 </p>'+
                                '</div>'+
                                '<div class="card-footer">'+
                                    '<button class="fa fa-trash" id="deleteIcon" style="border: none; background: transparent" onclick="deleteCommodity('+i+')" aria-hidden="true"></button>' +
                                    '<button class="fa fa-pencil-square-o" id="editIcon" type="button" onclick="toEditOneCommodityPage('+i+')" style="border: none; background: transparent" aria-hidden="true"></button>'+
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


function deleteCommodity(i) {
    var cid = document.getElementById("cid"+i)["value"]
    $.ajax({
        type: "post",
        url: "commodity/delete",
        data: {"cid": cid},
        success:function () {
            console.log($("#template"+i));
            $("#template"+i).remove();
            console.log("success");
        },
        error:function (error) {
            console.log(error)
        }
    })
}

function toEditOneCommodityPage(i) {
    var cid = document.getElementById("cid"+i)["value"]
    window.location = "updateCommodityInfo.html?id="+cid+"";
}
