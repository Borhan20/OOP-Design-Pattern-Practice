public class MainClass{
    public static void main(String[] args){

        StudentInterface student1 = new CSEStudent("John", "CSE", "CSE Lab");
        StudentInterface student2 = new CSEStudent();

        System.out.println("Student1 Name: " + student1.getStudentName());
        System.out.println("Student1 Department: " + student1.getStudentDept());
        // System.out.println("Student1 Lab Name: " + student1.getLabName());

        student2.setStudentName("Jane");
        student2.setStudentDept("CSE");
        // student2.setLabName("CSE Lab");

        System.out.println("Student1 Name: " + student2.getStudentName());
        System.out.println("Student1 Department: " + student2.getStudentDept());
        // System.out.println("Student1 Lab Name: " + student2.getLabName());
    }
}