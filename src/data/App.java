package data;

public class App {

    public static void welcomeMessage() {
        System.out.println("Welcome to Employee manager App!");
        System.out.println("\nFunctionalities:");
        System.out.println("1) Adding employee data(name, surname, gender);");
        System.out.println("2) Visualising added employee data;");
        System.out.println("3) Editing employee data;");
        System.out.println("4) Removing employee data.");
    }

    public static void main(String[] args) {

        welcomeMessage();

        boolean xxx = false;

        EmployeeManager employee = new EmployeeManager();
        employee.create();

        while (!xxx)
        {
            int option = employee.userOption();

            switch (option) {

                case 0 : System.exit(0); break;

                case 1 : employee = new EmployeeManager(); employee.create(); break;

                case 2 : employee.view(); break;

                case 3 : employee.update(); break;

                case 4 :
                    if (employee.delete() == 0 ){
                        employee = new EmployeeManager(); employee.create(); break;
                    }

                    else break;
            }
        }

    }
}
