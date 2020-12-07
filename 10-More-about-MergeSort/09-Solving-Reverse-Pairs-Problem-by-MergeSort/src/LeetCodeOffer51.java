/**
 * 剑指 Offer 51. 数组中的逆序对
 * https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 *
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 * 示例:
 * 输入: [7,5,6,4]
 * 输出: 5
 */
public class LeetCodeOffer51 {

    public static void main(String[] args) {
        main1();
        main2();
    }

    private static void main1() {

        int[] nums = {7, 5, 6, 4};

        int reversePairs = new Solution().reversePairs(nums);
        System.out.println(reversePairs);
    }

    private static void main2() {

        int[] nums = {7, 5, 6, 4};

        int reversePairs = new Solution2().reversePairs(nums);
        System.out.println(reversePairs);
    }

}
