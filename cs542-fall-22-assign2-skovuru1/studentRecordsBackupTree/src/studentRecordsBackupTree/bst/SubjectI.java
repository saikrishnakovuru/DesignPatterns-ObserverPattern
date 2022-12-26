package studentRecordsBackupTree.bst;

public interface SubjectI {

    public void addObserver(ObserverI observer);

    public void notifyAllObservers(int a);
}
