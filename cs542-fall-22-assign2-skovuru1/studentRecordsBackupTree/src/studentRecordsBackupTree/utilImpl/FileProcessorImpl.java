package studentRecordsBackupTree.utilImpl;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import studentRecordsBackupTree.util.FileProcessorInterface;
import studentRecordsBackupTree.utilImpl.MyLogger.DebugLevel;

public class FileProcessorImpl implements FileProcessorInterface {

    private List<Integer> inputDataList;
    private Scanner scanner;
    private FileWriter fileWriter;

    public FileProcessorImpl(FileWriter errorLog) {
        fileWriter = errorLog;
        inputDataList = new ArrayList<>();
    }

    @Override
    public List<Integer> givenInput(String inputFile) {
        try {
            scanner = new Scanner(new File(inputFile));

            while (scanner.hasNext()) {

                if (scanner.hasNextInt()) {
                    int bNumber = scanner.nextInt();
                    inputDataList.add(bNumber);
                } else {
                    MyLogger.writeMessage("Only integers has to be passed as inputs to BST", DebugLevel.CONSTRUCTOR);
                    fileWriter.write("Only integers has to be passed as inputs to BST");
                    fileWriter.flush();
                    System.exit(1);
                }
            }

        } catch (Exception ex) {

            ex.printStackTrace();

        } finally {
            // closing the scanner resource
            scanner.close();
        }
        return inputDataList;
    }

}
