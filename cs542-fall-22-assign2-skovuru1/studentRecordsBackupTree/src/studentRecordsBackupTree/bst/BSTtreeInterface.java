package studentRecordsBackupTree.bst;

import studentRecordsBackupTree.bstImpl.Node;
import studentRecordsBackupTree.utilImpl.Results;
import studentRecordsBackupTree.bstImpl.BSTBuilderImpl.TreeType;

public interface BSTtreeInterface {

    public void addNode(Node node);

    public void inOrderTraversal(Node node, TreeType type);

    public Node getRootNode();

    public Node find(int index);

    public int addition();

    public void setMainBSTValuesAndTheirSumOfNodes(Results results, int summation);

    public void setBackUpTreeOneValuesAndTheirSumOfNodes(Results results, int summation);

    public void setBackUpTreeTwoValuesAndTheirSumOfNodes(Results results, int summation);

    public void setMainBSTValuesAndTheirSumOfNodesAfterIncrement(Results results, int summation);

    public void setBackUpTreeOneValuesAndTheirSumOfNodesAfterIncrement(Results results, int summation);

    public void setBackUpTreeTwoValuesAndTheirSumOfNodesAfterIncrement(Results results, int summation);

}
