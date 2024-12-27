abstract class Student{
    protected String name;
    protected String dept;
    public Student(){

    }
    public Student(String name, String dept){
        this.name = name;
        this.dept = dept;
    }
    abstract void setStudentName(String name);
    abstract void setStudentDept(String dept);
    abstract String getStudentName();
    abstract String getStudentDept();
}