package DataStructs.SingleLinkList;

/**
 * Created by aloneboy on 2017/12/17.
 */
public interface Node<T> {
    T getValue();
    void setValue(T value);
    boolean equals(Node node);
}
