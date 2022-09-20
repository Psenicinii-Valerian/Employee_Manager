package data;

public class EmployeeManager extends EmployeeKeyboardReader {

    // here is everything that is related with actions on employees

    private EmployeeKeyboardReader employeeReader = new EmployeeKeyboardReader();
    private int empNumber = this.employeeReader.getEmployeeNumber();
    private int empPosition;
    private Employee[] emp = new Employee[this.empNumber];

    public void create() {

        for (int i = 0; i < this.emp.length; i++) {

            System.out.println("\nEmployee number: " + (i+1) );

            this.emp[i] = this.employeeReader.setEmployee();

        }

        System.out.println();
    }

    public void view() {

        int answer = this.employeeReader.getView();

        switch (answer) {

            case 1:
                boolean qq = false;

                this.empPosition = this.employeeReader.getEmployeePosition(this.empNumber);

                if (this.emp[this.empPosition - 1] != null) {
                    System.out.println("Employee number: " + (this.empPosition));
                    System.out.println("Name: " + this.emp[this.empPosition - 1].getName());
                    System.out.println("Surname: " + this.emp[this.empPosition - 1].getSurname());
                    System.out.println("Gender: " + this.emp[this.empPosition - 1].getGender());
                    System.out.println();
                }
                break;


            case 2:
                for (int i = 0; i < this.empNumber; i++) {
                    if (this.emp[i] != null){
                        System.out.println("Employee number: " + (i + 1));
                        System.out.println("Name: " + this.emp[i].getName());
                        System.out.println("Surname: " + this.emp[i].getSurname());
                        System.out.println("Gender: " + this.emp[i].getGender());
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

                case 1 : this.emp[index-1].setName(this.employeeReader.setEmployeeName()); break;

                case 2 : this.emp[index-1].setSurname(this.employeeReader.setEmployeeSurname()); break;

                case 3 : this.emp[index-1].setGender(this.employeeReader.setEmployeeGender()); break;

                case 4 : this.emp[index-1] = this.employeeReader.setEmployee(); break;

            }

            System.out.println();
        }

    }

    public int delete() {

        System.out.println("You chose to delete an employee! Be careful!!!");
        for (int i = employeeReader.getEmployeePosition(this.empNumber); i < this.emp.length; i++) {
            this.emp[i-1] = this.emp[i];
        }

        this.emp[this.emp.length-1] = null;
        this.empNumber -= 1;

        if(this.empNumber == 0) {
            System.out.println("\nYOU DELETED ALL THE EMPLOYEES!!! Please create some or app will not function properly!");
            return 0;
        }

        return 1;
    }

}
