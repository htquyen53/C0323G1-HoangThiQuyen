package ss5.bai_tap.writeonly_class_construction_in_java;

public class TestStudent {
    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student);
        student.setName("An");
        student.setClasses("C0323G1");
        System.out.println(student);
    }
}
