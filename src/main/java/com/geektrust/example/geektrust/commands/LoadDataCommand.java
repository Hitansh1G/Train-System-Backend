package com.geektrust.example.geektrust.commands;

import java.util.List;
import com.geektrust.example.geektrust.repositories.IRouteRepository;
import com.geektrust.example.geektrust.repositories.IStationRepository;
import com.geektrust.example.geektrust.repositories.data.LoadData;

public class LoadDataCommand implements ICommand {
    private final IStationRepository iStationRepository;
    private final IRouteRepository iRouteRepository;

    public LoadDataCommand(IStationRepository iStationRepository, IRouteRepository iRouteRepository) {
        this.iStationRepository = iStationRepository;
        this.iRouteRepository = iRouteRepository;
    }

    @Override
    public void execute(List<String> tokens) {
        LoadData loadData = new LoadData(iStationRepository, iRouteRepository);
        loadData.loadData();        
    }
    
}
