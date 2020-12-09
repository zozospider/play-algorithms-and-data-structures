public class Solution {

    private int res;

    public int reversePairs(int[] nums) {
        // int[] tmpNums = Arrays.copyOf(nums, nums.length);
        int[] tmpNums = new int[nums.length];
        sort(nums, 0, nums.length - 1, tmpNums);
        return res;
    }

    private void sort(int[] nums, int left, int right, int[] tmpNums) {
        if (left >= right) {
            return;
        }
        int middle = left + (right - left) / 2;
        sort(nums, left, middle, tmpNums);
        sort(nums, middle + 1, right, tmpNums);
        if (nums[middle] > nums[middle + 1]) {
            merge(nums, left, middle, right, tmpNums);
        }
    }

    private void merge(int[] nums, int left, int middle, int right, int[] tmpNums) {
        System.arraycopy(nums, left, tmpNums, left, right - left + 1);
        int t1 = left;
        int t2 = middle + 1;
        for (int i = left; i <= right; i++) {
            if (t1 > middle) {
                nums[i] = tmpNums[t2];
                t2++;
            } else if (t2 > right) {
                nums[i] = tmpNums[t1];
                t1++;
            } else if (tmpNums[t1] < tmpNums[t2]) {
                nums[i] = tmpNums[t1];
                t1++;
            } else {
                res += middle - t1 + 1;
                nums[i] = tmpNums[t2];
                t2++;
            }
        }
    }

}
