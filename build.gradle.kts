// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library)apply false
    alias(libs.plugins.kotlin.android)apply false
}
//apply {from("versions.gradle")}

task<Delete>("clean",{
    delete(rootProject.buildDir)
})

/*buildscript {


    dependencies {
        classpath "com.android.tools.build:gradle:$versions.androidGradlePlugin"

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files

        classpath 'com.jfrog.bintray.gradle:gradle-bintray-plugin:1.7.3'
        classpath 'com.github.dcendents:android-maven-gradle-plugin:2.1'
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$versions.kotlin"
    }
}

allprojects {

    configurations.all {
        resolutionStrategy {
            cacheChangingModulesFor 0, 'seconds'
        }
    }

}
*/

