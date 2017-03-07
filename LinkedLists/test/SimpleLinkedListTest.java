import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SimpleLinkedListTest {
    SimpleLinkedList list;
    @Before
    public void setup(){
        list = new SimpleLinkedList();
    }

    @Test
    public void emptyList(){
        assertTrue(list.isEmpty());
        assertEquals(-1, list.indexOf(5));
    }

    @Test
    public void insertToList(){
        list.insert(1);
        assertEquals(1, list.size());
        assertEquals(1, list.get(0));
    }

    @Test
    public void insertToList2(){
        list.insert(1);
        list.insert(3);
        list.insert(5);
        assertEquals(3, list.size());
        assertEquals(5, list.get(2));
    }

    @Test
    public void insertAtIndex(){
        list.insert(1);
        list.insert(3);
        list.insert(5);
        list.insertAt(1, 2);

        assertEquals(4, list.size());
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));

    }

    @Test
    public void delete(){
        list.insert(1);
        list.insert(3);
        list.insert(5);

        list.delete(3);

        assertEquals(2, list.size());
        assertEquals(1, list.get(0));
        assertEquals(5, list.get(1));
    }
}
