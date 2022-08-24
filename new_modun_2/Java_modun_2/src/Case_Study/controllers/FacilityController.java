package Case_Study.controllers;

import Case_Study.services.IsFacilityService;
import Case_Study.services.impl.Facilitiservices;
import Case_Study.utils.Checked;

public class FacilityController {
    private IsFacilityService isFacilityService =new Facilitiservices();
    public void facilityManagement(){
        while (true){
            System.out.println("--------------------------");
            System.out.println("BẢNG HIỂN THỊ MỤC FACILITY:");
            System.out.println("1. Display list facility.");
            System.out.println("2. Add new facility.");
            System.out.println("3. Display list facility maintenance.");
            System.out.println("4. Return main menu.");
            System.out.print("Mời nhập lựa chọn(1-4): ");
            double value=0;
            value= Checked.checked(value,4);
            switch ((int) value){
                case 1:
                    isFacilityService.displayListFacility();
                    break;
                case 2:
                    isFacilityService.addNewFacility();
                    break;
                case 3:
                    isFacilityService.displayListFacilityMaintenance();
                case 4:
                    return;
            }
        }
    }
}
