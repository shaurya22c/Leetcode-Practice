package BasicsJava;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;

public class arrayDequeDemo {

    static class Student {
        private int id;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        private String name;
    }

    public static void main(String[] args) {
        Deque<Student> dq= new ArrayDeque<>();
        Student s1= new Student(10, "Shaurya");
        Student s2= new Student(20, "Kishan");
        dq.add(s1);
        dq.add(s2);
        for(Student s: dq){
            System.out.println(s.toString());
        }
        dq.offerFirst(new Student(30, "Gotu"));
        dq.offerLast(new Student(40, "Shukla"));
    }
}
