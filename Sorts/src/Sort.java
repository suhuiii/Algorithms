public interface Sort {
    void sort(Comparable[] a);

    static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }

    static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
