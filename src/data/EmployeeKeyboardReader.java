package data;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeKeyboardReader{

    // here is everything that is related to user choice

    Scanner sc = new Scanner(System.in);

    public String setEmployeeName() {
        System.out.print("Enter employee's name: ");
        String name = sc.nextLine();

        return name;
    }

    public String setEmployeeSurname() {
        System.out.print("Enter employee's surname: ");
        String surname = sc.nextLine();

        return surname;
    }

    public String setEmployeeGender() {
        boolean x = false;
        String gender = null;

        while (!x){
            System.out.print("Enter employee's gender (M or F): ");
            gender = sc.nextLine();

            if(gender.equalsIgnoreCase("M") ||  gender.equalsIgnoreCase("F")
                    || gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female")){
                x = true;
            }
        }

        return gender;
    }

    public Employee setEmployee() {
        return new Employee(setEmployeeName(), setEmployeeSurname(), setEmployeeGender());
    }


    public int getEmployeeNumber() {

        boolean num = false;
        int nr = 0;

        while(!num){
            try{
                System.out.print("\nEnter the number of employees you want to add: ");
                nr = sc.nextInt();
                if (nr < 1){
                    throw new NegativeArraySizeException();
                }
                num = true;
                sc.nextLine();

            } catch (NegativeArraySizeException | InputMismatchException ex){
                System.out.println("Enter a valid number of employees(a natural nonzero number)!");
                sc.nextLine();
            }
        }

        return nr;
    }

    public int getView(){
        boolean q = false;
        int answer = 0;

        while (!q){
            try{
                System.out.print("Do you want to see only one employee(1) or all employees(2)?: ");
                answer = sc.nextInt();

                if(answer == 1  || answer == 2) {
                    q = true;
                }

                sc.nextLine();

            } catch (InputMismatchException ex){
                System.out.println("Type correctly the answer(1/2) as required!");
                sc.nextLine();
                System.out.println();
            }

        }

        return answer;
    }

    public int getEmployeePosition(int nr){

        boolean qq = false;
        int employeeNumber = 0;

        while (!qq){
            try{
                System.out.print("Enter the employee ID: (from 1 to " + nr + "): ");
                employeeNumber = sc.nextInt();

                if (employeeNumber > 0 && employeeNumber <= nr) {
                    qq = true;
                }

                sc.nextLine();
                System.out.println();

            } catch (InputMismatchException ex){
                System.out.println("Enter the proper employee number (maximum employees: " + nr + ")!");
                sc.nextLine();
                System.out.println();
            }
        }

        return employeeNumber;
    }

    public int updateEmployee() {
        boolean qq = false;
        int choice = 0;

        while (!qq){
            try{
                System.out.print("Enter what you want to modify: ");
                System.out.print("0 - nothing, i'm good | 1 - name | 2 - surname | 3 - gender | 4 - all data: ");
                choice = sc.nextInt();

                if (choice >=0 && choice <=4 ) {
                    qq = true;
                }

                sc.nextLine();

            } catch (InputMismatchException ex){
                System.out.println("Enter the proper answer(0-4)!");
                sc.nextLine();
                System.out.println();
            }
        }

        return choice;
    }

    public int userOption() {
        int answer = 0;
        boolean xx = false;

        while (!xx) {
            try {
                System.out.print("Choose what action you want to do: ");
                System.out.println("0 - exit app, 1 - recreate new employee list, 2 - view employees, " +
                        "3 - update employees, 4 - delete employees:");

                answer = sc.nextInt();

                if (answer >= 0 && answer <= 4) {
                    xx = true;
                }

                sc.nextLine();

                System.out.println();

            } catch (InputMismatchException ex) {
                System.out.println("Type correctly the answer(0-4) as required!");
                sc.nextLine();
                System.out.println();
            }

        }

        return answer;
    }


}
