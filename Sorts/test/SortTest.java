import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public abstract class SortTest {
    private Sort sortTechnique;
    abstract Sort createSort();

    @Before
    public void init(){
        sortTechnique = createSort();
    }

    @Test
    public void sort0Items(){
        Integer[] toSort = new Integer[]{};
        sortTechnique.sort(toSort);

        assertArrayEquals(new Integer[]{}, toSort);
    }

    @Test
    public void sort1Items(){
        Integer[] toSort = new Integer[]{1};
        sortTechnique.sort(toSort);

        assertArrayEquals(new Integer[]{1}, toSort);
    }

    @Test
    public void sortAFewItems(){
        Integer[] toSort = new Integer[]{1 , 5, 0, 2, 15, 8, 3, 9, 7, 10};
        sortTechnique.sort(toSort);

        assertArrayEquals(new Integer[]{0, 1, 2, 3, 5, 7, 8, 9, 10, 15}, toSort);
    }

}
