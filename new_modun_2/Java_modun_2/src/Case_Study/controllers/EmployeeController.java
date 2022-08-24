package Case_Study.controllers;

import Case_Study.services.IsEmployeeService;
import Case_Study.services.impl.Employeeservices;
import Case_Study.utils.Checked;

public class EmployeeController {
    private IsEmployeeService isEmployeeManagement = new Employeeservices();

    public void employeeManagement() {
        while (true) {
            System.out.println("----------------------------------");
            System.out.println("BẢNG HIỂN THỊ MỤC EMPLOYEE:");
            System.out.println("1. Display list employees.");
            System.out.println("2. Add new employee.");
            System.out.println("3. Edit employee.");
            System.out.println("4. Return main menu.");
            System.out.print(" Mời Nhập lựa chọn(1-4): ");
            double value = 0;
            value = Checked.checked(value, 4);
            switch ((int) value) {
                case 1:
                    isEmployeeManagement.displayListEmployees();
                    break;
                case 2:
                    isEmployeeManagement.addNewEmployee();
                    break;
                case 3:
                    isEmployeeManagement.editEmployee();
                    break;
                case 4:
                    return;
            }
        }
    }
}
