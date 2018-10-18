package com.urls.small.controller;

import com.urls.small.modle.SinaShortUrl;
import com.urls.small.modle.Url;
import com.urls.small.service.SinaShortUrlService;
import com.urls.small.service.UrlService;
import com.urls.small.utils.MessageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 短链接生成
 * @author YI
 * @date 2018-10-18 22:07:23
 */
@Controller
@RequestMapping("/")
public class UrlController {
    @Autowired
    UrlService urlService;
    @Autowired
    SinaShortUrlService sinaShortUrlService;

    /**
     * 主页
     * @return
     */
    @GetMapping("/")
    public String index() {
        return "/index";
    }

    /**
     * 根据id跳转到指定页面
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public String redirect(@PathVariable("id") String id) {
        Url u = urlService.getUrl(id);

        if(u == null){
            return "/404";
        }

        return "redirect:" + u.getUrl();
    }

    /**
     * 通过本地算法获取短链接地址
     * @param url 长连接
     * @return
     */
    @PostMapping("/getShortUrl")
    @ResponseBody
    public MessageResult getShortUrl(Url url){

        String urls = urlService.saveUrl(url);
        
        return MessageResult.ok(urls);
    }

    /**
     * 通过新浪接口获取短链接地址
     * @param url   长连接
     * @return
     */
    @PostMapping("/getSinaShortUrl")
    @ResponseBody
    public MessageResult getSinaShortUrl(String url){

        SinaShortUrl shortUrl = sinaShortUrlService.getShortUrl(url);

        return MessageResult.ok(shortUrl.getUrls().get(0).getUrl_short());
    }

}
