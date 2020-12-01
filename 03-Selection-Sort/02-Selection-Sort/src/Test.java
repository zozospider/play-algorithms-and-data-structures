public class Test {

    // 测试选择排序是否有效
    public static void main(String[] args) {

        int[] arr = {1, 4, 2, 3, 6, 5};

        int[] newArr = SelectionSortMoreSpace.sort(arr);
        for (int i : newArr) {
            System.out.print(i + " ");
        }

        System.out.println();
        System.out.println("------");

        SelectionSort.sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}
