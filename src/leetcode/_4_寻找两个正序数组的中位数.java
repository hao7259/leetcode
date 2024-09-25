package leetcode;

public class _4_寻找两个正序数组的中位数 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];
        int p1 = 0, p2 = 0;
        for (int i = 0; i < nums1.length + nums2.length; i++) {
            if (nums1[p1] <= nums2[p2]) {
                arr[i] = nums1[p1++];
            } else {
                arr[i] = nums2[p2++];
            }
        }
        if (arr.length % 2 != 0) {
            return arr[arr.length / 2];
        } else {
            return (arr[arr.length / 2 - 1] + arr[arr.length / 2]) / 2.0;
        }
    }
}
