/*
 * Name: Dobreva Iva Yordanova
 * Student ID: 2016147551
 */

public class Polygon
{
    private CircularLinkedList<Point> boundary;

    /*
     * Constructor for our Polygon
     *
     * Initialize the instance variables to their default values
     */
    public Polygon()
    {
      boundary = new CircularLinkedList<Point>();
    }

    /*
     * addPoint
     *
     * Insert a new point to the end of the polygon boundary
     *
     * p - Point; the point to be added to the polygon
     *
     * Note: By the "end" of the polygon boundary we mean the tail of the
     *       underlying circular linked list
     */
    public void addPoint(Point p)
    {
      boundary.insertAtTail(p);
    }

    /*
     * getSize
     *
     * Return the number of points on the polygon boundary
     */
    public int getSize()
    {
        return boundary.getSize();
    }

    /*
     * pointInPolygon
     *
     * Return true if the point is inside of the polygon and false otherwise
     *
     * p - Point; the point to be tested
     *
     * Note: You should use the "Ray-Casting" algorithm described in the
     *       handout.
     *
     * Note: Your ray should have slope 0, meaning it extends to infinity
     *       directly to the right of the point (see edge case #4)
     *
     * Note: You DO NOT have to consider the following edge cases:
     *          1) There are two points in the polygon with the same x and y
     *          2) The test point lies on a straight line with two adjacent
     *             points on the boundary, or lies exactly on the boundary
     *          3) The test point has the same x and y as a point already in the
     *             polygon
     *          4) The ray intersecting the boundary at a vertex (where two
     *             edges meet).
     *                 i) This is the reason for the slope 0 ray
     */
    public boolean pointInPolygon(Point p)
    {
        Point vert1, vert2;
        int count = 0;
        double x1, x2, y1, y2, y, x;
        x  = p.getX();        y  = p.getY();

        if(boundary.getSize() < 3 ) {
          return false;
        }

        for(int idx = 0; idx < getSize(); idx++) {
          if (idx == getSize() -1 ) {
            vert1 = boundary.getElementAtIndex(idx).getData();
            vert2 = boundary.getHead().getData();

          }
          vert1 = boundary.getElementAtIndex(idx).getData();
          vert2 = boundary.getElementAtIndex(idx+1).getData();

          x1 = vert1.getX();    y1 = vert1.getY();
          x2 = vert2.getX();    y2 = vert2.getY();

          // NOT to consider 3 and 4
          if((x==x1 && y==y1) || (x==x2 && y==y2)) {
            return true;
          }

          if((y>=y1 && y<=y2) || (y<=y1 && y>=y2) ) {
            if ((x <= x1) || (x <= x2)) {
              count += 1;
            }
          }

        }

        if (count%2 != 0) {
          return true;
        }
        return false;
    }
}

/*
 * Point class
 *
 * This class describes a basic 2-d point object
 *
 * You should not edit anything below this line but please note exactly what
 * is implemented so that you can use it in your linked list code
 */

class Point
{
    private double x,y;
    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    //You probably won't have to use this but we have implemented it for you
    //in case you want to test your code
    @Override public boolean equals(Object obj)
    {
        if(this == obj)
            return true;
        if(!(obj instanceof Point))
            return false;
        else
        {
            Point obj_cast = (Point)obj;
            return this.x == obj_cast.x && this.getY() == obj_cast.getY();
        }
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }
}
