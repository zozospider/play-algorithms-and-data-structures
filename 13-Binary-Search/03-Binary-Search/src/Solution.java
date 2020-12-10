public class Solution {

    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    private int search(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int middle = left + (right - left) / 2;
        if (target == nums[middle]) {
            return middle;
        } else if (target > nums[middle]) {
            return search(nums, middle + 1, right, target);
        } else {
            return search(nums, left, middle - 1, target);
        }
    }

}
