import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        // 创建一个长度为 10, 元素为 int 的数组
        int[] arr = new int[10];
        // 遍历数组, 赋值
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        System.out.println(Arrays.toString(arr));

        System.out.println("------");

        // 创建一个长度为 3, 元素为 int 的数组, 并已赋值
        int[] scores = {100, 99, 66};
        // 遍历数组, 输出
        for (int i = 0; i < scores.length; i++) {
            System.out.println(scores[i]);
        }

        System.out.println("------");

        // 遍历数组, 输出
        for (int score : scores) {
            System.out.println(score);
        }

        System.out.println("------");

        // 修改数组某个元素值
        scores[0] = 98;
        // 遍历数组, 输出
        for (int i = 0; i < scores.length; i++) {
            System.out.println(scores[i]);
        }
    }

}
