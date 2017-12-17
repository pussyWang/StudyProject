package DataStructs.SingleLinkList;

/**
 * Created by aloneboy on 2017/12/17.
 */
public interface SingleLinkList<T> {

    void insertForHead(T node);

    void insertForTail(T node);

    int getLength();

    void deleteByIndex(int index);

    void deleteByNode(T node);

    T queryByIndex(int index);

    boolean equals(SingleLinkList linkList);



}
