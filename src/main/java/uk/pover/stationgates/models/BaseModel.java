package uk.pover.stationgates.models;

import java.util.UUID;

public class BaseModel {
    public BaseModel() { }

    public Object getId() {
        if(null != _id) {
            return _id;
        }
        if(null != _uuid) {
            return _uuid;
        }
        return null;
    }

    public void setId(UUID id) {
        _uuid = id;
        setModified();
    }

    public void setId(int id) {
        _id = id;
        setModified();
    }

    protected boolean setModified() {
        return (_modified = true);
    }

    public boolean isModified() {
        return _modified;
    }

    public boolean save() {
        return isModified() && hasDataType();
    }

    protected void setDataType(String dataType) {
        _apiDataType = dataType;
    }

    public boolean hasDataType() {
        return (null != _apiDataType) && (_apiDataType.length() > 0);
    }

    private Integer _id;
    private UUID _uuid;
    private boolean _modified = false;
    private String _apiDataType;
}
