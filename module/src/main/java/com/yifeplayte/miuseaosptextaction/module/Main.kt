package com.yifeplayte.miuseaosptextaction.module

import android.annotation.SuppressLint
import android.util.ArrayMap
import android.util.Log
import com.android.internal.policy.DecorViewStub
import com.miui.base.MiuiStubRegistry
import com.miui.base.MiuiStubUtil

@Suppress("unused")
@SuppressLint("PrivateApi")
object Main {
    const val TAG = "MiUseAOSPTextAction"

    @JvmStatic
    fun main() {
        runCatching {
            val sManifestStubsField =
                MiuiStubRegistry::class.java
                    .getDeclaredField("sManifestStubs")
                    .apply { isAccessible = true }
            val sInstanceField =
                DecorViewStub::class.java
                    .getDeclaredField("sInstance")
                    .apply { isAccessible = true }
            val updateManifestMethod =
                MiuiStubRegistry::class.java
                    .getDeclaredMethod(
                        "updateManifest",
                        HashMap::class.java,
                        ArrayMap::class.java
                    ).apply { isAccessible = true }
            val sManifestStubs = sManifestStubsField.get(null)
            val newProviders = ArrayMap<String, MiuiStubRegistry.ImplProvider<*>>()
            newProviders["com.android.internal.policy.DecorViewStub"] =
                DecorViewStubImplProxy.Provider()
            val updatedManifest = updateManifestMethod.invoke(null, sManifestStubs, newProviders)
            sManifestStubsField.set(null, updatedManifest)
            sInstanceField.set(null, MiuiStubUtil.getInstance(DecorViewStub::class.java))
            // Log.i(TAG, "Replace ResolverActivityStub provider success")
        }.onFailure {
            Log.e(TAG, "Replace ResolverActivityStub provider failed: $it", it)
        }
    }
}
