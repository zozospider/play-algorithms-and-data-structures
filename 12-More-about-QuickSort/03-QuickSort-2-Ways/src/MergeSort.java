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

        // 临时数组, 用于 merge 方法, 防止修改 arr 过程中原数据被覆盖
        // 将 tmpArr 传入 merge 方法的方式, 可以避免每次在 merge 方法中创建临时数组对象, 因此该方式更优
        E[] tmpArr = Arrays.copyOfRange(arr, left, right + 1);

        sort(arr, 0, arr.length - 1, tmpArr);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int left, int right, E[] tmpArr) {

        if (left >= right) {
            return;
        }

        /* 优化思路
        // 在要排序的区间较小时, 因为归并排序的 merge 操作执行步骤较多, 反而使得插入排序更有优势
        // 该结论在大部分解释型语言有效, 编译型语言对递归有优化, 可能和预期的结果不一样, 因此此处不采用该方法
        if (right - left <= 15) {
            InsertionSort.sort(arr, left, right);
            return;
        }
        */

        // 求此区间的中间索引位置
        // int mid = (right - left) / 2;
        int mid = left + (right - left) / 2;

        // 对数组 arr 中的左区间 arr[left, mid] 进行排序
        sort(arr, left, mid, tmpArr);
        // 对数组 arr 中的右区间 arr[mid + 1, right] 进行排序
        sort(arr, mid + 1, right, tmpArr);

        // 将数组 arr 中的两个有序区间 arr[left, mid] 和 arr[mid + 1, right] 合并调整成一个有序区间 arr[left, right]
        // 只有在左区间存在比右区间大的元素时, 才需要排序
        if (arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, left, mid, right, tmpArr);
        }
    }

    // 此方法的宏观语义 (建议画图帮助理解):
    // 将数组 arr 中的两个有序区间 arr[left, mid] 和 arr[mid + 1, right] 合并调整成一个有序区间 arr[left, right]
    // 时间复杂度: O(n)
    private static <E extends Comparable<E>> void merge(E[] arr, int left, int mid, int right, E[] tmpArr) {

        // 将 arr 中的区间 arr[left, right] 拷贝到 tmpArr 中同样的区间 tmpArr[left, right]
        // 此逻辑一定要执行, 因为在执行 merge 前, tmpArr 中的区间 tmpArr[left, right] 是无序的
        // 因此 tmpArr 需要先与 arr 中的两个有序区间 arr[left, mid] 和 arr[mid + 1, right] 保持同步, 才能执行后面的逻辑
        // tmpArr[left, right] == arr[left, right]
        System.arraycopy(arr, left, tmpArr, left, right - left + 1);

        // t1 和 s2 用于记录 tmpArr 左区间和右区间的当前索引, 初始化为区间的索引起始值
        int t1 = left;
        int t2 = mid + 1;

        for (int i = left; i <= right; i++) {

            if (t1 > mid) {

                // 如果 tmpArr 的左区间 t1 已移动到中间位置后, 说明左区间已全部赋值完成, 则赋值右区间的 t2 值到 arr
                arr[i] = tmpArr[t2];
                t2++;

            } else if (t2 > right) {

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
