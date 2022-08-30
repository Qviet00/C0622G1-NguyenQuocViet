package Case_Study.controllers;

import Case_Study.services.IsCustomerService;
import Case_Study.services.impl.Customerservices;
import Case_Study.utils.Checked;

public class CustomerController {
    private IsCustomerService isCustomerService = new Customerservices();

    public void customerManagement() {
        while (true) {
            System.out.println("------------------------------");
            System.out.println("BẢNG HIỂN THỊ MỤC CUSTOMER:");
            System.out.println("1. Display list customers.");
            System.out.println("2. Add new customer.");
            System.out.println("3. Edit customer.");
            System.out.println("4. Return main menu.");
            System.out.print("Mời nhập lựa chọn(1-4): ");
            double value = 0;
            value = Checked.checked(value,4,0);
            switch ((int) value) {
                case 1:
                    isCustomerService.displayListCustomers();
                    break;
                case 2:
                    isCustomerService.addNewCustomer();
                    break;
                case 3:
                    isCustomerService.editCustomer();
                    break;
                case 4:
                    return;
            }
        }
    }
}
