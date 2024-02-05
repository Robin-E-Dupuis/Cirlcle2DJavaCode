package com.mycompany.circle2d;



/**
 *
 * @author Robin Dupuis
 */

 import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;


import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;

public class BigCircle2D {
    private BigDecimal x;
    private BigDecimal y;
    private BigDecimal radius;

    public BigCircle2D() {
        this(BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ONE);
    }

    public BigCircle2D(BigDecimal x, BigDecimal y, BigDecimal radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public BigDecimal getX() {
        return x;
    }

    public BigDecimal getY() {
        return y;
    }

    public BigDecimal getRadius() {
        return radius;
    }

    public BigDecimal getArea() {
        BigDecimal radiusSquared = radius.pow(2);
        return BigDecimal.valueOf(Math.PI).multiply(radiusSquared);
    }

    public BigDecimal getPerimeter() {
        BigDecimal two = BigDecimal.valueOf(2);
        return BigDecimal.valueOf(Math.PI).multiply(radius).multiply(two);
    }

    @Override
    public String toString() {
        return "Circle2D{" +
                "x=" + x +
                ", y=" + y +
                ", radius=" + radius +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BigCircle2D bigcircle2D = (BigCircle2D) o;
        return x.equals(bigcircle2D.x) &&
                y.equals(bigcircle2D.y) &&
                radius.equals(bigcircle2D.radius);
    }

    public boolean contains(BigDecimal x, BigDecimal y) {
        BigDecimal d = distance(x, y, this.x, this.y);
        return d.compareTo(radius) <= 0;
    }

    public boolean contains(BigCircle2D circle) {
        BigDecimal d = distance(circle.x, circle.y, this.x, this.y);
        return d.add(circle.radius).compareTo(this.radius) <= 0;
    }

    public boolean overlaps(BigCircle2D circle) {
        BigDecimal d = distance(circle.x, circle.y, this.x, this.y);
        return d.compareTo(circle.radius.add(this.radius)) < 0;
    }

    private BigDecimal distance(BigDecimal x1, BigDecimal y1, BigDecimal x2, BigDecimal y2) {
        BigDecimal xDiff = x1.subtract(x2);
        BigDecimal yDiff = y1.subtract(y2);
        return xDiff.pow(2).add(yDiff.pow(2)).sqrt(new MathContext(10));
    }

    public static BigCircle2D[] sortCirclesByPerimeter(BigCircle2D[] ar) {
       for (int i = 0; i < ar.length - 1; i++) {
        for (int j = 0; j < ar.length - i - 1; j++) {
            
            if (ar[j].getPerimeter().intValue()> ar[j + 1].getPerimeter().intValue()) {
                BigCircle2D temp = ar[j];
                ar[j] = ar[j + 1];
                ar[j + 1] = temp;
            }
        }
    }
    return ar;
    }
     
    
     public int getCounts(BigCircle2D[] circle) {
         int count = 0;
         double d = distance(x, y, this.x, this.y).floatValue();//gets the distance between 2 centers
        if( d < (radius.floatValue() + this.radius.floatValue())){
            count++;
        } 
        else{
            return count;
        }
        return count;
    }
    public static BigCircle2D[] sortCirclesByNumberOfTimesOverlapping(BigCircle2D[] ar) {
            for(int i = 0; i<ar.length; ++i){
         if(ar[i].getCounts(ar)>ar[i++].getCounts(ar)){
             BigCircle2D currentMin = ar[i];
             ar[i]=ar[i++];
             ar[i++]=currentMin;
             
         }
     }
  
        return ar;
    }

    private static int countOverlaps(BigCircle2D circle, BigCircle2D[] ar) {
        int count = 0;
        for (BigCircle2D c : ar) {
            if (circle != c && circle.overlaps(c)) {
                count++;
            }
        }
        return count;
    }

    public static void print(BigCircle2D[] ar) {
        for (BigCircle2D c : ar) {
            System.out.println(c);
        }
    }

    public static void main(String[] args) {
        BigDecimal two = BigDecimal.valueOf(2);

        BigCircle2D c1 = new BigCircle2D(BigDecimal.valueOf(2), BigDecimal.valueOf(2), BigDecimal.valueOf(5.5));
        System.out.println("Area is " + c1.getArea());
        System.out.println("Perimeter is " + c1.getPerimeter());
        System.out.println(c1.contains(BigDecimal.valueOf(3), BigDecimal.valueOf(3)));
        System.out.println(c1.contains(new BigCircle2D(BigDecimal.valueOf(4), BigDecimal.valueOf(5), BigDecimal.valueOf(10.5))));
        System.out.println(c1.overlaps(new BigCircle2D(BigDecimal.valueOf(3), BigDecimal.valueOf(5), BigDecimal.valueOf(2.3))));

        // Additional testing for sorting
        BigCircle2D c2 = new BigCircle2D(BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.valueOf(2));
        BigCircle2D c3 = new BigCircle2D(BigDecimal.valueOf(4), BigDecimal.valueOf(4), BigDecimal.valueOf(3));
        BigCircle2D c4 = new BigCircle2D(BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE);
       BigCircle2D c5 = new BigCircle2D(BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.valueOf(3));
        BigCircle2D c6 = new BigCircle2D(BigDecimal.valueOf(6), BigDecimal.valueOf(6), BigDecimal.valueOf(2));
        BigCircle2D c7 = new BigCircle2D(BigDecimal.valueOf(8), BigDecimal.valueOf(8), BigDecimal.ONE);

       BigCircle2D[] circles = {c1, c2, c3, c4, c5, c6, c7};

        System.out.println("\nCircles sorted by perimeter:");
        print(sortCirclesByPerimeter(circles));

        System.out.println("\nCircles sorted by the number of times they overlap:");
        print(sortCirclesByNumberOfTimesOverlapping(circles));
    }
} 

