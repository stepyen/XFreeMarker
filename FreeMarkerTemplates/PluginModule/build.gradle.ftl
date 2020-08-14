apply from:'../../common_plugin.gradle'

android {
    repositories {
        flatDir {
            dirs 'libs',
                    '../${plugin_name}/libs'
        }
    }

    // 限定资源名必须以 <resourcePrefix> 开头，避免module间资源冲突。图片资源无法限定
    resourcePrefix "${name_lower_case}_"

}
dependencies {

}