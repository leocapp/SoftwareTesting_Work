import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest{

    @Test
    void CACCTest1(){
        //Row 2 -> m = 2; y = 2000, expected = 29
        //Row 6 -> m = 2; y = 2100, expected = 28

        assertAll( ()-> {
            int expectedRow2 = 29;
            assertEquals(expectedRow2, Date.numberOfDays(2, 2000));

            int expectedRow6 = 28;
            assertEquals(expectedRow6, Date.numberOfDays(2, 2100));
        });
    }
}