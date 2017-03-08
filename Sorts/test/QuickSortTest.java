public class QuickSortTest extends SortTest {
    @Override
    Sort createSort() {
        return new Quick();
    }
}
