package com.urls.small.service;

import com.urls.small.modle.Url;

public interface UrlService {

    Url getUrl(String id);

    String saveUrl(Url url);

}
