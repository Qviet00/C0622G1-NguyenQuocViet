package ss_19_String_Regex.Post3.serives;

import java.io.IOException;

public interface ITeacherService {
    void displayAllTeacher() throws IOException;

    void addTeacher() throws IOException;

    void deleteTeacher();

    void searchTeacher();

    void sortTeacher() throws IOException;
}
