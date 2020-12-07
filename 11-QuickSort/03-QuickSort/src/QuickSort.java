// 快速排序
public class QuickSort {

    private QuickSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {

        // v = arr[l]
        // 循环不变量: arr[l+1...p] < v; arr[p+1...i] >= v
        int p = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i].compareTo(arr[p]) >= 0) {
                continue;
            }
            if (arr[i].compareTo(arr[p]) < 0) {
                p++;
                swap(arr, i, p);
            }
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
