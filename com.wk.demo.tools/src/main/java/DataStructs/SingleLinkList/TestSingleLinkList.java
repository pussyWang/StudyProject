package DataStructs.SingleLinkList;

/**
 * Created by aloneboy on 2017/12/17.
 */
public class TestSingleLinkList {
    public static void main(String[] args) {
        SingleLinkList<Integer> linkList = new SingleLinkListImpl<Integer>();
        System.out.println("length:" + linkList.getLength());
        linkList.insertForHead(1);
        linkList.insertForHead(2);
        linkList.insertForHead(3);
        linkList.insertForHead(4);

    }
}
