package UCHelper.adt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

public class LinkedListTest {
    @Test
    public void testIsEmpty() {
        LinkedList<Integer> list = new LinkedList<>();

        assertTrue(list.isEmpty());

        list.add(5);

        assertFalse(list.isEmpty());
    }

    @Test
    public void testSize() {
        LinkedList<Integer> list = new LinkedList<>();

        assertEquals(0, list.size());

        list.add(5);

        assertEquals(1, list.size());

        list.add(8);

        assertEquals(2, list.size());
    }

    @Test
    public void testAdd() {
        LinkedList<Integer> list = new LinkedList<>();

        // Test adding same element
        assertTrue(list.add(1));
        assertTrue(list.add(1));

        // Test adding different element
        assertTrue(list.add(3));
    }

    @Test
    public void testRemove() {
        LinkedList<Integer> list = new LinkedList<>();

        assertTrue(list.add(1));
        assertTrue(list.add(2));
        assertTrue(list.add(3));

        list.remove(0);

        assertEquals("2 3 ", list.toString());
        assertEquals(2, list.size());

        list.remove(1);

        assertEquals("2 ", list.toString());
        assertEquals(1, list.size());
    }

    @Test
    public void testReplace() {
        LinkedList<Integer> list = new LinkedList<>();

        assertTrue(list.add(1));
        assertTrue(list.add(2));
        assertTrue(list.add(3));

        list.replace(0, 3);
        list.replace(2, 1);

        assertEquals(list.get(0), new Integer(3));
        assertEquals(list.get(2), new Integer(1));
    }

    @Test
    public void testGet() {
        LinkedList<Integer> list = new LinkedList<>();

        assertTrue(list.add(1));
        assertTrue(list.add(2));
        assertTrue(list.add(3));

        assertEquals(new Integer(1), list.get(0));
        assertEquals(new Integer(2), list.get(1));
        assertEquals(new Integer(3), list.get(2));
    }

    @Test
    public void testContains() {
        LinkedList<Integer> list = new LinkedList<>();

        assertTrue(list.add(2));
        assertTrue(list.add(3));
        assertTrue(list.add(4));

        assertTrue(list.contains(2));
        assertTrue(list.contains(3));
        assertTrue(list.contains(4));

        assertFalse(list.contains(1));
        assertFalse(list.contains(5));
    }

    @Test
    public void testFindIndex() {
        LinkedList<Integer> list = new LinkedList<>();

        assertTrue(list.add(1));
        assertTrue(list.add(2));
        assertTrue(list.add(3));

        assertEquals(0, list.findIndex(1));
        assertEquals(1, list.findIndex(2));
        assertEquals(2, list.findIndex(3));
    }

    @Test
    public void testIterator() {
        LinkedList<Integer> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);

        Iterator<Integer> itr = list.iterator();

        while (itr.hasNext()) {
            Integer elem = itr.next();
            sb.append(elem);
        }

        assertEquals("1231", sb.toString());
    }
}
