package com.example.geektrust.entities;


public class Station extends BaseEntity {
    private String stationName;
    private String stationCode;
    private Integer distanceFromSource;

    public Station(String stationName, String stationCode, Integer distanceFromSource){
        this.stationName=stationCode;
        this.stationCode = stationCode;
        this.distanceFromSource = distanceFromSource;
    }

    @Override
    public String getId() {
        return super.getId();
    }

    public String getStationCode() {
        return stationCode;
    }

    public Integer getDistanceFromSource() {
        return distanceFromSource;
    }

    public String getStationName(String stationName) {
        return stationName;
    }

    public Station (String id ,String stationName, String stationCode, Integer distanceFromSource ){
        this.id = id;
        this.stationName =stationCode;
        this.stationCode= stationCode;
        this.distanceFromSource = distanceFromSource;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(!(obj instanceof Station)){
            return false;
        }

        Station station = (Station) obj;
        return getId().equals(station.getId());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }


}
