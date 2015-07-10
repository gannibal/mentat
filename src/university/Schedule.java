package university;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by Misha on 09.07.2015.
 */
public class Schedule {
    private ArrayList<Lecture> lectures = new ArrayList<Lecture>();

    public Schedule(ArrayList<Lecture> lectures) {
        for (Lecture s : lectures) {
            this.lectures.add(s);
        }
    }

    public ArrayList<Lecture> getDailyLectures(long date) {
        ArrayList<Lecture> dailyLectures = new ArrayList<Lecture>();
        for (Lecture lecture : lectures) {
            if (lecture.getDate().equals(date))
                dailyLectures.add(lecture);
        }
        return dailyLectures;
    }

    public ArrayList<String> getGroupSchedule(String groupId) {
        ArrayList<String> groupLectures = new ArrayList<String>();
        for (Lecture lecture : lectures) {
            ArrayList<Group> temp = lecture.getGroup();
            for (Group g : temp) {
                if (g.getId().equals(groupId))
                    groupLectures.add(lecture.getSubject() + " " + lecture.getTeacher());
            }

        }
        return groupLectures;
    }

}

