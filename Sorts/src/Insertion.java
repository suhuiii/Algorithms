public class Insertion implements Sort{
    public void sort(Comparable[] a){
        Insertion.insertionSort(a);
    }

    public static void insertionSort(Comparable[] a ){
        for(int i = 1; i < a.length; i++){
            for(int j = i; j > 0 && Sort.less(a[j], a[j-1]); j--){
                Sort.exch(a, j, j-1 );
            }
        }

    }}
