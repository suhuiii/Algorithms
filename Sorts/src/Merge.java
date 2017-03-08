public class Merge implements Sort {
    static Comparable[] aux;
    @Override
    public void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        Merge.mergeSort(a, 0, a.length-1);
    }

    private static void mergeSort(Comparable[] a, int start, int end) {
        if(start >= end)
            return;

        int middle = start + (end - start)/2;
        mergeSort(a, start, middle);
        mergeSort(a, middle +1, end);
        merge(a, start, middle, end);
    }

    private static void merge(Comparable[] a, int start, int middle, int end) {
        int i = start, j = middle + 1;
        copyToAux(a, start, end);

        for(int k = start; k <= end; k++){
            if( i > middle){ //exhausted left half
                a[k] = aux[j++];
            }else if(j > end){ //exhausted right half
                a[k] = aux[i++];
            }else if(Sort.lessThan(aux[j], aux[i])){ //take from the right
                a[k] = aux[j++];
            }else{
                a[k] = aux[i++];
            }
        }
    }

    private static void copyToAux(Comparable[] a, int start, int end) {
        for(int i = start; i <= end; i++){
            aux[i] = a[i];
        }

    }
}
