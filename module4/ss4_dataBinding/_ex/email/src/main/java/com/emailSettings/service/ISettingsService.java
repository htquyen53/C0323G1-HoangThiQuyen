package com.emailSettings.service;

import com.emailSettings.model.Settings;

public interface ISettingsService {
    Settings getSettings();
    void update(Settings settings);
}
