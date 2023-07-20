package com.emailSettings.service;

import com.emailSettings.model.Settings;
import com.emailSettings.repository.ISettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class SettingsService implements ISettingsService {
    @Autowired
    @Qualifier("settingsRepository")
    private ISettingsRepository iSettingsRepository;

    @Override
    public Settings getSettings() {
        return iSettingsRepository.getSettings();
    }

    @Override
    public void update(Settings settings) {
        iSettingsRepository.update(settings);
    }
}
