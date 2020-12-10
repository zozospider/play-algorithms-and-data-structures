import java.util.Random;

public class Test {

    // 测试不同数据规模的二分查找耗时
    public static void main(String[] args) {

        int[] dataSizes = {1_000_000, 10_000_000};

        for (int n : dataSizes) {

            // 生成一个长度为 n 的有序数组
            Integer[] data = ArrayGenerator.generateOrderedArray(n);
            // int target = data.length;
            int target = new Random().nextInt(data.length);

            // LinearSearch
            // 时间复杂度: O(n)
            long timeO1 = SearchHelper.search(data, target, SearchHelper.SEARCH.LINEAR_SEARCH);
            System.out.println("n: " + n + ", LinearSearch time: " + timeO1 + "ms");

            // BinarySearch
            // 时间复杂度: O(log n)
            long timeO21 = SearchHelper.search(data, target, SearchHelper.SEARCH.BINARY_SEARCH);
            System.out.println("n: " + n + ", BinarySearch time: " + timeO21 + "ms");
            long timeO22 = SearchHelper.search(data, target, SearchHelper.SEARCH.BINARY_SEARCH_NOT_RECURSION);
            System.out.println("n: " + n + ", BinarySearchNotRecursion time: " + timeO22 + "ms");
            long timeO23 = SearchHelper.search(data, target, SearchHelper.SEARCH.BINARY_SEARCH_NOT_RECURSION_2);
            System.out.println("n: " + n + ", BinarySearchNotRecursion2 time: " + timeO23 + "ms");

            System.out.println();
            System.out.println("------");
            System.out.println();
        }
    }

}
