package Case_Study.services.impl;

import Case_Study.models.Managerment.Employee;
import Case_Study.services.IsEmployeeService;
import Case_Study.utils.CheckDay;
import Case_Study.utils.Checked;
import Case_Study.utils.ReadFileUtil;
import ss_16_IO_Text_File.Post3.utils.UntilException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Employeeservices implements IsEmployeeService {
    public static final String PATH = "src/Case_Study/data/EmployeeText.csv";
    private static Scanner src = new Scanner(System.in);
    private List<Employee> employees = new ArrayList<>();


    @Override
    public void displayListEmployees() {
        employees = readFileEmployee();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    @Override
    public void addNewEmployee() {
        employees = readFileEmployee();
        Employee employee = this.infoEmployee();
        employees.add(employee);
        System.out.println("Thêm nhân viên thành công");
        writeFile(employees);
    }

    @Override
    public void editEmployee() {
        employees = readFileEmployee();
        Employee employee = findEmployee();
        if (employee == null) {
            System.out.println("Nhân viên không tồn tại trong danh sách!");
            return;
        }
        double choose = 0;
        do {
            System.out.println(employee);
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
            employee.setName(name);
            String dateOfBirth = null;
            dateOfBirth = CheckDay.checkDay(dateOfBirth);
            employee.setBirthDay(dateOfBirth);
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
            employee.setGrand(grand);
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
            employee.setNumberCard(numberCard);
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
            employee.setNumberPhone(numberPhone);
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
            employee.setEmail(email);
            String level;
            while (true) {
                try {
                    System.out.print("Mời bạn nhập trình độ: ");
                    level = String.format(src.nextLine());
                    if (!level.equals("Đại học") && !level.equals("Cao đẳng") && !level.equals("Trung cấp") && !level.equals("Sau đại học")) {
                        throw new UntilException("Trình độ bạn nhập không đúng");
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Dữ liệu nhập không đúng");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            employee.setLevel(level);
            String location;
            while (true) {
                try {
                    System.out.print("Mời bạn nhập vị trí: ");
                    location = String.format(src.nextLine());
                    if (!location.equals("Lễ tân") && !location.equals("Phục vụ") &&
                            !location.equals("Chuyên viên") && !location.equals("Gíam sát") && !location.equals("Quản lí")
                            && !location.equals("Gíam đốc")) {
                        throw new UntilException("vị trí bạn nhập không đúng");
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Dữ liệu nhập không đúng");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            employee.setLocation(location);
            String salary;
            while (true) {
                try {
                    System.out.print("Mời bạn nhập mức lương: ");
                    salary = String.format(src.nextLine());
                    if (!salary.matches("[1-9][0-9]{5,9}")) {
                        throw new UntilException("Số bạn nhập không đúng");
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Dữ liệu nhập không đúng");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            employee.setSalary(salary);

            System.out.println("Chỉnh sửa thành công!");
            writeFile(employees);
            System.out.println("Bạn có muốn tiếp tục chỉnh sửa?");
            System.out.print("Vui lòng chọn 1 (Có) - 2 (Không): ");
            choose = Checked.checked(choose, 2, 0);
            if (choose != 1) {
                return;
            }
        } while (true);
    }

    public void delete() {
        employees = readFileEmployee();
        Employee employee = this.findEmployee();
        if (employee == null) {
            System.out.println("Không tìm thấy.");
        } else {
            System.out.println("Muốn xóa: " + employee.getIdEmployee());
            System.out.println("1 .Yes");
            System.out.println("2 .No");
            int choice = 0;
            choice = (int) Checked.checked(choice, 2, 0);
            if (choice == 1) {
                employees.remove(employee);
                System.out.println("Xóa ok");
            }
        }
        writeFile(employees);
    }

    public void search() {
        employees = readFileEmployee();
        System.out.println(" ");
        System.out.println("->TÌM KIẾM<-");
        System.out.println("1.Tìm kiếm theo tên");
        System.out.println("2.Tìm theo mã nhân viên.");
        System.out.print("Nhập lựa chọn(1/2): ");
        int chose = 0;
        chose = (int) Checked.checked(chose, 2, 0);
        if (chose == 1) {
            System.out.print("Mời bạn nhập tên cần tìm: ");
            String name = src.nextLine();
            int count = 0;
            for (Employee employee : employees) {
                if (employee.getName().toLowerCase().contains(name.toLowerCase())) {
                    System.out.println(employee);
                    count++;
                }
            }
            if (count == 0) {
                System.out.println("Không có tên trong danh sách!");
            }

        } else {
            Employee employee = this.findEmployee();
            if (employee == null) {
                System.out.println("Không tìm thấy");
            } else
                System.out.println(employee);
        }
    }


    private Employee infoEmployee() {
        String idEmployee;
        while (true) {
            try {
                System.out.print("Nhập mã nhân viên: ");
                idEmployee = src.nextLine();
                if (!idEmployee.matches("NV[0-9]{2}")) {
                    throw new UntilException("Không đúng ,nhập lại: ");
                } else {
                    for (Employee employee : employees) {
                        if (employee.getIdEmployee().equals(idEmployee)) {
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
        String level;
        while (true) {
            try {
                System.out.print("Mời bạn nhập trình độ: ");
                level = String.format(src.nextLine());
                if (!level.equals("Đại học") && !level.equals("Cao đẳng") && !level.equals("Trung cấp") && !level.equals("Sau đại học")) {
                    throw new UntilException("Trình độ bạn nhập không đúng");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Dữ liệu nhập không đúng");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String location;
        while (true) {
            try {
                System.out.print("Mời bạn nhập vị trí: ");
                location = String.format(src.nextLine());
                if (!location.equals("Lễ tân") && !location.equals("Phục vụ") &&
                        !location.equals("Chuyên viên") && !location.equals("Gíam sát") && !location.equals("Quản lí")
                        && !location.equals("Gíam đốc")) {
                    throw new UntilException("vị trí bạn nhập không đúng");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Dữ liệu nhập không đúng");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String salary;
        while (true) {
            try {
                System.out.print("Mời bạn nhập mức lương: ");
                salary = String.format(src.nextLine());
                if (!salary.matches("[1-9][0-9]{5,9}")) {
                    throw new UntilException("Số bạn nhập không đúng");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Dữ liệu nhập không đúng");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return new Employee(idEmployee, name, dateOfBirth, grand, numberCard, numberPhone, email, level, location, salary);
    }

    private List<Employee> readFileEmployee() {
        List<String> employeeList;
        employeeList = ReadFileUtil.readFile(PATH);
        List<Employee> employees = new ArrayList<>();
        if (employeeList.size() == 0) {
            System.out.println("Dữ liệu trong file không có.");
            return null;
        } else {
            String[] propertiesOfEmployee;
            Employee employee;
            for (String s : employeeList) {

                if (!s.equals("")){
                    propertiesOfEmployee = s.split(",");
                    employee = new Employee(propertiesOfEmployee[0], propertiesOfEmployee[1], propertiesOfEmployee[2],
                            propertiesOfEmployee[3], propertiesOfEmployee[4], propertiesOfEmployee[5], propertiesOfEmployee[6],
                            propertiesOfEmployee[7], propertiesOfEmployee[8], propertiesOfEmployee[9]);
                    employees.add(employee);
                }else{
                    System.out.println("Không có dữ liệu.");
                    break;
                }
            }
            return employees;
        }
    }

    private static void writeFile(List<Employee> employees) {
        try {
            File file = new File(PATH);
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (Employee emp : employees) {
                bufferedWriter.write(emp.infoString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private Employee findEmployee() {
        System.out.print("Nhập mã nhân viên: ");
        String id = src.nextLine();
        for (Employee employee : employees) {
            if (employee.getIdEmployee().equals(id)) {
                return employee;
            }
        }
        return null;
    }

    static class comparatorName implements Comparator<Employee> {
        public int compare(Employee emp1, Employee emp2) {
            return emp1.getName().compareTo(emp2.getName());
        }
    }

    static class comparatorID implements Comparator<Employee> {
        public int compare(Employee emp1, Employee emp2) {
            return emp1.getIdEmployee().compareTo(emp2.getIdEmployee());
        }
    }

    public void sorts() {
        employees = readFileEmployee();
        System.out.println(" ");
        System.out.println("->SẮP XẾP<-");
        System.out.println("1.Sắp theo tên.");
        System.out.println("2.sắp xếp theo mã nhân viên.");
        System.out.print("Mời nhập lựa chọn(1/2): ");
        int chose = 0;
        chose = (int) Checked.checked(chose, 2, 0);
        if (chose == 1) {
            employees.sort(new comparatorName());
            for (Employee st : employees) {
                System.out.println(st);
            }
        } else {
            employees.sort(new comparatorID());
            for (Employee st : employees) {
                System.out.println(st);
            }

        }

    }
}




