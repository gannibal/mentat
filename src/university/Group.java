package university;

import java.util.ArrayList;

/**
 * Created by Misha on 09.07.2015.
 */
public class Group {
    private String id;
    private ArrayList<Student> student = new ArrayList<Student>();

    public Group(String id, ArrayList<Student> students) {
        this.id = id;
        for (Student s : students) {
            try {
                student.add(s);
            } catch (NullPointerException e) {
            }

        }
    }

    public String getId() {
        return id;
    }

    public ArrayList getStudent() {
        ArrayList<Student> list = new ArrayList<Student>();
        for (Student st : student) {
            list.add(st);
        }
        return list;
    }
}
