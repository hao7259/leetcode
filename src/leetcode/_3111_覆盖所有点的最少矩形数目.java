package leetcode;

import java.util.Arrays;

public class _3111_覆盖所有点的最少矩形数目 {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        int[] arr = new int[w];
        for (int i = 0; i < points.length; i++) {
            arr[i] = points[i][0];
        }
        Arrays.sort(arr);
        int start = -1, res = 0;
        for (int[] point : points) {
            if (point[0] > start) {
                res++;
                start = point[0] + w;
            }
        }
        return res;


    }

}
