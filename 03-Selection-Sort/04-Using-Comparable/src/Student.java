public class Student implements Comparable<Student> {

    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Student student = (Student) obj;
        return name.equals(student.name);
    }

    @Override
    public int compareTo(Student o) {
        if (score < o.score) {
            return -1;
        } else if (score == o.score) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

}
