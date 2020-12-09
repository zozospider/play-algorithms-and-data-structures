// 选择排序
public class SelectionSort {

    private SelectionSort() {
    }

    // 选择排序: 对数组 arr 进行排序
    public static <E extends Comparable<E>> void sort(E[] arr) {

        sort(arr, 0, arr.length - 1);
    }

    // 选择排序: 对数组 arr 中的区间 arr[left, right] 进行排序
    // 时间复杂度: O(1/2 * n^2 + 1/2 * n) = O(n^2)
    public static <E extends Comparable<E>> void sort(E[] arr, int left, int right) {

        // 循环不变量: arr[left, i) 已排序, arr[i, right] 未排序
        for (int i = left; i <= right; i++) {

            // 循环体: arr[i, right] 未排序, 将 arr[i, right] 中的最小值要放到 arr[i] 的位置
            int minIndex = i;
            for (int j = i; j <= right; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
