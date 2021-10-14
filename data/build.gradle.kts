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
        buildConfigField("String", "THE_MOVIES_DB_BASE_URL", "\"https://api.themoviedb.org/3/\"")
        buildConfigField("String", "THE_MOVIES_DB_API_KEY", "\"${project.properties["TMDB_API_KEY"]}\"")
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = listOf("-Xjvm-default=compatibility")
    }
}

dependencies {
    //dagger
    implementation(Libs.DAGGER)
    kapt(Libs.DAGGER_ANDROID_PROCESSOR)
    kapt(Libs.DAGGER_COMPILER)

    //rxjava
    implementation(Libs.RX_JAVA)

    // retrofit
    api(Libs.RETROFIT)
    implementation(Libs.RETROFIT_RX_JAVA_ADAPTER)
    implementation(Libs.RETROFIT_GSON_CONVERTER)
    implementation(Libs.LOGGING_INTERCEPTOR)

    implementation(Libs.GSON)

    testImplementation(Libs.JUNIT)
}