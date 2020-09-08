package uk.pover.stationgates.models;

public class Journey extends BaseModel implements IModel {
    private Player _player;
    private TrainStation _start;
    private TrainStation _end;
    private Integer _time;
    private Integer _distance;
}
