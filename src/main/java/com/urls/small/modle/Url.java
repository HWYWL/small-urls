package com.urls.small.modle;

/**
 * 本地短链接
 * @author YI
 * @date 2018-10-18 22:09:54
 */
public class Url {
    private String id;

    private String url;

    private String qrCode;

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

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    @Override
    public String toString() {
        return "Url{" +
                "id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", qrCode='" + qrCode + '\'' +
                '}';
    }
}
