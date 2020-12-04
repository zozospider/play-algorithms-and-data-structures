// 插入排序
public class InsertionSort {

    private InsertionSort() {
    }

    // 插入排序
    public static <E extends Comparable<E>> void sortV0(E[] arr) {

        // 循环不变量: arr[0, i) 已排序, arr[i, n) 未排序
        for (int i = 0; i < arr.length; i++) {

            // 循环体: arr[i, n) 未排序, 将 arr[i] 放到 arr[0, i] 的排序位置
            for (int j = i; j >= 1; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }

            /* 另一种写法
            for (int j = i; j >= 1 && arr[j - 1].compareTo(arr[j]) < 0; j--) {
                swap(arr, j, j - 1);
            }
            */
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
