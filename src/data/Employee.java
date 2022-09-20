package data;

public class Employee {

    // here are the employees themselves (and some necessary methods for processing them)

    private String name;
    private String surname;
    private String gender;

    public Employee() {

    }

    public Employee(int param, String variable){
        switch (param) {
            case 1 : this.name = variable; break;
            case 2 : this.surname = variable; break;
            case 3 : this.gender = variable; break;
        }
    }

    public Employee(String name, String surname, String gender){
        this.name = name;
        this.surname = surname;
        this.gender = gender;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public String getSurname(){
        return this.surname;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public String getGender(){
        return this.gender.toUpperCase();
    }

}
