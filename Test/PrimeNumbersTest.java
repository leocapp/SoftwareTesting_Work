import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrimeNumbersTest {

    PrimeNumbers primeInstance = new PrimeNumbers();
    @BeforeEach
    void setUp() {
        System.out.println("Before Each");
    }

    @AfterEach
    void tearDown() {
        System.out.println("After Each");
        //System.out.println("Actual List returned = ");
        //System.out.println(primeInstance.toString());
    }
    //D
    @Test
    void testForRevealFaultWInput(){
        primeInstance.computePrimes(8);
        List<Integer> expected = Arrays.asList(2,3,5,7,11,13,17,19);
        assertEquals(expected, primeInstance.primesList);
    }

    //E
    @Test
    void testForNoReveal(){//THIS IS JUST A BAD TEST - INSUFFICIENT
        primeInstance.computePrimes(9);
        //List<Integer> expected = Arrays.asList(2,3,5,7,11,13,17);//11,13,17,19);
        Iterator<Integer> itr = primeInstance.iterator();
        assertEquals(2, itr.next());
        assertEquals(23, primeInstance.primesList.get(primeInstance.primesList.size()-1));//testing last element too
    }
    //F
    @ParameterizedTest
    @MethodSource("primeMethodValues")
    void testPrimeMethodValues(List array, int actual){
        System.out.println("Expected Array: " + array.toString());
        primeInstance.computePrimes(actual);
        System.out.println("Actual Array: " + primeInstance.primesList.toString());
        assertEquals(array, primeInstance.primesList);
    }
    private static Object[] primeMethodValues(){
        return new Object[][]{
                {Arrays.asList(2, 3, 5, 7, 11, 13, 17),7},
                {Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19), 8},
                {Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23),9},
                {Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29),10},
                {Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31),11}
        };
    }
}