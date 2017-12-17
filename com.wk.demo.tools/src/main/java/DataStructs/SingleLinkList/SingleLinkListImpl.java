package DataStructs.SingleLinkList;

import org.apache.poi.ss.formula.functions.T;

/**
 * Created by aloneboy on 2017/12/17.
 */
public class SingleLinkListImpl implements SingleLinkList<T> {
    private int length;
    private LinkNode head;

    public SingleLinkListImpl() {
        this.length = 0;
        head = new LinkNode();
    }

    @Override
    public void insertForHead(T node) {
        LinkNode linkNode = new LinkNode(node);
        linkNode.next = head.next;
        head.next = linkNode;
        length++;
    }

    @Override
    public void insertForTail(T node) {
        LinkNode linkNode = new LinkNode(node);
        LinkNode next = head;
        while (hasNext(next)){
            next = next.next;
        }
        next.next = linkNode;
        linkNode.next = null;
    }

    @Override
    public int getLength() {
        return length;
    }

    private boolean hasNext(LinkNode node) {
        return node != null && node.next != null;
    }

    private LinkNode getHead(){
        return head;
    }

    @Override
    public T queryByIndex(int index) {
        if (index <= 0 || index > length){
            System.out.println("index out of range!");
            return null;
        }
        LinkNode next = head;
        for (int i = 0;i < index;i++){
            next = next.next;
        }
        return next.getValue();
    }

    @Override
    public void deleteByIndex(int index) {
        if (index <= 0 || index > length){
            System.out.println("index out of range!");
            return;
        }
        LinkNode pre = head;
        for (int i = 0;i < index -1;i++){
            pre = pre.next;
        }
        LinkNode delete = pre.next;
        pre.next = delete.next;
    }

    @Override
    public void deleteByNode(T node) {
        LinkNode pre = head;
        LinkNode next = head.next;
        while (next != null){
            if (next.getValue().equals(node)){
                break;
            }
            pre = next;
            next = next.next;
        }
        if (next == null){
            System.out.println("no such node!");
            return;
        }
        pre.next = next.next;
    }

    @Override
    public boolean equals(SingleLinkList linkList) {
        assert (linkList != null && linkList instanceof SingleLinkListImpl);
        SingleLinkListImpl impl = (SingleLinkListImpl)linkList;
        return this.length == impl.length && this.head == impl.head;
    }



    class LinkNode implements Node<T>{
        private T value;
        private LinkNode next;
        public LinkNode() {
            this.value = null;
            this.next = null;
        }
        public LinkNode(T value) {
            this.value = value;
            this.next = null;
        }
        public LinkNode(T value, LinkNode next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public T getValue() {
            return value;
        }

        @Override
        public void setValue(T value) {
            this.value = value;
        }

        @Override
        public boolean equals(Node node) {
            return this.value == node.getValue();
        }

        public LinkNode getNext() {
            return next;
        }

        public void setNext(LinkNode next) {
            this.next = next;
        }
    }


}
