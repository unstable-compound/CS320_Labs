import java.util.*;
import java.util.function.*;

class Point {
  double x;
  double y;
  Point (double x, double y) {this.x = x; this.y = y;}

  double distance(Point other) {
    double delta_x = this.x - other.x;
    double delta_y = this.y - other.y;
    return Math.sqrt(delta_x * delta_x + delta_y * delta_y);
  }
}


class PSet {
  Predicate<Point> ps;    // representation of a point set
  private PSet(Predicate<Point> ps) {this.ps = ps;}

  boolean in(Point p) {
    return ps.test(p);
  }

  static PSet disk(Point center, double radius) {
    return new PSet(point -> center.distance(point) <= radius);
  }

  PSet intersect(PSet set) {
    return new PSet(point -> ps.test(point) && set.ps.test(point));
  }

  static PSet rect(Point corner1, Point corner2) {
    return new PSet(point -> corner1.distance(point)<= corner1.distance(corner2) 
                        && corner2.distance(point) <= corner2.distance(corner1));


  }

  PSet union(PSet set) {
    return new PSet(point -> (ps.test(point) || set.ps.test(point)));
  }

  PSet complement() {
    return new PSet(point -> ps.test(point) == false);
  }

  PSet reflectx() { 
    //for each point (x, y), we want a new point (x, -y)
    return new PSet(p -> in(new Point(p.x, -p.y)));
    //return new PSet(p -> (q -> ps.test(q)) && p.x == q.x && p.y == -q.y);

  }
}
  

class Example {
  public static void main(String argv[]) {
    double x = Double.parseDouble(argv[0]);
    double y = Double.parseDouble(argv[1]);
    Point p = new Point(x,y);
    //two circles of radius 2, one with center (0,0) and one with center (0, 2)
    //these two circles intersection:
    PSet myregion = PSet.disk(new Point(0,0),2).intersect(PSet.disk(new Point(0,2),2));
    System.out.println(myregion.in(p));

    PSet comp = myregion.complement();
    System.out.println(comp.in(p));

    PSet ref = myregion.reflectx();
    System.out.println(ref.in(p));


    PSet un = comp.union(myregion);//all points should be included in un now
    System.out.println(un.in(p));


    PSet rec = PSet.rect(new Point(2,2), new Point(0,2));
    System.out.println(rec.in(p));

  }
}
