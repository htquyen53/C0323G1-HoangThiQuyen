package com.emailSettings.repository;

import com.emailSettings.model.Settings;

public interface ISettingsRepository {
    Settings getSettings();
    void update(Settings settings);
}
