// 插入排序
public class InsertionSort {

    private InsertionSort() {
    }

    // 插入排序 (推荐): 对数组 arr 进行排序
    public static <E extends Comparable<E>> void sort(E[] arr) {

        sort(arr, 0, arr.length - 1);
    }

    // 插入排序 (推荐): 对数组 arr 中的区间 arr[l, r] 进行排序
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

    // 插入排序 (另一种方式: 从后往前): 对数组 arr 进行排序
    public static <E extends Comparable<E>> void sort2(E[] arr) {

        sort2(arr, 0, arr.length - 1);
    }

    // 插入排序 (另一种方式: 从后往前): 对数组 arr 中的区间 arr[l, r] 进行排序
    // 时间复杂度: O(n^2)
    public static <E extends Comparable<E>> void sort2(E[] arr, int l, int r) {

        // 循环不变量: arr(i, r] 已排序, arr[l, i] 未排序
        for (int i = r; i >= l; i--) {

            // 循环体: arr[l, i] 未排序, 将 arr[i] 放到 arr[i, r] 的排序位置
            E temp = arr[i];
            int maxIndex = i;
            for (int j = i; j <= r - 1; j++) {
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
            for (j = i; j <= r - 1 && temp.compareTo(arr[j + 1]) > 0; j++) {
                arr[j] = arr[j + 1];
            }
            arr[j] = temp;
            */
        }
    }

}
