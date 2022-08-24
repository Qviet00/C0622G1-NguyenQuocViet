package Case_Study.controllers;


import Case_Study.services.IsPromotionService;
import Case_Study.services.impl.Promtionservices;
import Case_Study.utils.Checked;

public class PromotionController {
    private IsPromotionService isPromotionService = new Promtionservices();
    public  void promotionManagement(){
        while (true){
            System.out.println("-------------------------");
            System.out.println("BẢNG HIỂN THỊ MỤC PROMOTION:");
            System.out.println("1. Display list customers use service.");
            System.out.println("2. Display list customers get voucher.");
            System.out.println("3. Return main menu.");
            System.out.print("Mời nhập lựa chọn(1-3): ");
            double value = 0;
            value=Checked.checked(value,3);
            switch ((int) value){
                case 1:
                    isPromotionService.displayListCustomersUseService();
                    break;
                case 2:
                    isPromotionService.displayListCustomersGetVoucher();
                    break;
                case 3:
                    return;
            }
        }
    }

}
