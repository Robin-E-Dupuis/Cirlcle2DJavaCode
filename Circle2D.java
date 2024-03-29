package com.mycompany.circle2d;

import java.util.Arrays;

/**
 *
 * @author Robin Dupuis
 */
public class Circle2D {

    private double x;
    private double y;
    private double radius;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public Circle2D() {
        this(0, 0, 1);
    }

    public Circle2D(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getArea(double radius) {
        return radius * radius * Math.PI;
    }

    public double getPerimeter(double radius) {
        return 2 * Math.PI * radius;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Circle2D circle2D = (Circle2D) o;
        return Double.compare(circle2D.x, x) == 0
                && Double.compare(circle2D.y, y) == 0
                && Double.compare(circle2D.radius, radius) == 0;
    }

    private static double distance(double x1, double y1,
            double x2, double y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    public boolean contains(double x, double y) {
        double d = distance(x, y, this.x, this.y);
        return d <= radius;
    }

    public boolean contains(Circle2D circle) {
        double d = distance(circle.x, circle.y, this.x, this.y);//gets the distance between the two centers
        return d + circle.radius <= this.radius;//if the distance + the radius are inferior or equal to the current radius then the method returns true
    }

    // Two circles overlap if the distance between the two centers
// are less than or equal to this.radius + circle.radius
// MyPoint is defined in Exercise9_4
    public boolean overlaps(Circle2D circle) {
        
        double d = distance(circle.x, circle.y, this.x, this.y);//gets the distance between 2 centers
        return d < (circle.radius + this.radius);//returns true if the distance between the two centers is inferior to the radius of the first circle + the second circle
    }

   public static Circle2D[] sortCirclesByPerimeter(Circle2D[] circles) {
    for (int i = 0; i < circles.length - 1; i++) {
        for (int j = 0; j < circles.length - i - 1; j++) {
            
            if (circles[j].getPerimeter(j) > circles[j + 1].getPerimeter(i)) {
                Circle2D temp = circles[j];
                circles[j] = circles[j + 1];
                circles[j + 1] = temp;
            }
        }
    }
    return circles;
}
   
 

     public int getCounts(Circle2D[] circle) {
         int count = 0;
         double d = distance(x, y, this.x, this.y);//gets the distance between 2 centers
        if( d < (radius + this.radius)){
            count++;
        } 
        else{
            return count;
        }
        return count;
    }
 public static Circle2D[] sortCirclesByNumberOfTimesOverlapping(Circle2D[] ar) {
     for(int i = 0; i<ar.length; ++i){
         if(ar[i].getCounts(ar)>ar[i++].getCounts(ar)){
             Circle2D currentMin = ar[i];
             ar[i]=ar[i++];
             ar[i++]=currentMin;
             
         }
     }
  
        return ar;
}

    @Override
    public String toString() {
        return "Circle2D{" + "x=" + x + ", y=" + y + ", radius=" + radius + '}';
    }
    
     public static void print(Circle2D[] ar) {
        for (Circle2D c : ar) {
            System.out.println(c);
        }
    }

    public static void main(String[] args) {
        Circle2D c1 = new Circle2D(2, 2, 5.5);

        System.out.println("Area is " + c1.getArea(c1.getRadius()));
        System.out.println("Perimeter is " + c1.getPerimeter(c1.getRadius()));
        System.out.println(c1.contains(3, 3));
        System.out.println(c1.contains(new Circle2D(4, 5, 10.5)));
        System.out.println(c1.overlaps(new Circle2D(3, 5, 2.3)));
          System.out.println("\nCircles sorted by the number of times they overlap:");
          
               Circle2D c2 = new Circle2D(0, 0, 2);
        Circle2D c3 = new Circle2D(4, 4, 3);
        Circle2D c4 = new Circle2D(1, 1, 1);
        Circle2D c5 = new Circle2D(0, 0, 3);
        Circle2D c6 = new Circle2D(6, 6, 2);
        Circle2D c7 = new Circle2D(8, 8, 1);

        Circle2D[] circles = {c1, c2, c3, c4, c5, c6, c7};
        
        System.out.println("\nCircles sorted by overlap numbers:");
        print(sortCirclesByNumberOfTimesOverlapping(circles));
        System.out.println("\nCircles sorted by perimeter:");
        print(sortCirclesByPerimeter(circles));
    }
}
