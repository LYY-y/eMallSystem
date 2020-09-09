function getUrlParam() {
    // var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var param = window.location.search.split("=")[1];
    return param;
}

function transDate(timestamp){
    var date = new Date(timestamp);
    // 取得年 (yyyy)
    Y = date.getFullYear() + '-';
    // 取得月 (0-11)
    M = (date.getMonth()+1 < 10 ? '0' + (date.getMonth()+1) : date.getMonth()+1) + '-';
    // 取得日 (1-31)
    D = (date.getDate()+1 < 10 ? '0' + date.getDate() : date.getDate()) + ' ';
    // 取得時 (0-23)
    h = (date.getHours() + 1 < 10 ? '0' + (date.getHours()+1) : date.getHours()+1) + ':';
    // 取得分 (0-59)
    m = (date.getMinutes() + 1 < 10 ? '0' + date.getMinutes() : date.getMinutes()) + ':';
    // 取得秒 (0-59)
    s = (date.getSeconds()+1 < 10 ? '0'+date.getSeconds() : date.getSeconds());
    console.log(Y+M+D+h+m+s)
    return Y+M+D+h+m+s;
}


//折扣开始时间不早于今天
$('#promotion_start_time').datetimepicker({
    startDate: new Date(),
    todayBtn : true,
    todayHighlight: true,
    forceParse: true,
    keyboardNavigation: true,
    fontAwesome:'font-awesome',
    language:'zh-CN',
    format:'yyyy-mm-dd hh:ii',
    autoclose: true,
}).on("changeDate",function (ev) {
    if (ev){
        $('#promotion_end_time').datetimepicker('setStartDate',new Date($('#start_time').val()))
    }else {
        $('#promotion_end_time').datetimepicker('setStartDate', new Date())
    }
});

//折扣结束时间不晚于开始时间
$('#promotion_end_time').datetimepicker({
    startDate: new Date($("input[name='promotion_start_time']").innerText),
    todayBtn : true,
    todayHighlight: true,
    forceParse: true,
    keyboardNavigation: true,
    fontAwesome:'font-awesome',
    language:'zh-CN',
    format:'yyyy-mm-dd hh:ii',
}).on("changeDate", function (ev) {
    if (ev){
        $('#promotion_start_time').datetimepicker('setEndDate',new Date($('#end_time').val()))
    }else {
        $('#promotion_start_time').datetimepicker('setEndDate', )
    }
});

var cid = getUrlParam();
console.log(cid);
console.log(this)

$.ajax({
        url: "commodity/findOneCommodity?cid="+cid,
        data: null,
        contentType: "application/json;charset=UTF-8", //发送数据的格式
        type: "get",
        dataType: "json",
        success: function(data) {
            console.log(data)
            $("#title").attr("value",data['title']);
            $("#commodity_id").attr("value",data['commodity_id']);
            $("#price").attr("value",data['price']);
            $("#promotion_price").attr("value",data['promotion_price']);
            $("#description").attr("value",data['description']);
            $("#stock").attr("value",data['stock']);
            $("#weight").attr("value",data['weight']);
            $("#keywords").attr("value",data['keywords']);
            if (data['promotion_start_time']!=null){
                $("#start_time").attr("value", transDate(data['promotion_start_time']));
            }
            if (data['promotion_end_time']!=null) {
                $("#end_time").attr("value", transDate(data['promotion_end_time']));
            }
            $("#promotion_per_limit").attr("value",data['promotion_per_limit']);
            $("#product_category_input").attr("value", $("#c"+data['category_id']).text());
            $("#brand_id_input").attr("value", $("#b"+data['brand_id']).text());
            $("#promotion_type_input").attr("value", $("#"+data['promotion_type']).text());
            $("#product_category").attr("value", data['category_id']);
            $("#brand_name").attr("value", data['brand_id']);
            $("#place").attr("value",data['place']);
            },
        error: function() {
            alert("失败了")
        }
    });


//预览图片
function showPreview(source) {
    var file = source.files[0];
    if(window.FileReader) {
        var fr = new FileReader();
        fr.onloadend = function(e) {
            console.log(e.target.result);
            document.getElementById("main_pic").src = e.target.result;
        };
        fr.readAsDataURL(file);  //也是利用将图片作为url读出
    }
}



$("button.dropdown-item").click(function () {
    var name = $(this)[0].innerText;
    var id = $(this)[0].id;
    $($(this)[0].parentNode.parentNode.parentNode.children[1]).val(name)
    $($(this)[0].parentNode.parentNode.parentNode.children[2]).val(id)
});


$('label[required]').after('<span style="color:red">*</span>');

var files=[];
var that = this;

$("#upload").click(function(){
    $("#file").trigger("click");
})


//选择图片实时预览
$("#file").change(function(){
    // document.getElementById("gallery").innerHTML="";
    var img=document.getElementById("file").files;
    // var div=document.createElement("div");
    for(var i=0; i<img.length;i++){
        var box = document.createElement("div");
        box.setAttribute("style","padding-bottom:15px")

        document.getElementById("card-deck").append(box);

        var file = img[i];
        var url = URL.createObjectURL(file);
        var card = document.createElement("div")
        card.className = 'card';

        box.appendChild(card);

        var pic=document.createElement("img");
        pic.setAttribute("src",url);
        pic.setAttribute("height","150px");
        pic.setAttribute("width","150px");
        pic.className='card-img-top';

        card.appendChild(pic);

        var tool = document.createElement("div");
        tool.setAttribute("style","text-align:center");
        tool.className='card-footer'

        card.appendChild(tool);

        var deleteIcon = document.createElement("button");
        deleteIcon.setAttribute("id","deleteIcon")
        deleteIcon.className = 'fa fa-trash';
        deleteIcon.setAttribute("aria-hidden",true);
        deleteIcon.dataset.filename = img[i].name;

        tool.appendChild(deleteIcon);

        that.files = img;

        $(deleteIcon).click(function () {
            var filename = $(this).data("filename");
            $(this).parent().parent().parent().remove();
            var fileList = Array.from(that.files);
            for(var j=0;j<fileList.length;j++){
                if(fileList[j].name = filename){
                    fileList.splice(j,1);
                    break;
                }
            }
            that.files = fileList
        })
    }
})

function update() {
    var formData = new FormData($("#commodityBaseInfo")[0]);
    formData.append("cid",cid)
    $.ajax({
        url: "commodity/updateCommodity",
        type: "POST",
        data: formData,
        cache: false,
        processData: false,
        contentType: false,
        success: function (data) {
            var state = data['state'];
            console.log(state);
            if ('success'==state){
                alert("成功修改商品信息！");
                window.location.href = "allShow.html";
            }else if ('fail' == state){
                alert("修改商品信息失败！");
            }else {
                alert("未知错误！");
            }
        },
        error: function (err) {
            console.log(err)
            alert("Error!")
        }
    });
}




