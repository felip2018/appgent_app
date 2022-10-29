package com.fgarzon.appgent.storage;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

public class StorageServices extends Application {

    private static StorageServices storageServices = null;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor sharedPreferencesEditor;

    private StorageServices() {
        sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        sharedPreferencesEditor = sharedPreferences.edit();
    }

    public static StorageServices getInstance() {
        if (storageServices == null) {
            storageServices = new StorageServices();
        }
        return storageServices;
    }

    public void save(String key, String value) {
        sharedPreferencesEditor.putString(key, value);
        sharedPreferencesEditor.apply();
    }

    public String get(String key) {
        return sharedPreferences.getString(key, null);
    }

}
