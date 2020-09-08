package uk.pover.stationgates.models;

public class TrainStation extends BaseModel implements IModel {
    public TrainStation() {
        setDataType("RailwayStation");
    }

    public String getName() {
        return _name;
    }

    public String getLabel() {
        return _label;
    }

    public void setName(String name) {
        _name = name;
        setModified();
    }

    public void setLabel(String label) {
        _label = label.toUpperCase();
        setModified();
    }

    @Override
    public String toString() {
        return _name != null ? _name : _label;
    }

    private String _name;
    public String _label;
}
