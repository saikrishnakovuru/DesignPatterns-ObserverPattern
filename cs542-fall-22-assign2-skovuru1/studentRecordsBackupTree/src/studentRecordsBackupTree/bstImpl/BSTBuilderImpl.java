package studentRecordsBackupTree.bstImpl;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import studentRecordsBackupTree.bst.BSTBuilderInterface;
import studentRecordsBackupTree.bst.BSTtreeInterface;
import studentRecordsBackupTree.util.FileProcessorInterface;
import studentRecordsBackupTree.utilImpl.Results;

public class BSTBuilderImpl implements BSTBuilderInterface {

	public static enum TreeType {
		// enum values to differentiate the treed
		MAIN, BACKUP_ONE, BACKUP_TWO
	};

	private BSTtreeInterface mainBST;
	private BSTtreeInterface backUpTreeOne;
	private BSTtreeInterface backUpTreeTwo;
	private Node mainNode;
	private Node backUpNodeOne;
	private Node backUpNodeTwo;
	private List<Integer> inputFileDataList;
	private FileProcessorInterface fileProcessor;
	private Results results;
	private int valueToIncrementTheNode;
	FileWriter errorLog;

	public BSTBuilderImpl(Results res, int incrementValue) {
		valueToIncrementTheNode = incrementValue;
		results = res;
		mainBST = new BSTreeImpl();
		backUpTreeOne = new BSTreeImpl();
		backUpTreeTwo = new BSTreeImpl();

		inputFileDataList = new ArrayList<Integer>();
	}

	@Override
	public void build(String inputFile, FileProcessorInterface processor) {
		fileProcessor = processor;
		inputFileDataList = fileProcessor.givenInput(inputFile);
		// Getting the values one by one from file processor
		for (int bNumber : inputFileDataList) {
			setValuesToBinarySearchTree(bNumber);
		}

		// in order traversel.
		mainBST.inOrderTraversal(mainBST.getRootNode(), TreeType.MAIN);
		// setting the values of addition.
		mainBST.setMainBSTValuesAndTheirSumOfNodes(results, mainBST.addition());

		// using enum to differentiate the tree
		backUpTreeOne.inOrderTraversal(backUpTreeOne.getRootNode(), TreeType.BACKUP_ONE);
		backUpTreeOne.setBackUpTreeOneValuesAndTheirSumOfNodes(results, mainBST.addition());

		// using enum to differentiate the tree
		backUpTreeTwo.inOrderTraversal(backUpTreeTwo.getRootNode(), TreeType.BACKUP_TWO);
		backUpTreeTwo.setBackUpTreeTwoValuesAndTheirSumOfNodes(results, mainBST.addition());

		// incremetning the node value which is entred in the commandline
		incrementGivenValue(inputFileDataList, valueToIncrementTheNode);
		// using enum to differentiate the tree
		mainBST.inOrderTraversal(mainBST.getRootNode(), TreeType.MAIN);
		mainBST.setMainBSTValuesAndTheirSumOfNodesAfterIncrement(results, mainBST.addition());

		// using enum to differentiate the tree
		backUpTreeOne.inOrderTraversal(backUpTreeOne.getRootNode(), TreeType.BACKUP_ONE);
		backUpTreeOne.setBackUpTreeOneValuesAndTheirSumOfNodesAfterIncrement(results, mainBST.addition());

		// using enum to differentiate the tree
		backUpTreeTwo.inOrderTraversal(backUpTreeTwo.getRootNode(), TreeType.BACKUP_TWO);
		backUpTreeTwo.setBackUpTreeTwoValuesAndTheirSumOfNodesAfterIncrement(results, mainBST.addition());
	}

	private void incrementGivenValue(List<Integer> inputFileDataList, int a) {
		// idea behind the collections reverse is because I was clueless behind the
		// reason why the tree
		// as not printing in the order because, since hte InOrder prints in the
		// ascending order
		// the tree values are bieng swapped, do used reverse order and then incremented
		// the vlaues and then
		// calling BST will never cause any problem.
		Collections.reverse(inputFileDataList);
		for (int bNumber : inputFileDataList) {
			Node node = mainBST.find(bNumber);
			// got null pointer exception few times while adding the input so added the if
			// condition for the node existence

			if (node != null) {
				node.setbNumber(node.getBNumber() + a);
				// notifying obnservers.
				node.notifyAllObservers(a);
			}
		}

	}

	private void setValuesToBinarySearchTree(int bNumber) {

		mainNode = new Node(bNumber);
		// cloning the values to backup from main.
		backUpNodeOne = mainNode;
		backUpNodeTwo = mainNode;

		// registering the observers
		registerObservers(mainNode, backUpNodeOne, backUpNodeTwo);

		// addig the node to the BST's
		mainBST.addNode(mainNode);
		backUpTreeOne.addNode(backUpNodeOne);
		backUpTreeTwo.addNode(backUpNodeTwo);
	}

	private void registerObservers(Node mainNode, Node backUpNodeOne, Node backUpNodeTwo) {
		mainNode.addObserver(backUpNodeOne);
		mainNode.addObserver(backUpNodeTwo);
	}

}
