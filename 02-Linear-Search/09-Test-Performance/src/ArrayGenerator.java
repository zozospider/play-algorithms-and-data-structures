// 数组生成器
public class ArrayGenerator {

    private ArrayGenerator() {
    }

    // 生成一个长度为 n 的有序数组
    public static Integer[] generateOrderedArray(int capacity) {
        Integer[] arr = new Integer[capacity];
        for (int i = 0; i < capacity; i++) {
            arr[i] = i;
        }
        return arr;
    }

}
