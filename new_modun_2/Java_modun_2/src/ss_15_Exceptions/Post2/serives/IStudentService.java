package ss_15_Exceptions.Post2.serives;

import java.io.IOException;

public interface IStudentService {
    void addStudent() throws IOException;

    void displayAllStudent() throws IOException;

    void deteleStudent();

    void searchStudent();
    void sortStudent() throws IOException;
}
