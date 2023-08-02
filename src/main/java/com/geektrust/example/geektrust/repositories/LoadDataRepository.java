package com.geektrust.example.geektrust.repositories;

import com.geektrust.example.geektrust.entities.Route;
import com.geektrust.example.geektrust.entities.Station;

import javax.xml.crypto.Data;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static com.geektrust.example.geektrust.Constants.Constants.*;
import static com.geektrust.example.geektrust.Constants.Constants.SECOND_TRAIN;

public class LoadDataRepository implements IDataRepository {
    private final IStationRepository iStationRepository;
    private final IRouteRepository iRouteRepository;

    public LoadDataRepository(IStationRepository iStationRepository, IRouteRepository iRouteRepository) {
        this.iStationRepository = iStationRepository;
        this.iRouteRepository = iRouteRepository;
    }

    @Override
    public void loadData() {
        
        
        LinkedList<Station> stationsOfRoute1 = new LinkedList<>();

        Route route1 = new Route(FIRST_TRAIN, stationsOfRoute1, dis1);
        iRouteRepository.save(route1);

        Station station = new Station(Chennai, CHN, dis2);
        Station tempStation = iStationRepository.save(station);
        stationsOfRoute1.add(tempStation);

        station = new Station(Salem, SLM, dis3);
        tempStation = iStationRepository.save(station);
        stationsOfRoute1.add(tempStation);

        station = new Station(Bangalore, BLR, dis4);
        tempStation = iStationRepository.save(station);
        stationsOfRoute1.add(tempStation);

        station = new Station(Kurnool, KRN, dis5);
        tempStation = iStationRepository.save(station);
        stationsOfRoute1.add(tempStation);

        station = new Station(Hyderabad, HYB, dis6);
        tempStation = iStationRepository.save(station);
        stationsOfRoute1.add(tempStation);

        station = new Station(Nagpur, NGP, dis7);
        tempStation = iStationRepository.save(station);
        stationsOfRoute1.add(tempStation);

        station = new Station(Itarsi, ITJ, dis8);
        tempStation = iStationRepository.save(station);
        stationsOfRoute1.add(tempStation);

        station = new Station(Bhopal, BPL, dis9);
        tempStation = iStationRepository.save(station);
        stationsOfRoute1.add(tempStation);

        station = new Station(Agra, AGA, dis10);
        tempStation = iStationRepository.save(station);
        stationsOfRoute1.add(tempStation);

        station = new Station(New_Delhi, NDL, dis11);
        tempStation = iStationRepository.save(station);
        stationsOfRoute1.add(tempStation);

        

        // stations of second route
        LinkedList<Station> stationsOfRoute2 = new LinkedList<Station>();
        station = new Station(Trivandrum, TVC, dis12);
        tempStation = iStationRepository.save(station);
        stationsOfRoute2.add(tempStation);

        station = new Station(Shoranpur, SRR, dis13);
        tempStation = iStationRepository.save(station);
        stationsOfRoute2.add(tempStation);

        station = new Station(Mangalore, MAQ, dis14);
        tempStation = iStationRepository.save(station);
        stationsOfRoute2.add(tempStation);

        station = new Station(Madgaon, MAO, dis15);
        tempStation = iStationRepository.save(station);
        stationsOfRoute2.add(tempStation);

        station = new Station(Pune, PNE, dis16);
        tempStation = iStationRepository.save(station);
        stationsOfRoute2.add(tempStation);

        station = new Station(Hyderabad, HYB, dis17);
        tempStation = iStationRepository.save(station);
        stationsOfRoute2.add(tempStation);

        station = new Station(Nagpur, NGP, dis18);
        tempStation = iStationRepository.save(station);
        stationsOfRoute2.add(tempStation);

        station = new Station(Itarsi, ITJ, dis19);
        tempStation = iStationRepository.save(station);
        stationsOfRoute2.add(tempStation);

        station = new Station(Bhopal, BPL, dis20);
        tempStation = iStationRepository.save(station);
        stationsOfRoute2.add(tempStation);

        station = new Station(Patna, PTA, dis21);
        tempStation = iStationRepository.save(station);
        stationsOfRoute2.add(tempStation);

        station = new Station(New_Jalpaiguri, NJP, dis22);
        tempStation = iStationRepository.save(station);
        stationsOfRoute2.add(tempStation);

        station = new Station(Guwahati, GHY, dis23);
        tempStation = iStationRepository.save(station);
        stationsOfRoute2.add(tempStation);

        Route route2 = new Route(SECOND_TRAIN, stationsOfRoute2, dis24);
        iRouteRepository.save(route2);
        
    }

    @Override
    public Data save(Data entity) {
        return null;
    }

    @Override
    public List<Data> findAll() {
        return null;
    }

    @Override
    public Optional<Data> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public void delete(Data entity) {

    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public long count() {
        return 0;
    }
}
