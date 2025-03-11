package com.android.internal.policy;

import android.view.ActionMode;
import android.view.View;

public interface DecorViewStub {
    ActionMode createActionMode(int type, ActionMode.Callback callback, View view);
}
