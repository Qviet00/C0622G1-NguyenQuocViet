package Case_Study.controllers;

import Case_Study.utils.Checked;

public class FuramaController {
    CustomerController customer = new CustomerController();
    EmployeeController employee = new EmployeeController();
    FacilityController facility = new FacilityController();
    PromotionController promotion = new PromotionController();
    BookingController booking = new BookingController();

    public void displayMainMenu() {
        while (true) {
            System.out.println();
            System.out.println("*BẢNG HIỂN THỊ CHỨC NĂNG*");
            System.out.println("1.Employee Management.");
            System.out.println("2.Customer Management.");
            System.out.println("3.Facility Management.");
            System.out.println("4.Booking Management.");
            System.out.println("5.Promotion Management.");
            System.out.println("6.Exit.");
            System.out.print("Mời nhập lựa chọn(1-6): ");
            double value = 0;
            value = Checked.checked(value,6,0);
            switch ((int) value) {
                case 1:
                    employee.employeeManagement();
                    break;
                case 2:
                    customer.customerManagement();
                    break;
                case 3:
                    facility.facilityManagement();
                    break;
                case 4:
                    booking.bookingManagerment();
                    break;
                case 5:
                    promotion.promotionManagement();
                    break;
                case 6:
                    return;
            }
        }
    }
}
