-keep class com.yifeplayte.miuseaosptextaction.module.** { *; }
-dontoptimize
-dontobfuscate
-repackageclasses com.yifeplayte.miuseaosptextaction

# For AndroidHiddenApiBypass.
-dontwarn dalvik.system.VMRuntime
-assumenosideeffects class android.util.Property{
    public static *** of(...);
}
-if class org.lsposed.hiddenapibypass.HiddenApiBypass
-keepclassmembers class org.lsposed.hiddenapibypass.Helper$* { *; }

# This is generated automatically by the Android Gradle plugin.
-dontwarn androidx.annotation.NonNull
-dontwarn androidx.annotation.Nullable
-dontwarn androidx.annotation.RequiresApi
-dontwarn androidx.annotation.VisibleForTesting
