package university;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class ScheduleTest {
    Lecture firstLecture;
    Lecture secondLecture;
    Schedule schedule;

    @Before
    public void setUp() throws Exception {
        Long firstLectureDate= 1435738600000L;
        Long secondLectureDate = 1435798600000L;
        Room room = new Room("first");
        ArrayList<Teacher> teachers = new ArrayList<Teacher>();
        Teacher teacher = new Teacher("teacher");
        teachers.add(teacher);
        Subject sub = new Subject(("subject"), teachers);
        ArrayList<Student> students = new ArrayList<Student>();
        students.add(new Student("stud", 1));
        students.add(new Student("stud1", 2));
        ArrayList<Group> group = new ArrayList<Group>();
        group.add(new Group("1-a", students));

        firstLecture = new Lecture(firstLectureDate, room, teacher, sub, group);
        secondLecture = new Lecture(secondLectureDate, room, teacher, sub, group);

        ArrayList<Lecture> lectures = new ArrayList<Lecture>();
        lectures.add(firstLecture);
        lectures.add(secondLecture);
        schedule = new Schedule(lectures);

    }

    @Test
    public void testGetDailyLectures() throws Exception {
        ArrayList<Lecture> expected = new ArrayList<Lecture>();
        expected.add(firstLecture);
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