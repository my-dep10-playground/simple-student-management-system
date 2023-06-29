package lk.ijse.dep10.app.business;

import lk.ijse.dep10.app.dto.StudentsDTO;

import java.util.List;

public interface StudentsBO {

    List<StudentsDTO> getAllStudents() throws Exception;
    void saveStudnets( StudentsDTO studentsDTO) throws Exception;

    void deleteStudents(int id) throws Exception;

}
