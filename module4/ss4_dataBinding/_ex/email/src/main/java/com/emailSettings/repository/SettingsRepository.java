package com.emailSettings.repository;

import com.emailSettings.model.Settings;
import org.springframework.stereotype.Repository;

@Repository
public class SettingsRepository implements ISettingsRepository{
    private static Settings settingsInfo = new Settings();
    static {
        settingsInfo.setLanguage("English");
        settingsInfo.setPageSize(5);
        settingsInfo.setSpamsFilter(true);
        settingsInfo.setSignature("default...");
    }
    @Override
    public Settings getSettings() {
        return settingsInfo;
    }

    @Override
    public void update(Settings settings) {
        settingsInfo.setLanguage(settings.getLanguage());
        settingsInfo.setPageSize(settings.getPageSize());
        settingsInfo.setSpamsFilter(settings.isSpamsFilter());
        settingsInfo.setSignature(settings.getSignature());

    }
}
