// 选择排序法
public class SelectionSort {

    private SelectionSort() {
    }

    // 选择排序
    // 时间复杂度: O(1/2 * n^2 + 1/2 * n) = O(n^2)
    public static <E extends Comparable<E>> void sort(E[] arr) {

        // 循环不变量: arr[0, i) 已排序, arr[i, n) 未排序
        for (int i = 0; i < arr.length; i++) {

            // 循环体: arr[i, n) 未排序, 将 arr[i, n) 中的最小值要放到 arr[i] 的位置
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    // 选择排序 (另一种方式: 从后往前)
    // 时间复杂度: O(n^2)
    public static <E extends Comparable<E>> void sort2(E[] arr) {

        // 循环不变量: arr(i, n) 已排序, arr[0, i] 未排序
        for (int i = arr.length - 1; i >= 0; i--) {

            // 循环体: arr[0, i] 未排序, 将 arr[0, i] 中的最大值要放到 arr[i] 的位置
            int maxIndex = i;
            for (int j = i; j >= 0; j--) {
                if (arr[j].compareTo(arr[maxIndex]) > 0) {
                    maxIndex = j;
                }
            }
            swap(arr, i, maxIndex);
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
