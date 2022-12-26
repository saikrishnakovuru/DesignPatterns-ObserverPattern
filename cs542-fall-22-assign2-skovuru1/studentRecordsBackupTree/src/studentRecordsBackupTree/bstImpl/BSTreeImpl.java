package studentRecordsBackupTree.bstImpl;

import studentRecordsBackupTree.bst.BSTtreeInterface;
import studentRecordsBackupTree.bstImpl.BSTBuilderImpl.TreeType;
import studentRecordsBackupTree.utilImpl.Results;

public class BSTreeImpl implements BSTtreeInterface {

    private Node rootNode;
    private String BSTMain = "";
    private String backUpOne = "";
    private String backUpTwo = "";

    public BSTreeImpl() {
    }

    @Override
    public void addNode(Node node) {
        // careting BST
        int bNumber = node.getBNumber();
        if (find(bNumber) == null) {
            if (getRootNode() == null) {
                rootNode = node;
            } else {
                Node focusNode = getRootNode();
                Node parent;

                while (true) {
                    parent = focusNode;

                    if (bNumber < focusNode.getBNumber()) {
                        focusNode = focusNode.getLeftChild();

                        if (focusNode == null) {
                            parent.setLeftChild(node);
                            return;
                        }
                    } else {
                        focusNode = focusNode.getRightChild();
                        if (focusNode == null) {
                            parent.setRightChild(node);
                            return;
                        }
                    }
                }
            }
        }

    }

    @Override
    public void inOrderTraversal(Node focusNode, TreeType type) {
        if (focusNode != null) {
            inOrderTraversal(focusNode.getLeftChild(), type);
            if (type == TreeType.MAIN) {
                BSTMain += focusNode.toString() + ",";
            } else if (type == TreeType.BACKUP_ONE) {
                backUpOne += focusNode.toString() + ",";
            } else if (type == TreeType.BACKUP_TWO) {
                backUpTwo += focusNode.toString() + ",";
            }
            inOrderTraversal(focusNode.getRightChild(), type);
        }
    }

    @Override
    public void setMainBSTValuesAndTheirSumOfNodes(Results results, int sumOfNodes) {
        results.setMainBST(BSTMain, sumOfNodes);
    }

    @Override
    public void setBackUpTreeOneValuesAndTheirSumOfNodes(Results results, int sumOfNodes) {
        results.setBackUpOne(backUpOne, sumOfNodes);
    }

    @Override
    public void setBackUpTreeTwoValuesAndTheirSumOfNodes(Results results, int sumOfNodes) {
        results.setBackUpTwo(backUpTwo, sumOfNodes);
    }

    @Override
    public void setMainBSTValuesAndTheirSumOfNodesAfterIncrement(Results results, int sumOfNodes) {
        results.setMainBSTAfterIncrement(sumOfNodes);
    }

    @Override
    public void setBackUpTreeOneValuesAndTheirSumOfNodesAfterIncrement(Results results, int sumOfNodes) {
        results.setBackUpOneAfterIncrement(sumOfNodes);
    }

    @Override
    public void setBackUpTreeTwoValuesAndTheirSumOfNodesAfterIncrement(Results results, int sumOfNodes) {
        results.setBackUpTwoAfterIncrement(sumOfNodes);
    }

    @Override
    public int addition() {
        Node root = getRootNode();
        return addRoots(root);
    }

    public int addRoots(Node root) {

        if (root == null)
            return 0;
        // returnign the addition if not the root is null
        return root.getBNumber() + addRoots(root.getLeftChild()) + addRoots(root.getRightChild());
    }

    // Finding the node
    // source geeksForGeeks.
    @Override
    public Node find(int index) {
        // finding the node baed on the index.
        Node currentNode = rootNode;
        if (rootNode == null) {
            return null;
        }
        while (currentNode.getBNumber() != index) {
            if (index < currentNode.getBNumber()) {
                currentNode = currentNode.getLeftChild();
            } else {
                currentNode = currentNode.getRightChild();
            }
            if (currentNode == null) {
                return null;
            }
        }
        return currentNode;
    }

    @Override
    public Node getRootNode() {
        // returnign the root node.
        return rootNode;
    }

}
