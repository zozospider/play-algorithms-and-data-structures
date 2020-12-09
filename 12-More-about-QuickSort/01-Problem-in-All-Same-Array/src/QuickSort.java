import java.util.Random;

// 快速排序
public class QuickSort {

    private QuickSort() {
    }

    // 快速排序: 对数组 arr 进行排序
    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort1way(arr);
    }

    // 快速排序 (单路): 对数组 arr 进行排序
    public static <E extends Comparable<E>> void sort1way(E[] arr) {
        sort1way(arr, 0, arr.length - 1);
    }

    // 快速排序 (单路): 对数组 arr 中的区间 arr[left, right] 进行排序
    public static <E extends Comparable<E>> void sort1way(E[] arr, int left, int right) {
        sort1way(arr, left, right, new Random());
    }

    private static <E extends Comparable<E>> void sort1way(E[] arr, int left, int right, Random random) {

        if (left >= right) {
            return;
        }

        /* 优化思路
        // 在要排序的区间较小时, 因为快速排序的 partition 操作执行步骤较多, 反而使得插入排序更有优势
        // 该结论在大部分解释型语言有效, 编译型语言对递归有优化, 可能和预期的结果不一样, 因此此处不采用该方法
        if (right - left <= 15) {
            InsertionSort.sort(arr, left, right);
            return;
        }
        */

        // 对数组 arr 中的区间 arr[left, right] 进行分区, 得到标定点 v 的索引
        int p = partition1way(arr, left, right, random);

        // 对标定点 v 的左区间再 arr[left, p - 1] 进行分区
        sort1way(arr, left, p - 1, random);
        // 对标定点 v 的右区间再 arr[p + 1, right] 进行分区
        sort1way(arr, p + 1, right, random);
    }

    // 此方法的宏观语义 (建议画图帮助理解):
    // 对数组 arr 中的区间 arr[left, right] 进行分区, 确保标定点 v 左边的值小于 v, 右边的值大于 v, 并返回 v 对应的索引
    private static <E extends Comparable<E>> int partition1way(E[] arr, int left, int right, Random random) {

        // 初始化标定点:
        // 为了避免在处理有序数组 (或其他有规律的数组) 时, 递归深度增加到 n, 时间复杂度增加到 O(n^2), 不能将标定点的索引值设定为固定的索引位置的值
        int randomOffset = random.nextInt(right - left + 1);
        int randomIndex = left + randomOffset;
        // 确保随机获取的标定点的索引值交换到到当前区间的最左边, 交换值后, 标定点 v 就是当前区间的最左边的数: v = arr[left]
        swap(arr, left, randomIndex);

        int p = left;

        // 循环不变量: arr[left+1...p] < v; arr[p+1...i] >= v
        // 该循环不变量表示, 在 i 不断往右移动过程中, 确保从 left+1 到 p 的索引值都小于 v, 从 p+1 到 i 的索引值都大于等于 v
        for (int i = left + 1; i <= right; i++) {

            // 如果 arr[i] 大于等于 v, 则不需要处理, i++ 后继续下轮循环
            /*if (arr[i].compareTo(arr[left]) >= 0) {
                continue;
            }*/

            // 如果 arr[i] 小于 v, 则需要先将 p 往后移动一个位置, 然后将 i 和 p 的索引值交换, 以确保满足循环不变量
            if (arr[i].compareTo(arr[left]) < 0) {
                p++;
                swap(arr, i, p);
            }
        }

        // 将 left 和 p 的索引值交换, 以确保 v 移动到最后确定的 p 索引位置
        swap(arr, left, p);
        // 返回 v 的索引
        return p;
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
