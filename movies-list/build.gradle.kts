plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdk = Versions.COMPILE_SDK_VERSION
    defaultConfig {
        minSdkPreview = Versions.MIN_SDK_VERSION
        targetSdk = Versions.TARGET_SDK_VERSION
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(Libs.ANDROID_X_CORE)
    implementation(Libs.APP_COMPAT)
    implementation(Libs.MATERIAL)

    //dagger
    implementation(Libs.DAGGER)
    kapt(Libs.DAGGER_ANDROID_PROCESSOR)
    kapt(Libs.DAGGER_COMPILER)

    //rxjava
    implementation(Libs.RX_JAVA)

    //ribs
    implementation(Libs.RIB_ANDROID)
    annotationProcessor(Libs.RIB_COMPILER)
    testImplementation(Libs.RIB_TEST)

    testImplementation(Libs.JUNIT)
}