package data.manager;

import java.util.ArrayList;

public class ListEmployeeManager extends EmployeeKeyboardReader implements EmployeeManager {

    // here is everything that is related with actions on employees

    private EmployeeKeyboardReader employeeReader = new EmployeeKeyboardReader();
    private int empNumber = this.employeeReader.getEmployeeNumber();
    private int empPosition;
    private ArrayList<Employee> emp = new ArrayList<Employee>(this.empNumber);

    public void create() {

        for (int i = 0; i < this.empNumber; i++) {

            System.out.println("\nEmployee number: " + (i+1) );

            this.emp.add( i, this.employeeReader.setEmployee() );
        }

        System.out.println();
    }

    public void view() {

        int answer = this.employeeReader.getView();

        switch (answer) {

            case 1:
                boolean qq = false;

                this.empPosition = this.employeeReader.getEmployeePosition(this.empNumber);

                if (this.emp.get(this.empPosition - 1) != null) {
                    System.out.println("Employee number: " + (this.empPosition));
                    System.out.println("Name: " + this.emp.get(this.empPosition - 1).getName());
                    System.out.println("Surname: " + this.emp.get(this.empPosition - 1).getSurname());
                    System.out.println("Gender: " + this.emp.get(this.empPosition - 1).getGender());
                    System.out.println();
                }
                break;


            case 2:
                for (int i = 0; i < this.empNumber; i++) {
                    if (this.emp.get(i) != null){
                        System.out.println("Employee number: " + (i + 1));
                        System.out.println("Name: " + this.emp.get(i).getName());
                        System.out.println("Surname: " + this.emp.get(i).getSurname());
                        System.out.println("Gender: " + this.emp.get(i).getGender());
                        System.out.println();
                    }
                }
                break;
        }

    }


    public void update() {
        System.out.println("You chose to update(modify) an employee! Be careful!");
        int index = this.employeeReader.getEmployeePosition(this.empNumber);

        boolean xx = false;

        while (!xx){
            int choice = this.employeeReader.updateEmployee();

            switch (choice) {

                case 0 : xx = true; break;

                case 1 : this.emp.get(index-1).setName( this.employeeReader.setEmployeeName()); break;

                case 2 : this.emp.get(index-1).setSurname(this.employeeReader.setEmployeeSurname()); break;

                case 3 : this.emp.get(index-1).setGender(this.employeeReader.setEmployeeGender()); break;

                case 4 : this.emp.get(index-1).equals( this.employeeReader.setEmployee() ); break;

            }

            System.out.println();
        }

    }

    public int delete() {

        System.out.println("You chose to delete an employee! Be careful!!!");
        for (int i = employeeReader.getEmployeePosition(this.empNumber); i < this.empNumber; i++) {
            this.emp.get(i-1).equals( this.emp.get(i) );
        }

        this.emp.get(this.empNumber-1).equals(null);
        this.empNumber -= 1;

        if(this.empNumber == 0) {
            System.out.println("\nYOU DELETED ALL THE EMPLOYEES!!! Please create some or app will not function properly!");
            return 0;
        }

        return 1;
    }

    public void add(){

        int start = this.empNumber;

        this.empNumber += this.employeeReader.getEmployeeNumber();

        for (int i = start; i < this.empNumber; i++) {

            System.out.println("\nEmployee number: " + (i+1) );

            this.emp.add( i, this.employeeReader.setEmployee() );
        }

        System.out.println();

    }


}
