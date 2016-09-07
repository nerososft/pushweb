package org.twtpush.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * author： nero
 * email: nerosoft@outlook.com
 * data: 16-9-7
 * time: 下午5:43.
 */
@Controller
@RequestMapping("/page")
public class PageController {


    @RequestMapping(value = "/document")
    public String Document(){
        return "document";
    }

    @RequestMapping(value = "/community")
    public String Community(){
        return "community";
    }

    @RequestMapping(value = "/about")
    public String About(){
        return "about";
    }

    @RequestMapping(value = "/download")
    public String Download(){
        return "download";
    }


}
