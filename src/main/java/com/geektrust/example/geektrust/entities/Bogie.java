package com.geektrust.example.geektrust.entities;

public class Bogie extends BaseEntitiy {
    private Station destinationStation;
//
    public Bogie(String id, Station destinationStation) {
        this.id = id;
        this.destinationStation=destinationStation;
    }

    public Bogie(Station destinationStation) {
        this.destinationStation = destinationStation;
    }

    public Station getdestinationStation() {
        return destinationStation;
    }

    public String getdestinationStationCode(){
        return destinationStation.getStationCode();
    }

    private Boolean ifDestinationNull(Bogie  bogie1, Bogie  bogie2){
        return bogie1.getdestinationStation() == null && bogie2.getdestinationStation() != null || (bogie1.getdestinationStation() != null && bogie2.getdestinationStation() == null);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
}
