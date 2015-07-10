package university;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Misha on 09.07.2015.
 */
public class Lecture {
    private long date;
    private Room room;
    private Teacher teacher;
    private Subject subject;
    private ArrayList<Group> groups = new ArrayList<Group>();

    public Lecture() {
        super();
    }

    public Lecture(Long date, Room room, Teacher teacher, Subject subject, ArrayList<Group> group) {
        this.date = date;
        this.room = room;
        this.teacher = teacher;
        this.subject = subject;
        for (Group s : group) {
            groups.add(s);
        }

    }

    public String getTeacher() {
        return teacher.getName();
    }

    public Long getDate() {
        return date;
    }

    public ArrayList<Group> getGroup() {
        return groups;
    }

    public String getSubject() {
        return subject.getName();
    }


}
