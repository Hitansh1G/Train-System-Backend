package com.geektrust.example.geektrust.repositories;

import com.geektrust.example.geektrust.entities.Route;
import com.geektrust.example.geektrust.entities.Station;

import javax.xml.crypto.Data;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import static com.geektrust.example.geektrust.Constants.Constants.*;

public class LoadDataRepository implements IDataRepository {
    private final IStationRepository iStationRepository;
    private final IRouteRepository iRouteRepository;

    public LoadDataRepository(IStationRepository iStationRepository, IRouteRepository iRouteRepository) {
        this.iStationRepository = iStationRepository;
        this.iRouteRepository = iRouteRepository;
    }

    @Override
    public void loadData() {
        loadFirstRoute();
        loadSecondRoute();
    }

    private void loadFirstRoute() {
        LinkedList<Station> stationsOfRoute1 = new LinkedList<>();

        stationsOfRoute1.add(saveStation(new Station(Chennai, CHN, dis2)));
        stationsOfRoute1.add(saveStation(new Station(Salem, SLM, dis3)));
        stationsOfRoute1.add(saveStation(new Station(Bangalore, BLR, dis4)));
        stationsOfRoute1.add(saveStation(new Station(Kurnool, KRN, dis5)));
        stationsOfRoute1.add(saveStation(new Station(Hyderabad, HYB, dis6)));
        stationsOfRoute1.add(saveStation(new Station(Nagpur, NGP, dis7)));
        stationsOfRoute1.add(saveStation(new Station(Itarsi, ITJ, dis8)));
        stationsOfRoute1.add(saveStation(new Station(Bhopal, BPL, dis9)));
        stationsOfRoute1.add(saveStation(new Station(Agra, AGA, dis10)));
        stationsOfRoute1.add(saveStation(new Station(New_Delhi, NDL, dis11)));

        Route route1 = new Route(FIRST_TRAIN, stationsOfRoute1, dis1);
        iRouteRepository.save(route1);
    }

    private void loadSecondRoute() {
        LinkedList<Station> stationsOfRoute2 = new LinkedList<>();
        stationsOfRoute2.add(saveStation(new Station(Trivandrum, TVC, dis12)));
        stationsOfRoute2.add(saveStation(new Station(Shoranpur, SRR, dis13)));
        stationsOfRoute2.add(saveStation(new Station(Mangalore, MAQ, dis14)));
        stationsOfRoute2.add(saveStation(new Station(Madgaon, MAO, dis15)));
        stationsOfRoute2.add(saveStation(new Station(Pune, PNE, dis16)));
        stationsOfRoute2.add(saveStation(new Station(Hyderabad, HYB, dis17)));
        stationsOfRoute2.add(saveStation(new Station(Nagpur, NGP, dis18)));
        stationsOfRoute2.add(saveStation(new Station(Itarsi, ITJ, dis19)));
        stationsOfRoute2.add(saveStation(new Station(Bhopal, BPL, dis20)));
        stationsOfRoute2.add(saveStation(new Station(Patna, PTA, dis21)));
        stationsOfRoute2.add(saveStation(new Station(New_Jalpaiguri, NJP, dis22)));
        stationsOfRoute2.add(saveStation(new Station(Guwahati, GHY, dis23)));

        Route route2 = new Route(SECOND_TRAIN, stationsOfRoute2, dis24);
        iRouteRepository.save(route2);
    }

    private Station saveStation(Station station) {
        return iStationRepository.save(station);
    }

    @Override
    public Data save(Data entity) {
        return null;
    }

    @Override
    public List<Data> findAll() {
        return null;
    }

//    @Override
//    public List<Data> findAll() {
//        return null;
//    }

//    @Override
//    public Optional<Data> findById(String s) {
//        return Optional.empty();
//    }
//
//    @Override
//    public boolean existsById(String s) {
//        return false;
//    }
//
//    @Override
//    public void delete(Data entity) {
//
//    }
//
//    @Override
//    public void deleteById(String s) {
//
//    }
//
//    @Override
//    public long count() {
//        return 0;
//    }
}
