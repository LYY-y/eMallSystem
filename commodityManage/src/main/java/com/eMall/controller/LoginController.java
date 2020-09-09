package com.eMall.controller;
import com.eMall.entity.User;
import com.eMall.service.LoginService;
import com.eMall.util.RandomNumUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
    @Autowired
    @Qualifier("loginService")
    private LoginService loginService;

    @RequestMapping(value = "/seller",method = RequestMethod.POST)
    @ResponseBody
    public Object sellerLogin(@RequestBody User seller, HttpSession session){
        Map<String, Object> map = new HashMap<String, Object>();
        boolean login =  loginService.sellerLogin(seller.getName(), seller.getPassword());
        map.put("verify",login);
        if (login) {
            long uniqueId = RandomNumUtil.createId();
            String uniqueIdStr = String.valueOf(uniqueId);
            map.put("uniqueId", uniqueIdStr);
            session.setAttribute("uniqueId",uniqueIdStr);
        }
        return map;
    }

    @RequestMapping(value = "/jumpCommodity",method = RequestMethod.POST)
    public String jumpToCommodityPage(String uniqueId, HttpSession session){
        if (uniqueId.equals(session.getAttribute("uniqueId"))){
            return "redirect:/allShow.html";
        }
        return null;
    }
}
