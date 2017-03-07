public class SimpleLinkedList<T> {
    private class Node{
        T value;
        Node nextNode;

        Node(T value){
            this.value = value;
        };
    }

    Node head;
    Node last;
    int size = 0;

    public void enqueue(T value){
        if(head == null){
          head = new Node(value);
          last = head;
        }else{
            Node currentNode = last;
            last = new Node(value);
            currentNode.nextNode = last;
        }

        size++;
    }

    public T dequeue(){
        Node first = head;

        if(head != null){
            head = head.nextNode;
            size--;
            return first.value;
        }

        return null;
    }

    public int size(){return size;}

    public boolean isEmpty(){return head == null;}

}
