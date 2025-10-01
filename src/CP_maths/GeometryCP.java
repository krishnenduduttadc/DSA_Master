package CP_maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
===================================================================
    Geometry in Competitive Programming
===================================================================

1. POINT REPRESENTATION
   - Use (x, y) coordinates (double or long).
   - Define basic operations: distance, cross product, orientation.

2. ORIENTATION TEST (CCW test)
   - For points a, b, c:
       cross(b-a, c-a) > 0 → counter-clockwise turn
       cross(b-a, c-a) < 0 → clockwise turn
       = 0 → collinear

3. LINE SEGMENT INTERSECTION
   - Two segments AB and CD intersect if:
       - The orientation tests differ:
           (A,B,C) and (A,B,D) have different signs
           (C,D,A) and (C,D,B) have different signs
       - Special case: collinear + overlapping.

4. CONVEX HULL (Graham Scan / Monotone Chain)
   - Smallest convex polygon enclosing all points.
   - Complexity O(N log N).
   - Useful in geometry problems, closest pair, rotating calipers.

5. ROTATING CALIPERS
   - Once convex hull is built, can find:
       - Diameter of set of points (farthest distance).
       - Minimum bounding rectangle.
       - Useful for max/min distance queries.

===================================================================
*/

class GeometryCP {
    // Cross product of AB x AC
    static double cross(Point a, Point b, Point c) {
        return (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
    }

    // Distance squared
    static double dist2(Point a, Point b) {
        double dx = a.x - b.x, dy = a.y - b.y;
        return dx * dx + dy * dy;
    }

    // Orientation test
    static int orientation(Point a, Point b, Point c) {
        double val = cross(a, b, c);
        if (val > 0) return 1;   // counter-clockwise
        if (val < 0) return -1;  // clockwise
        return 0;                // collinear
    }

    // Check if point q lies on segment pr
    static boolean onSegment(Point p, Point q, Point r) {
        return q.x <= Math.max(p.x, r.x) && q.x >= Math.min(p.x, r.x) &&
                q.y <= Math.max(p.y, r.y) && q.y >= Math.min(p.y, r.y);
    }

    // Check if segments p1q1 and p2q2 intersect
    static boolean segmentsIntersect(Point p1, Point q1, Point p2, Point q2) {
        int o1 = orientation(p1, q1, p2);
        int o2 = orientation(p1, q1, q2);
        int o3 = orientation(p2, q2, p1);
        int o4 = orientation(p2, q2, q1);

        if (o1 != o2 && o3 != o4) return true; // general case

        // Special collinear cases
        if (o1 == 0 && onSegment(p1, p2, q1)) return true;
        if (o2 == 0 && onSegment(p1, q2, q1)) return true;
        if (o3 == 0 && onSegment(p2, p1, q2)) return true;
        if (o4 == 0 && onSegment(p2, q1, q2)) return true;

        return false;
    }

    // Convex Hull using Monotone Chain (returns list in CCW order)
    static List<Point> convexHull(List<Point> pts) {
        Collections.sort(pts);
        int n = pts.size();
        if (n <= 1) return pts;

        List<Point> lower = new ArrayList<>();
        for (Point p : pts) {
            while (lower.size() >= 2 && cross(lower.get(lower.size() - 2), lower.get(lower.size() - 1), p) <= 0) {
                lower.remove(lower.size() - 1);
            }
            lower.add(p);
        }

        List<Point> upper = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            Point p = pts.get(i);
            while (upper.size() >= 2 && cross(upper.get(upper.size() - 2), upper.get(upper.size() - 1), p) <= 0) {
                upper.remove(upper.size() - 1);
            }
            upper.add(p);
        }

        lower.remove(lower.size() - 1);
        upper.remove(upper.size() - 1);
        lower.addAll(upper);
        return lower; // convex hull in CCW order
    }

    public static void main(String[] args) {
        // ==========================
        // Example 1: Segment Intersection
        // ==========================
        Point p1 = new Point(1, 1), q1 = new Point(10, 1);
        Point p2 = new Point(5, 0), q2 = new Point(5, 5);
        System.out.println("Segments intersect? " + segmentsIntersect(p1, q1, p2, q2));
        // true

        // ==========================
        // Example 2: Convex Hull
        // ==========================
        List<Point> pts = Arrays.asList(
                new Point(0, 0), new Point(1, 1), new Point(2, 2),
                new Point(0, 2), new Point(2, 0), new Point(1, 2), new Point(2, 1)
        );
        List<Point> hull = convexHull(new ArrayList<>(pts));
        System.out.println("Convex Hull Points:");
        for (Point p : hull) {
            System.out.println("(" + p.x + ", " + p.y + ")");
        }
        // Expected hull: (0,0), (2,0), (2,2), (0,2)
    }

    // Point class
    static class Point implements Comparable<Point> {
        double x, y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Point p) {
            if (this.x == p.x) return Double.compare(this.y, p.y);
            return Double.compare(this.x, p.x);
        }
    }
}
