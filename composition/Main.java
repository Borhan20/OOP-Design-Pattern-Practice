import java.util.List;
import java.util.ArrayList;
public class Main{
    public static void main(String[] args){
        Course c = new Course();
        c.setName("liniar algebra");
        Dept d = new Dept();
        d.setName("CSE");
        d.addCourses(c); 
        System.out.println("Department: "+d.getName()+ ", Courses: "+d.getCourses().get(0).getName());
    }
}

class Dept{
    private String name;
    private List<Course> courses = new ArrayList<Course>();

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void addCourses(Course course){
        this.courses.add(course);
    }
    public List<Course> getCourses(){
        return this.courses;
    }

}

class Course{
    private String name;
    public void setName(String name){
        this.name = name;
    }  
    public String getName(){
        return this.name;
    }
}