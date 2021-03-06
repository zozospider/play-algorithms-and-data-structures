import java.util.Arrays;

// 归并排序
public class MergeSort {

    private MergeSort() {
    }

    // 归并排序: 对数组 arr 进行排序
    public static <E extends Comparable<E>> void sort(E[] arr) {

        sort(arr, 0, arr.length - 1);
    }

    // 归并排序: 对数组 arr 中的区间 arr[left, right] 进行排序
    // 时间复杂度 (忽略底数): O(n log n) = O(n log 2 n)
    // 最快复杂度 (有序时): O(n) = O(2n) = O(n + n/2 + n/4 + n/8 + ... + 1)
    public static <E extends Comparable<E>> void sort(E[] arr, int left, int right) {

        if (left >= right) {
            return;
        }

        // 求此区间的中间索引位置
        // int middle = (right - left) / 2;
        int middle = left + (right - left) / 2;

        // 对数组 arr 中的左区间 arr[left, middle] 进行排序
        sort(arr, left, middle);
        // 对数组 arr 中的右区间 arr[middle + 1, right] 进行排序
        sort(arr, middle + 1, right);

        // 将数组 arr 中的两个有序区间 arr[left, middle] 和 arr[middle + 1, right] 合并调整成一个有序区间 arr[left, right]
        // 只有在左区间存在比右区间大的元素时, 才需要排序
        if (arr[middle].compareTo(arr[middle + 1]) > 0) {
            merge(arr, left, middle, right);
        }
    }

    // 此方法的宏观语义 (建议画图帮助理解):
    // 将数组 arr 中的两个有序区间 arr[left, middle] 和 arr[middle + 1, right] 合并调整成一个有序区间 arr[left, right]
    // 时间复杂度: O(n)
    private static <E extends Comparable<E>> void merge(E[] arr, int left, int middle, int right) {

        // 拷贝一个临时数组 (只拷贝 arr[left, r] 区间), 防止修改 arr 过程中原数据被覆盖
        // 注意下标值对应关系:
        // arr[left] -> subArr[0]
        // arr[middle] -> subArr[middle - left]
        // arr[right] -> subArr[right - left]

        // subArr[0] -> arr[left]
        // subArr[middle - left] -> arr[middle]
        // subArr[right - left] -> arr[right]
        E[] subArr = Arrays.copyOfRange(arr, left, right + 1);

        // s1 和 s2 用于记录 subArr 左区间和右区间的当前索引, 初始化为区间的索引起始值
        int s1 = 0;
        int s2 = middle - left + 1;

        for (int i = left; i <= right; i++) {

            if (s1 > (middle - left)) {

                // 如果 subArr 的左区间 s1 已移动到中间位置后, 说明左区间已全部赋值完成, 则赋值右区间的 s2 值到 arr
                arr[i] = subArr[s2];
                s2++;

            } else if (s2 > (right - left)) {

                // 如果 subArr 的右区间 s2 已移动到尾部位置后, 说明右区间已全部赋值完成, 则赋值左区间的 s1 值到 arr
                arr[i] = subArr[s1];
                s1++;

            } else if (subArr[s1].compareTo(subArr[s2]) < 0) {

                // 如果 subArr 的左区间 s1 值小于右区间 s2 值, 则赋值左区间的 s1 值到 arr
                arr[i] = subArr[s1];
                s1++;

            } else {

                // 如果 subArr 的右区间 s2 值小于左区间 s1 值, 则赋值右区间的 s2 值到 arr
                arr[i] = subArr[s2];
                s2++;
            }
        }

        /* 另一种写法
        int s1 = left;
        int s2 = middle + 1;
        for (int i = left; i <= right; i++) {
            if (s1 > middle) {
                arr[i] = subArr[s2 - left];
                s2++;
            } else if (s2 > r) {
                arr[i] = subArr[s1 - left];
                s1++;
            } else if (subArr[s1 - left].compareTo(subArr[s2 - left]) < 0) {
                arr[i] = subArr[s1 - left];
                s1++;
            } else {
                arr[i] = subArr[s2 - left];
                s2++;
            }
        }
        */
    }

}
