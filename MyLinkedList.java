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
         if (index == 0 && size ==0) {
             add(value);
         }
        else if (index == 0){
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
        if (index < 0 || index >= size)throw new IndexOutOfBoundsException();
        Node current = getNodeAtIndex(index);
        String temp = current.getData();
        current.setData(value);
        return temp;
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


    public String remove(int index) {
        if(index < 0 || (index >= size)) {
          throw new IndexOutOfBoundsException("index can only be positive and less than size" + index);
      }
        String current = getNodeAtIndex(index).getData();
        Node nextVal = getNodeAtIndex(index+1);

            if (size == 1) {
                start.setNext(null);
                end.setPrev(null);
                size--;

            }
            else {
             if (index == 0){
                start = nextVal;
                nextVal.setPrev(null);
                size--;

            }
            else if (index == size-1) {
                Node beforeVal = getNodeAtIndex(index-1);
                end = beforeVal;
                beforeVal.setNext(null);
                size--;
            }
            else {
                Node beforeVal = getNodeAtIndex(index-1);
                beforeVal.setNext(nextVal);
                nextVal.setPrev(beforeVal);
                size--;
            }
        }

        return current;
    }


    public void extend(MyLinkedList other){
        this.end.setNext(other.start);
        other.start.setPrev(this.end);
        this.size = size + other.size();
        other.size = 0;
        other.start = null;
        other.end = null;
 }
    }
