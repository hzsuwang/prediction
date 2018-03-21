package com.iterror.prediction.web.controller;

import com.google.common.collect.Maps;
import com.iterror.prediction.common.view.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("admin")
public class AdminController extends BaseController {
    @RequestMapping("/")
    public String index(Model model) {
        Map user = Maps.newHashMap();
        user.put("id", 1);
        user.put("name", "曹操");
        user.put("name1", "曹操1");

        user.put("description", "一代枭雄");
        model.addAttribute("user", user);
        return "admin/index";
    }


    @RequestMapping("/adminuser/list.do")
    public String queryAdminUser(Model model){
        return "admin/adminuser/list";
    }
}

