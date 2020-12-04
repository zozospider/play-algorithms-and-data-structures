import java.util.Arrays;

// 归并排序
public class MergeSort {

    private MergeSort() {
    }

    // 归并排序
    // 时间复杂度 (忽略底数): O(n log n) = O(n log 2 n)
    public static <E extends Comparable<E>> void sort(E[] arr) {

        // 对 arr 进行排序
        sort(arr, 0, arr.length - 1);
    }

    // 对 arr 的区间 arr[l, r] 进行排序
    // 时间复杂度 (忽略底数): O(n log n) = O(n log 2 n)
    // 最快复杂度 (有序时): O(n) = O(2n) = O(n + n/2 + n/4 + n/8 + ... + 1)
    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {

        if (l >= r) {
            return;
        }

        /* 优化思路
        // 在要排序的区间较小时, 因为归并排序的 merge 操作执行步骤较多, 反而使得插入排序更有优势
        // 该结论在大部分解释型语言有效, 编译型语言对递归有优化, 可能和预期的结果不一样, 因此此处不采用该方法
        if (r - l <= 15) {
            InsertionSort.sort(arr, l, r);
            return;
        }
        */

        // 求此区间的中间索引位置
        // int mid = (r - l) / 2;
        int mid = l + (r - l) / 2;

        // 对 arr 的左区间 arr[l, mid] 进行排序
        sort(arr, l, mid);
        // 对 arr 的右区间 arr[mid + 1, r] 进行排序
        sort(arr, mid + 1, r);

        // 将 arr 中的两个有序区间 arr[l, mid] 和 arr[mid + 1, r] 合并调整成一个有序区间 arr[l, r]
        // 只有在左区间存在比右区间大的元素时, 才需要排序
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r);
        }
    }

    // 此方法的宏观语义 (建议画图帮助理解):
    // 将 arr 中的两个有序区间 arr[l, mid] 和 arr[mid + 1, r] 合并调整成一个有序区间 arr[l, r]
    // 时间复杂度: O(n)
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r) {

        // 拷贝一个临时数组 (只拷贝 arr[l, r] 区间), 防止修改 arr 过程中原数据被覆盖.
        // 注意下标值对应关系:
        // arr[l] -> subArr[0]
        // arr[mid] -> subArr[mid - l]
        // arr[r] -> subArr[r - l]

        // subArr[0] -> arr[l]
        // subArr[mid - l] -> arr[mid]
        // subArr[r - l] -> arr[r]
        E[] subArr = Arrays.copyOfRange(arr, l, r + 1);

        // s1 和 s2 用于记录 subArr 左区间和右区间的当前索引, 初始化为区间的索引起始值
        int s1 = 0;
        int s2 = mid - l + 1;

        for (int i = l; i <= r; i++) {

            if (s1 > (mid - l)) {

                // 如果 subArr 的左区间 s1 已移动到中间位置后, 说明左区间已全部赋值完成, 则赋值右区间的 s2 值到 arr
                arr[i] = subArr[s2];
                s2++;

            } else if (s2 > (r - l)) {

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
        int s1 = l;
        int s2 = mid + 1;
        for (int i = l; i <= r; i++) {
            if (s1 > mid) {
                arr[i] = subArr[s2 - l];
                s2++;
            } else if (s2 > r) {
                arr[i] = subArr[s1 - l];
                s1++;
            } else if (subArr[s1 - l].compareTo(subArr[s2 - l]) < 0) {
                arr[i] = subArr[s1 - l];
                s1++;
            } else {
                arr[i] = subArr[s2 - l];
                s2++;
            }
        }
        */
    }

}
