package com.stepyen.xfreemarker.freemarker.manager;

import com.stepyen.xfreemarker.freemarker.bean.APPlugin;
import com.stepyen.xfreemarker.freemarker.bean.IPlugin;

/**
 * date：2020-03-20
 * author：stepyen
 * description：
 */
public class APPluginManager extends IPluginManager {

    @Override
    IPlugin getPlugin() {
        return new APPlugin();
    }

}
