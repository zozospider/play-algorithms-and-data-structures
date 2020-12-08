public class Test {

    public static void main(String[] args) {

        // 测试不同数据规模的归并排序耗时
        int[] dataSizes = {10_000, 100_000};

        for (int n : dataSizes) {

            // 生成一个长度为 n 的随机数组
            Integer[] data = ArrayGenerator.generateRandomArray(n, n);

            // MergeSort
            // 时间复杂度: O(n^2)
            long time = SortingHelper.sort(data, "MergeSort");
            System.out.println("n: " + n + ", MergeSort time: " + time + "ms");
        }

    }

}
