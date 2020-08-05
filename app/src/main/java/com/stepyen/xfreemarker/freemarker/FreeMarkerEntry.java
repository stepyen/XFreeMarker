package com.stepyen.xfreemarker.freemarker;

import com.stepyen.xfreemarker.freemarker.manager.APPluginManager;
import com.stepyen.xfreemarker.freemarker.manager.BBPluginManager;

/**
 * date：2020-03-19
 * author：stepyen
 * description：FreeMarker 入口
 *
 * BB：babybus 工程
 * AP：打包 工程
 *
 * 使用步骤：
 *
 * 1、修改 Constant 下 模板地址、文件输出路径、作者
 * 2、修改 FreeMarkerEntry 下 插件名称 pluginName
 * 3、开始执行
 *
 */
public class FreeMarkerEntry {


    public static void main(String[] args) {

        String pluginName = "Mintegral";

        // 创建 BB module
        new BBPluginManager().create(pluginName);

//         创建 AP module
        new APPluginManager().create(pluginName);

    }
}
