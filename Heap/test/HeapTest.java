import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HeapTest {
    BinaryHeap heap;

    @Before
    public void setup(){
        heap = new BinaryHeap();
    }

    @Test
    public void testEmptyHeap(){
        assertEquals(0, heap.size());
        assertTrue(heap.isEmpty());
        assertEquals(0, heap.deleteMax());
    }

    @Test
    public void insertIntoHeap(){
        heap.insert(1);
        assertEquals(1, heap.peek());
        heap.insert(5);
        assertEquals(5, heap.peek());

        heap.insert(-3);
        assertEquals(5, heap.peek());
    }

    @Test
    public void deleteFromHeap(){
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        heap.insert(-5);

        assertEquals(5, heap.size());
        assertEquals(4, heap.deleteMax());
        assertEquals(3, heap.deleteMax());
        assertEquals(3, heap.size());
        assertEquals(2, heap.deleteMax());
        assertEquals(1, heap.deleteMax());
        assertEquals(-5, heap.deleteMax());
    }



}
