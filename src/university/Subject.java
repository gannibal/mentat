package university;

import java.util.ArrayList;

/**
 * Created by Misha on 09.07.2015.
 */
public class Subject {
    private String name;
    ArrayList<Teacher> whoCanRead = new ArrayList<Teacher>();

    public Subject(String name, ArrayList<Teacher> teacher) {
        this.name = name;
        for (Teacher s : teacher) {
            whoCanRead.add(s);
        }
    }

    public String getName() {
        return this.name;
    }

    public String getTeacher(int i) {
        return whoCanRead.get(i).getName();
    }

    public static void main(String[] args) {
        ArrayList<Teacher> teachers = new ArrayList<Teacher>();
        teachers.add(new Teacher("teacher"));
        Subject sub = new Subject("a", teachers);

        System.out.println(sub.name);
    }
}
