apply from:'../../common_plugin.gradle'

android {
    repositories {
        flatDir {
            dirs 'libs',
                    '../${plugin_name}/libs'
        }
}

dependencies {

}