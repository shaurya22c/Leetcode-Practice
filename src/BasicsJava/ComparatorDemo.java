package BasicsJava;
import java.util.*;
public class ComparatorDemo {
    public static void main(String[] args) {
        List<Student> l= new ArrayList<>();
        Student s1= new Student("Adam", 3.5);
        Student s2= new Student("Joy", 4.0);
        Student s3= new Student("Joy", 3.9);
        Student s4= new Student("Zack", 3.2);
        l.add(s1);
        l.add(s2);
        l.add(s3);
        l.add(s4);
        System.out.println("Sorting by name:");
        Collections.sort(l, new NameComparator());
        for(int i=0; i<l.size(); i++){
            System.out.println(" "+l.get(i));
        }

        System.out.println("Sorting by cgpa:");
        Collections.sort(l, new CgpaComparator());
        for(int i=0; i<l.size(); i++){
            System.out.println(" "+l.get(i));
        }
        Comparator<Student> comparatorDemoObject= Comparator.comparing(Student::getName).thenComparing(Student::getCgpa);
        Collections.sort(l, comparatorDemoObject);
        System.out.println("After using comparator demo object");
        for(int i=0; i<l.size(); i++){
            System.out.println(" "+l.get(i));
        }
    }
}
