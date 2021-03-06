public class Test {

    // 测试不同数据规模的插入排序耗时
    public static void main(String[] args) {

        int[] dataSizes = {10_000, 50_000};

        for (int n : dataSizes) {

            // 生成一个长度为 n 的随机数组
            Integer[] data = ArrayGenerator.generateRandomArray(n, n);

            // InsertionSort2
            // 时间复杂度: O(n^2)
            long time = SortingHelper.sort(data, SortingHelper.SORT.INSERTION_SORT_2);
            System.out.println("n: " + n + ", InsertionSort2 time: " + time + "ms");
        }
    }

}
