package com.lrm.web;

import com.lrm.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author wu
 * @date 2022-01-21 12:58
 */
@Controller
public class AboutShowController {
    @Autowired
    BlogService blogService;

    @GetMapping("/about")
    public String about(){
        return "about";
    }

    //服务于footer里面的最新
    @GetMapping("/footer/newblog")
    public String newblogs(Model model) {
        model.addAttribute("newblogs", blogService.listRecommendBlogTop(3));
        return "_fragments :: newblogList";
    }

}
