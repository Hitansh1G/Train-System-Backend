package com.geektrust.example.geektrust.entities;

import static com.geektrust.example.geektrust.Constants.Constants.PRIME;
import static com.geektrust.example.geektrust.Constants.Constants.TEMP;

public class Bogie extends BaseEntitiy {
    private final Station destinationStation;
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

    public Boolean ifDestinationNull(Bogie bogie1, Bogie bogie2){
        return bogie1.getdestinationStation() == null && bogie2.getdestinationStation() != null || (bogie1.getdestinationStation() != null && bogie2.getdestinationStation() == null);
    }

    @Override
    public int hashCode() {
        int result = TEMP;
        result = PRIME * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
}
