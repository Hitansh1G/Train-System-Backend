package com.example.geektrust.entities;

public class Bogie extends BaseEntity{
    private Station destinationStation;

    public Bogie(String id, Station destinationStation){
        this.id = id;
        this.destinationStation = destinationStation;
    }
    public Bogie(Station destinationStation){
        this.destinationStation = destinationStation;
    }

    public Station getDestinationStation() {
        return destinationStation;
    }

    public String getDestinationCode(){
        return destinationStation.getStationCode();
    }

    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

}
