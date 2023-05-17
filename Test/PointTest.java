import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @BeforeEach
    void setUp() {
        System.out.println("Before Each");
    }

    @AfterEach
    void tearDown() {
        System.out.println("After Each");
    }
    @Test
    void hashConsistentWithEquals(){
        Point p1 = new Point(1,2);
        Point p2 = new Point(1,2);
        System.out.println(p1.hashCode() + " " + p2.hashCode());
        assertEquals(p1.hashCode(), p2.hashCode());
    }
}