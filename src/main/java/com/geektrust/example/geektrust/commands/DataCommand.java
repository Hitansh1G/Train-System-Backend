package com.geektrust.example.geektrust.commands;

import java.util.List;

import com.geektrust.example.geektrust.repositories.LoadDataRepository;
import com.geektrust.example.geektrust.repositories.RouteRepositoryInterface;
import com.geektrust.example.geektrust.repositories.IStationRepository;

public class DataCommand implements ICommand {
    private final IStationRepository iStationRepository;
    private final RouteRepositoryInterface routeRepositoryInterface;

    public DataCommand(IStationRepository iStationRepository, RouteRepositoryInterface routeRepositoryInterface) {
        this.iStationRepository = iStationRepository;
        this.routeRepositoryInterface = routeRepositoryInterface;
    }

    @Override
    public void execute(List<String> tokens) {
        LoadDataRepository loadData = new LoadDataRepository(iStationRepository, routeRepositoryInterface);
        loadData.loadData();        
    }
    
}
