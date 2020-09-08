package uk.pover.stationgates.models;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class StationGate extends BaseModel implements IModel {
    public Location getLocation() {
        if(null == _world || null == _x || null == _y || null == _z) {
            return new Location(getWorld(), _x, _y, _z);
        }
        return null;
    }

    public void setX(int x) {
        _x = x;
        setModified();
    }

    public void setY(int y) {
        _y = y;
        setModified();
    }

    public void setZ(int z) {
        _z = z;
        setModified();
    }

    public World getWorld() {
        return Bukkit.getServer().getWorld(_world);
    }

    public boolean setWorld(String world) {
        if(Bukkit.getServer().getWorld(world) != null) {
            _world = world;
            return setModified();
        }
        return false;
    }

    public TrainStation getStation() {
        return _station;
    }

    public void setStation(TrainStation station) {
        _station = station;
    }

    private TrainStation _station;
    private String _world;
    private Integer _x;
    private Integer _y;
    private Integer _z;
}
