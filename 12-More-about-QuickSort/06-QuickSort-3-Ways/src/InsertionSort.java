// 插入排序
public class InsertionSort {

    private InsertionSort() {
    }

    // 插入排序 (推荐): 对数组 arr 进行排序
    public static <E extends Comparable<E>> void sort(E[] arr) {

        sort(arr, 0, arr.length - 1);
    }

    // 插入排序 (推荐): 对数组 arr 中的区间 arr[left, right] 进行排序
    // 时间复杂度: O(n^2)
    // 最快复杂度 (有序时): O(n)
    public static <E extends Comparable<E>> void sort(E[] arr, int left, int right) {

        // 循环不变量: arr[left, i) 已排序, arr[i, right] 未排序
        for (int i = left; i <= right; i++) {

            // 循环体: arr[i, right] 未排序, 将 arr[i] 放到 arr[0, i] 的排序位置
            E temp = arr[i];
            int minIndex = i;
            for (int j = i; j >= left + 1; j--) {
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
            for (j = i; j >= left + 1 && temp.compareTo(arr[j - 1]) < 0; j--) {
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

    // 插入排序 (另一种方式: 从后往前): 对数组 arr 中的区间 arr[left, right] 进行排序
    // 时间复杂度: O(n^2)
    public static <E extends Comparable<E>> void sort2(E[] arr, int left, int right) {

        // 循环不变量: arr(i, right] 已排序, arr[left, i] 未排序
        for (int i = right; i >= left; i--) {

            // 循环体: arr[left, i] 未排序, 将 arr[i] 放到 arr[i, right] 的排序位置
            E temp = arr[i];
            int maxIndex = i;
            for (int j = i; j <= right - 1; j++) {
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
            for (j = i; j <= right - 1 && temp.compareTo(arr[j + 1]) > 0; j++) {
                arr[j] = arr[j + 1];
            }
            arr[j] = temp;
            */
        }
    }

}
