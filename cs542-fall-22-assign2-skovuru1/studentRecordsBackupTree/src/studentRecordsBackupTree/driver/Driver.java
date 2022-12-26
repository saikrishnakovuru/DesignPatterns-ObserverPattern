package studentRecordsBackupTree.driver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import studentRecordsBackupTree.bst.BSTBuilderInterface;
import studentRecordsBackupTree.bstImpl.BSTBuilderImpl;
import studentRecordsBackupTree.util.FileProcessorInterface;
import studentRecordsBackupTree.utilImpl.FileProcessorImpl;
import studentRecordsBackupTree.utilImpl.MyLogger;
import studentRecordsBackupTree.utilImpl.Results;

public class Driver {

	private BSTBuilderInterface bstBuilder;
	private FileProcessorInterface fileProcessor;

	public Driver(BSTBuilderInterface builder, FileProcessorInterface processor) {
		bstBuilder = builder;
		fileProcessor = processor;
	}

	private void doStuff(String inputFile) {
		bstBuilder.build(inputFile, fileProcessor);
	}

	public static void main(String[] args) {

		if (args.length != 5 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")
				|| args[3].equals("${arg3}") || args[4].equals("${arg4}")) {

			System.err.println("Error: Incorrect number of arguments. Program accepts 5 argumnets.");
			System.exit(1);
		}

		if (new File(args[0]).exists() && new File(args[1]).exists()
				&& new File(args[0]).length() != 0) {

			try {
				FileWriter bstOutput = new FileWriter(args[1]);
				FileWriter errorLog = new FileWriter(args[2]);
				int valueToIncrementTheNode = 0;
				int debugLevel = 0;

				if (args[3].matches("\\d+") && args[4].matches("\\d+")) {
					debugLevel = Integer.parseInt(args[3]);
					valueToIncrementTheNode = Integer.parseInt(args[4]);

					MyLogger.setDebugValue(debugLevel);
					Results results = new Results(bstOutput);

					BSTBuilderInterface bstBuilder = new BSTBuilderImpl(results, valueToIncrementTheNode);
					FileProcessorInterface fileProcessor = new FileProcessorImpl(errorLog);
					Driver driver = new Driver(bstBuilder, fileProcessor);
					driver.doStuff(args[0]);
					results.displayResultsInConsole();
					results.displayResultsInFile();
				} else {
					errorLog.write("Either debug value or increment value has been entered in a non integer format");
					MyLogger.writeMessage(
							"Either debug value or increment value has been entered in a non integer format", null);
					errorLog.flush();
					System.exit(1);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {

			}
		} else {
			MyLogger.writeMessage("Wither the file is not there or the data in the input file is not present", null);
		}
		// }
	}
}
