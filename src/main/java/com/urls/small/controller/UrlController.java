package com.urls.small.controller;

import com.urls.small.modle.SinaShortUrl;
import com.urls.small.modle.Url;
import com.urls.small.service.SinaShortUrlService;
import com.urls.small.service.UrlService;
import com.urls.small.utils.MessageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class UrlController {
    @Autowired
    UrlService urlService;
    @Autowired
    SinaShortUrlService sinaShortUrlService;

    @GetMapping("/")
    public String index() {
        return "/index";
    }

    @GetMapping("/{id}")
    public String redirect(@PathVariable("id") String id) {
        Url u = urlService.getUrl(id);

        if(u == null){
            return "/404";
        }

        return "redirect:" + u.getUrl();
    }

    @PostMapping("/getShortUrl")
    @ResponseBody
    public MessageResult getShortUrl(Url url){

        String urls = urlService.saveUrl(url);
        
        return MessageResult.ok(urls);
    }

    @PostMapping("/getSinaShortUrl")
    @ResponseBody
    public MessageResult getSinaShortUrl(String url){

        SinaShortUrl shortUrl = sinaShortUrlService.getShortUrl(url);

        return MessageResult.ok(shortUrl.getUrls().get(0).getUrl_short());
    }

}
