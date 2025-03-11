package com.android.internal.policy;

import android.view.ActionMode;
import android.view.View;

import com.miui.base.MiuiStubRegistry;

public class DecorViewStubImpl implements DecorViewStub {
    @Override
    public ActionMode createActionMode(int type, ActionMode.Callback callback, View view) {
        throw new IllegalArgumentException("Stub!");
    }

    public static final class Provider implements MiuiStubRegistry.ImplProvider<DecorViewStubImpl> {
        @Override
        public DecorViewStubImpl provideNewInstance() {
            throw new IllegalArgumentException("Stub!");
        }

        @Override
        public DecorViewStubImpl provideSingleton() {
            throw new IllegalArgumentException("Stub!");
        }
    }
}
