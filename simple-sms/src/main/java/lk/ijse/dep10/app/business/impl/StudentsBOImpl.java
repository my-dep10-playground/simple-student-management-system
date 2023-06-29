package lk.ijse.dep10.app.business.impl;

import com.sun.jdi.request.DuplicateRequestException;
import lk.ijse.dep10.app.business.StudentsBO;
import lk.ijse.dep10.app.business.util.Transformer;
import lk.ijse.dep10.app.dao.custom.StudentsDAO;
import lk.ijse.dep10.app.dto.StudentsDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class StudentsBOImpl implements StudentsBO {

    private final StudentsDAO studentsDAO;

    private final Transformer transformer;

    public StudentsBOImpl(StudentsDAO studentsDAO, Transformer transformer) {
        this.studentsDAO = studentsDAO;

        this.transformer = transformer;
    }

    @Transactional(readOnly = true)
    @Override
    public List<StudentsDTO> getAllStudents() throws Exception {
        return studentsDAO.findAll().stream().map(transformer::fromStudentEntity).collect(Collectors.toList());
    }

    @Override
    public void saveStudnets(StudentsDTO studentsDTO) throws Exception {

        if(studentsDAO.existsById(studentsDTO.getId())) {
            throw new DuplicateRequestException(studentsDTO.getId() + " already exists");
        }
        studentsDAO.save(transformer.toStudentsEntity(studentsDTO));
    }

    @Override
    public void deleteStudents(int id) throws Exception {
  studentsDAO.deleteById(id);
    }
}
