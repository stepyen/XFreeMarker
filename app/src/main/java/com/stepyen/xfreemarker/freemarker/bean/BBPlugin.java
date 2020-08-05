package com.stepyen.xfreemarker.freemarker.bean;

import com.stepyen.xfreemarker.freemarker.common.Constant;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * date：2020-03-19
 * author：stepyen
 * description：插件
 */
public class BBPlugin extends IPlugin {

    static {
        TEMPLATE_PATH = Constant.TEMPLATES_PATH + "PluginModule";
    }

    public String name_lower_case;

    public String plugin_name;
    public String plugin_name_lower_case;

    public String plugin_path;
    public String main_path;
    public String java_path;
    public String value_path;

    @Override
    public void setName(String name) {

        this.name = name;
        name_lower_case = name.toLowerCase();
        pluginName = "Plugin" + name;
        plugin_name = "Plugin_" + name;
        plugin_name_lower_case = plugin_name.toLowerCase();
        plugin_path = Constant.OUTPUT_PATH + plugin_name + "/";

        main_path = plugin_path + "src/main/";
        java_path = main_path + "java/com/babybus/plugin/" + name_lower_case + "/";
        value_path = main_path + "res/values/";

        pathDatas.add(new PathBean(plugin_path + "libs/", false));
        pathDatas.add(new PathBean(plugin_path + "src/main/", false));
        pathDatas.add(new PathBean(main_path, false));
        pathDatas.add(new PathBean(java_path, false));
        pathDatas.add(new PathBean(java_path + "/activity/", false));
        pathDatas.add(new PathBean(java_path + "/request/", false));
        pathDatas.add(new PathBean(java_path + "/statistics/", false));
        pathDatas.add(new PathBean(java_path + "/statistics/"+name+"Statistics.kt","Statistics.kt.ftl", true));
        pathDatas.add(new PathBean(java_path + "/core/", false));
        pathDatas.add(new PathBean(java_path + "/constant/", false));
        pathDatas.add(new PathBean(java_path + "/constant/"+name+"Constant.kt","Constant.kt.ftl", true));
        pathDatas.add(new PathBean(java_path + "/bean/", false));
        pathDatas.add(new PathBean(java_path + "/widget/", false));
        pathDatas.add(new PathBean(java_path + pluginName + ".kt", "PluginJavaClass.kt.ftl", true));
        pathDatas.add(new PathBean(value_path + "strings.xml", true));
        pathDatas.add(new PathBean(main_path + "AndroidManifest.xml", true));
        pathDatas.add(new PathBean(plugin_path + "build.gradle", true));
        pathDatas.add(new PathBean(plugin_path + "proguard-rules.pro", true));

    }

    @Override
    public void buildVarMap() {
        super.buildVarMap();
        varMap.put("name", name);
        varMap.put("name_lower_case", name_lower_case);
        varMap.put("pluginName", pluginName);
        varMap.put("plugin_name", plugin_name);
        varMap.put("plugin_name_lower_case", plugin_name_lower_case);



    }


}
