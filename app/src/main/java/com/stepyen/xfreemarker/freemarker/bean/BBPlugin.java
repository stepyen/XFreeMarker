package com.stepyen.xfreemarker.freemarker.bean;

import com.stepyen.xfreemarker.freemarker.common.Constant;

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

    @Override
    public void setName(String name) {

        this.name = name;
        name_lower_case = name.toLowerCase();
        pluginName = "Plugin" + name;
        plugin_name = "Plugin_" + name;
        plugin_name_lower_case = plugin_name.toLowerCase();
        String plugin_path = Constant.OUTPUT_PATH + plugin_name + "/";

        String main_path = plugin_path + "src/main/";
        String java_path = main_path + "java/com/babybus/plugin/" + name_lower_case + "/";
        String res_path = main_path + "res/";
        String value_path = main_path + "res/values/";

        pathDatas.add(new PathBean(plugin_path + "libs/", false));
        pathDatas.add(new PathBean(plugin_path + "src/main/", false));
        pathDatas.add(new PathBean(main_path, false));
        pathDatas.add(new PathBean(java_path, false));


        pathDatas.add(new PathBean(java_path + "/activity/", false));

        pathDatas.add(new PathBean(java_path + "/analysis/", false));
        pathDatas.add(new PathBean(java_path + "/analysis/" + name + "Analysis.kt", "Analysis.kt.ftl", true));

        pathDatas.add(new PathBean(java_path + "/bean/", false));

        pathDatas.add(new PathBean(java_path + "/core/", false));

        pathDatas.add(new PathBean(java_path + "/constant/", false));
        pathDatas.add(new PathBean(java_path + "/constant/" + name + "Constant.kt", "Constant.kt.ftl", true));

        pathDatas.add(new PathBean(java_path + "/request/", false));
        pathDatas.add(new PathBean(java_path + "/request/" + name + "RequestManager.java", "RequestManager.ftl", true));
        pathDatas.add(new PathBean(java_path + "/request/" + name + "RequestService.java", "RequestService.ftl", true));

        pathDatas.add(new PathBean(java_path + "/widget/", false));

        pathDatas.add(new PathBean(java_path + pluginName + ".kt", "PluginJavaClass.kt.ftl", true));
        pathDatas.add(new PathBean(res_path, false));
        pathDatas.add(new PathBean(res_path+"anim/", false));
        pathDatas.add(new PathBean(res_path+"layout/", false));
        pathDatas.add(new PathBean(res_path+"drawable/", false));
        pathDatas.add(new PathBean(res_path+"drawable-xxhdpi/", false));
        pathDatas.add(new PathBean(res_path+"mipmap-xxhdpi/", false));
        pathDatas.add(new PathBean(value_path + "colors.xml", true));
        pathDatas.add(new PathBean(value_path + "attrs.xml", true));
        pathDatas.add(new PathBean(value_path + "dimens.xml", true));
        pathDatas.add(new PathBean(value_path + "strings.xml", true));
        pathDatas.add(new PathBean(value_path + "styles.xml", true));
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
