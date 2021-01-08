public class MyLinkedList {

    private int size;
    private Node start,end;
    public MyLinkedList(){
        size = 0;

    }
    public int size() {
        return size;
    }

    public boolean add(String value) {
        Node newNode = new Node(value);
        if (size == 0) {
            start = newNode;
            end = newNode;
            size++;
        }
        else {
            end.setNext(newNode);
           newNode.setPrev(end);
           end = newNode;
           size++;
        }
        return true;
    }
    public boolean add(int index, String value) {


    }
    public String get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return getNodeAtIndex(index).getData();

    }
    public String set(int index, String value) {
        Node current = start;
        if (index < 0 || index >= size)throw new IndexOutOfBoundsException();
        for(int i = 0;i<index;i++){
            current = current.getNext();
        }
        return current.getData();
    }

    public String toString() {
        String s = "[";
        for(int i  = 0; i< this.size; i++){
            s = s + this.get(i);
            if(i!= this.size-1) s+= ", ";
            else s+= "]";
        }
        if (size == 0) s = "[]";
        return s;
    }
}
