package com.miui.base;

public class MiuiStubUtil {
    public static <T> T getInstance(Class<T> cls) {
        throw new IllegalArgumentException("Stub!");
    }
}
