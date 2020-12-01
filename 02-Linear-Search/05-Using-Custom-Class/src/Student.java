public class Student {

    private String name;

    public Student(String name) {
        this.name = name;
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
        Student that = (Student) obj;
        return name.equals(that.name);
    }

}
