// 快速排序
public class QuickSort {

    private QuickSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    // 快速排序: 对 arr 的区间 arr[l, r] 进行排序
    public static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {

        if (l >= r) {
            return;
        }

        // 对 arr 中的区间 arr[l, r] 进行分区, 得到标定点 v 的索引
        int p = partition(arr, l, r);

        // 对标定点 v 的左区间再 arr[l, p - 1] 进行分区
        sort(arr, l, p - 1);
        // 对标定点 v 的右区间再 arr[p + 1, r] 进行分区
        sort(arr, p + 1, r);
    }

    // 此方法的宏观语义 (建议画图帮助理解):
    // 对 arr 中的区间 arr[l, r] 进行分区, 确保标定点 v 左边的值小于 v, 右边的值大于 v, 并返回 v 对应的索引
    private static <E extends Comparable<E>> int partition(E[] arr, int l, int r) {

        // 将标定点 v 初始化为当前范围内的第一个数: v = arr[l]
        int p = l;

        // 循环不变量: arr[l+1...p] < v; arr[p+1...i] >= v
        // 该循环不变量表示, 在 i 不断往右移动过程中, 确保从 l+1 到 p 的索引值都小于 v, 从 p+1 到 i 的索引值都大于等于 v
        for (int i = l + 1; i <= r; i++) {

            // 如果 arr[i] 大于等于 v, 则不需要处理, i++ 后继续下轮循环
            /*if (arr[i].compareTo(arr[l]) >= 0) {
                continue;
            }*/

            // 如果 arr[i] 小于 v, 则需要先将 p 往后移动一个位置, 然后将 i 和 p 的索引值交换, 以确保满足循环不变量
            if (arr[i].compareTo(arr[l]) < 0) {
                p++;
                swap(arr, i, p);
            }
        }

        // 将 l 和 p 的索引值交换, 以确保 v 移动到最后确定的 p 索引位置
        swap(arr, l, p);
        // 返回 v 的索引
        return p;
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
