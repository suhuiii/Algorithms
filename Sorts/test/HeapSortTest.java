public class HeapSortTest extends SortTest {
    @Override
    Sort createSort() {
        return new Heap();
    }
}
