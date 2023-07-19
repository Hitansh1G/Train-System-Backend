package com.example.geektrust.repositories;

import com.example.geektrust.entities.Route;
import com.example.geektrust.entities.Station;

import java.util.*;

public class RouteRepository implements IRouteRepository {

    private final IStationRepository iStationRepository;
    private final IRouteRepository iRouteRepository;
    private HashMap<String, Route> routeListing;


    public RouteRepository(IStationRepository iStationRepository, IRouteRepository iRouteRepository) {
        this.iStationRepository = iStationRepository;
        this.iRouteRepository = iRouteRepository;
        this.routeListing = new HashMap<String, Route>();
    }

    public RouteRepository(IStationRepository iStationRepository, IRouteRepository iRouteRepository, HashMap<String, Route> routeListing){
        this.iStationRepository = iStationRepository;
        this.iRouteRepository = iRouteRepository;
        this.routeListing = routeListing;
    }

    @Override
    public Route save(Route entity) {
        return null;
    }

    @Override
    public List<Route> findAll() {
        return null;
    }

    @Override
    public Optional<Route> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public void delete(Route entity) {

    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public long count() {
        return 0;
    }

    private Integer identification=0;
    @Override
    public Route saveRoute(Route route) {
//        return null;
        if(route.getId() == null){
            identification++;
            Route tempRoute = new Route(Integer.toString(identification) ,
                    route.getRouteName(),
                    route.getStationsStops(),
                    route.getHyderabadDistance());
            routeListing.put(tempRoute.getId(), tempRoute);
        }

        routeListing.put(route.getId(), route);
        return route;
    }


    @Override
    public Route findRouteByName(String routeName) {
//        return null;
        return routeListing.values().stream().filter(route -> route.getRouteName().equals(routeName)).findFirst().get();
    }

    @Override
    public List<Route> getAllRoutes() {
//        return null;
        return new ArrayList<>(routeListing.values());
    }

    @Override
    public void preDefinedRoute() {

        // ADDING PREDEFINED VALUES OF ROUTE AS GIVEN IN THE PROBLEM STATEMENT
        LinkedList<Station>routeA_Stations = new LinkedList<Station>();

        Station stn = new Station("Chennai", "CHN", 0);
        Station savedStation = iStationRepository.saveStation(stn);
        routeA_Stations.add(savedStation);

        stn = new Station("Salem", "SLM", 350);
        savedStation = iStationRepository.saveStation(stn);
        routeA_Stations.add(savedStation);

        stn = new Station("Bangalore", "BLR", 550);
        savedStation = iStationRepository.saveStation(stn);
        routeA_Stations.add(savedStation);

        stn = new Station("Kurnool", "KRN", 900);
        savedStation = iStationRepository.saveStation(stn);
        routeA_Stations.add(savedStation);

        stn = new Station("Hyderabad", "HYB", 1200);
        savedStation = iStationRepository.saveStation(stn);
        routeA_Stations.add(savedStation);

        stn = new Station("Nagpur", "NGP", 1600);
        savedStation = iStationRepository.saveStation(stn);
        routeA_Stations.add(savedStation);

        stn = new Station("Itarsi", "ITJ", 1900);
        savedStation = iStationRepository.saveStation(stn);
        routeA_Stations.add(savedStation);

        stn = new Station("Bhopal", "BPL", 2000);
        savedStation = iStationRepository.saveStation(stn);
        routeA_Stations.add(savedStation);

        stn = new Station("Agra", "AGA", 2500);
        savedStation = iStationRepository.saveStation(stn);
        routeA_Stations.add(savedStation);

        stn = new Station("New Delhi", "NDL", 2700);
        savedStation = iStationRepository.saveStation(stn);
        routeA_Stations.add(savedStation);

        Route routeFirst = new Route("TRAIN_A", routeA_Stations, 1200);
        iRouteRepository.saveRoute(routeFirst);

        // Saving the stations of other route
        LinkedList<Station> routeB_Stations = new LinkedList<Station>();
        stn = new Station("Trivandrum", "TVC", 0);
        savedStation = iStationRepository.saveStation(stn);
        routeB_Stations.add(savedStation);

        stn = new Station("Shoranpur", "SRR", 300);
        savedStation = iStationRepository.saveStation(stn);
        routeB_Stations.add(savedStation);

        stn = new Station("Mangalore", "MAQ", 600);
        savedStation = iStationRepository.saveStation(stn);
        routeB_Stations.add(savedStation);

        stn = new Station("Madgaon", "MAO", 1000);
        savedStation = iStationRepository.saveStation(stn);
        routeB_Stations.add(savedStation);

        stn = new Station("Pune", "PNE", 1400);
        savedStation = iStationRepository.saveStation(stn);
        routeB_Stations.add(savedStation);

        stn = new Station("Hyderabad", "HYB", 2000);
        savedStation = iStationRepository.saveStation(stn);
        routeB_Stations.add(savedStation);

        stn = new Station("Nagpur", "NGP", 2400);
        savedStation = iStationRepository.saveStation(stn);
        routeB_Stations.add(savedStation);

        stn = new Station("Itarsi", "ITJ", 2700);
        savedStation = iStationRepository.saveStation(stn);
        routeB_Stations.add(savedStation);

        stn = new Station("Bhopal", "BPL", 2800);
        savedStation = iStationRepository.saveStation(stn);
        routeB_Stations.add(savedStation);

        stn = new Station("Patna", "PTA", 3800);
        savedStation = iStationRepository.saveStation(stn);
        routeB_Stations.add(savedStation);

        stn = new Station("New Jalpaiguri", "NJP", 4200);
        savedStation = iStationRepository.saveStation(stn);
        routeB_Stations.add(savedStation);

        stn = new Station("Guwahati", "GHY", 4700);
        savedStation = iStationRepository.saveStation(stn);
        routeB_Stations.add(savedStation);

        Route routeSecond = new Route("TRAIN_B", routeB_Stations, 2000);
        iRouteRepository.saveRoute(routeSecond);

    }
}
