package hoanghh.study.interfacepractice;

import java.util.Comparator;

public class Rectangle implements Comparator<Rectangle>, Comparable<Rectangle> {
    protected double vertical;
    protected double horizontal;

    public Rectangle(double vertical, double horiontal) {
        this.vertical = vertical;
        this.horizontal = horiontal;
    } // end method
    
    public double getPerimeter() {
        return (this.vertical + this.horizontal) * 2;
    } // end method

    public double getArea() {
        return this.vertical * this.horizontal;
    } // end method

    public boolean equals(Rectangle rec) {
        if ((rec.vertical == this.vertical)
                && (rec.horizontal == this.horizontal)) {
            return true;
        }

        return false;
    } // end method

    public int compare(Rectangle rec1, Rectangle rec2) {
        double rec1Area = rec1.getArea();
        double rec2Area = rec2.getArea();
        if (rec1Area < rec2Area) {
            return -1;
        } else if (rec1Area > rec2Area) {
            return 1;
        }

        return 0;
    } // end method
    
    public int compareTo(Rectangle rec) {
        return this.compare(this, rec);
    } // end method
} // end class
