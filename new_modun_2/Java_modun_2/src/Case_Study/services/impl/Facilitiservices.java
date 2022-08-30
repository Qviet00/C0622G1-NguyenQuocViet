package Case_Study.services.impl;

import Case_Study.models.Facility.Facility;
import Case_Study.models.Facility.House;
import Case_Study.models.Facility.Room;
import Case_Study.models.Facility.Villa;
import Case_Study.services.IsFacilityService;
import Case_Study.utils.Checked;
import Case_Study.utils.ReadFacility;
import Case_Study.utils.WriteFacility;
import ss_16_IO_Text_File.Post3.utils.UntilException;

import java.io.*;
import java.util.*;

public class Facilitiservices implements IsFacilityService {
    public static final String PATHROOM = "src/Case_Study/data/Room.csv";
    public static final String PATHHOUSE = "src/Case_Study/data/House.csv";
    public static final String PATHVILLA = "src/Case_Study/data/Villa.csv";
    private List<Room> rooms = new LinkedList<>();
    private List<House> houses = new LinkedList<>();
    private List<Villa> villas = new ArrayList<>();


    private Scanner src = new Scanner(System.in);


    @Override
    public void displayListFacility() {
        double choice = 0;
        while (true) {
            System.out.println("Tình trạng phòng.");
            System.out.println("1. Villa");
            System.out.println("2. House");
            System.out.println("3. Room");
            System.out.println("4. Exit");
            System.out.print("Nhập lựa chọn (1->4): ");
            choice = Checked.checked(choice, 4, 0);
            switch ((int) choice) {
                case 1:
                    System.out.println("->Villa<-");
                    Map<Facility, Integer> villas = readVilla(PATHVILLA);

                    if (villas.isEmpty()) {
                        System.out.println("Phòng Villa trống.");
                    } else {
                        for (Facility villa : villas.keySet()) {
                            System.out.println(villa + " Đang sử dụng: " + villas.get(villa));
                        }
                    }
                    break;
                case 2:
                    System.out.println("->House<-");
                    Map<Facility, Integer> houses = readHouse(PATHHOUSE);
                    if (houses.isEmpty()) {
                        System.out.println("Phòng House trống");
                    } else {
                        for (Facility house : houses.keySet()) {
                            System.out.println(house + " Đang sử dụng: " + houses.get(house));
                        }
                    }
                    break;
                case 3:
                    System.out.println("->Room<-");
                    Map<Facility, Integer> rooms = readRoom(PATHROOM);
                    if (rooms.isEmpty()) {
                        System.out.println("Phòng Room trống");
                    } else {
                        for (Facility room : rooms.keySet()) {
                            System.out.println(room + " Đang sử dụng: " + rooms.get(room));
                        }
                    }
                    break;
                case 4:
                    return;
            }
        }
    }

    @Override
    public void addNewFacility() {
        int chose = 0;
        do {
            System.out.println(" ");
            System.out.println("BẢNG LỰA CHỌN.");
            System.out.println("1. Add New Villa");
            System.out.println("2. Add New House");
            System.out.println("3. Add New Room");
            System.out.println("4.Back to menu");
            System.out.print("Mời bạn lựa chọn:(1-4): ");
            chose = (int) Checked.checked(chose, 4, 0);
            switch (chose) {
                case 1:
                    addVilla();
                    System.out.println("Thêm thành công.");
                    break;
                case 2:
                    addHouse();
                    System.out.println("Thêm thành công.");
                    break;
                case 3:
                    addRoom();
                    System.out.println("Thêm thành công.");
                    break;
                case 4:
                    return;
            }

        } while (true);
    }

    @Override
    public void displayListFacilityMaintenance() {
        double choice = 0;
        while (true) {
            System.out.println(" ");
            System.out.println("Chọn phòng ");
            System.out.println("1. Villa");
            System.out.println("2. House");
            System.out.println("3. Room");
            System.out.println("4. Exit");
            System.out.print("Nhập mục muốn chọn(1-4):");
            choice = Checked.checked(choice, 4, 0);
            switch ((int) choice) {
                case 1:
                    System.out.println("->Villa<-");
                    Map<Facility, Integer> villas = ReadFacility.readFacilityFile(PATHVILLA);
                    if (villas.isEmpty()) {
                        System.out.println("Không có bảo trì");
                    } else {
                        for (Facility villa : villas.keySet()) {
                            if (villas.get(villa) > 5) {
                                System.out.println(villa + " được bảo trì: " + villas.get(villa));
                            } else {
                                System.out.println("Không có bảo trì");
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.println("->House<-");
                    Map<Facility, Integer> houses = ReadFacility.readFacilityFile(PATHHOUSE);
                    if (houses.isEmpty()) {
                        System.out.println("Không có bảo trì");
                    } else {
                        for (Facility house : houses.keySet()) {
                            if (houses.get(house) > 5) {
                                System.out.println(house + " được bảo trì: " + houses.get(house));
                            } else {
                                System.out.println("Không có bảo trì");
                            }
                        }
                    }
                    break;
                case 3:
                    System.out.println("->Room<-");
                    Map<Facility, Integer> rooms = ReadFacility.readFacilityFile(PATHROOM);
                    if (rooms.isEmpty()) {
                        System.out.println("Không có phòng nào đang được bảo trì");
                    } else {
                        for (Facility room : rooms.keySet()) {
                            if (rooms.get(room) >= 5) {
                                System.out.println(room + " được bảo trì: " + rooms.get(room));
                            } else {
                                System.out.println("Không có bảo trì");
                            }
                        }
                    }
                    break;
                case 4:
                    return;
            }
        }
    }


    private Room infoRoom() {
        System.out.println("->ADD ROOM<-");
        String idSeriver;
        while (true) {
            try {
                System.out.print("Nhập mã dịch vụ: ");
                idSeriver = src.nextLine();
                if (!idSeriver.matches("SVRO-[0-9]{4}")) {
                    throw new UntilException("Không đúng ,nhập lại: ");
                } else {
                    for (Room home : rooms) {
                        if (home.getIdService().equals(idSeriver)) {
                            throw new UntilException("Mã số bị trùng, Nhập lại: ");
                        }
                    }
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String serviceName;
        while (true) {
            try {
                System.out.print("Nhập tên dịch vụ: ");
                serviceName = src.nextLine();
                if (!serviceName.matches("\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*")) {
                    throw new UntilException("Tên không đúng ,nhập lại: ");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        double usableArea = 0;
        System.out.print("Nhập diện tích sử dụng: ");
        usableArea = Checked.checkedOne(usableArea, 30);

        double rentalCosts = 0;
        System.out.print("Nhập chi phí thuê: ");
        rentalCosts = Checked.checkedOne(rentalCosts, 0);

        double peopleMax = 0;
        System.out.print("Nhập số người thuê: ");
        peopleMax = Checked.checked(peopleMax, 20, 0);

        String rentalType;
        while (true) {
            try {
                System.out.print("Nhập thời gian thuê: ");
                rentalType = src.nextLine();
                if (!rentalType.matches("([0-2][0-9])h.([0-9]{2})/([0-9]{2})/([0-9]{4})")) {
                    throw new UntilException("Không đúng ,nhập lại: ");
                }
                if (Integer.parseInt(rentalType.substring(0, 2)) > 24)
                    throw new UntilException("Không đúng,Nhập lại:  ");
                if (Integer.parseInt(rentalType.substring(10)) > 2030
                        || Integer.parseInt(rentalType.substring(10)) < 2022) {
                    throw new UntilException("Không đúng,Nhập lại:  ");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        String serviceFree;
        while (true) {
            try {
                System.out.print("Nhập tên dịch vụ miễn phí đi kèm: ");
                serviceFree = src.nextLine();
                if (!serviceFree.matches("\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*")) {
                    throw new UntilException("Tên không đúng ,nhập lại: ");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return new Room(idSeriver, serviceName, usableArea, rentalCosts, (int) peopleMax, rentalType, serviceFree);
    }

    private void addRoom() {
        Map<Facility, Integer> facilityRoom = new LinkedHashMap<>();
        Room room = this.infoRoom();
        facilityRoom.put(room, 1);
        WriteFacility.writeFacility(PATHROOM, facilityRoom, true);
    }

    private House infoHouse() {
        System.out.println("->ADD HOUSE<-");
        String idSeriver;
        while (true) {
            try {
                System.out.print("Nhập mã dịch vụ: ");
                idSeriver = src.nextLine();
                if (!idSeriver.matches("SVHO-[0-9]{4}")) {
                    throw new UntilException("Không đúng ,nhập lại: ");
                } else {
                    for (House hs : houses) {
                        if (hs.getIdService().equals(idSeriver)) {
                            throw new UntilException("Mã số bị trùng, Nhập lại: ");
                        }
                    }
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String serviceName;
        while (true) {
            try {
                System.out.print("Nhập tên dịch vụ: ");
                serviceName = src.nextLine();
                if (!serviceName.matches("\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*")) {
                    throw new UntilException("Tên không đúng ,nhập lại: ");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        double usableArea = 0;
        System.out.print("Nhập diện tích sử dụng: ");
        usableArea = Checked.checkedOne(usableArea, 30);

        double rentalCosts = 0;
        System.out.print("Nhập chi phí thuê: ");
        rentalCosts = Checked.checkedOne(rentalCosts, 2000000);

        double peopleMax = 0;
        System.out.print("Nhập số người thuê: ");
        peopleMax = Checked.checked(peopleMax, 20, 0);

        String rentalType;
        while (true) {
            try {
                System.out.print("Nhập thời gian thuê: ");
                rentalType = src.nextLine();
                if (!rentalType.matches("([0-2][0-9])h.([0-9]{2})/([0-9]{2})/([0-9]{4})")) {
                    throw new UntilException("Không đúng ,nhập lại: ");
                }
                if (Integer.parseInt(rentalType.substring(0, 2)) > 24)
                    throw new UntilException("Không đúng,Nhập lại:  ");
                if (Integer.parseInt(rentalType.substring(10)) > 2030
                        || Integer.parseInt(rentalType.substring(10)) < 2022) {
                    throw new UntilException("Không đúng,Nhập lại:  ");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        String roomStandard;
        while (true) {
            try {
                System.out.print("Nhập tiêu chuẩn phòng: ");
                roomStandard = src.nextLine();
                if (!roomStandard.matches("\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*")) {
                    throw new UntilException("Tên không đúng ,nhập lại: ");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        int numberFloors = 0;
        System.out.print("Nhập số tầng: ");
        numberFloors = (int) Checked.checked(numberFloors, 5, 0);


        return new House(idSeriver, serviceName, usableArea, rentalCosts, (int) peopleMax, rentalType,
                roomStandard, numberFloors);
    }

    private void addHouse() {
        Map<Facility, Integer> houses = new LinkedHashMap<>();
        House house = this.infoHouse();
        houses.put(house, 1);
        WriteFacility.writeFacility(PATHHOUSE, houses, true);
    }

    private Villa infoVilla() {
        System.out.println("->ADD VILLA<-");
        String idSeriver;
        while (true) {
            try {
                System.out.print("Nhập mã dịch vụ: ");
                idSeriver = src.nextLine();
                if (!idSeriver.matches("SVVL-[0-9]{4}")) {
                    throw new UntilException("Không đúng ,nhập lại: ");
                } else {
                    for (Villa vl : villas) {
                        if (vl.getIdService().equals(idSeriver)) {
                            throw new UntilException("Mã số bị trùng, Nhập lại: ");
                        }
                    }
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        String serviceName;
        while (true) {
            try {
                System.out.print("Nhập tên dịch vụ: ");
                serviceName = src.nextLine();
                if (!serviceName.matches("\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*")) {
                    throw new UntilException("Tên không đúng ,nhập lại: ");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        double usableArea = 0;
        System.out.print("Nhập diện tích sử dụng: ");
        usableArea = Checked.checkedOne(usableArea, 30);

        double rentalCosts = 0;
        System.out.print("Nhập chi phí thuê: ");
        rentalCosts = Checked.checkedOne(rentalCosts, 2000000);

        double peopleMax = 0;
        System.out.print("Nhập số người thuê: ");
        peopleMax = Checked.checked(peopleMax, 20, 0);

        String rentalType;
        while (true) {
            try {
                System.out.print("Nhập thời gian thuê: ");
                rentalType = src.nextLine();
                if (!rentalType.matches("([0-2][0-9])h.([0-9]{2})/([0-9]{2})/([0-9]{4})")) {
                    throw new UntilException("Không đúng ,nhập lại: ");
                }
                if (Integer.parseInt(rentalType.substring(0, 2)) > 24)
                    throw new UntilException("Không đúng,Nhập lại:  ");
                if (Integer.parseInt(rentalType.substring(10)) > 2030
                        || Integer.parseInt(rentalType.substring(10)) < 2022) {
                    throw new UntilException("Không đúng,Nhập lại:  ");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        String roomStandard;
        while (true) {
            try {
                System.out.print("Nhập tiêu chuẩn phòng: ");
                roomStandard = src.nextLine();
                if (!roomStandard.matches("\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*")) {
                    throw new UntilException("Tên không đúng ,nhập lại: ");
                }
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        double usablePoolArea = 0;
        System.out.print("Nhập diện tích sử dụng: ");
        usablePoolArea = Checked.checkedOne(usablePoolArea, 30);
        int numberFloors = 0;
        System.out.print("Nhập số tầng: ");
        numberFloors = (int) Checked.checked(numberFloors, 5, 0);


        return new Villa(idSeriver, serviceName, usablePoolArea, rentalCosts, (int) peopleMax, rentalType,
                roomStandard, usableArea, numberFloors);
    }

    private void addVilla() {
        Map<Facility, Integer> villas = new LinkedHashMap<>();
        Villa villa = this.infoVilla();
        villas.put(villa, 1);
        WriteFacility.writeFacility(PATHVILLA, villas, true);
    }

    public static Map<Facility, Integer> readVilla(String path) {
        Map<Facility, Integer> facilities = new LinkedHashMap<>();
        File file = new File(path);
        FileReader fileReader;
        BufferedReader bufferedReader;

        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] info = line.split(",");
                facilities.put(new Villa(info[0], info[1], Double.parseDouble(info[2]), Double.parseDouble(info[3]),
                                Integer.parseInt(info[4]), info[5], info[6], Double.parseDouble(info[7]), Integer.parseInt(info[8])),
                        Integer.parseInt(info[9]));
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return facilities;
    }

    public static Map<Facility, Integer> readHouse(String path) {
        Map<Facility, Integer> facilities = new LinkedHashMap<>();
        File file = new File(path);
        FileReader fileReader;
        BufferedReader bufferedReader;

        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] info = line.split(",");
                facilities.put(new House(info[0], info[1], Double.parseDouble(info[2]), Double.parseDouble(info[3]),
                        Integer.parseInt(info[4]), info[5], info[6], Integer.parseInt(info[7])), Integer.parseInt(info[8]));
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return facilities;
    }

    public static Map<Facility, Integer> readRoom(String path) {
        Map<Facility, Integer> facilities = new LinkedHashMap<>();
        File file = new File(path);
        FileReader fileReader;
        BufferedReader bufferedReader;

        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] info = line.split(",");

                facilities.put(new Room(info[0], info[1], Double.parseDouble(info[2]), Double.parseDouble(info[3]),
                        Integer.parseInt(info[4]), info[5], info[6]), Integer.parseInt(info[7]));
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return facilities;
    }


}



