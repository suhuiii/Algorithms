public class Selection implements Sort {
    @Override
    public void sort(Comparable[] a) {
        Selection.selectionSort(a);
    }

    private static void selectionSort(Comparable[] a) {
        for(int i = 0; i < a.length; i++){
            int minIndex = i;
            for(int j = i + 1; j < a.length; j++ ){
                if(Sort.lessThan(a[j], a[minIndex])){
                    minIndex = j;
                }
            }
            Sort.exch(a, i, minIndex);
        }
    }
}
