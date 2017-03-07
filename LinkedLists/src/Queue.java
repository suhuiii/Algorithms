public class Queue<T> {
    private class Node{
        T value;
        Node nextNode;
        Node previousNode;

        Node(T value){
            this.value = value;
        };
    }

    Node head;
    Node last;
    int size = 0;

    public void insertBack(T value){
        if(head == null){
          head = new Node(value);
          last = head;
        }else{
            Node oldLast = last;
            last = new Node(value);
            last.previousNode = oldLast;
            oldLast.nextNode = last;
        }

        size++;
    }

    public void insertFront(T value){
        if(head == null){
            head = new Node(value);
            last = head;
        }else{
            Node oldHead = head;
            head = new Node(value);
            head.nextNode = oldHead;
            oldHead.previousNode = head;
        }
        size++;
    }

    public T removeFromFront(){
        if(isEmpty()){
            return null;
        }

        Node first = head;
        if(first.nextNode != null){
            head = first.nextNode;
            head.previousNode = null;
        }else{
            head = null;
            last = null;
        }

        size--;

        return first.value;

    }

    public T removeFromBack(){
        if(isEmpty()){
            return null;
        }

        Node lastItem = last;
        if(lastItem.previousNode != null){
            last = lastItem.previousNode;
            last.nextNode = null;
        }else{
            last = null;
            head = null;
        }
        size--;

        return lastItem.value;

    }

    public int size(){return size;}

    public boolean isEmpty(){return head == null;}

}
