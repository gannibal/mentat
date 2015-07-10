package university;

/**
 * Created by Misha on 09.07.2015.
 */
public class Student {
    private String name;
    private int studentRecordBook;
    public Student(String name, int book){
        this.name=name;
        this.studentRecordBook=book;
    }
    public String getName(){
        return this.name;
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
