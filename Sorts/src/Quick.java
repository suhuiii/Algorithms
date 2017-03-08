public class Quick implements Sort {
    @Override
    public void sort(Comparable[] a) {
        Quick.sort(a, 0, a.length -1);
    }

    private static void sort(Comparable[] a, int start, int end) {
        if(start >= end)
            return;

        int pivot = partition(a, start, end);
        sort(a, start, pivot - 1);
        sort(a, pivot + 1, end);
    }

    private static int partition(Comparable[] a, int start, int end) {
        int i = start, j = end - 1 ;

        Comparable pivotPoint = a[end];

        while(true){

            while(Sort.lessThan(a[i], pivotPoint) && i != end) i++;
            while(Sort.lessThan(pivotPoint, a[j]) && j != start) j--;

            if(i >= j)
                break;

            Sort.exch(a, i, j);
        }
        Sort.exch(a, i, end);

        return i;
    }
}
