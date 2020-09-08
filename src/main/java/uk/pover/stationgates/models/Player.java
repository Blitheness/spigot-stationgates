package uk.pover.stationgates.models;

public class Player extends BaseModel implements IModel {
    public Player() {
        setDataType("Player");
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
        setModified();
    }

    private String _name;
}
