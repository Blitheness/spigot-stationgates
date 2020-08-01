package uk.pover.stationgates;

import org.bukkit.plugin.java.JavaPlugin;
import org.mcstats.Metrics;

import java.io.IOException;
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

        // Plugin Metrics
        try {
            Metrics metrics = new Metrics(this);
            metrics.start();
        } catch (IOException e) {
            logWarning("metricsError");
        }
    }

    @Override
    public void onDisable() {

    }

    public ResourceBundle getMessages() {
        return _messages;
    }

    public void logInfo(String messageKey) {
        String message;
        try {
            message = getMessages().getString(messageKey);
        } catch(MissingResourceException ex) {
            return;
        }
        getLogger().info(message);
    }

    public void logWarning(String messageKey) {
        String message;
        try {
            message = getMessages().getString(messageKey);
        } catch(MissingResourceException ex) {
            return;
        }
        getLogger().warning(message);
    }

    protected ResourceBundle _messages;
}
