import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains 13 JUnit tests for the Iterator interface. The tests are derived from an
 * IDM (input domain modeling) based on the JavaDoc API for Iterator.
 * The three methods tested are: hasNext(), next(), remove()
 * The following characteristics have been identified and are used to generate tests for the methods:
 * C1: iterator has more values
 * C2: iterator returns a non-null object reference
 * C3: remove() is supported
 * C4: remove() precondition is satisfied
 * C5: collection in consistent state while iterator in use
 * Each characteristic has a boolean partition
 */

public class IteratorTest {

    List<String> list;
    Iterator<String> itr;

    @BeforeEach
    void setUp() {
        list = new ArrayList<>();
        list.add("Cat");
        list.add("Dog");
        //list.add(null);

        itr = list.iterator();
    }

    @Test//Testing hasNext method: base case - T
    void testHasNextTrue(){
        //C1: True
        assertTrue(itr.hasNext());
    }
    @Test//Testing hasNext method: base case - F
    void testHasNextFalse(){
        //C1 False
        itr.next();//consume cat
        itr.next();//consume dog
        //itr.next();//consume bird
        assertFalse(itr.hasNext());
    }
    @Test//Testing next method: base case - TT
    void testNextBaseCase(){
        //C1: True, C2: True
        assertEquals("Cat", itr.next());
    }
    @Test//Testing next method: revised TR - FF
    void testNextC1(){
        //C1: False, C2: False
        itr.next();//consume cat
        itr.next();//consume dog
        //iterator.next();//consume bird
        //Now the iterator points at the end of the list
        assertThrows(NoSuchElementException.class, ()-> itr.next());
    }
    @Test
    void testNextTrueFalse(){
        //C1: True, C2: False
        list = new ArrayList<>();
        list.add(null);
        itr = list.iterator();
        assertNull(itr.next());
    }

    //Test 1 of remove(): C1: true, C2: true, C3: true, C4: true
    @Test
    public void testRemove_BaseCase(){
        itr.next();
        itr.remove();
        assertFalse(list.contains("Cat"));
    }

    // Test 2 of remove(): testRemove_C1(): C1-F, C2-T, C3-T, C4-T, C5-T
    @Test
    public void testRemoveC1(){
        itr.next();
        itr.next();                   // consume the cat and the dog
        itr.remove();                 // remove dog from list.
        assertFalse (list.contains ("dog"));
    }

    // Test 3 of remove(): testRemove_C2(): C1-T, C2-F, C3-T, C4-T, C5-T
    @Test
    public void testRemove_C2() {
        list.add (null);
        list.add ("elephant");
        itr = list.iterator();
        itr.next(); itr.next();        // consume the cat and the dog
        itr.next();        // consume null; iterator not empty
        itr.remove();      // remove null from list
        assertFalse(list.contains (null));
    }

    // Test 4 of remove(): testRemove_C3(): C1-T, C2-T, C3-F, C4-T, C5-T
    @Test
    public void testRemove_C3() {
        list = Collections.unmodifiableList (list);
        itr = list.iterator();
        itr.next(); // consume first element to make C4 true
        assertThrows(UnsupportedOperationException.class, ()->itr.remove());
    }

    // Test 5 of remove(): testRemove_C4(): C1-T, C2-T, C3-T, C4-F, C5-T
    @Test
    public void testRemove_C4() {
        assertThrows(IllegalStateException.class, ()->itr.remove());
    }

    // Test 6 of next(): testRemove_C5(): C1-T, C2-T, C3-T, C4-T, C5-F
    @Test
    public void testRemove_C5() {
        itr.next();
        list.add ("elephant");
        assertThrows(ConcurrentModificationException.class, ()->itr.remove());
    }

}
