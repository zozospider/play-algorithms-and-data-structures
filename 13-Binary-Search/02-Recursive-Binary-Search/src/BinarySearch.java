// 二分查找
public class BinarySearch {

    private BinarySearch() {
    }

    // 二分查找
    // 时间复杂度: O(log n) = 1 + 1 + ... + 1
    public static <E extends Comparable<E>> int search(E[] data, E target) {

        return search(data, 0, data.length - 1, target);
    }

    // 在数组 arr 的区间 arr[left, right] 中查找 target 所在的索引, 如果 target 不存在则返回 -1
    private static <E extends Comparable<E>> int search(E[] data, int left, int right, E target) {

        if (left > right) {
            return -1;
        }

        // 求此区间的中间索引位置
        // int middle = (right - left) / 2;
        int middle = left + (right - left) / 2;

        if (target.compareTo(data[middle]) == 0) {

            // 如果 target 等于中间元素的值, 则说明 target 找到了, 返回中间元素的索引
            return middle;

        } else if (target.compareTo(data[middle]) > 0) {

            // 如果 target 大于中间元素的值, 则说明 target 在右区间, 查找并返回右区间 arr[middle + 1, right] 中 target 所在的索引
            return search(data, middle + 1, right, target);

        } else {

            // 如果 target 小于中间元素的值, 则说明 target 在左区间, 查找并返回左区间 arr[left, middle - 1] 中 target 所在的索引
            return search(data, left, middle - 1, target);
        }
    }

}
