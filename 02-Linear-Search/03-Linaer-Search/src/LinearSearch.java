// 线性查找
public class LinearSearch {

    private LinearSearch() {
    }

    // 线性查找
    // 在数组 data 中查找 target 所在的索引, 如果 target 不存在则返回 -1
    public static int search(int[] data, int target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return i;
            }
        }
        return -1;
    }

}
