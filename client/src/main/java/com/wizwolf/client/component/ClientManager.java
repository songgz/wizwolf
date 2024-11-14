package com.wizwolf.client.component;

import org.springframework.stereotype.Component;

import java.util.prefs.Preferences;

@Component
public class ClientManager {
    Preferences prefs = Preferences.userNodeForPackage(ClientManager.class);

    public String getString(String key) {
        return prefs.get(key, "");
    }

    public void putString(String key, String value) {
        prefs.put(key, value);
        save();
    }

    public int getInt(String key) {
        return prefs.getInt(key, 0);
    }

    public void putInt(String key, int value) {
        prefs.putInt(key, value);
        save();
    }

    public boolean getBoolean(String key) {
        return prefs.getBoolean(key, false);
    }

    public void putBoolean(String key, boolean value) {
        prefs.putBoolean(key, value);
        save();
    }

    private void save() {
        try {
            prefs.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void remove(String key) {
        prefs.remove(key);
        save();
    }

    public void clear() {
        try {
            prefs.clear();
            save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
