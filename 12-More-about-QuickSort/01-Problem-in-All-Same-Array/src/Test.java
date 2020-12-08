import java.util.Arrays;

public class Test {

    // 测试无序和有序的不同数据规模下, 插入排序, 选择排序, 归并排序, 快速排序的耗时对比
    public static void main(String[] args) {

        int[] dataSizes = {10_000, 100_000};

        for (int n : dataSizes) {

            // 无序数组耗时对比
            Integer[] dataA1 = ArrayGenerator.generateRandomArray(n, n);
            Integer[] dataA2 = Arrays.copyOf(dataA1, dataA1.length);
            Integer[] dataA3 = Arrays.copyOf(dataA1, dataA1.length);
            Integer[] dataA4 = Arrays.copyOf(dataA1, dataA1.length);
            // 时间复杂度: O(n^2)
            long timeA1 = SortingHelper.sort(dataA1, "SelectionSort");
            System.out.println("n: " + n + ", Random Array, SelectionSort time: " + timeA1 + "ms");
            // 时间复杂度: O(n^2)
            long timeA2 = SortingHelper.sort(dataA2, "InsertionSort");
            System.out.println("n: " + n + ", Random Array, InsertionSort time: " + timeA2 + "ms");
            // 时间复杂度 (忽略底数): O(n log n) = O(n log 2 n)
            long timeA3 = SortingHelper.sort(dataA3, "MergeSort");
            System.out.println("n: " + n + ", Random Array, MergeSort time: " + timeA3 + "ms");
            long timeA4 = SortingHelper.sort(dataA4, "QuickSort");
            System.out.println("n: " + n + ", Random Array, QuickSort time: " + timeA4 + "ms");

            System.out.println("---");

            // 有序数组耗时对比
            Integer[] dataB1 = ArrayGenerator.generateOrderedArray(n);
            Integer[] dataB2 = Arrays.copyOf(dataB1, dataB1.length);
            Integer[] dataB3 = Arrays.copyOf(dataB1, dataB1.length);
            Integer[] dataB4 = Arrays.copyOf(dataB1, dataB1.length);
            // 时间复杂度: O(n^2)
            long timeB1 = SortingHelper.sort(dataB1, "SelectionSort");
            System.out.println("n: " + n + ", Ordered Array, SelectionSort time: " + timeB1 + "ms");
            // 时间复杂度: O(n)
            long timeB2 = SortingHelper.sort(dataB2, "InsertionSort");
            System.out.println("n: " + n + ", Ordered Array, InsertionSort time: " + timeB2 + "ms");
            // 时间复杂度 (忽略底数): O(n log n) = O(n log 2 n)
            long timeB3 = SortingHelper.sort(dataB3, "MergeSort");
            System.out.println("n: " + n + ", Ordered Array, MergeSort time: " + timeB3 + "ms");
            long timeB4 = SortingHelper.sort(dataB4, "QuickSort");
            System.out.println("n: " + n + ", Ordered Array, QuickSort time: " + timeB4 + "ms");

            System.out.println();
            System.out.println("------");
            System.out.println();
        }
    }

}
