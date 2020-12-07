public class Solution2 {

    public int reversePairs(int[] nums) {
        // int[] tmpNums = Arrays.copyOf(nums, nums.length);
        int[] tmpNums = new int[nums.length];
        return sort(nums, 0, nums.length - 1, tmpNums);
    }

    private int sort(int[] nums, int l, int r, int[] tmpNums) {
        int res = 0;
        if (l >= r) {
            return res;
        }
        int mid = l + (r - l) / 2;
        res += sort(nums, l, mid, tmpNums);
        res += sort(nums, mid + 1, r, tmpNums);
        if (nums[mid] > nums[mid + 1]) {
            res += merge(nums, l, mid, r, tmpNums);
        }
        return res;
    }

    private int merge(int[] nums, int l, int mid, int r, int[] tmpNums) {
        int res = 0;
        System.arraycopy(nums, l, tmpNums, l, r - l + 1);
        int t1 = l;
        int t2 = mid + 1;
        for (int i = l; i <= r; i++) {
            if (t1 > mid) {
                nums[i] = tmpNums[t2];
                t2++;
            } else if (t2 > r) {
                nums[i] = tmpNums[t1];
                t1++;
            } else if (tmpNums[t1] < tmpNums[t2]) {
                nums[i] = tmpNums[t1];
                t1++;
            } else {
                res += mid - t1 + 1;
                nums[i] = tmpNums[t2];
                t2++;
            }
        }
        return res;
    }

}
