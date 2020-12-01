public class Test {

    // 测试不同数据规模的线性查找耗时
    public static void main(String[] args) {

        int[] dataSizes = {1_000_000, 10_000_000};

        for (int n : dataSizes) {

            // 生成一个长度为 n 的有序数组
            Integer[] data = ArrayGenerator.generateOrderedArray(n);

            // 测试线性查找耗时
            // 时间复杂度: O(n)
            long time = test(data);
            System.out.println("n: " + n + ", time: " + time + "ms");
        }
    }

    private static long test(Integer[] data) {
        // 记录开始时间 (单位: 毫秒)
        long start = System.currentTimeMillis();

        int index = LinearSearch.search(data, data.length);

        // 记录结束时间 (单位: 毫秒)
        long end = System.currentTimeMillis();

        // 返回时间间隔 (单位: 毫秒)
        return end - start;
    }

}
