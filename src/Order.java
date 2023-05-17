public class Order {

    public static boolean isOrderValid(boolean isPremiumMember, int orderTotal, boolean hasCoupon) {
        if (isPremiumMember || (orderTotal >= 50 && hasCoupon) || !hasCoupon) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {

    }
}
