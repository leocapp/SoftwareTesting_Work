import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    @BeforeEach
    void setUp() {
        System.out.println("Before Each");
    }
    @AfterEach
    void tearDown() {
        System.out.println("After Each");
    }


    //Testing size on empty list, edge case
    @Test
    void testDefaultConstructor() {
        MyArrayList<String> list = new MyArrayList<>();
        //assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    //Testing size on a specified list
    @Test
    void testInitialCapacityConstructor() {
        MyArrayList<Integer> list = new MyArrayList<>(5);
        //assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    //Testing a negative list size
    @Test
    void testNegativeInitialCapacityConstructor() throws IllegalArgumentException{
        MyArrayList<Double> list = new MyArrayList<>(-5);
    }

    //Testing normal add method
    @Test
    void testAdd() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Leo");
        //assertFalse(list.isEmpty());
        assertEquals(1, list.size());
        assertEquals("Leo", list.get(0));
    }

    //Testng the other add method with specified index
    @Test
    void testAddWithIndex() {
        MyArrayList<Integer> list = new MyArrayList<>(2);
        list.add(0, 1);
        assertEquals(1,list.get(0));
        list.add(0, 2);
        assertEquals(2,list.get(0));
        //assertEquals(1,list.get(1));
        list.add(2, 3);
        assertEquals(3,list.get(2));
    }

    //Testing adding at an index that's out of bounds
    @Test
    void testAddWithInvalidIndex() {
        MyArrayList<String> list = new MyArrayList<>();
        assertThrows(IndexOutOfBoundsException.class,()-> list.add(1, "foo"));
        //list.add(1, "foo");
    }

    //Testing remove method by getting the size after removal
    @Test
    void testRemove() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Leo");
        list.add("Steve");
        assertEquals("Leo", list.remove(0));
        assertEquals(1, list.size());
        assertEquals("Steve", list.get(0));
    }

    //Removing 0 index from an empty list, edge case
    @Test
    void testRemoveWithInvalidIndex() {
        MyArrayList<Integer> list = new MyArrayList<>();
        assertThrows(IndexOutOfBoundsException.class,() ->list.remove(0));
    }

    //Testing size
    @Test
    void testSize() {
        MyArrayList<String> list = new MyArrayList<>();
        assertEquals(0, list.size());
        list.add("Leo");
        list.add("Jeff");
        assertEquals(2, list.size());
    }

    //Testing isEmpty method
    @Test
    void testIsEmpty() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Leo");
        assertEquals(false,list.isEmpty());
    }

    //Testing size on a larger than initialCapacity list
    @Test
    void testIncreaseListSize() {
        MyArrayList<Integer> list = new MyArrayList<>(2);
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
    }

    //Test with incomparable types
    @Test
    void testIncomparableTypes(){
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        assertEquals("3", list.get(2));
    }

    //Write test case adding a bunch of stuff and then deleting something from the middle, forcing a shift.
    //then check each index
    @Test
    void testForShiftingIndex(){
        MyArrayList<Integer> test = new MyArrayList<>();
        test.add(0);
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);
        test.add(1,7);
        assertEquals(7, test.get(1));
        assertEquals(1,test.get(2));

    }
}