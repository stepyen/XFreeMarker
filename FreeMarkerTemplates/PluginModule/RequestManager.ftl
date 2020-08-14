package com.babybus.plugin.${name_lower_case}.request;


import com.babybus.utils.downloadutils.ApiManager;


/**
 * date：${date}
 * author：${author}
 * description：请求管理类
 *
 */
public class ${name}RequestManager {
    private static ${name}RequestService ${name_lower_case}Service;

    public static ${name}RequestService get(){
        if (${name_lower_case}Service == null){
            synchronized (${name}RequestManager.class){
                if (${name_lower_case}Service == null){
                    ${name_lower_case}Service = ApiManager.get().create(${name}RequestService.class);
                }
            }
        }
        return ${name_lower_case}Service;
    }
}
