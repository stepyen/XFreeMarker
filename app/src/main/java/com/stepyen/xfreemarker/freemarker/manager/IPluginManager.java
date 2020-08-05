package com.stepyen.xfreemarker.freemarker.manager;

import com.stepyen.xfreemarker.freemarker.bean.APPlugin;
import com.stepyen.xfreemarker.freemarker.bean.IPlugin;
import com.stepyen.xfreemarker.freemarker.bean.PathBean;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * date：2020/8/4
 * author：stepyen
 * description：
 */
abstract class IPluginManager {


    public Configuration cfg;
    public Writer writer = null;

    public IPlugin plugin;


    public void create(String pluginName){
        try {

            plugin = getPlugin();

            if (plugin == null) {
                throw new NullPointerException("IPlugin 不可为空");
            }

            plugin.setName(pluginName);
            plugin.buildVarMap();

            cfg = new Configuration();
            cfg.setDirectoryForTemplateLoading(new File(APPlugin.TEMPLATE_PATH));

            // 删除原来的插件文件夹
//            File pluginPathFile = new File(plugin.plugin_path);
//            if (pluginPathFile.exists()) {
//                pluginPathFile.delete();
//            }

            for (PathBean bean :plugin.pathDatas) {

                process(bean);

            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    };

    public void process(PathBean bean) throws Exception{
        System.out.println(bean.path);


        File file = new File(bean.path);
        if (!file.exists()) {

            if (bean.isFile) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }else{
                file.mkdirs();
            }

        }

        if (bean.isFile) {

            Template t = cfg.getTemplate(bean.templatesFileName);
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            t.process(plugin.varMap, writer);

        }

    }


    abstract IPlugin getPlugin();
}
