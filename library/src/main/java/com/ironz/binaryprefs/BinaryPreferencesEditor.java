package com.ironz.binaryprefs;

import android.content.SharedPreferences;
import com.ironz.binaryprefs.cache.CacheAdapter;
import com.ironz.binaryprefs.files.FileAdapter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BinaryPreferencesEditor implements SharedPreferences.Editor {

    private final Map<String, Object> commitMap = new HashMap<>();

    private final CacheAdapter cacheAdapter;
    private final FileAdapter fileAdapter;

    public BinaryPreferencesEditor(CacheAdapter cacheAdapter, FileAdapter fileAdapter) {
        this.cacheAdapter = cacheAdapter;
        this.fileAdapter = fileAdapter;
    }

    @Override
    public SharedPreferences.Editor putString(String key, String value) {
        return null;
    }

    @Override
    public SharedPreferences.Editor putStringSet(String key, Set<String> values) {
        return null;
    }

    @Override
    public SharedPreferences.Editor putInt(String key, int value) {
        return null;
    }

    @Override
    public SharedPreferences.Editor putLong(String key, long value) {
        return null;
    }

    @Override
    public SharedPreferences.Editor putFloat(String key, float value) {
        return null;
    }

    @Override
    public SharedPreferences.Editor putBoolean(String key, boolean value) {
        return null;
    }

    @Override
    public SharedPreferences.Editor remove(String key) {
        return null;
    }

    @Override
    public SharedPreferences.Editor clear() {
        return null;
    }

    @Override
    public boolean commit() {
        return false;
    }

    @Override
    public void apply() {

    }
}
