// public class CSEStudent extends Student{
//     private String labName;
//     public CSEStudent(){
//         super();
       
//     }
//     public CSEStudent(String name, String dept, String labName){
//         super(name, dept);
//         this.labName = labName;
//     }
//     public void setLabName(String labName){
//         this.labName = labName;
//     }
//     public String getLabName(){
//         return this.labName;
//     }
//     public void setStudentName(String name){
//         super.name = name;
//     }
//     public void setStudentDept(String dept){
//         super.dept = dept;
//     }
//     public String getStudentName(){
//         return super.name;
//     }
//     public String getStudentDept(){
//         return super.dept;
//     }
// }


public class CSEStudent implements StudentInterface {
    //encapsulation
    private String name;
    private String dept;
    private String labName;

    //polymorphism-----
    public CSEStudent() {
    }

    public CSEStudent(String name, String dept, String labName) {
        this.name = name;
        this.dept = dept;
        this.labName = labName;
    }//----polymorphism

    public void setLabName(String labName) {
        this.labName = labName;
    }

    public String getLabName() {
        return this.labName;
    }

    @Override
    public void setStudentName(String name) {
        this.name = name;
    }

    @Override
    public void setStudentDept(String dept) {
        this.dept = dept;
    }

    @Override
    public String getStudentName() {
        return this.name;
    }

    @Override
    public String getStudentDept() {
        return this.dept;
    }
}
