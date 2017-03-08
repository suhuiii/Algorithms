public class MergeSortTest extends SortTest {

    @Override
    Sort createSort() {
        return new Merge();
    }
}
