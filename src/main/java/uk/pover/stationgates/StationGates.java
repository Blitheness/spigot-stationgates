package uk.pover.stationgates;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.ResourceBundle;

/**
 * @author CoffeeAndChill (dev@oneiric.co.uk)
 */
public class StationGates extends JavaPlugin {
    @Override
    public void onEnable() {
        messages = ResourceBundle.getBundle("Messages");
    }
    @Override
    public void onDisable() {

    }
    protected ResourceBundle messages;
}
