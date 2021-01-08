import java.util.*;
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
            size++;
            end = start = newNode;
            return true;
        }
        else {
            size++;
          Node temp = new Node(value);
          end.setNext(temp);
          temp.setPrev(end);
          end = temp;
          return true;
        }
    }


    public void add(int index, String value) {
    Node added = new Node(value);
    if(index < 0 || index > size) {
      throw new IndexOutOfBoundsException("index cannot be " + index);
    }

  }

    public String get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node value = start;
        for (int i = 0; i < index; i++) {
            value  = value.getNext();
        }
        return value.getData();
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


    public String toStringReversed() {
        String s ="[";
        for (int i = size-1; i >= 0; i--){
            s+=get(i);
            if(i!=0) s+=", ";
            else s+= "]";
        }
        if (size == 0) s = "[]";
        return s;
    }
}
