function verify() {
    var  name = $("#name").val();
    var password = $("#password").val();
    var form={'name':name,'password':password}
    console.log(form);
    $.ajax({
            url: "login/seller",
            data: JSON.stringify(form),
            contentType: "application/json;charset=UTF-8", //发送数据的格式
            type: "post",
            dataType: "json",
            success: function (data) {
                if (data['verify']){
                    $("#uniqueId").val(data['uniqueId']);
                    $("#jumpFormSubmit").click();
                }else {
                    var html = "<span id='errorTip' style='color: red; padding-bottom: 0px'>用户名或密码错误，请重新填写</span>";
                    $("#passwordDiv").append(html)
                }
            },
            error: function () {
                alert("错误");
            }
        })
}

function tip(){
    $("#errorTip").remove();
}
