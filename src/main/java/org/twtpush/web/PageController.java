package org.twtpush.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.twtpush.util.CONSTANT.*;

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
    public String document(){
        return PAGE_DOCUMENT.name;
    }

    @RequestMapping(value = "/community")
    public String community(){
        return PAGE_COMMUNITY.name;
    }

    @RequestMapping(value = "/about")
    public String about(){
        return PAGE_ABOUT.name;
    }

    @RequestMapping(value = "/download")
    public String download(){

        return PAGE_DOWNLOAD.name;
    }


}
