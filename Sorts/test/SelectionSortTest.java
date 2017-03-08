public class SelectionSortTest extends SortTest {
    @Override
    Sort createSort() {
        return new Selection();
    }
}
