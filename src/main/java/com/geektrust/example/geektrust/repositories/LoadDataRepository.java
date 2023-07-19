package com.geektrust.example.geektrust.repositories;

import com.geektrust.example.geektrust.entities.Route;
import com.geektrust.example.geektrust.entities.Station;

import javax.xml.crypto.Data;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class LoadDataRepository implements IDataRepository {
    private final IStationRepository iStationRepository;
    private final IRouteRepository iRouteRepository;

    public LoadDataRepository(IStationRepository iStationRepository, IRouteRepository iRouteRepository) {
        this.iStationRepository = iStationRepository;
        this.iRouteRepository = iRouteRepository;
    }

    @Override
    public void loadData() {
        
        
        LinkedList<Station> stationsOfRoute1 = new LinkedList<Station>();

        Route route1 = new Route("TRAIN_A", stationsOfRoute1, 1200);
        iRouteRepository.saveRoute(route1);

        Station station = new Station("Chennai", "CHN", 0);
        Station tempStation = iStationRepository.saveStation(station);
        stationsOfRoute1.add(tempStation);

        station = new Station("Salem", "SLM", 350);
        tempStation = iStationRepository.saveStation(station);
        stationsOfRoute1.add(tempStation);

        station = new Station("Bangalore", "BLR", 550);
        tempStation = iStationRepository.saveStation(station);
        stationsOfRoute1.add(tempStation);

        station = new Station("Kurnool", "KRN", 900);
        tempStation = iStationRepository.saveStation(station);
        stationsOfRoute1.add(tempStation);

        station = new Station("Hyderabad", "HYB", 1200);
        tempStation = iStationRepository.saveStation(station);
        stationsOfRoute1.add(tempStation);

        station = new Station("Nagpur", "NGP", 1600);
        tempStation = iStationRepository.saveStation(station);
        stationsOfRoute1.add(tempStation);

        station = new Station("Itarsi", "ITJ", 1900);
        tempStation = iStationRepository.saveStation(station);
        stationsOfRoute1.add(tempStation);

        station = new Station("Bhopal", "BPL", 2000);
        tempStation = iStationRepository.saveStation(station);
        stationsOfRoute1.add(tempStation);

        station = new Station("Agra", "AGA", 2500);
        tempStation = iStationRepository.saveStation(station);
        stationsOfRoute1.add(tempStation);

        station = new Station("New Delhi", "NDL", 2700);
        tempStation = iStationRepository.saveStation(station);
        stationsOfRoute1.add(tempStation);

        

        // Saving the stations of other route
        LinkedList<Station> stationsOfRoute2 = new LinkedList<Station>();
        station = new Station("Trivandrum", "TVC", 0);
        tempStation = iStationRepository.saveStation(station);
        stationsOfRoute2.add(tempStation);

        station = new Station("Shoranpur", "SRR", 300);
        tempStation = iStationRepository.saveStation(station);
        stationsOfRoute2.add(tempStation);

        station = new Station("Mangalore", "MAQ", 600);
        tempStation = iStationRepository.saveStation(station);
        stationsOfRoute2.add(tempStation);

        station = new Station("Madgaon", "MAO", 1000);
        tempStation = iStationRepository.saveStation(station);
        stationsOfRoute2.add(tempStation);

        station = new Station("Pune", "PNE", 1400);
        tempStation = iStationRepository.saveStation(station);
        stationsOfRoute2.add(tempStation);

        station = new Station("Hyderabad", "HYB", 2000);
        tempStation = iStationRepository.saveStation(station);
        stationsOfRoute2.add(tempStation);

        station = new Station("Nagpur", "NGP", 2400);
        tempStation = iStationRepository.saveStation(station);
        stationsOfRoute2.add(tempStation);

        station = new Station("Itarsi", "ITJ", 2700);
        tempStation = iStationRepository.saveStation(station);
        stationsOfRoute2.add(tempStation);

        station = new Station("Bhopal", "BPL", 2800);
        tempStation = iStationRepository.saveStation(station);
        stationsOfRoute2.add(tempStation);

        station = new Station("Patna", "PTA", 3800);
        tempStation = iStationRepository.saveStation(station);
        stationsOfRoute2.add(tempStation);

        station = new Station("New Jalpaiguri", "NJP", 4200);
        tempStation = iStationRepository.saveStation(station);
        stationsOfRoute2.add(tempStation);

        station = new Station("Guwahati", "GHY", 4700);
        tempStation = iStationRepository.saveStation(station);
        stationsOfRoute2.add(tempStation);

        Route route2 = new Route("TRAIN_B", stationsOfRoute2, 2000);
        iRouteRepository.saveRoute(route2);
        
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
