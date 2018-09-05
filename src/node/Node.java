package node;

public class Node {

    private Node pervious;
    private Node next;
    private  Object obj;


    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public Node getPervious() {
        return pervious;
    }

    public void setPervious(Node pervious) {
        this.pervious = pervious;
    }
}
