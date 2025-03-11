package com.yifeplayte.miuseaosptextaction.module;

import android.view.ActionMode;
import android.view.View;

import com.android.internal.policy.DecorViewStubImpl;
import com.miui.base.MiuiStubRegistry;

import org.lsposed.hiddenapibypass.HiddenApiBypass;

public class DecorViewStubImplProxy extends DecorViewStubImpl {
    @Override
    public ActionMode createActionMode(int type, ActionMode.Callback callback, View view) {
        return null;
    }

    public static class Provider implements MiuiStubRegistry.ImplProvider<DecorViewStubImpl> {
        private final MiuiStubRegistry.ImplProvider<DecorViewStubImpl> originalProvider = new DecorViewStubImpl.Provider();

        @Override
        public DecorViewStubImpl provideNewInstance() {
            return originalProvider.provideNewInstance();
        }

        @Override
        public DecorViewStubImpl provideSingleton() {
            HiddenApiBypass.addHiddenApiExemptions("Lcom/android/internal/policy/DecorViewStubImpl;");
            return Singleton.singleton;
        }

        public static class Singleton {
            private static final DecorViewStubImpl singleton = new DecorViewStubImplProxy();
        }
    }
}
