package data;

import data.manager.ListEmployeeManager;
import data.manager.VectorEmployeeManager;

import static data.manager.EmployeeKeyboardReader.getUserChoice;

public class App {

    public static void welcomeMessage() {
        System.out.println("Welcome to Employee manager App!");
        System.out.println("\nFunctionalities:");
        System.out.println("1) Adding employee data(name, surname, gender);");
        System.out.println("2) Visualising added employee data;");
        System.out.println("3) Editing employee data;");
        System.out.println("4) Removing employee data;");
        System.out.println("5) Adding new employee data(name, surname, gender);");
        System.out.println();
    }

    public static void main(String[] args) {

        welcomeMessage();

        boolean xxx = false;

        if (getUserChoice() == 1) {

            ListEmployeeManager employeeList = new ListEmployeeManager();

            employeeList.create();

            while (!xxx) {
                int option = employeeList.userOption();

                switch (option) {

                    case 0:
                        System.exit(0);
                        break;

                    case 1:
                        employeeList = new ListEmployeeManager();
                        employeeList.create();
                        break;

                    case 2:
                        employeeList.view();
                        break;

                    case 3:
                        employeeList.update();
                        break;

                    case 4:
                        if (employeeList.delete() == 0) {
                            employeeList = new ListEmployeeManager();
                            employeeList.create();
                            break;

                        } else break;

                    case 5:
                        // employeeList = new ListEmployeeManager();
                        employeeList.add();
                        break;
                }
            }
        }

        else {

            VectorEmployeeManager employeeVector = new VectorEmployeeManager();

            employeeVector.create();

            while (!xxx) {
                int option = employeeVector.userOption();

                switch (option) {

                    case 0:
                        System.exit(0);
                        break;

                    case 1:
                        employeeVector = new VectorEmployeeManager();
                        employeeVector.create();
                        break;

                    case 2:
                        employeeVector.view();
                        break;

                    case 3:
                        employeeVector.update();
                        break;

                    case 4:
                        if (employeeVector.delete() == 0) {
                            employeeVector = new VectorEmployeeManager();
                            employeeVector.create();
                            break;

                        } else break;

                    default :
                        System.out.println("You didn't choose a proper option!");
                        System.out.println();
                }
            }
        }
    }
}
