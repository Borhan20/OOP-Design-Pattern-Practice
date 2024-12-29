import java.util.List;
import java.util.ArrayList;
public class Main{
    public static void main(String[] args){
        //one to one association
        Passport p = new Passport();
        p.setNumber("123456");
        Person person = new Person();
        person.setName("John");
        person.setPassport(p);
        System.out.println("name: "+person.getName()+" has passport number "+person.getPassport());

        //one to many association
        Mobile m1 = new Mobile();
        m1.setNumber("123456");
        Mobile m2 = new Mobile();
        m2.setNumber("123457");
        person.addMobile(m1);
        person.addMobile(m2);
        System.out.println("name: "+person.getName()+
        " has mobile numbers "+person.getMobiles().get(0).getNumber()+
        " and "+person.getMobiles().get(1).getNumber());

        //many to many association
        Address a1 = new Address();
        a1.setAddress("123 Main St");
        Address a2 = new Address();
        a2.setAddress("456 Main St");
        person.addAddress(a1);
        person.addAddress(a2);
        Person person2 = new Person();
        person2.setName("Jane");
        person2.addAddress(a1);
        person2.addAddress(a2);  
        a1.addPerson(person);
        a1.addPerson(person2);
        System.out.println("name: "+person.getName()+ " lives at "
        +person.getAddresses().get(0).getAddress()+ 
        " and "+person.getAddresses().get(1).getAddress());
        System.out.println("address1:lives people: "+a1.getPersons().get(0).getName()+
        " and "+a1.getPersons().get(1).getName());
    }
}




class Person{
    private String name;
    private String passport;
    public List<Mobile> mobiles = new ArrayList<Mobile>();
    public List<Address> addresses = new ArrayList<Address>();
    public void setName(String name){
        this.name = name;
    }

    public void setPassport(Passport passport){
        this.passport = passport.getNumber();
    }
    public String getPassport(){
        return this.passport;
    }
    public String getName(){
        return this.name;
    }
    public void addMobile(Mobile mobile){
        this.mobiles.add(mobile);
    }
    public List<Mobile> getMobiles(){
        return this.mobiles;
    }
    public void addAddress(Address address){
        this.addresses.add(address);
    }
    public List<Address> getAddresses(){
        return this.addresses;
    }
}

class Passport{
    private String number;
    public void setNumber(String number){
        this.number = number;
    }
    public String getNumber(){
        return this.number;
    }
}

class Mobile{
    private String number;
    public void setNumber(String number){
        this.number = number;
    }
    public String getNumber(){
        return this.number;
    }
}

class Address{
    private String address;
    private List<Person> persons = new ArrayList<Person>();
    public void setAddress(String address){
        this.address = address;
    }
    public String getAddress(){
        return this.address;
    }
    public void addPerson(Person person){
        this.persons.add(person);
    }
    public List<Person> getPersons(){
        return this.persons;
    }
}