package leetcode;
public class _53_最大子数组之和 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return maxSubarray(nums, 0, nums.length);


    }

    //    [begin,end)
    private static int maxSubarray(int[] nums, int begin, int end) {
        if (end - begin < 2) return nums[begin];
        int mid = (begin + end) >> 1;
        int leftMax = nums[mid - 1];
        int leftSum = leftMax;
        for (int i = mid - 2; i >= begin; i--) {
            leftSum += nums[i];
            leftMax = Math.max(leftMax, leftSum);
        }
        int rightMax = nums[mid];
        int rightSum = rightMax;
        for (int i = mid + 1; i < end; i++) {
            rightSum += nums[i];
            rightMax = Math.max(rightSum, rightMax);
        }
        return Math.max(leftMax + rightMax,
                Math.max(maxSubarray(nums, begin, mid),
                        maxSubarray(nums, mid, end)));

    }
}
