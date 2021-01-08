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
    else{
      if(index == 0) {
        start.setPrev(added);
        Node oldStart = start;
        start = added;
        start.setNext(oldStart);
        size++;
      }
      else if(index == size) {
        add(value);
      }
      else {
        Node current = start;
        for(int i = 0; i < index-1; i++) {
          current = current.getNext();
        }
        current.setNext(added);
        added.setPrev(current);
        current = end;
        for(int i = size - 1; i > index+1; i--) {
          current = end.getPrev();
        }
        current.setPrev(added);
        added.setNext(current);
        size++;
      }
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
}
