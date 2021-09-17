object Versions {

    const val MIN_SDK_VERSION = "21"
    const val COMPILE_SDK_VERSION = 30
    const val TARGET_SDK_VERSION = 30

    const val DAGGER2_VERSION = "2.38.1"
    const val RIBS_VERSION = "0.11.3"
    const val RX_JAVA_VERSION = "3.1.1"
    const val ANDROID_X_CORE_VERSION = "1.6.0"
    const val APP_COMPAT_VERSION = "1.3.1"
    const val MATERIAL_VERSION = "1.4.0"
    const val CONSTRAINT_LAYOUT_VERSION = "2.1.0"
    const val JUNIT_VERSION = "4.13"
}

object Libs {
    //dagger
    const val DAGGER = "com.google.dagger:dagger:${Versions.DAGGER2_VERSION}"
    const val DAGGER_COMPILER = "com.google.dagger:dagger-compiler:${Versions.DAGGER2_VERSION}"
    const val DAGGER_ANDROID_PROCESSOR =
        "com.google.dagger:dagger-android-processor:${Versions.DAGGER2_VERSION}"

    // RIBs
    const val RIB_ANDROID = "com.uber.rib:rib-android:${Versions.RIBS_VERSION}"
    const val RIB_COMPILER = "com.uber.rib:rib-compiler-test:${Versions.RIBS_VERSION}"
    const val RIB_TEST = "com.uber.rib:rib-test:${Versions.RIBS_VERSION}"

    //RxJava
    const val RX_JAVA = "io.reactivex.rxjava3:rxjava:${Versions.RX_JAVA_VERSION}"

    //
    const val ANDROID_X_CORE = "androidx.core:core-ktx:${Versions.ANDROID_X_CORE_VERSION}"
    const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT_VERSION}"
    const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL_VERSION}"
    const val CONSTRAINT_LAYOUT =
        "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT_VERSION}"

    const val JUNIT = "junit:junit:${Versions.JUNIT_VERSION}"
}