public class SimpleLinkedList<T> {

    private class Node{
        T value;
        Node next;
        Node(T val){
            value = val;
        }
    }
    Node head;
    int size = 0;

    public void insert(T value){
        if(head == null){
            head = new Node(value);
        }else{
            Node current = head;

            for(int i = 0; i < size - 1 ; i++){
                current = current.next;
            }
            current.next = new Node(value);
        }
        size ++;
    }

    public void insertAt(int index, T value){
        Node current = head;

        for(int i = 0; i < index - 1 ; i++){
            current = current.next;
        }

        Node nextNode = current.next;
        current.next = new Node(value);
        current.next.next = nextNode;

        size ++;
    }

    public T get(int index){
        if(isEmpty())
            return null;

        if(index > size)
            throw new IllegalArgumentException("index is larger than size of list");

        Node current = head;

        for(int i = 0; i < index; i++){
            current = current.next;
        }

        return current.value;

    }

    public int indexOf(T value){
        if(!isEmpty()){
            Node current = head;

            for(int i = 0; i < size ; i++){
                if(current.value == value)
                    return i;

                current = current.next;
            }
        }
        return -1;
    }

    public void delete(T value){
        if(!isEmpty()){
            Node current = head;

            for(int i = 0; i < size - 1 ; i++){
                if(current.next.value == value){
                    current.next = current.next.next;
                    break;
                }
                current = current.next;
            }
        }

        size--;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public int size() {
        return size;
    }


}
