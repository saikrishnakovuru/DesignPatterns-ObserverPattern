package studentRecordsBackupTree.bst;

import studentRecordsBackupTree.util.FileProcessorInterface;

public interface BSTBuilderInterface {

	public void build(String inputFile, FileProcessorInterface fileProcessor);
	
}
