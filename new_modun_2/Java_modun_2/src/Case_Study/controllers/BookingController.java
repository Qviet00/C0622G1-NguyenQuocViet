package Case_Study.controllers;

import Case_Study.services.IsBookingService;
import Case_Study.services.impl.Bookingservices;
import Case_Study.utils.Checked;

public class BookingController {
    private IsBookingService isBookingService = new Bookingservices();

    public void bookingManagerment() {
        while (true) {
            System.out.println("-----------------------------");
            System.out.println("BẢNG HIỆN THỊ MỤC BOOKING:");
            System.out.println("1. Add new booking.");
            System.out.println("2. Display list booking.");
            System.out.println("3. Create new constracts.");
            System.out.println("4. Display list contracts.");
            System.out.println("5. Edit contracts.");
            System.out.println("6. Return main menu.");
            System.out.print("Mời nhập lựa chọn(1-6): ");
            double value = 0;
            value = Checked.checked(value, 6);
            switch ((int) value) {
                case 1:
                    isBookingService.addNewBooking();
                    break;
                case 2:
                    isBookingService.displayListBooking();
                    break;
                case 3:
                    isBookingService.createNewConstracts();
                    break;
                case 4:
                    isBookingService.displayListcontracts();
                    break;
                case 5:
                    isBookingService.editContracts();
                    break;
                case 6:
                    return;
            }
        }
    }
}
