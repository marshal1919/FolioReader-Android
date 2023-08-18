/*apply plugin: 'com.android.application'
apply plugin: 'checkstyle'
apply plugin: 'kotlin-android'*/
plugins {
    alias(libs.plugins.android.application)
    //alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}
//apply plugin: 'kotlin-android-extensions'

android {
    namespace="com.folioreader.android.sample"
    defaultConfig {
        applicationId ="com.folioreader.android.sample"
        //targetSdkVersion versions.androidTargetSdk
        versionCode=1
        versionName ="1.1.0"
        testInstrumentationRunner="androidx.test.runner.AndroidJUnitRunner"
        //isMultiDexEnabled= true
        minSdk = 27
    }

    buildTypes {
        release {
            isMinifyEnabled= true
            //proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }

    /*dexOptions {
        javaMaxHeapSize "4G"
    }*/

    packagingOptions {
        exclude("META-INF/ASL2.0")
        exclude( "META-INF/DEPENDENCIES.txt")
        exclude ("META-INF/LICENSE.txt")
        exclude ("META-INF/NOTICE.txt")
        exclude ("META-INF/NOTICE")
        exclude ("META-INF/LICENSE")
        exclude ("META-INF/DEPENDENCIES")
        exclude ("META-INF/notice.txt")
        exclude ("META-INF/license.txt")
        exclude ("META-INF/dependencies.txt")
        exclude ("META-INF/LGPL2.1")
        exclude ("META-INF/services/javax.annotation.processing.Processor")
    }
    compileSdk = 33

    /*lintOptions {
        abortOnError false
    }*/
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation (libs.androidx.appcompat)
    implementation (libs.androidx.constraintlayout)
    testImplementation (libs.junit)
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")

    implementation (project(":folioreader"))
    //implementation "com.folioreader:folioreader:$versions.folioreaderSdk"

    implementation (libs.fasterxml.jackson.core)
    implementation (libs.fasterxml.jackson.annotations)
    implementation (libs.fasterxml.jackson.databind)
    implementation (libs.fasterxml.jackson.module)

    //progressBar error solve
    /*configurations.matching { it.name == '_internal_aapt2_binary' }.all { config ->
        config.resolutionStrategy.eachDependency { details ->
            details.useVersion("3.3.2-5309881")
        }
    }*/

}
