class Solution {
    public int[][] kClosest(int[][] points, int k) {
       Arrays.sort(points,(a,b)->distance(a)-distance(b));
        return Arrays.copyOf(points,k);
    }
    public int distance(int[] point){
        return point[0]*point[0]+point[1]*point[1];
    }
}

/**
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
*/
