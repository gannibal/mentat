package university;

import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class ScheduleTest {
    Lecture l;
    Lecture l1;
    Schedule schedule;

    @Before
    public void setUp() throws Exception {
        Long d = 1435738600000L;
        Long d1 = 1435798600000L;
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String date = sdf.format(d);
        Room r = new Room("first");
        ArrayList<Teacher> teachers = new ArrayList<Teacher>();
        Teacher teacher = new Teacher("teacher");
        teachers.add(teacher);
        Subject sub = new Subject(("subject"), teachers);
        ArrayList<Student> students = new ArrayList<Student>();
        students.add(new Student("stud", 1));
        students.add(new Student("stud1", 2));
        ArrayList<Group> group = new ArrayList<Group>();
        group.add(new Group("1-a", students));

        l = new Lecture(d, r, teacher, sub, group);
        l1 = new Lecture(d1, r, teacher, sub, group);

        ArrayList<Lecture> lectures = new ArrayList<Lecture>();
        lectures.add(l);
        lectures.add(l1);
        schedule = new Schedule(lectures);

    }

    @Test
    public void testGetDailyLectures() throws Exception {
        ArrayList<Lecture> expected = new ArrayList<Lecture>();
        expected.add(l);
        ArrayList<Lecture> actual = schedule.getDailyLectures(1435738600000L);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetGroupSchedule() throws Exception {
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("subject teacher");
        ArrayList<String> actual = new ArrayList<String>();
        for (String s : schedule.getGroupSchedule("1-a")) {
            actual.add(s);
        }
        assertEquals(expected, actual);

    }

    @Test(expected = NullPointerException.class)
    public void exceptionTest() {
        ArrayList<Lecture> list = null;
        Schedule sc = new Schedule(list);
    }
}