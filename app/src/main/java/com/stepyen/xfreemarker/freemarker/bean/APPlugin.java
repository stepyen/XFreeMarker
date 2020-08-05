package com.stepyen.xfreemarker.freemarker.bean;

import com.stepyen.xfreemarker.freemarker.common.Constant;

import java.util.HashMap;

/**
 * date：2020-03-19
 * author：stepyen
 * description：插件
 */
public class APPlugin extends IPlugin {


    static {
        TEMPLATE_PATH = Constant.TEMPLATES_PATH + "APModule";
    }



    @Override
    public void setName(String name) {
        this.name = name;

        plugin_path = Constant.OUTPUT_PATH+name+"/";

        pathDatas.add(new PathBean(plugin_path + "aar/README",true));
        pathDatas.add(new PathBean(plugin_path + "depends/depends.json",true));
        pathDatas.add(new PathBean(plugin_path + "manifest/AndroidManifest.json",true));

    }

    @Override
    public void buildVarMap() {
        super.buildVarMap();
        varMap.put("name",name);
    }
}
