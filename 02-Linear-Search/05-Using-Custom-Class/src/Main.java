public class Main {

    public static void main(String[] args) {

        Student[] students = {new Student("Amy"), new Student("Bob"), new Student("Car")};

        int res = LinearSearch.search(students, new Student("Bob"));
        System.out.println(res);

        int res2 = LinearSearch.search(students, new Student("Ford"));
        System.out.println(res2);
    }

}
