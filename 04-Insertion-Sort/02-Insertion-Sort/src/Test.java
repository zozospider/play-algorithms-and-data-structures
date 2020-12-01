public class Test {

    // 测试不同数据规模的插入排序耗时
    public static void main(String[] args) {

        int[] dataSizes = {10_000, 100_000};

        for (int n : dataSizes) {

            // 生成一个长度为 n 的随机数组
            Integer[] data = ArrayGenerator.generateRandomArray(n, n);

            // 测试选择排序耗时
            // 时间复杂度: O(n^2)
            long time = SortingHelper.sort(data, "InsertionSort");
            System.out.println("n: " + n + ", time: " + time + "ms");
        }
    }

}
