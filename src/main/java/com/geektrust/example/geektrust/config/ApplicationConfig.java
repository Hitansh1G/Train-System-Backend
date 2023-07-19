package com.geektrust.example.geektrust.config;

import com.geektrust.example.geektrust.commands.CommandInvoker;
import com.geektrust.example.geektrust.commands.ICommand;
import com.geektrust.example.geektrust.commands.LoadDataCommand;
import com.geektrust.example.geektrust.commands.LoadTrainDataCommand;
import com.geektrust.example.geektrust.commands.MergeTrainCommand;
import com.geektrust.example.geektrust.commands.TravelCommand;
import com.geektrust.example.geektrust.repositories.BoggyRepository;
import com.geektrust.example.geektrust.repositories.IBoggyRepository;
import com.geektrust.example.geektrust.repositories.IRouteRepository;
import com.geektrust.example.geektrust.repositories.IStationRepository;
import com.geektrust.example.geektrust.repositories.ITrainRepository;
import com.geektrust.example.geektrust.repositories.RouteRepository;
import com.geektrust.example.geektrust.repositories.StationRepository;
import com.geektrust.example.geektrust.repositories.TrainRepository;
import com.geektrust.example.geektrust.services.ITrainService;
import com.geektrust.example.geektrust.services.TrainService;

public class ApplicationConfig {
    private IRouteRepository iRouteRepository = new RouteRepository();
    private ITrainRepository iTrainRepository = new TrainRepository();
    private IBoggyRepository iBoggyRepository = new BoggyRepository();
    private IStationRepository iStationRepository = new StationRepository();

    private ITrainService iTrainService = new TrainService(iRouteRepository, iTrainRepository, iBoggyRepository,
            iStationRepository);

    private ICommand loadDataCommand = new LoadDataCommand(iStationRepository, iRouteRepository);
    private ICommand loadTrainDataCommand = new LoadTrainDataCommand(iTrainService);
    private ICommand travelCommand = new TravelCommand(iTrainService);
    private ICommand mergeTrainCommand = new MergeTrainCommand(iTrainService);

    private final CommandInvoker commandInvoker = new CommandInvoker();

    public CommandInvoker getCommandInvoker() {
        commandInvoker.register("LOAD_DATA", loadDataCommand);
        commandInvoker.register("TRAIN_A", loadTrainDataCommand);
        commandInvoker.register("TRAIN_B", loadTrainDataCommand);
        commandInvoker.register("TRAVEL", travelCommand);
        commandInvoker.register("MERGE", mergeTrainCommand);
        return commandInvoker;
    }    
}
