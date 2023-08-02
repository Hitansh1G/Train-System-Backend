package com.geektrust.example.geektrust.config;

import com.geektrust.example.geektrust.commands.CommandInvoker;
import com.geektrust.example.geektrust.commands.ICommand;
import com.geektrust.example.geektrust.commands.DataCommand;
import com.geektrust.example.geektrust.commands.LoadTrainDataCommand;
import com.geektrust.example.geektrust.commands.MergeTrainCommand;
import com.geektrust.example.geektrust.commands.TravelCommand;
import com.geektrust.example.geektrust.repositories.BogieRepository;
import com.geektrust.example.geektrust.repositories.IBogieRepository;
import com.geektrust.example.geektrust.repositories.IRouteRepository;
import com.geektrust.example.geektrust.repositories.IStationRepository;
import com.geektrust.example.geektrust.repositories.ITrainRepository;
import com.geektrust.example.geektrust.repositories.RouteRepository;
import com.geektrust.example.geektrust.repositories.StationRepository;
import com.geektrust.example.geektrust.repositories.TrainRepository;
import com.geektrust.example.geektrust.services.ITrainService;
import com.geektrust.example.geektrust.services.TrainService;

import static com.geektrust.example.geektrust.Constants.Constants.*;

public class ApplicationConfig {
    private final IRouteRepository iRouteRepository = new RouteRepository();
    private final ITrainRepository iTrainRepository = new TrainRepository();
    private final IBogieRepository iBogieRepository = new BogieRepository();
    private final IStationRepository iStationRepository = new StationRepository();

    private final ITrainService iTrainService = new TrainService(iRouteRepository, iTrainRepository, iBogieRepository,
            iStationRepository);

    private final ICommand loadDataCommand = new DataCommand(iStationRepository, iRouteRepository);
    private final ICommand loadTrainDataCommand = new LoadTrainDataCommand(iTrainService);
    private final ICommand travelCommand = new TravelCommand(iTrainService);
    private final ICommand mergeTrainCommand = new MergeTrainCommand(iTrainService);

    private final CommandInvoker commandInvoker = new CommandInvoker();

    public CommandInvoker getCommandInvoker() {
        commandInvoker.register(LOAD_DATA, loadDataCommand);
        commandInvoker.register(FIRST_TRAIN, loadTrainDataCommand);
        commandInvoker.register(SECOND_TRAIN, loadTrainDataCommand);
        commandInvoker.register(TRAVEL, travelCommand);
        commandInvoker.register(MERGE, mergeTrainCommand);
        return commandInvoker;
    }    
}
