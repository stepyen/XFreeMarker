package com.stepyen.xfreemarker.freemarker.bean;

import com.stepyen.xfreemarker.freemarker.common.Constant;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * date：2020/8/4
 * author：stepyen
 * description：
 */
public abstract class IPlugin {

    /**
     * 模板地址
     */
    public static String TEMPLATE_PATH;

    /**
     * 插件地址
     */
    public String plugin_path;

    /**
     * 插件名
     * 如：Mintegral
     */
    protected String name;


    /**
     *
     *
     * 如：PluginMintegral
     */
    public String pluginName;

    /**
     * 变量集合
     *
     */
    public HashMap<String, String> varMap = new HashMap<>();

    /**
     * 路径集合
     */
    public ArrayList<PathBean> pathDatas = new ArrayList<>();

    /**
     * 设置插件名
     * @param name
     */
    public abstract void setName(String name);


    /**
     * 构建map
     */
    public void buildVarMap(){
        varMap.put("author", Constant.AUTHOR);
        varMap.put("date", getDate());
    };

    private String getDate() {
        Date date = new Date();// 当前时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 解析格式
        return sdf.format(date);// 解析
    }
}
