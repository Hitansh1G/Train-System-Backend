package com.geektrust.example.geektrust.commands;

import java.util.List;

import com.geektrust.example.geektrust.repositories.LoadDataRepository;
import com.geektrust.example.geektrust.repositories.IRouteRepository;
import com.geektrust.example.geektrust.repositories.IStationRepository;

public class DataCommand implements ICommand {
    private final IStationRepository iStationRepository;
    private final IRouteRepository IRouteRepository;

    public DataCommand(IStationRepository iStationRepository, IRouteRepository IRouteRepository) {
        this.iStationRepository = iStationRepository;
        this.IRouteRepository = IRouteRepository;
    }

    @Override
    public void execute(List<String> tokens) {
        LoadDataRepository loadData = new LoadDataRepository(iStationRepository, IRouteRepository);
        loadData.loadData();        
    }
    
}
