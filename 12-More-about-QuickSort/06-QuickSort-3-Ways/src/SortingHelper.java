// 排序帮助类
public class SortingHelper {

    private SortingHelper() {
    }

    // 判断数组是否有序
    public static <E extends Comparable<E>> boolean isSorted(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].compareTo(arr[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    enum SORT {
        SELECTION_SORT,
        SELECTION_SORT_2,
        INSERTION_SORT,
        INSERTION_SORT_2,
        MERGE_SORT,
        QUICKSORT,
        QUICKSORT_1_WAY,
        QUICKSORT_2_WAYS,
        QUICKSORT_3_WAYS
    }

    // 测试排序耗时
    public static <E extends Comparable<E>> long sort(E[] arr, SORT sort) {
        // 记录开始时间 (单位: 毫秒)
        long start = System.currentTimeMillis();

        if (sort == SORT.SELECTION_SORT) {
            SelectionSort.sort(arr);
        } else if (sort == SORT.SELECTION_SORT_2) {
            SelectionSort.sort2(arr);
        } else if (sort == SORT.INSERTION_SORT) {
            InsertionSort.sort(arr);
        } else if (sort == SORT.INSERTION_SORT_2) {
            InsertionSort.sort2(arr);
        } else if (sort == SORT.MERGE_SORT) {
            MergeSort.sort(arr);
        } else if (sort == SORT.QUICKSORT) {
            QuickSort.sort(arr);
        } else if (sort == SORT.QUICKSORT_1_WAY) {
            QuickSort.sort1way(arr);
        } else if (sort == SORT.QUICKSORT_2_WAYS) {
            QuickSort.sort2ways(arr);
        } else if (sort == SORT.QUICKSORT_3_WAYS) {
            QuickSort.sort3ways(arr);
        }

        // 记录结束时间 (单位: 毫秒)
        long end = System.currentTimeMillis();

        if (!isSorted(arr)) {
            throw new RuntimeException(sort + " failed");
        }
        // 返回时间间隔 (单位: 毫秒)
        return end - start;
    }

}
