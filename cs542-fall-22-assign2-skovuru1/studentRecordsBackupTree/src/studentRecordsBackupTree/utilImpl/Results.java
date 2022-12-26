package studentRecordsBackupTree.utilImpl;

import java.io.FileWriter;
import java.io.IOException;

import studentRecordsBackupTree.util.FileDisplayInterface;
import studentRecordsBackupTree.util.StdoutDisplayInterface;
import studentRecordsBackupTree.utilImpl.MyLogger.DebugLevel;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {

    private String mainBST;
    private String backUpTreeOne;
    private String backUpTreeTwo;
    private int sumOfNodesInMainBST;
    private int sumOfNodesInBackUpOne;
    private int sumOfNodesInBackUpTwo;
    private int sumOfNodesInMainBSTAfterIncrement;
    private int sumOfNodesInBackUpOneAfterIncrement;
    private int sumOfNodesInBackUpTwoAfterIncrement;
    private FileWriter BSTWriter;

    public Results(FileWriter bstOutput) {
        BSTWriter = bstOutput;
    }

    @Override
    public void displayResultsInConsole() {
        MyLogger.writeMessage("// Inorder traversal", DebugLevel.CONSTRUCTOR);
        MyLogger.writeMessage("BST: " + mainBST, DebugLevel.CONSTRUCTOR);
        MyLogger.writeMessage("Backup-1: " + backUpTreeOne, DebugLevel.CONSTRUCTOR);
        MyLogger.writeMessage("Backup-2: " + backUpTreeTwo, DebugLevel.CONSTRUCTOR);

        MyLogger.writeMessage("\n" + "\n" + "// Sum of all the B-Numbers in each tree", DebugLevel.CONSTRUCTOR);
        MyLogger.writeMessage("BST: " + sumOfNodesInMainBST, DebugLevel.CONSTRUCTOR);
        MyLogger.writeMessage("Backup-1: " + sumOfNodesInBackUpOne, DebugLevel.CONSTRUCTOR);
        MyLogger.writeMessage("Backup-2: " + sumOfNodesInBackUpTwo, DebugLevel.CONSTRUCTOR);

        MyLogger.writeMessage("\n" + "\n" + "// Sum of all the B-Numbers after increment", DebugLevel.CONSTRUCTOR);
        MyLogger.writeMessage("BST: " + sumOfNodesInMainBSTAfterIncrement, DebugLevel.CONSTRUCTOR);
        MyLogger.writeMessage("Backup-1: " + sumOfNodesInBackUpOneAfterIncrement, DebugLevel.CONSTRUCTOR);
        MyLogger.writeMessage("Backup-2: " + sumOfNodesInBackUpTwoAfterIncrement, DebugLevel.CONSTRUCTOR);

    }

    @Override
    public void displayResultsInFile() {
        try {
            BSTWriter.write("// Inorder traversal");
            BSTWriter.write("\n" + "BST: " + mainBST);
            BSTWriter.write("\n" + "Backup-1: " + backUpTreeOne);
            BSTWriter.write("\n" + "Backup-2: " + backUpTreeTwo);

            BSTWriter.write("\n" + "\n" + "// Sum of all the B-Numbers in each tree");
            BSTWriter.write("\n" + "BST: " + sumOfNodesInMainBST);
            BSTWriter.write("\n" + "Backup-1: " + sumOfNodesInBackUpOne);
            BSTWriter.write("\n" + "Backup-2: " + sumOfNodesInBackUpTwo);

            BSTWriter.write("\n" + "\n" + "// Sum of all the B-Numbers after increment");
            BSTWriter.write("\n" + "BST: " + sumOfNodesInMainBSTAfterIncrement);
            BSTWriter.write("\n" + "Backup-1: " + sumOfNodesInBackUpOneAfterIncrement);
            BSTWriter.write("\n" + "Backup-2: " + sumOfNodesInBackUpTwoAfterIncrement);

            BSTWriter.flush();
            BSTWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }

    }

    public void setMainBST(String mainBst, int sumOfNodes) {
        mainBST = trimTree(mainBst);
        sumOfNodesInMainBST = sumOfNodes;
    }

    public void setBackUpOne(String backUpOne, int sumOfNodes) {
        backUpTreeOne = trimTree(backUpOne);
        sumOfNodesInBackUpOne = sumOfNodes;
    }

    public void setBackUpTwo(String backUpTwo, int sumOfNodes) {
        backUpTreeTwo = trimTree(backUpTwo);
        sumOfNodesInBackUpTwo = sumOfNodes;
    }

    public void setMainBSTAfterIncrement(int sumOfNodes) {
        sumOfNodesInMainBSTAfterIncrement = sumOfNodes;
    }

    public void setBackUpOneAfterIncrement(int sumOfNodes) {
        sumOfNodesInBackUpOneAfterIncrement = sumOfNodes;
    }

    public void setBackUpTwoAfterIncrement(int sumOfNodes) {
        sumOfNodesInBackUpTwoAfterIncrement = sumOfNodes;
    }

    private String trimTree(String value) {
        if (value != null && value.endsWith(",")) {
            value = value.substring(0, value.length() - 1);
        }
        return value;
    }

}
