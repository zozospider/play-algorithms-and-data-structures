public class Test {

    // 测试选择排序是否有效
    public static void main(String[] args) {

        Student[] students = {new Student("Amy", 88), new Student("Bob", 100), new Student("Ford", 66)};

        SelectionSort.sort(students);

        for (Student student : students) {
            System.out.print(student + " ");
        }
    }

}
