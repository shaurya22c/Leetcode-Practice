package BasicsJava;
import java.util.*;
public class CgpaComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2){
            if(s1.getCgpa()> s2.getCgpa()) return 1;
            else if(s1.getCgpa()== s2.getCgpa()) return 0;
            else return -1;
    }
}
