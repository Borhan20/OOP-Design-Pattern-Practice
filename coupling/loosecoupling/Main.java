
public class Main{
    public static void main(String[] args){
        Subject s = new Subject();
        s.setSubject("math", "algebra");
        System.out.println(s.getSubject());
    }
}

class Subject{
    private String name;
    Topic t = new Topic();
    public void Subject(String name){
        this.name = name;
    }
    public void setSubject(String name, String topic){
        this.name = name;
        t.setTopic(topic);
        System.out.println("Subject is set");
    }
    public String getSubject(){
        return "subject: "+name+", topic: "+ t.getTopic();
    }
}

class Topic{
    private String name;
    public void Topic(){

    }
    public void setTopic(String name){
        this.name = name;
        System.out.println("Topic is set");

    }
    public String getTopic(){
        return name;
    }

}


public class Main{
    public static void main(String[] args){
        Subject s = new Subject();
        s.setSubject("math", "algebra");
        System.out.println(s.getSubject());
    }
}

class Subject{
    private String name;
    Topic t = new Topic();
    public void Subject(String name){
        this.name = name;
    }
    public void setSubject(String name, String topic){
        this.name = name;
        t.setTopic(topic);
        System.out.println("Subject is set");
    }
    public String getSubject(){
        return "subject: "+name+", topic: "+ t.getTopic();
    }
}

//loose coupling using interface
interface Topic{
    public void setTopic(String name);
    public String getTopic();
}

class Algebra implements Topic{
    private String name;
    public void Topic(){

    }
    public void setTopic(String name){
        this.name = name;
        System.out.println("Topic is set");

    }
    public String getTopic(){
        return name;
    }

}

