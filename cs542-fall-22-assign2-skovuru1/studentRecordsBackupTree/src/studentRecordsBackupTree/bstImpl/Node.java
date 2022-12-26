package studentRecordsBackupTree.bstImpl;

import java.util.ArrayList;
import java.util.List;

import studentRecordsBackupTree.bst.ObserverI;
import studentRecordsBackupTree.bst.SubjectI;

public class Node implements SubjectI, ObserverI {
	private int bNumber;
	private Node leftChild;
	private Node rightChild;
	private List<ObserverI> observers;

	public Node(int number) {
		bNumber = number;
		observers = new ArrayList<ObserverI>();
	}

	@Override
	public void updateNodeValue(int bNumber) {
		Node temp = new Node(bNumber);
		temp.setbNumber(getBNumber() + bNumber);
	}

	@Override
	public void addObserver(ObserverI observer) {
		getObservers().add(observer);

	}

	@Override
	public void notifyAllObservers(int a) {
		if (getObservers() != null) {
			for (int i = 0; i < observers.size(); i++) {
				updateNodeValue(a);
			}
		}
	}

	public int getBNumber() {
		return bNumber;
	}

	public void setbNumber(int bNumber) {
		this.bNumber = bNumber;
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}

	@Override
	public String toString() {
		return "" + bNumber;
	}

	public List<ObserverI> getObservers() {
		return observers;
	}
}
