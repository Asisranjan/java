
public class OrientationTest {

	static class Point
	{
		int x;
		int y;
		
		Point(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p1 = new Point(0, 0);
		Point p2 = new Point(4, 4);
		Point p3 = new Point(1, 2);
		
		System.out.println(getOrientation(p1, p2, p3));
		
		Point p4 = new Point(10, 0);
		Point q4 = new Point(0, 10);
		
		Point p5 = new Point(0, 0);
		Point q5 = new Point(10, 10);
		
		System.out.println("Isintersect: "+isTwoGivenLineSegmentIntersect(p4, q4, p5, q5));
	}
	
	public static boolean isInSegment(Point p, Point q, Point r)
	{
		if (r.x <= Math.max(p.x, q.x) && r.x >= Math.min(p.x, q.x) && r.y <= Math.max(p.y, q.y) && r.y >= Math.min(p.y, q.y)) {
			return true;
		}
		return false;
	}
	
	public static boolean isTwoGivenLineSegmentIntersect(Point p1, Point q1, Point p2, Point q2) {
		String o1 = getOrientation(p1, q1, q2);
		String o2 = getOrientation(p1, q1, p2);
		
		String o3 = getOrientation(p2, q2, q1);
		String o4 = getOrientation(p2, q2, p1);
		
		System.out.println(o1+", "+o2+", "+o3+", "+o4);
		if (o1.equals("colinear") && isInSegment(p1, q1, q2))
		{
			return true;
		}
		else if (o2.equals("colinear") && isInSegment(p1, q1, p2)) {
			return true;
		}
		else if(o3.equals("colinear") && isInSegment(p2, q2, q1)) {
			return true;
		}
		else if (o4.equals("colinear") && isInSegment(p2, q2, p1))
		{
			return true;
		}
		else if (!o1.equals(o2) && !o3.equals(o4)) {
			return true;
		}
		return false;
	}
	
	public static int ccw(Point a, Point b, Point c) {
        // return a.x*b.y - a.y*b.x + a.y*c.x - a.x*c.y + b.x*c.y - b.y*c.x;
        double area2 = (b.x - a.x) * (c.y - a.y) - (c.x - a.x) * (b.y - a.y);
        if      (area2 < 0) return -1;
        else if (area2 > 0) return +1;
        else                return  0;
    }
	
	public static String getOrientation(Point p1, Point p2, Point p3)
	{
		
		/*int slope1 = (p2.y - p1.y)/(p2.x - p1.x);
		int slope2 = (p3.y - p2.y)/(p3.x - p2.x);
		
		System.out.println("slope1: "+slope1+", slope2:"+slope2);
		if (slope1 < slope2)
			return "clock wise";
		else if (slope1 > slope2)
			return "counter clock wise";
		else
			return "colinear";*/
		
		int val = (p2.y - p1.y) * (p3.x - p2.x) - (p3.y - p2.y) * (p2.x - p1.x);
		
		return (val == 0) ? "colinear" : (val > 0) ? "clockwise" : "counter clockwise";
	
	}

}
