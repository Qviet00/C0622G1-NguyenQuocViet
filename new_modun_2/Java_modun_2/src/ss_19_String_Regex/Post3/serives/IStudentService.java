package ss_19_String_Regex.Post3.serives;

import java.io.IOException;

public interface IStudentService {
    void addStudent() throws IOException;

    void displayAllStudent() throws IOException;

    void deteleStudent();

    void searchStudent();
    void sortStudent() throws IOException;
}
