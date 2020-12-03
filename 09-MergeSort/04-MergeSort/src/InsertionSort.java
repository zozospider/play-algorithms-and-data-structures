// 插入排序法
public class InsertionSort {

    private InsertionSort() {
    }

    // 插入排序
    // 时间复杂度: O(n^2)
    // 当数组有序时, 时间复杂度: O(n)
    public static <E extends Comparable<E>> void sortV0(E[] arr) {

        // 循环不变量: arr[0, i) 已排序, arr[i, n) 未排序
        for (int i = 0; i < arr.length; i++) {

            // 循环体: arr[i, n) 未排序, 将 arr[i] 放到 arr[0, i] 的排序位置
            for (int j = i; j > 0; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }

            /* 另一种写法
            for (int j = i; i > 0 && arr[j - 1].compareTo(arr[j]) < 0; j--) {
                swap(arr, j, j - 1);
            }
            */
        }
    }

    // 插入排序 - 优化 (推荐)
    // 时间复杂度: O(n^2)
    // 当数组有序时, 时间复杂度: O(n)
    public static <E extends Comparable<E>> void sort(E[] arr) {

        // 循环不变量: arr[0, i) 已排序, arr[i, n) 未排序
        for (int i = 0; i < arr.length; i++) {

            // 循环体: arr[i, n) 未排序, 将 arr[i] 放到 arr[0, i] 的排序位置
            E temp = arr[i];
            int minIndex = i;
            for (int j = i; j > 0; j--) {
                if (temp.compareTo(arr[j - 1]) < 0) {
                    arr[j] = arr[j - 1];
                    minIndex = j - 1;
                } else {
                    break;
                }
            }
            arr[minIndex] = temp;

            /* 另一种写法
            E temp = arr[i];
            int j;
            for (j = i; j > 0 && temp.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
            */
        }
    }

    // 插入排序 (另一种方式: 从后往前)
    // 时间复杂度: O(n^2)
    public static <E extends Comparable<E>> void sort2(E[] arr) {

        // 循环不变量: arr(i, n) 已排序, arr[0, i] 未排序
        for (int i = arr.length - 1; i >= 0; i--) {

            // 循环体: arr[0, i] 未排序, 将 arr[i] 放到 arr[i, n) 的排序位置
            E temp = arr[i];
            int maxIndex = i;
            for (int j = i; j <= arr.length - 2; j++) {
                if (temp.compareTo(arr[j + 1]) > 0) {
                    arr[j] = arr[j + 1];
                    maxIndex = j + 1;
                } else {
                    break;
                }
            }
            arr[maxIndex] = temp;

            /* 另一种写法
            E temp = arr[i];
            int j;
            for (j = i; j <= arr.length - 2 && temp.compareTo(arr[j + 1]) > 0; j++) {
                arr[j] = arr[j + 1];
            }
            arr[j] = temp;
            */
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
