package lk.ijse.dep10.app.business.util;

import lk.ijse.dep10.app.dto.StudentsDTO;
import lk.ijse.dep10.app.entity.Students;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Transformer {

private final ModelMapper modelMapper;


    public Transformer(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Students toStudentsEntity(StudentsDTO studentsDTO){
        return  modelMapper.map(studentsDTO, Students.class);
    }

    public StudentsDTO fromStudentEntity(Students students){
        return modelMapper.map(students, StudentsDTO.class);
    }
}
