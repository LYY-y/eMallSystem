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

function checkPromotion(text) {
    console.log(text)
    if (text == '无折扣'){
        disabledPromotion();
    }else {
        enablePromotion();
    }
}

function disabledPromotion(){
    $("#start_time").attr("disabled",true);
    $("#end_time").attr("disabled",true);
    $("#promotion_per_limit").attr("disabled",true);
    $("i.fa-calendar").hide();
}

function enablePromotion(){
    $("#start_time").attr("disabled",false);
    $("#end_time").attr("disabled",false);
    $("#promotion_per_limit").attr("disabled",false);
    $("i.fa-calendar").show();
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
    format:'yyyy-mm-dd hh:ii:ss',
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
    format:'yyyy-mm-dd hh:ii:ss',
}).on("changeDate", function (ev) {
    if (ev){
        $('#promotion_start_time').datetimepicker('setEndDate',new Date($('#end_time').val()))
    }else {
        $('#promotion_start_time').datetimepicker('setEndDate', )
    }
});


$("button.dropdown-item").click(function () {
    var name = $(this)[0].innerText;
    var id = $(this)[0].id;
    $($(this)[0].parentNode.parentNode.parentNode.children[1]).val(name);
    $($(this)[0].parentNode.parentNode.parentNode.children[2]).val(id);
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


$("#submit").click(function () {
    $("input[required]").each(function(){
        if ($(this).val() == null || $(this).val() == ""){
            // alert("请填写 "+$($(this)[0].parentNode.children[0]).html()+" 的值");
            $(this).popover('show');
        }
    });
    var files = that.files;
    var imgs = new Array();
    var formData = new FormData($("#commodityBaseInfo")[0]);
    for(var i=0;i<files.length;i++){
        console.log(i+" "+files[i].name)
        imgs.push(files[i])
    }
    console.log("imgs "+imgs)
    formData.append('imgs',imgs);
    $.ajax({
        url: "commodity/editCommodity",
        type: "POST",
        data: formData,
        cache: false,
        processData: false,
        contentType: false,
        success: function (data) {
            var state = data['state'];
            console.log(state);
            if ('success'==state){
                alert("成功添加商品信息！");
                window.location.href = "allShow.html";
            }else if ('fail' == state){
                alert("添加商品信息失败！");
            }else {
                alert("未知错误！");
            }
        },
        error: function (err) {
            console.log(err)
            alert("Error!")
        }
    });
})


