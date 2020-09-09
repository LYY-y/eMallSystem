var secondSessionId = null;

var orderCommodityList = new Array();
var orderCommodityNumList = new Array();
var orderCommoditySinglePriceList = new Array();

var orderItemNum = 0;
function getUrlParam() {
    // var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var param = window.location.search.split("=")[1];
    return param;
}

$('label[required]').after('<span style="color:red">*</span>');

$.ajax({
    url: "order/show",
    data: getUrlParam(),
    contentType: "application/json;charset=UTF-8", //发送数据的格式
    type: "post",
    dataType: "json",
    success: function(data) {
        console.log(data)
        secondSessionId = data['secondSessionId'];
        var orderBaseInfo = data['orderBaseInfo'];
        $("#from_place").attr("value",orderBaseInfo['from_place']);
        $("#order_state").attr("value","待付款");
        $("#all_price").attr("value",orderBaseInfo['all_price']);
        $("#real_pay").attr("value",Number(orderBaseInfo['real_pay'])+Number(0));
        $("#totalWeight").val(data['weight']);
        $("#freight").val(0);
        var commodities = data['commodities'];
        $("#totalNum").val(commodities.length)
        $.each(commodities,function (i,d) {
            var html = '<ul class="form-group list-group">\n' +
                '            <li  class="list-group-item d-flex justify-content-between align-items-center list-group-item-action">\n' +
                '                <span id="title'+i+'"></span>' +
                '                <span id="single_price'+i+'" hidden></span>' +
                '                <span id="weight'+i+'" hidden></span>' +
                '                <span>\n' +
                '                    <input type="number" id="'+i+'" value="1" onchange="changeFreight(this),changePrices(this),changeNumList(this)">\n' +
                '                    <span class="badge badge-primary badge-pill">件</span>\n' +
                '                </span>\n' +
                '            </li>\n' +
                '        </ul>'
            $("#commodityList").prepend(html);
            $("#title"+i+"").get(0).innerText = d['title'];
            $("#single_price"+i+"").get(0).innerText = d['promotion_price'];
            $("#weight"+i+"").get(0).innerText = d['weight'];
            orderCommodityList.push(d['cid']);
            orderCommodityNumList.push(1)
            orderCommoditySinglePriceList.push(d['promotion_price']);
        })
        orderItemNum = commodities.length;
        console.log("orderCommodityList",orderCommodityList);
        console.log("orderCommodityNumList",orderCommodityNumList);
        console.log("orderCommoditySinglePriceList",orderCommoditySinglePriceList);
    },
    error: function() {
        alert("失败了")
    }
});

function changeNumList(num){
    var i = num.id;
    orderCommodityNumList[i] = num.value;
    return i;
}

function changePrices(num) {
    var all_price = 0;
    var real_pay = 0;
    for (let i=0; i<orderItemNum; i++){
        console.log("single_price",$("#single_price"+i+"").get(0).innerText);
        console.log("i",$("#"+i+"").val());
        all_price = Number(all_price) + Number($("#single_price"+i+"").get(0).innerText) * Number($("#"+i+"").val());
    }
    $("#all_price").attr("value",all_price);
    $("#real_pay").attr("value",Number(all_price)+Number($("#freight").val()));
}

function changeFreight(num){
    var newWeight = 0;
    var newNum = 0;
    for (let i = 0; i < orderItemNum; i++){
        newWeight = Number(newWeight) + Number($("#weight"+i+"").get(0).innerText) * Number($("#"+i+"").val());
        newNum = Number(newNum) + Number($("#"+i+"").val());
    }
    var newFreight = checkFreight(newWeight,newNum,$("#first_weight").val(),$("#first_fee").val(),$("#continue_weight").val(),
        $("#continue_fee").val(),$("#charge_type").val());
    $("#freight").val(newFreight)
}




$("button.dropdown-item").click(function () {
    var name = $(this)[0].innerText;
    var id = $(this)[0].id;
    $($(this)[0].parentNode.parentNode.parentNode.children[1]).val(name);
    $($(this)[0].parentNode.parentNode.parentNode.children[2]).val(id);
});

function findFreight() {
    var map = {"from_place":$("#from_place").val(), "dest_place":$("#dest_place").val()};
    console.log(map);
    $.ajax({
        url: "freight/find",
        data: map,
        type: "post",
        success: function(data) {
            console.log(data)
            if (data['state'] == 'success'){
                var freightInfo = data['freight']
                $("#first_weight").val(freightInfo['first_weight']);
                $("#first_fee").val(freightInfo['first_fee']);
                $("#continue_weight").val(freightInfo['continue_weight']);
                $("#continue_fee").val(freightInfo['continue_fee']);
                $("#charge_type").val(freightInfo['charge_type']);
            }
            var freight = checkFreight($("#totalWeight").val(), $("#totalNum").val(),$("#first_weight").val(),$("#first_fee").val(),
                $("#continue_weight").val(),$("#continue_fee").val(),$("#charge_type").val())
            $("#freight").val(freight);
            $("#real_pay").attr("value", Number($("#freight").val())+Number($("#all_price").val()))
        },
        error: function() {
            alert("查找运费失败！")
        }
    });
}

function checkFreight(weight,num,first_weight,first_fee,continue_weight,continue_fee,charge_type) {
    // charge_type计费类型:0->按重量；1->按件数; 2->包邮
    if (charge_type == ""){
        return 0;
    }else if (charge_type == 0){
        if (weight <= first_weight){
            if (weight == 0){
                return 0;
            }
            return first_fee;
        }else {
            var outWeight = Number(weight) - Number(first_weight);
            var outFee = Number(outWeight) / Number(continue_weight) * Number(continue_fee);
            return Number(first_fee) + Number(outFee);
        }
    }else if (charge_type == 1){
        //按数量算时，first_fee为一件的运费
        return Number(num) * Number(first_fee);
    }else if (charge_type == 2){
        return 0;
    }
}

function createOrder() {
    $.ajax({
        url: "order/create",
        type: "POST",
        traditional:true,
        dataType: 'json',
        data: {
            "dest_place":$("#dest_place").val(),
            "receiver_name":$("#receiver_name").val(),
            "receiver_phone":$("#receiver_phone").val(),
            "pay_method":$("#pay_method").val(),
            "freight":$("#freight").val(),
            "all_price":$("#all_price").val(),
            "real_pay":$("#real_pay").val(),
            "orderCommodities": orderCommodityList,
            "orderCommodityNumList":orderCommodityNumList,
            "orderCommoditySinglePriceList":orderCommoditySinglePriceList
        },
        success: function(data) {
            alert("成功提交订单")
            window.location.href="commodityDisplay.html";
        },
        error: function() {
            alert("失败了")
        }
    });
}