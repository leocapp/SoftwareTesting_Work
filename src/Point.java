// Introduction to Software Testing
// Authors: Paul Ammann & Jeff Offutt
// Chapter 1

import java.util.HashSet;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        // Location A
        if (!(o instanceof Point)){
            return false;
        }

        Point p = (Point) o;
        return (p.x == this.x) && (p.y == this.y);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.x;
        hash = 31 * hash + this.y;
        return hash;
    }

    public static void main(String[] args) {
        Point item1 = new Point(5,10);
        Point item2 = new Point(5,10);

        HashSet<Point> setForPoint = new HashSet<>();

        if(item1.equals(item2)){
            System.out.println("item1 and item2 are equal");
        }else{
            System.out.println("item1 and item2 are not equal");
        }
        setForPoint.add(item1);
        setForPoint.add(item2);
        System.out.println("Set size is: " + setForPoint.size());
    }
}