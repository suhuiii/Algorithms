import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class SLLTest {
    SimpleLinkedList list;
    @Before
    public void setup(){
        list = new SimpleLinkedList();
    }

    @Test
    public void testEmpty(){
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
        assertNull(list.dequeue());
    }

    @Test
    public void testListSize1(){
        list.enqueue(5);

        assertEquals(1, list.size());
        assertFalse(list.isEmpty());
        assertEquals(5, list.dequeue());

    }

    @Test
    public void testMultipleItems(){
        list.enqueue("Hello");
        list.enqueue("World");
        list.enqueue("I'm a List");

        assertEquals(3, list.size());
        assertEquals("Hello", list.dequeue());
        assertEquals("World", list.dequeue());
        assertEquals("I'm a List", list.dequeue());
        assertNull(list.dequeue());
        assertEquals(0, list.size());


    }

}
