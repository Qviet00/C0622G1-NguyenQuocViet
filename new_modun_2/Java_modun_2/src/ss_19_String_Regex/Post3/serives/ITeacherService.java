package ss_16_IO_Text_File.Post3.serives;

import java.io.IOException;

public interface ITeacherService {
    void displayAllTeacher() throws IOException;

    void addTeacher() throws IOException;

    void displayAllStudent() throws IOException;

    void deleteTeacher();

    void searchTeacher();
    void sortTeacher() throws IOException;
}
