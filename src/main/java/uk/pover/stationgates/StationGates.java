package uk.pover.stationgates;

import org.bukkit.plugin.java.JavaPlugin;
import org.bstats.bukkit.Metrics;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class StationGates extends JavaPlugin {
    @Override
    public void onEnable() {
        // Copy config.yml resource to plugin directory
        saveDefaultConfig();

        // Fetch localised strings
        _messages = ResourceBundle.getBundle("Messages");

        // Show welcome message
        if(getConfig().getBoolean("displayWelcome")) {
            logInfo("welcome");
        }

        // API connection
        if(getConfig().getBoolean("apiEnabled")) {
            _api = new WebApi(this);
        }
        else {
            logInfo("apiNotEnabled");
        }

        // Plugin Metrics
        try {
            new Metrics(this, BSTATS_PLUGIN_ID);
        }
        catch(Exception e) {
            logWarning("metricsError");
        }
    }

    @Override
    public void onDisable() {
        logInfo("disableMessage");
    }

    public ResourceBundle getMessages() {
        return _messages;
    }

    public void logInfo(String messageKey) {
        log(messageKey, false);
    }

    public void logWarning(String messageKey) {
        log(messageKey, true);
    }

    public void log(String messageKey, boolean warning) {
        String message;
        try {
            message = getMessages().getString(messageKey);
        } catch(MissingResourceException ex) {
            message = messageKey;
        }
        if(warning) {
            getLogger().warning(message);
        }
        else {
            getLogger().info(message);
        }
    }

    public boolean isApiEnabled() {
        return _api != null;
    }

    protected ResourceBundle _messages;
    protected WebApi _api;

    private final int BSTATS_PLUGIN_ID = 8786;
}
