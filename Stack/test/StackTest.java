import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class StackTest {
    Stack testStack;

    @Test
    public void testEmptyStack(){
        testStack = new Stack();

        assertEquals(0, testStack.size());
        assertNull(testStack.peek());
        assertNull(testStack.pop());
    }


    @Test
    public void testNoNegativeOverflowWhenPoppedWhenEmpty(){
        testStack = new Stack();

        assertEquals(0, testStack.size());
        assertNull(testStack.pop());
        assertNull(testStack.pop());
        assertNull(testStack.pop());
    }


    @Test
    public void testStringStack(){
        testStack =  new Stack();

        testStack.push("Hello");
        assertEquals(1, testStack.size());
        assertEquals("Hello", testStack.peek());
        assertEquals("Hello", testStack.pop());
    }

    @Test
    public void testLIFO(){
        testStack = new Stack<Integer>();
        testStack.push(5);
        testStack.push(4);
        testStack.push(3);
        assertEquals(3, testStack.pop());
        testStack.push(2);
        testStack.pop();
        assertEquals(4, testStack.peek());
    }

    @Test
    public void typesLIFO(){
        testStack = new Stack<Integer>();
        testStack.push(5);
        testStack.push("HI");
        testStack.push(3);
        assertEquals(3, testStack.pop());
        testStack.push(2);
        testStack.pop();
        assertEquals("HI", testStack.peek());
    }

    @Test
    public void testIterator(){
        testStack = new Stack<Integer>();
        testStack.push(5);
        testStack.push(4);
        testStack.push(3);
        testStack.push(2);
        testStack.push(1);

        Iterator<Integer> iterator = testStack.iterator();
        int[] result = new int[5];
        int i = 0;

        while(iterator.hasNext()){
            result[i++] = iterator.next();
        }
        assertArrayEquals(new int[]{1,2,3,4,5}, result);
    }
}

