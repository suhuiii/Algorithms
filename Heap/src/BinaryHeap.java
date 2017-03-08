public class BinaryHeap {
    int[] heap;
    int N = 0;

    public BinaryHeap(){
        heap =  new int[1];
    }

    public boolean isEmpty(){
        return N == 0;
    }
    public int size(){
        return N;
    }

    public void insert(int value){
        if(isFull())
            resize(heap.length * 2);

        heap[++N] = value;
        swim(N);
    }

    private void resize(int max) {
        int[] newHeap = new int[max];

        for(int i = 0; i < N + 1; i++){
            newHeap[i] = heap[i];
        }
        heap = newHeap;
    }

    public int peek(){
        return N == 0 ? 0 : heap[1];
    }

    public int deleteMax(){
        if(N == 0)
            return 0;

        int max = heap[1];
        exch(1, N--);
        heap[N + 1] = 0;
        sink(1);

        if(N > 0  && N == heap.length/4 - 1)
            resize(heap.length/2);

        return max;
    }

    private boolean isFull(){
        return N == heap.length - 1;
    }

    private void swim(int position) {
        while(position > 1 && heap[position] > heap[position/2]){
            exch(position, position/2);
            position = position/2;
        }
    }

    private void sink(int position){
        while(2*position <= N){
            int newPosition = 2*position;

            if (newPosition < N && heap[newPosition] < heap[newPosition + 1]) {
                newPosition++;
            }
            if(heap[newPosition] > heap[position]){
                exch(newPosition, position);
                position = newPosition;
            }else{
                break;
            }
        }
    }

    private void exch(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

}
