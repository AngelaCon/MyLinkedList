public class Nano {
    private String data;
    private Node next,prev;

    public Node(String value){
        data = value;
    }

    public String getData() {
        return data;

    }

    public Node getNext() {
        return next;

    }

    public Node getPrev() {
        return prev;

    }

    public String setData(String value) {
        data = value;
    }

    public Node setNext() {
        this.next = next;
    }

    public void setPrev() {
        this.prev = prev;
    }



}
