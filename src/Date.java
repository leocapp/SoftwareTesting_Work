public class Date{

    public static int numberOfDays(int m, int y) {
        if (m <= 0 || m > 12) {
            throw new IllegalArgumentException("Months must be in range 1..12");
        }

        if (m == 2) {
            if (y % 400 == 0 || (y % 4 == 0 && y % 100 != 0)) {
                return 29;
            } else {
                return 28;
            }
        }

        if (m <= 7) {
            if (m % 2 == 1) {
                return 31;
            }
            return 30;
        }

        if (m % 2 == 0) {
            return 31;
        }
        return 30;
    }

}
