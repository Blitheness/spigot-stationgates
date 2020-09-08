package uk.pover.stationgates.models;

public class RailwayLine extends BaseModel implements IModel {
    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
        setModified();
    }

    public String getColour() {
        return _colour;
    }

    public boolean setColour(String colour) {
        if(colour.length() > MAX_COLOUR_LENGTH) {
            return false;
        }
        _colour = colour;
        return setModified();
    }

    public String getStatus() {
        return _status;
    }

    public void setStatus(String status) {
        _status = status;
        setModified();
    }

    private String _name;
    private String _colour;
    private String _status;

    private final int MAX_COLOUR_LENGTH = 6;
}
