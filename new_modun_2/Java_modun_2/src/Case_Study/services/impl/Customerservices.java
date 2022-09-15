package Case_Study.services.impl;

import Case_Study.models.Managerment.Customer;
import Case_Study.services.IsCustomerService;
import Case_Study.utils.CheckDay;
import Case_Study.utils.Checked;
import Case_Study.utils.ReadFileUtil;
import ss_16_IO_Text_File.Post3.utils.UntilException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Customerservices implements IsCustomerService {
    public static final String PATH = "src/Case_Study/data/Customer.csv";
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

    public void editCustomer() {
        customers = readFileCustomer();
        Customer customer = findCustomer();
        if (customer == null) {
            System.out.println("Khách hàng không tồn tại trong danh sách!");
            return;
        }
        double choose = 0;
        do {
            System.out.println("Nhập mã khách hàng cần chỉnh sửa: ");
            System.out.println(customer);
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
            customer.setName(name);
            String dateOfBirth = null;
            dateOfBirth = CheckDay.checkDay(dateOfBirth);
            customer.setBirthDay(dateOfBirth);
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
            customer.setGrand(grand);
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
            customer.setNumberCard(numberCard);
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
            customer.setNumberPhone(numberPhone);
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
            customer.setEmail(email);
            String typeGuest;
            while (true)
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
            customer.setTypeGuest(typeGuest);
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

            customer.setAddress(address);

            System.out.println("Chỉnh sửa thành công!");
            writeFile(customers);
            System.out.println("Bạn có muốn tiếp tục chỉnh sửa?");
            System.out.print("Vui lòng chọn 1 (Có) - 2 (Không): ");
            choose = Checked.checked(choose, 2, 0);
            if (choose != 1) {
                return;
            }
        } while (true);
    }

    @Override
    public void delete() {
        customers = readFileCustomer();
        Customer customer = this.findCustomer();
        if (customer == null) {
            System.out.println("Không tìm thấy.");
        } else {
            System.out.println("Muốn xóa: " + customer.getIdCustomer());
            System.out.println("1 .Yes");
            System.out.println("2 .No");
            int choice = 0;
            choice = (int) Checked.checked(choice, 2, 0);
            if (choice == 1) {
                customers.remove(customer);
                System.out.println("Xóa ok");
            }
        }
        writeFile(customers);
    }


    public void search() {
        customers = readFileCustomer();
        System.out.println(" ");
        System.out.println("->TÌM KIẾM<-");
        System.out.println("1.Tìm kiếm theo tên");
        System.out.println("2.Tìm theo mã nhân viên.");
        System.out.print("Mời nhập lựa chọn(1/2): ");
        int chose = 0;
        chose = (int) Checked.checked(chose, 2, 0);
        if (chose == 1) {
            System.out.print("Mời bạn nhập tên cần tìm: ");
            String name = src.nextLine();
            int count = 0;
            for (Customer customer : customers) {
                if (customer.getName().toLowerCase().contains(name.toLowerCase())) {
                    System.out.println(customer);
                    count++;
                }
            }
            if (count == 0) {
                System.out.println("Không có tên trong danh sách!");
            }

        } else {
            Customer customer = this.findCustomer();
            if (customer == null) {
                System.out.println("Không tìm thấy");
            } else
                System.out.println(customer);
        }
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
                if (!name.matches("[\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll})*]{5,50}")) {
                    throw new UntilException("Tên không đúng ,nhập lại: ");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String dateOfBirth = null;
        dateOfBirth = CheckDay.checkDay(dateOfBirth);
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
        while (true)
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
                if (!s.equals("")) {
                    propertiesOfCustomer = s.split(",");
                    customer = new Customer(propertiesOfCustomer[0], propertiesOfCustomer[1], propertiesOfCustomer[2],
                            propertiesOfCustomer[3], propertiesOfCustomer[4], propertiesOfCustomer[5], propertiesOfCustomer[6],
                            propertiesOfCustomer[7], propertiesOfCustomer[8]);
                    customers.add(customer);
                } else {
                    System.out.println("Không có dữ liệu.");
                    break;
                }
            }
            return customers;
        }
    }

    private static void writeFile(List<Customer> customers) {
        try {
            File file = new File(PATH);
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (Customer cus : customers) {
                bufferedWriter.write(cus.infoString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    Customer findCustomer() {
        System.out.print("Mời bạn nhập mã khách hàng: ");
        String id = src.nextLine();
        for (Customer customer : customers) {
            if (customer.getIdCustomer().equals(id)) {
                return customer;
            }
        }
        return null;
    }

    /**
     * Sắp xếp:
     */

    static class comparatorName implements Comparator<Customer> {
        public int compare(Customer emp1, Customer emp2) {
            return emp1.getName().compareTo(emp2.getName());
        }
    }

    static class comparatorID implements Comparator<Customer> {
        public int compare(Customer emp1, Customer emp2) {
            return emp1.getIdCustomer().compareTo(emp2.getIdCustomer());
        }
    }

    public void sorts() {
        customers = readFileCustomer();
        System.out.println(" ");
        System.out.println("->SẮP XẾP<-");
        System.out.println("1.Sắp theo tên.");
        System.out.println("2.sắp xếp theo mã nhân viên.");
        System.out.print("Mời nhập lựa chọn(1/2): ");
        int chose = 0;
        chose = (int) Checked.checked(chose, 2, 0);
        if (chose == 1) {
            customers.sort(new Customerservices.comparatorName());
            for (Customer st : customers) {
                System.out.println(st);
            }
        } else {
            customers.sort(new Customerservices.comparatorID());
            for (Customer st : customers) {
                System.out.println(st);
            }
        }
    }
}

