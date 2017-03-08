import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;
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
        Integer[] toSort = new Integer[]{1 , 5, 0, 2, 15, 8, 3, 9, 7, 10, 6};
        sortTechnique.sort(toSort);

        assertArrayEquals(new Integer[]{0, 1, 2, 3, 5, 6, 7, 8, 9, 10, 15}, toSort);
    }

    @Test
    public void sortARandomRange(){
        List<Integer> sorted = IntStream.rangeClosed(0,100)
                              .boxed()
                                .collect(Collectors.toList());

        List<Integer> random = new ArrayList<>(sorted);

        Collections.shuffle(random);

        Integer[] randomArray = new Integer[101];
        random.toArray(randomArray);

        Integer[] sortedArray = new Integer[101];
        sorted.toArray(sortedArray);

        sortTechnique.sort(randomArray);
        assertArrayEquals(sortedArray, randomArray);

    }

}
