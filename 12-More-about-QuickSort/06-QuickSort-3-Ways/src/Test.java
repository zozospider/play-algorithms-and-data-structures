import java.util.Arrays;

public class Test {

    // 测试不同数据规模, 不同排序方式, 不同排序算法的耗时对比
    public static void main(String[] args) {

        int[] dataSizes = {10_000, 50_000};

        for (int n : dataSizes) {

            // 无序数组耗时对比
            Integer[] dataR1 = ArrayGenerator.generateRandomArray(n, n);
            Integer[] dataR2 = Arrays.copyOf(dataR1, dataR1.length);
            Integer[] dataR3 = Arrays.copyOf(dataR1, dataR1.length);
            Integer[] dataR41 = Arrays.copyOf(dataR1, dataR1.length);
            Integer[] dataR42 = Arrays.copyOf(dataR1, dataR1.length);
            Integer[] dataR43 = Arrays.copyOf(dataR1, dataR1.length);

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
            long timeR41 = SortingHelper.sort(dataR41, "QuickSort1Way");
            System.out.println("n: " + n + ", Random Array, QuickSort1Way time: " + timeR41 + "ms");
            long timeR42 = SortingHelper.sort(dataR42, "QuickSort2Ways");
            System.out.println("n: " + n + ", Random Array, QuickSort2Ways time: " + timeR42 + "ms");
            long timeR43 = SortingHelper.sort(dataR43, "QuickSort3Ways");
            System.out.println("n: " + n + ", Random Array, QuickSort3Ways time: " + timeR43 + "ms");

            System.out.println("---");

            // 有序数组耗时对比
            Integer[] dataO1 = ArrayGenerator.generateOrderedArray(n);
            Integer[] dataO2 = Arrays.copyOf(dataO1, dataO1.length);
            Integer[] dataO3 = Arrays.copyOf(dataO1, dataO1.length);
            Integer[] dataO41 = Arrays.copyOf(dataO1, dataO1.length);
            Integer[] dataO42 = Arrays.copyOf(dataO1, dataO1.length);
            Integer[] dataO43 = Arrays.copyOf(dataO1, dataO1.length);

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
            long timeO41 = SortingHelper.sort(dataO41, "QuickSort1Way");
            System.out.println("n: " + n + ", Ordered Array, QuickSort1Way time: " + timeO41 + "ms");
            long timeO42 = SortingHelper.sort(dataO42, "QuickSort2Ways");
            System.out.println("n: " + n + ", Ordered Array, QuickSort2Ways time: " + timeO42 + "ms");
            long timeO43 = SortingHelper.sort(dataO43, "QuickSort3Ways");
            System.out.println("n: " + n + ", Ordered Array, QuickSort3Ways time: " + timeO43 + "ms");

            System.out.println("---");

            // 所有元素都相同 (都为 0) 的数组耗时对比
            Integer[] dataS1 = ArrayGenerator.generateRandomArray(n, 1);
            Integer[] dataS2 = Arrays.copyOf(dataS1, dataS1.length);
            Integer[] dataS3 = Arrays.copyOf(dataS1, dataS1.length);
            Integer[] dataS41 = Arrays.copyOf(dataS1, dataS1.length);
            Integer[] dataS42 = Arrays.copyOf(dataS1, dataS1.length);
            Integer[] dataS43 = Arrays.copyOf(dataS1, dataS1.length);

            // SelectionSort
            // 时间复杂度: O(n^2)
            long timeS1 = SortingHelper.sort(dataS1, "SelectionSort");
            System.out.println("n: " + n + ", Same Value Array, SelectionSort time: " + timeS1 + "ms");

            // InsertionSort
            // 时间复杂度: O(n)
            long timeS2 = SortingHelper.sort(dataS2, "InsertionSort");
            System.out.println("n: " + n + ", Same Value Array, InsertionSort time: " + timeS2 + "ms");

            // MergeSort
            // 时间复杂度 (忽略底数): O(n log n) = O(n log 2 n)
            long timeS3 = SortingHelper.sort(dataS3, "MergeSort");
            System.out.println("n: " + n + ", Same Value Array, MergeSort time: " + timeS3 + "ms");

            // QuickSort
            try {
                long timeS41 = SortingHelper.sort(dataS41, "QuickSort1Way");
                System.out.println("n: " + n + ", Same Value Array, QuickSort1Way time: " + timeS41 + "ms");
            } catch (StackOverflowError error) {
                System.out.println("n: " + n + ", Same Value Array, QuickSort1Way get a StackOverflowError!");
            }
            long timeS42 = SortingHelper.sort(dataS42, "QuickSort2Ways");
            System.out.println("n: " + n + ", Same Value Array, QuickSort2Ways time: " + timeS42 + "ms");
            long timeS43 = SortingHelper.sort(dataS43, "QuickSort3Ways");
            System.out.println("n: " + n + ", Same Value Array, QuickSort3Ways time: " + timeS43 + "ms");

            System.out.println();
            System.out.println("------");
            System.out.println();
        }
    }

}
