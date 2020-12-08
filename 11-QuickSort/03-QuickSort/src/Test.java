import java.util.Arrays;

public class Test {

    // 测试不同数据规模, 不同排序方式, 不同排序算法的耗时对比
    public static void main(String[] args) {

        int[] dataSizes = {10_000, 100_000};

        for (int n : dataSizes) {

            // 无序数组耗时对比
            Integer[] dataR1 = ArrayGenerator.generateRandomArray(n, n);
            Integer[] dataR2 = Arrays.copyOf(dataR1, dataR1.length);
            Integer[] dataR3 = Arrays.copyOf(dataR1, dataR1.length);
            Integer[] dataR4 = Arrays.copyOf(dataR1, dataR1.length);

            // SelectionSort
            // 时间复杂度: O(n^2)
            long timeR1 = SortingHelper.sort(dataR1, "SelectionSort");
            System.out.println("n: " + n + ", Random Array, SelectionSort time: " + timeR1 + "ms");

            // InsertionSort
            // 时间复杂度: O(n^2)
            long timeR2 = SortingHelper.sort(dataR2, "InsertionSort");
            System.out.println("n: " + n + ", Random Array, InsertionSort time: " + timeR2 + "ms");

            // MergeSort
            // 时间复杂度 (忽略底数): O(n log n) = O(n log 2 n)
            long timeR3 = SortingHelper.sort(dataR3, "MergeSort");
            System.out.println("n: " + n + ", Random Array, MergeSort time: " + timeR3 + "ms");

            // QuickSort
            long timeR4 = SortingHelper.sort(dataR4, "QuickSort");
            System.out.println("n: " + n + ", Random Array, QuickSort time: " + timeR4 + "ms");

            System.out.println("---");

            // 有序数组耗时对比
            Integer[] dataO1 = ArrayGenerator.generateOrderedArray(n);
            Integer[] dataO2 = Arrays.copyOf(dataO1, dataO1.length);
            Integer[] dataO3 = Arrays.copyOf(dataO1, dataO1.length);
            Integer[] dataO4 = Arrays.copyOf(dataO1, dataO1.length);

            // SelectionSort
            // 时间复杂度: O(n^2)
            long timeO1 = SortingHelper.sort(dataO1, "SelectionSort");
            System.out.println("n: " + n + ", Ordered Array, SelectionSort time: " + timeO1 + "ms");

            // InsertionSort
            // 时间复杂度: O(n)
            long timeO2 = SortingHelper.sort(dataO2, "InsertionSort");
            System.out.println("n: " + n + ", Ordered Array, InsertionSort time: " + timeO2 + "ms");

            // MergeSort
            // 时间复杂度 (忽略底数): O(n log n) = O(n log 2 n)
            long timeO3 = SortingHelper.sort(dataO3, "MergeSort");
            System.out.println("n: " + n + ", Ordered Array, MergeSort time: " + timeO3 + "ms");

            // QuickSort
            long timeO4 = SortingHelper.sort(dataO4, "QuickSort");
            System.out.println("n: " + n + ", Ordered Array, QuickSort time: " + timeO4 + "ms");

            System.out.println();
            System.out.println("------");
            System.out.println();
        }
    }

}
