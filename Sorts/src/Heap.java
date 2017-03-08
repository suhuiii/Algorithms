public class Heap implements Sort{
    @Override
    public void sort(Comparable[] a) {
        Comparable[] aSpace = new Comparable[a.length + 1];
        for(int i = 0; i < a.length ; i++){
            aSpace[i+1] = a[i];
        }
        Heap.heapsort(aSpace);

        for(int i = 0; i < a.length ; i++){
            a[i] = aSpace[i+1];
        }
    }

    private static void heapsort(Comparable[] a) {
        int N = a.length - 1;

        for(int k =  N/2; k >= 1; k--){
            sink(a, k, N);
        }

        while(N>1){
            Sort.exch(a, 1, N--);
            sink(a, 1, N);
        }


    }

    private static void sink(Comparable[] a, int position, int N) {
        while(position * 2 <= N){
            int child = position * 2;
            if(N > 0 && child + 1 < N && Sort.lessThan(a[child], a[child + 1])){
                child++;
            }
            if(!Sort.lessThan(a[position], a[child])) break;
            Sort.exch(a, position, child);

            position = child;
        }
    }
}
