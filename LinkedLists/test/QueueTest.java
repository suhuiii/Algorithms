import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class QueueTest {
    Queue queue;
    @Before
    public void setup(){
        queue = new Queue();
    }

    @Test
    public void testEmpty(){
        assertEquals(0, queue.size());
        assertTrue(queue.isEmpty());
        assertNull(queue.removeFromFront());
    }

    @Test
    public void testListSize1(){
        queue.insertBack(5);

        assertEquals(1, queue.size());
        assertFalse(queue.isEmpty());
        assertEquals(5, queue.removeFromFront());

    }

    @Test
    public void testMultipleItems(){
        queue.insertBack("Hello");
        queue.insertBack("World");
        queue.insertBack("I'm a List");

        assertEquals(3, queue.size());
        assertEquals("Hello", queue.removeFromFront());
        assertEquals("World", queue.removeFromFront());
        assertEquals("I'm a List", queue.removeFromFront());
        assertNull(queue.removeFromFront());
        assertEquals(0, queue.size());

    }

    @Test
    public void testRemoveFromBack(){
        queue.insertBack("Hello");
        queue.insertBack("World");
        queue.insertBack("I'm a List");

        assertEquals(3, queue.size());


        assertEquals("I'm a List", queue.removeFromBack());
        assertEquals("World", queue.removeFromBack());
        assertEquals(1, queue.size());
        assertEquals("Hello", queue.removeFromBack());

        assertNull(queue.removeFromFront());
        assertEquals(0, queue.size());

    }

    @Test
    public void insertFromFrontandBack(){
        queue.insertFront(1);
        queue.insertBack(5);
        queue.insertFront(2);
        queue.insertFront(3);
        queue.insertBack(4);

        assertEquals(3, queue.removeFromFront());
        assertEquals(2, queue.removeFromFront());
        assertEquals(1, queue.removeFromFront());
        assertEquals(5, queue.removeFromFront());
        assertEquals(4, queue.removeFromFront());

    }
}
