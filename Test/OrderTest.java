import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    Order o = new Order();
    boolean isPremiumMember = true;
    int orderTotal = 50;
    boolean hasCoupon = true;

    @Test
    void rows3And7(){
    //                                A               B             C
        assertTrue(o.isOrderValid(isPremiumMember, orderTotal-1, hasCoupon));//row 3
        assertFalse(o.isOrderValid(!isPremiumMember, orderTotal-1, hasCoupon));//row 7
    }

    @Test
    void rows5And7(){
        //                                A               B             C
        assertTrue(o.isOrderValid(!isPremiumMember, orderTotal, hasCoupon));//row 5
        assertFalse(o.isOrderValid(!isPremiumMember, orderTotal-1, hasCoupon));//row 7
    }

    @Test
    void rows7And8(){
        //                                A               B             C
        assertTrue(o.isOrderValid(!isPremiumMember, orderTotal-1, !hasCoupon));//row 8
        assertFalse(o.isOrderValid(!isPremiumMember, orderTotal-1, hasCoupon));//row 7
    }
}