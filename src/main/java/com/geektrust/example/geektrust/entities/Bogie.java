package com.geektrust.example.geektrust.entities;

public class Bogie extends BaseEntitiy {
    private Station destinationStation;

    private Boolean ifDestinationNull(Bogie  bogie1, Bogie  bogie2){
        return bogie1.getdestinationStation() == null && bogie2.getdestinationStation() != null || (bogie1.getdestinationStation() != null && bogie2.getdestinationStation() == null);
    }

    public Bogie(String id, Station destinationStation) {
        this(destinationStation);
        this.id = id;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((destinationStation == null) ? 0 : destinationStation.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Bogie other = (Bogie) obj;
        if (id != null && other.getId()!= null) {
            return id.equals(other.getId());
        } 
        if (id == null && other.getId() == null && destinationStation == null && other.getdestinationStation() == null)
            return true;
        if(id == null && other.getId() == null && (ifDestinationNull(this, other))){
            return false;
        }
        return destinationStation.equals(other.getdestinationStation());
    }

   


    // @Override
    // public boolean equals(Object obj) {
    //     if (this == obj)
    //         return true;
    //     if (obj == null)
    //         return false;
    //     if (getClass() != obj.getClass())
    //         return false;

    //     Bogie other = (Bogie) obj;
        
    //     if(id != null && other.getId()!= null){
    //         return id.equals(other.getId());            
    //     }else if(id == null && other.getId() == null){
    //         if((destinationStation == null && other.getdestinationStation() != null) || (destinationStation != null && other.getdestinationStation() == null)){
    //             return false;
    //         }else if(destinationStation == null && other.getdestinationStation() == null){
    //             return true;
    //         }
    //     }
    //     return destinationStation.equals(other.getdestinationStation());
    // }  
}
