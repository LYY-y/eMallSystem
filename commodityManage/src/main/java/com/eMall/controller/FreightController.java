package com.eMall.controller;

import com.alibaba.fastjson.JSONObject;
import com.eMall.dto.CommodityBaseInfo;
import com.eMall.entity.Commodity;
import com.eMall.entity.CommodityPic;
import com.eMall.entity.FreightInfo;
import com.eMall.service.FreightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping(value = "/freight")
public class FreightController {
    @Autowired
    @Qualifier("freightService")
    private FreightService freightService;

    @RequestMapping(value = "/find",method = RequestMethod.POST)
    @ResponseBody
    public Object findFreightInfoByFromAndTo(@RequestParam Map<String,String> map , HttpServletRequest request){
        String from = map.get("from_place");
        String dest = map.get("dest_place");
        JSONObject jsonObject = new JSONObject();
        try {
            FreightInfo freightInfo = freightService.findFreightInfoByFromAndTo(from,dest);
            jsonObject.put("state","success");
            jsonObject.put("freight",freightInfo);
        }catch (Exception e){
            jsonObject.put("state","fail");
            return jsonObject;
        }finally {
            return jsonObject;
        }
    }


}
