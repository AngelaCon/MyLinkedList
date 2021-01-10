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
        Node n = new Node(value);
        if (size == 0) {
            start = n;
            end = n;
            size++;
            return true;
        }
        else {
          size++;
          end.setNext(n);
          n.setPrev(end);
          end = n;
          return true;
        }
    }


    public void add(int index, String value) {
        if(index < 0 || (index > size)) {
          throw new IndexOutOfBoundsException("index can only be positive and less than size" + index);
        }
     else {
         Node n = new Node(value);
         Node preVal = getNodeAtIndex(index-1);
         Node currentVal = getNodeAtIndex(index);
        if (index == 0){
            start = n;
            n.setNext(currentVal);
            currentVal.setPrev(n);
            size++;

        } else if (index == size){
            add(value);
        } else {
            // set previous to new
            preVal.setNext(n);

            // set new to previous
            n.setPrev(preVal);

            //set new to current
            n.setNext(currentVal);

            //set current to new
            currentVal.setPrev(n);
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
        for(int i  = 0; i< size; i++){
            s = s + get(i);
            if(i!= size-1) s+= ", ";
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


    private Node getNodeAtIndex(int index){
            Node current = start;
            for (int i = 0; i<index; i++){
              current = current.getNext();
            }
            return current;
        }
    }
