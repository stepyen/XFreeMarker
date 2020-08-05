package com.stepyen.xfreemarker.freemarker.bean;

/**
 * date：2020/8/5
 * author：stepyen
 * description：
 */
public class PathBean {
    /**
     * 路径
     */
    public String path;
    /**
     * 模版文件名
     */
    public String templatesFileName;
    /**
     * 是否是文件
     */
    public boolean isFile;

    public PathBean(String path, String templatesFileName, boolean isFile) {
        this.path = path;
        this.templatesFileName = templatesFileName;
        this.isFile = isFile;
    }



    public PathBean(String path,  boolean isFile) {
        this.path = path;
        if (isFile) {
            // 从路径的最后一个 "/"开始截取
            this.templatesFileName = path.substring(path.lastIndexOf("/" )+1)+".ftl";
        }
        this.isFile = isFile;
    }



}
