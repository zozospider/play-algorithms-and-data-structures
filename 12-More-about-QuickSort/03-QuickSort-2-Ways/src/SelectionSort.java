// 选择排序
public class SelectionSort {

    private SelectionSort() {
    }

    // 选择排序: 对数组 arr 进行排序
    public static <E extends Comparable<E>> void sort(E[] arr) {

        sort(arr, 0, arr.length - 1);
    }

    // 选择排序: 对数组 arr 中的区间 arr[l, r] 进行排序
    // 时间复杂度: O(1/2 * n^2 + 1/2 * n) = O(n^2)
    public static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {

        // 循环不变量: arr[l, i) 已排序, arr[i, r] 未排序
        for (int i = l; i <= r; i++) {

            // 循环体: arr[i, r] 未排序, 将 arr[i, r] 中的最小值要放到 arr[i] 的位置
            int minIndex = i;
            for (int j = i; j <= r; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    // 选择排序 (另一种方式: 从后往前): 对数组 arr 中的区间 arr[l, r] 进行排序
    // 时间复杂度: O(n^2)
    public static <E extends Comparable<E>> void sort2(E[] arr) {

        sort2(arr, 0, arr.length - 1);
    }

    public static <E extends Comparable<E>> void sort2(E[] arr, int l, int r) {

        // 循环不变量: arr(i, r] 已排序, arr[l, i] 未排序
        for (int i = r; i >= l; i--) {

            // 循环体: arr[l, i] 未排序, 将 arr[l, i] 中的最大值要放到 arr[i] 的位置
            int maxIndex = i;
            for (int j = i; j >= l; j--) {
                if (arr[j].compareTo(arr[maxIndex]) > 0) {
                    maxIndex = j;
                }
            }
            swap(arr, i, maxIndex);
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}