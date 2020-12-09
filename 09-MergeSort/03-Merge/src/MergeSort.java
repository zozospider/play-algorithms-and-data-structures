import java.util.Arrays;

// 归并排序
public class MergeSort {

    private MergeSort() {
    }

    private static <E extends Comparable<E>> void sort(E[] arr) {

    }

    // 此方法的宏观语义 (重点关注):
    // 将数组 arr 中的两个有序区间 arr[left, middle] 和 arr[middle + 1, right] 合并调整成一个有序区间 arr[left, right]
    // (建议画图帮助理解各个步骤的执行顺序)
    private static <E extends Comparable<E>> void merge(E[] arr, int left, int middle, int right) {

        // 拷贝一个临时数组 (只拷贝 arr[left, right] 区间), 防止修改 arr 过程中原数据被覆盖
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
            } else if (s2 > right) {
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
