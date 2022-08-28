package Case_Study.services.impl;

import Case_Study.models.Managerment.Employee;
import Case_Study.services.IsEmployeeService;
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
            System.out.println("Mã nhân viên cần chỉnh sửa: ");
            System.out.println(employee);
            System.out.println("Bạn muốn chỉnh sửa nội dung nào?");
            System.out.println("1. Mã nhân viên");
            System.out.println("2. Tên nhân viên");
            System.out.println("3. Ngày sinh");
            System.out.println("4. Giới tính");
            System.out.println("5. Số cmnd");
            System.out.println("6. Số điện thoại");
            System.out.println("7. Email");
            System.out.println("8. Trình độ");
            System.out.println("9. Vị trí");
            System.out.println("10. Mức lương");
            System.out.println("11. Thoát");
            System.out.print("Chọn nội dung cần chỉnh sửa 1 -> 11: ");
            choose = Checked.checked(choose, 12);
            switch ((int) choose) {
                case 1:
                    employee.setIdEmployee(getEditInfo("Mã nhân viên"));
                    break;
                case 2:
                    employee.setName(getEditInfo("Tên nhân viên"));
                    break;
                case 3:
                    employee.setBirthDay(getEditInfo("Ngày sinh"));
                    break;
                case 4:
                    employee.setGrand(getEditInfo("Giới tính"));
                    break;
                case 5:
                    employee.setNumberCard(getEditInfo("Số CMND"));
                    break;
                case 6:
                    employee.setNumberPhone(getEditInfo("Số điện thoại"));
                    break;
                case 7:
                    employee.setEmail(getEditInfo("Email"));
                    break;
                case 8:
                    employee.setLevel(getEditInfo("Trình độ"));
                    break;
                case 9:
                    employee.setLocation(getEditInfo("Vị trí"));
                    break;
                case 10:
                    employee.setSalary(getEditInfo("Mức lương"));
                    break;
                case 11:
                    return;
            }
            System.out.println("Chỉnh sửa thành công!");
            writeFile(employees);
            System.out.println("Bạn có muốn tiếp tục chỉnh sửa?");
            System.out.print("Vui lòng chọn 1 (Có) - 2 (Không): ");
            choose = Checked.checked(choose, 3);
            if (choose != 1) {
                return;
            }
        } while (true);
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
                propertiesOfEmployee = s.split(",");
                employee = new Employee(propertiesOfEmployee[0], propertiesOfEmployee[1], propertiesOfEmployee[2],
                        propertiesOfEmployee[3], propertiesOfEmployee[4], propertiesOfEmployee[5], propertiesOfEmployee[6],
                        propertiesOfEmployee[7], propertiesOfEmployee[8], propertiesOfEmployee[9]);
                employees.add(employee);
            }
        }
        return employees;
    }

    private static void writeFile(List<Employee> employees) {
        try {
            File file = new File(PATH);
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (Employee emp : employees) {
                bufferedWriter.write(emp.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private Employee findEmployee() {
        System.out.print("Mời bạn nhập mã nhân viên: ");
        String id = src.nextLine();
        for (Employee employee : employees) {
            if (employee.getIdEmployee().equals(id)) {
                return employee;
            }
        }
        return null;
    }

    public String getEditInfo(String i) {
        System.out.print("Nhập " + i + " mới: ");
        return src.nextLine();
    }

}
