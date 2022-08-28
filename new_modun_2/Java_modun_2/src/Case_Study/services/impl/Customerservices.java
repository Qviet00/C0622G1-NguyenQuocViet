package Case_Study.services.impl;

import Case_Study.models.Managerment.Customer;
import Case_Study.services.IsCustomerService;
import Case_Study.utils.Checked;
import Case_Study.utils.ReadFileUtil;
import ss_16_IO_Text_File.Post3.utils.UntilException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Customerservices implements IsCustomerService {
    public static final String PATH = "src/Case_Study/data/BookingText.csv";
    private static Scanner src = new Scanner(System.in);
    private List<Customer> customers = new LinkedList<>();

    @Override
    public void displayListCustomers() {
        customers = readFileCustomer();
        for (Customer cus : customers) {
            System.out.println(cus);
        }

    }

    @Override
    public void addNewCustomer() {
       customers = readFileCustomer();
        Customer customer = this.infoCustomer();
        customers.add(customer);
        System.out.println("Thêm khách hàng thành công");
        writeFile(customers);

    }

    @Override
    public void editCustomer() {
        customers = readFileCustomer();
        Customer customer = findCustomer();
        if (customer == null) {
            System.out.println("Khách hàng không tồn tại trong danh sách!");
            return;
        }

        double choose = 0;
        do {
            System.out.println("Mã khách hàng cần chỉnh sửa: ");
            System.out.println(customer);
            System.out.println("Bạn muốn chỉnh sửa nội dung nào?");
            System.out.println("1. Mã khách hàng");
            System.out.println("2. Tên khách hàng");
            System.out.println("3. Ngày sinh");
            System.out.println("4. Giới tính");
            System.out.println("5. Số cmnd");
            System.out.println("6. Số điện thoại");
            System.out.println("7. Email");
            System.out.println("8. Loại khách");
            System.out.println("9. Địa chỉ");
            System.out.println("10. Thoát");
            System.out.print("Chọn nội dung cần chỉnh sửa 1 -> 10: ");
            choose = Checked.checked(choose, 11);
            switch ((int) choose) {
                case 1:
                    customer.setIdCustomer(getEditInfo("Mã khách hàng"));
                    break;
                case 2:
                    customer.setName(getEditInfo("Tên khách hàng"));
                    break;
                case 3:
                    customer.setBirthDay(getEditInfo("Ngày sinh"));
                    break;
                case 4:
                    customer.setGrand(getEditInfo("Giới tính"));
                    break;
                case 5:
                    customer.setNumberCard(getEditInfo("Số CMND"));
                    break;
                case 6:
                    customer.setNumberPhone(getEditInfo("Số điện thoại"));
                    break;
                case 7:
                    customer.setEmail(getEditInfo("Email"));
                    break;
                case 8:
                   customer.setTypeGuest(getEditInfo("Loại khách"));
                    break;
                case 9:
                    customer.setAddress(getEditInfo("Đại chỉ"));
                    break;
                case 10:
                    return;
            }
            System.out.println("Chỉnh sửa thành công!");
            writeFile(customers);
            System.out.println("Bạn có muốn tiếp tục chỉnh sửa?");
            System.out.print("Vui lòng chọn 1 (Có) - 2 (Không): ");
            choose = Checked.checked(choose, 3);
            if (choose != 1) {
                return;
            }
        } while (true);

    }

    private Customer infoCustomer() {
        String idCustomer;
        while (true) {
            try {
                System.out.print("Nhập mã khách hàng: ");
                idCustomer = src.nextLine();
                if (!idCustomer.matches("KH[0-9]{2}")) {
                    throw new UntilException("Không đúng ,nhập lại: ");
                } else {
                    for (Customer customer : customers) {
                        if (customer.getIdCustomer().equals(idCustomer)) {
                            throw new UntilException("Mã số bị trùng, Nhập lại: ");
                        }
                    }
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String name;
        while (true) {
            try {
                System.out.print("Nhập Tên: ");
                name = src.nextLine();
                if (!name.matches("\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*")) {
                    throw new UntilException("Tên không đúng ,nhập lại: ");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String dateOfBirth;
        while (true) {
            try {
                System.out.print("Nhập ngày sinh: ");
                dateOfBirth = src.nextLine();
                if (!dateOfBirth.matches("([0-9]{2})/([0-9]{2})/([0-9]{4})")) {
                    throw new UntilException("Không đúng ,nhập lại: ");
                }
                if (Integer.parseInt(dateOfBirth.substring(6)) > 2007
                        || Integer.parseInt(dateOfBirth.substring(6)) < 1990) {
                    throw new UntilException("Không đúng,Nhập lại:  ");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String grand;
        while (true) {
            try {
                System.out.print("Mời bạn nhập giới tính: ");
                grand = src.nextLine();
                if (!grand.equals("Nam") && !grand.equals("Nu") && !grand.equals("nam") && !grand.equals("nu")) {
                    throw new UntilException("Sai rồi, nhập lại: ");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String numberCard;
        while (true) {
            try {
                System.out.print("Mời bạn nhập số CMDN: ");
                numberCard = String.format(src.nextLine());
                if (!numberCard.matches("[0-9]{9}")) {
                    throw new UntilException(" Số CMND bạn nhập không đúng, nhập lại: ");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Nhập không đúng, nhập lại: ");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String numberPhone;
        while (true) {
            try {
                System.out.print("Mời bạn nhập số điện thoại: ");
                numberPhone = String.format(src.nextLine());
                if (!numberPhone.matches("0[0-9]{9}")) {
                    throw new UntilException("Số điện thoại bạn nhập không đúng");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Dữ liệu nhập không đúng");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String email;
        while (true) {
            try {
                System.out.print("Mời bạn nhập Email: ");
                email = String.format(src.nextLine());
                if (!email.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
                    throw new UntilException("Email bạn nhập không đúng");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Dữ liệu nhập không đúng");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String typeGuest;
        while (true) {
            try {
                System.out.print("Mời bạn nhập loại khách: ");
                typeGuest = String.format(src.nextLine());
                if (!typeGuest.equals("Diamond") && !typeGuest.equals(" Platinium") &&
                        !typeGuest.equals("Gold") && !typeGuest.equals("Silver") && !typeGuest.equals("Member")) {
                    throw new UntilException("Loại khách bạn nhập không đúng");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Dữ liệu nhập không đúng");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String address;
        while (true) {
            try {
                System.out.print("Mời bạn nhập địa chỉ: ");
                address = String.format(src.nextLine());
                if (!address.matches("\\w")) {
                    throw new UntilException("Đi chỉ  bạn nhập không đúng");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Dữ liệu nhập không đúng");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return new Customer(idCustomer, name, dateOfBirth, grand, numberCard, numberPhone, email, typeGuest, address);
    }

    private List<Customer> readFileCustomer() {
        List<String> customerList;
        customerList = ReadFileUtil.readFile(PATH);
        List<Customer> customers = new LinkedList<>();
        if (customerList.size() == 0) {
            System.out.println("Dữ liệu trong file không có.");
            return null;
        } else {
            String[] propertiesOfCustomer;
            Customer customer;
            for (String s : customerList) {
                propertiesOfCustomer = s.split(",");
                customer = new Customer(propertiesOfCustomer[0], propertiesOfCustomer[1], propertiesOfCustomer[2],
                        propertiesOfCustomer[3], propertiesOfCustomer[4], propertiesOfCustomer[5], propertiesOfCustomer[6],
                        propertiesOfCustomer[7], propertiesOfCustomer[8]);
                customers.add(customer);
            }
        }
        return customers;
    }
    private static void writeFile(List<Customer> customers) {
        try {
            File file = new File(PATH);
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (Customer cus : customers) {
                bufferedWriter.write(cus.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    private Customer findCustomer() {
        System.out.print("Mời bạn nhập mã khách hàng: ");
        String id = src.nextLine();
        for (Customer customer : customers) {
            if (customer.getIdCustomer().equals(id)) {
                return customer;
            }
        }
        return null;
    }
    public String getEditInfo(String i) {
        System.out.print("Nhập " + i + " mới: ");
        return src.nextLine();
    }
}

