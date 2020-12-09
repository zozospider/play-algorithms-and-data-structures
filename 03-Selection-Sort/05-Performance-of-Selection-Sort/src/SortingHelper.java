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
        SELECTION_SORT
    }

    // 测试排序耗时
    public static <E extends Comparable<E>> long sort(E[] arr, SORT sort) {
        // 记录开始时间 (单位: 毫秒)
        long start = System.currentTimeMillis();

        if (sort == SORT.SELECTION_SORT) {
            SelectionSort.sort(arr);
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
