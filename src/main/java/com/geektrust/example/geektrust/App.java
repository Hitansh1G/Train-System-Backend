package com.geektrust.example.geektrust;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import com.geektrust.example.geektrust.commands.CommandInvoker;
import com.geektrust.example.geektrust.config.ApplicationConfig;
import com.geektrust.example.geektrust.exceptions.NotFoundException;

import static com.geektrust.example.geektrust.Constants.Constants.*;

public class App {
	public static void run(String commandLineArgs) {
		ApplicationConfig applicationConfig = new ApplicationConfig();
		CommandInvoker commandInvoker = applicationConfig.getCommandInvoker();
		commandInvoker.executeCommand(LOAD_DATA, null);
		String inputFile = commandLineArgs;
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(inputFile));
			String line = reader.readLine();
			while (line != null) {
				List<String> tokens = Arrays.asList(line.split(space));
				commandInvoker.executeCommand(tokens.get(ZERO), tokens);
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException | NotFoundException e) {
//			e.printStackTrace();
		}
		commandInvoker.executeCommand(TRAVEL, Arrays.asList(FIRST_TRAIN, FIRST_TRAIN, HYB));
		commandInvoker.executeCommand(TRAVEL, Arrays.asList(SECOND_TRAIN, SECOND_TRAIN, HYB));
		commandInvoker.executeCommand(MERGE, Arrays.asList(FIRST_TRAIN, SECOND_TRAIN));
	}

	public static void main(String[] args) {
		run(args[0]);
	}

}
