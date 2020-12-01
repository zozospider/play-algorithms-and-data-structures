// 选择排序法 - 占用更多空间方式
public class SelectionSortMoreSpace {

    private SelectionSortMoreSpace() {
    }

    // 选择排序
    public static int[] sort(int[] arr) {

        // 排序后的数组
        int[] newArr = new int[arr.length];
        // 标记数组中每个索引是否已拷贝到排序后的数组
        boolean[] markArr = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {

            int minIndex = -1;
            for (int m = 0; m < arr.length; m++) {
                if (!markArr[m]) {
                    minIndex = m;
                    break;
                }
            }
            if (minIndex == -1) {
                System.out.println("ERROR!");
            }

            for (int j = 0; j < arr.length; j++) {
                if (!markArr[j] && arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            markArr[minIndex] = true;
            newArr[i] = arr[minIndex];
        }

        return newArr;
    }

}
