//apply plugin: 'com.android.library'
//apply from: '../config/quality/quality.gradle'
//apply plugin: 'com.github.dcendents.android-maven'
//apply plugin: 'kotlin-android'

plugins {
    alias(libs.plugins.android.application)
    //alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}
//apply {from("versions.gradle")}

/*ext {
    bintrayRepo = "maven"
    bintrayName = "folioreader"

    publishedGroupId = "com.folioreader"
    libraryName = "FolioReader"
    artifact = "folioreader"

    libraryDescription = "An epub reader for Android"

    siteUrl = "https://github.com/FolioReader/FolioReader-Android"
    gitUrl = "https://github.com/FolioReader/FolioReader-Android.git"

    libraryVersion = versions.folioreaderSdk

    developerId = "mobisystech"
    developerName = "Folio Reader"
    developerEmail = "mahavir@codetoart.com"

    licenseName = "FreeBSD License"
    licenseUrl = "https://en.wikipedia.org/wiki/FreeBSD_Documentation_License#License"
    allLicenses = ["FreeBSD"]
}*/

android {
    useLibrary("org.apache.http.legacy")
    compileSdkVersion(33)
    namespace="com.folioreader"

    defaultConfig {
        minSdk = 27
        //targetSdkVersion(versions.androidTargetSdk)
        versionCode=1
        versionName="1"
        vectorDrawables.useSupportLibrary = true
    }

    sourceSets {
        named("main"){
            manifest.srcFile("AndroidManifest.xml")
            java.srcDirs("src/main/java")
            res.srcDirs("res")
        }
        named("test") {
            java.srcDirs("src/test/java")
        }
    }

    packagingOptions {
        exclude("META-INF/ASL2.0")
        exclude("META-INF/DEPENDENCIES.txt")
        exclude ("META-INF/LICENSE.txt")
        exclude("META-INF/NOTICE.txt")
        exclude("META-INF/NOTICE")
        exclude("META-INF/LICENSE")
        exclude("META-INF/DEPENDENCIES")
        exclude("META-INF/notice.txt")
        exclude("META-INF/license.txt")
        exclude("META-INF/dependencies.txt")
        exclude("META-INF/LGPL2.1")
        exclude("META-INF/services/javax.annotation.processing.Processor")
    }

   /* lintOptions {
        abortOnError =false
        lintConfig file("lint.xml")
    }

    checkstyle {
        ignoreFailures = true
    }*/
}

//apply from: '../folioreader/bintray/installv1.gradle'
dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(libs.androidx.appcompat )
    implementation(  libs.androidx.constraintlayout )
    implementation(libs.androidx.recyclerview)
    implementation(libs.google.android.material)
    testImplementation(libs.junit)

    implementation(libs.slf4j)
    //implementation(libs.daimajia.swipelayout;ext="aar")
    implementation("com.daimajia.swipelayout:library:1.2.0@aar")

    implementation(libs.jetbrains.kotlin)

    implementation(libs.greenrobot)

    implementation(libs.fasterxml.jackson.core)
    implementation(libs.fasterxml.jackson.annotations)
    implementation(libs.fasterxml.jackson.databind)
    implementation(libs.fasterxml.jackson.module)
    implementation (libs.google.code.gson)

    implementation(libs.squareup.retrofit2.retofit)
    implementation(libs.squareup.retrofit2.converter.jackson)
    implementation(libs.squareup.retrofit2.converter.gson)

    // R2 modules
    api(libs.github.codetoart.shared) {
        isChanging = true
    }
    api(libs.github.codetoart.streamer) {
        exclude(group = "org.slf4j", module = "slf4j-api")
        isChanging = true
    }

    // Only ReflectionUtils in Spring framework is used
    implementation(libs.springframework)

    // Lifecycle
    implementation(libs.androidx.lifecycle)
    
}

//apply from: '../folioreader/bintray/bintrayv1.gradle'
