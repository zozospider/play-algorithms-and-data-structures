import java.util.Arrays;

// 归并排序
public class MergeSort {

    private MergeSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {

        // 对 arr 进行排序
        sort(arr, 0, arr.length - 1);
    }

    // 归并排序: 对 arr 的区间 arr[l, r] 进行排序
    // 时间复杂度 (忽略底数): O(n log n) = O(n log 2 n)
    // 最快复杂度 (有序时): O(n) = O(2n) = O(n + n/2 + n/4 + n/8 + ... + 1)
    public static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {

        // 临时数组, 用于 merge 方法, 防止修改 arr 过程中原数据被覆盖
        // 将 tmpArr 传入 merge 方法的方式, 可以避免每次在 merge 方法中创建临时数组对象, 因此该方式更优
        E[] tmpArr = Arrays.copyOfRange(arr, l, r + 1);

        // 对 arr 进行排序
        sort(arr, 0, arr.length - 1, tmpArr);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r, E[] tmpArr) {

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
        sort(arr, l, mid, tmpArr);
        // 对 arr 的右区间 arr[mid + 1, r] 进行排序
        sort(arr, mid + 1, r, tmpArr);

        // 将 arr 中的两个有序区间 arr[l, mid] 和 arr[mid + 1, r] 合并调整成一个有序区间 arr[l, r]
        // 只有在左区间存在比右区间大的元素时, 才需要排序
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r, tmpArr);
        }
    }

    // 此方法的宏观语义 (建议画图帮助理解):
    // 将 arr 中的两个有序区间 arr[l, mid] 和 arr[mid + 1, r] 合并调整成一个有序区间 arr[l, r]
    // 时间复杂度: O(n)
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r, E[] tmpArr) {

        // 将 arr 中的区间 arr[l, r] 拷贝到 tmpArr 中同样的区间 tmpArr[l, r]
        // 此逻辑一定要执行, 因为在执行 merge 前, tmpArr 中的区间 tmpArr[l, r] 是无序的
        // 因此 tmpArr 需要先与 arr 中的两个有序区间 arr[l, mid] 和 arr[mid + 1, r] 保持同步, 才能执行后面的逻辑
        // tmpArr[l, r] == arr[l, r]
        System.arraycopy(arr, l, tmpArr, l, r - l + 1);

        // t1 和 s2 用于记录 tmpArr 左区间和右区间的当前索引, 初始化为区间的索引起始值
        int t1 = l;
        int t2 = mid + 1;

        for (int i = l; i <= r; i++) {

            if (t1 > mid) {

                // 如果 tmpArr 的左区间 t1 已移动到中间位置后, 说明左区间已全部赋值完成, 则赋值右区间的 t2 值到 arr
                arr[i] = tmpArr[t2];
                t2++;

            } else if (t2 > r) {

                // 如果 tmpArr 的右区间 t2 已移动到尾部位置后, 说明右区间已全部赋值完成, 则赋值左区间的 t1 值到 arr
                arr[i] = tmpArr[t1];
                t1++;

            } else if (tmpArr[t1].compareTo(tmpArr[t2]) < 0) {

                // 如果 tmpArr 的左区间 t1 值小于右区间 t2 值, 则赋值左区间的 t1 值到 arr
                arr[i] = tmpArr[t1];
                t1++;

            } else {

                // 如果 tmpArr 的右区间 t2 值小于左区间 t1 值, 则赋值右区间的 t2 值到 arr
                arr[i] = tmpArr[t2];
                t2++;
            }
        }
    }

}
