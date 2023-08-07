package com.geektrust.example.geektrust;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

		// Validate and sanitize the input file path
		Path filePath = Paths.get(inputFile).toAbsolutePath();
		if (!isValidFilePath(filePath)) {
			System.err.println("Invalid file path.");
			return;
		}

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(filePath.toString()));
			String line = reader.readLine();
			while (line != null) {
				List<String> tokens = Arrays.asList(line.split(space));
				commandInvoker.executeCommand(tokens.get(ZERO), tokens);
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException | NotFoundException e) {
			System.err.println("Error reading the input file.");
		}

		commandInvoker.executeCommand(TRAVEL, Arrays.asList(FIRST_TRAIN, FIRST_TRAIN, HYB));
		commandInvoker.executeCommand(TRAVEL, Arrays.asList(SECOND_TRAIN, SECOND_TRAIN, HYB));
		commandInvoker.executeCommand(MERGE, Arrays.asList(FIRST_TRAIN, SECOND_TRAIN));
	}

	public static void main(String[] args) {
		if (args.length < 1) {
			System.err.println("Usage: java App <inputFilePath>");
			System.exit(1);
		}

		run(args[0]);
	}

	// Method to validate if the file path is within the allowed directory
	private static boolean isValidFilePath(Path filePath) {
		// Implement your logic to check if the file path is valid and within allowed directories
		// For example, compare against a predefined whitelist of directories or check for specific allowed paths
		return Files.exists(filePath) && filePath.startsWith(Paths.get("/path/to/allowed/directory"));
	}
}
