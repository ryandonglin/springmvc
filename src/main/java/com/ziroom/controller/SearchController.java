package com.ziroom.controller;

import com.ziroom.services.SearchService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by homelink on 2016/9/19.
 */
@Controller
@RequestMapping("/search")
public class SearchController {

    @RequestMapping("/index")
    public String search(String content) {
        return "search/index";
    }

    @RequestMapping("/index/rest")
    @ResponseBody
    public String restService(@RequestParam("content") String content) {
        SearchService ss = new SearchService();
        String result = ss.searchWithContent(content);
        return result;
    }
}
