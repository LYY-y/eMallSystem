package com.eMall.controller;

import com.alibaba.fastjson.JSONObject;
import com.eMall.dto.CommodityBaseInfo;
import com.eMall.entity.Commodity;
import com.eMall.entity.CommodityPic;
import com.eMall.entity.enums.Promotion;
import com.eMall.service.CommodityService;
import com.eMall.util.CheckEmptyUtil;
import com.eMall.util.RandomNumUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/commodity")
public class CommodityController {
    @Autowired
    @Qualifier("commodityService")
    private CommodityService commodityService;

//    public void setService(CommodityService commodityService){
//        this.commodityService = commodityService;
//    }

    @RequestMapping(value = "/editCommodity",method = RequestMethod.POST)
    @ResponseBody
    public Object editCommodityBaseInfo(CommodityBaseInfo commodityBaseInfo, MultipartFile[] imgs, HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        CommodityPic[] commodityPics = createPics(imgs, jsonObject,request);
        Commodity commodity = createCommodity(commodityBaseInfo);
        try {
            commodityService.addCommodity(commodity, commodityPics, Long.valueOf(commodity.getCid()));
            jsonObject.put("state","success");
        }catch (Exception e){
            jsonObject.put("state","fail");
        }finally {
            return jsonObject;
        }
    }

    public CommodityPic[] createPics(MultipartFile[] imgs, JSONObject jsonObject, HttpServletRequest request){
        int pic_size = imgs.length;
        CommodityPic[] strings = new CommodityPic[pic_size];
        String pic_path = request.getServletContext().getRealPath("imgs");//文件存储地
        for (int i = 0; i < imgs.length; i++) {
            MultipartFile pic = imgs[i];
            if (checkPicIsEmpty(pic,jsonObject)){
                File file = new File(pic_path, pic.getOriginalFilename());
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                try {
                    pic.transferTo(file);
                    strings[i] = new CommodityPic(RandomNumUtil.createId(),file.getPath(),i);
                    jsonObject.put("info","上传文件成功");
                } catch (IOException e) {
                    e.printStackTrace();
                    jsonObject.put("info","上传文件失败，请上传.jpg或.png类型的图片");
                }
            }
        }
        return strings;
    }

    //判断上传文件是否为空
    public boolean checkPicIsEmpty(MultipartFile pic, JSONObject jsonObject){
        if (!pic.isEmpty()) {
            java.lang.String pic_name = pic.getOriginalFilename();//原始文件名
            if (pic_name.endsWith("jpg") || pic_name.endsWith("jpeg") || pic_name.endsWith("png")) {//限制只能上传jpg和png的图片文件
                return true;
            }else {
                jsonObject.put("info", "上传文件失败，请上传.jpg或.png类型的图片");
                return false;
            }
        }else {
            jsonObject.put("info","上传文件为空");
            return false;
        }
    }

    //初始化商品基本信息
    public Commodity createCommodity(CommodityBaseInfo commodityBaseInfo){
        Commodity commodity = new Commodity();
        String temp = commodityBaseInfo.getCommodity_id();
        if (CheckEmptyUtil.checkString(temp)) {
            commodity.setCommodity_id(Integer.valueOf(temp));
        }
        temp = commodityBaseInfo.getBrand_id();
        if (CheckEmptyUtil.checkString(temp)) {
            commodity.setBrand_id(Integer.valueOf(temp.substring(temp.length()-1)));
        }
        temp = commodityBaseInfo.getCategory_id();
        if (CheckEmptyUtil.checkString(temp)){
            commodity.setCategory_id(Integer.valueOf(temp.substring(temp.length()-1)));
        }
        commodity.setTitle(commodityBaseInfo.getTitle());
        commodity.setPrice(new BigDecimal(commodityBaseInfo.getPrice()));
        temp = commodityBaseInfo.getPromotion_price();
        if (CheckEmptyUtil.checkString(temp)) {
            commodity.setPromotion_price(new BigDecimal(temp));
        }else {
            commodity.setPromotion_price(commodity.getPrice());
        }
        commodity.setDescription(commodityBaseInfo.getDescription());
        temp = commodityBaseInfo.getStock();
        if (CheckEmptyUtil.checkString(temp)) {
            commodity.setStock(Integer.valueOf(temp));
        }
        temp = commodityBaseInfo.getPlace();
        if (CheckEmptyUtil.checkString(temp)) {
            commodity.setPlace(temp);
        }
        temp = commodityBaseInfo.getWeight();
        if (CheckEmptyUtil.checkString(temp)) {
            commodity.setWeight(new BigDecimal(temp));
        }
        commodity.setKeywords(commodityBaseInfo.getKeywords());
        temp = commodityBaseInfo.getPromotion_start_time();
        if (temp != null && CheckEmptyUtil.checkString(temp)) {
            commodity.setPromotion_start_time(transToTimeStamp(temp));
        }
        temp = commodityBaseInfo.getPromotion_end_time();
        if (temp != null && CheckEmptyUtil.checkString(temp)){
            commodity.setPromotion_end_time(transToTimeStamp(temp));
        }
        temp = commodityBaseInfo.getPromotion_per_limit();
        if (temp != null && CheckEmptyUtil.checkString(temp)){
            commodity.setPromotion_per_limit(Integer.valueOf(temp));
        }
        temp = commodityBaseInfo.getPromotion_type();
        if (temp != null){
            commodity.setPromotion_type(Promotion.valueOf(temp));
        }
        commodity.setPublish_time(new Timestamp(System.currentTimeMillis()));
        commodity.setShop_id(1L);
        commodity.setCid(RandomNumUtil.createId());
        return commodity;
    }

    //日期转换器，字符串转成时间戳
    public Timestamp transToTimeStamp(String timeStamp){
        Date date = new Date();
        DateFormat sf = new SimpleDateFormat(timeStamp);
        String dataStr = sf.format(date);
        Timestamp timestamp = Timestamp.valueOf(dataStr);
        return timestamp;
    }

    @RequestMapping(value="/allShow", method = RequestMethod.GET)
    @ResponseBody
    public List<Commodity> findAllCommodities(){
        List<Commodity> list = commodityService.findAllCommodities();
        for (Commodity commodity: list){
            System.out.println(commodity.toString());
        }
        return list;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public void deleteCommodityById(String cid){
        System.out.println("cid:"+cid);
        try {
            commodityService.deleteCommodity(cid);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @RequestMapping(value = "/findOneCommodity",params = {"cid"})
    @ResponseBody
    public Commodity toEditCommodityPage(String cid){
        Commodity commodity = commodityService.findOneCommodity(cid);
        return commodity;
    }

    @RequestMapping(value = "/updateCommodity", method = RequestMethod.POST)
    @ResponseBody
    public Object updateCommodityInfo(CommodityBaseInfo commodityBaseInfo, String cid, MultipartFile[] imgs, HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        Commodity commodity = createCommodity(commodityBaseInfo);
        commodity.setCid(Long.valueOf(cid));
        try {
            commodityService.updateCommodityInfo(commodity);
            jsonObject.put("state","success");
        }catch (Exception e){
            jsonObject.put("state","fail");
        }finally {
            return jsonObject;
        }

    }
}
