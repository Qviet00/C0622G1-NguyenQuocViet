package ss_16_IO_Text_File.Post3.serives;

import java.io.IOException;

public interface IStudentService {
    void addStudent() throws IOException;

    void displayAllStudent() throws IOException;

    void deteleStudent();

    void searchStudent();
    void sortStudent() throws IOException;
}
