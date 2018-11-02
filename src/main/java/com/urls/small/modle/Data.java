package com.urls.small.modle;

/**
 * 图传实体
 * @author YI
 * @date 2018-10-19 15:06:18
 */
public class Data {

    /**
     * 名称	        类型	        示例值	                                            描述
     * code	        String	    success	                                            上传文件状态。正常情况为 success。出现错误时为 error
     * filename	    String	    smms.jpg	                                        上传文件时所用的文件名
     * storename	String	    561cc4e3631b1.png	                                上传后的文件名
     * size	        Int	187851	                                                    文件大小
     * width	    Int	1157	                                                    图片的宽度
     * height	    Int	680	                                                        图片的高度
     * hash	        String	    nLbCw63NheaiJp1	                                    随机字符串，用于删除文件
     * delete	    String	    https://sm.ms/api/delete/nLbCw63NheaiJp1	        删除上传的图片文件专有链接
     * url	        String	    https://ooo.0o0.ooo/2015/10/13/561cfc3282a13.png	图片服务器地址
     * path	        String	    /2015/10/13/561cfc3282a13.png	                    图片的相对地址
     * msg	        String	    No files were uploaded.	                            上传图片出错时将会出现
     */
    private int width;
    private int height;
    private String filename;
    private String storename;
    private int size;
    private String path;
    private String hash;
    private long timestamp;
    private String ip;
    private String url;
    private String delete;

    public void setWidth(int width) {
        this.width = width;
    }
    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    public int getHeight() {
        return height;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
    public String getFilename() {
        return filename;
    }

    public void setStorename(String storename) {
        this.storename = storename;
    }
    public String getStorename() {
        return storename;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public int getSize() {
        return size;
    }

    public void setPath(String path) {
        this.path = path;
    }
    public String getPath() {
        return path;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
    public String getHash() {
        return hash;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    public long getTimestamp() {
        return timestamp;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
    public String getIp() {
        return ip;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public String getUrl() {
        return url;
    }

    public void setDelete(String delete) {
        this.delete = delete;
    }
    public String getDelete() {
        return delete;
    }

}
