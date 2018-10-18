package com.urls.small.modle;

/**
 * 新浪短链接转换bean
 * @author YI
 * @date 2018-4-11 19:06:46
 */
public class Urls {
    private String url_short;
    private String url_long;
    private String object_type;
    private int type;
    private String object_id;

    public void setUrl_short(String url_short){
        this.url_short = url_short;
    }

    public String getUrl_short(){
        return this.url_short;
    }

    public void setUrl_long(String url_long){
        this.url_long = url_long;
    }

    public String getUrl_long(){
        return this.url_long;
    }

    public void setObject_type(String object_type){
        this.object_type = object_type;
    }

    public String getObject_type(){
        return this.object_type;
    }

    public void setType(int type){
        this.type = type;
    }

    public int getType(){
        return this.type;
    }

    public void setObject_id(String object_id){
        this.object_id = object_id;
    }

    public String getObject_id(){
        return this.object_id;
    }

    @Override
    public String toString() {
        return "Urls{" +
                "url_short='" + url_short + '\'' +
                ", url_long='" + url_long + '\'' +
                ", object_type='" + object_type + '\'' +
                ", type=" + type +
                ", object_id='" + object_id + '\'' +
                '}';
    }
}
