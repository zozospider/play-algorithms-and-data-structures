import java.util.Random;

// 数组生成器
public class ArrayGenerator {

    private ArrayGenerator() {
    }

    // 生成一个长度为 n 的有序数组
    public static Integer[] generateOrderedArray(int n) {

        Integer[] arr = new Integer[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        return arr;
    }

    // 生成一个长度为 n 的随机数组, 每个数字的范围是 [0, bound)
    public static Integer[] generateRandomArray(int n, int bound) {

        Integer[] arr = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(bound);
        }
        return arr;
    }

}
