// 插入排序
public class InsertionSort {

    private InsertionSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {

        sort(arr, 0, arr.length - 1);
    }

    // 插入排序 (推荐): 对 arr 中的区间 arr[l, r] 进行排序
    // 时间复杂度: O(n^2)
    // 最快复杂度 (有序时): O(n)
    public static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {

        // 循环不变量: arr[l, i) 已排序, arr[i, r] 未排序
        for (int i = l; i <= r; i++) {

            // 循环体: arr[i, r] 未排序, 将 arr[i] 放到 arr[0, i] 的排序位置
            E temp = arr[i];
            int minIndex = i;
            for (int j = i; j >= l + 1; j--) {
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
            for (j = i; j >= l + 1 && temp.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
            */
        }
    }

}
