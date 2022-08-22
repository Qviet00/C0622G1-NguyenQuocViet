package ss_15_Exceptions.Post2.serives;

import java.io.IOException;

public interface ITeacherService {
    void displayAllTeacher() throws IOException;

    void addTeacher() throws IOException;

    void displayAllStudent() throws IOException;

    void deleteTeacher();

    void searchTeacher();
    void sortTeacher() throws IOException;
}
