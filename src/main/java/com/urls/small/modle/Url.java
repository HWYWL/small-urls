package com.urls.small.modle;

/**
 * 本地短链接
 * @author YI
 * @date 2018-10-18 22:09:54
 */
public class Url {
    private String id;

    private String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }



    @Override
    public String toString() {
        return new StringBuilder()
                .append("id:"+ id)
                .append("url:"+ url)
                .toString();
    }

}
