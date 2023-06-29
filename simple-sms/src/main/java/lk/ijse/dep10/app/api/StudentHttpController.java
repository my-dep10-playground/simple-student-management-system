package lk.ijse.dep10.app.api;

import lk.ijse.dep10.app.business.StudentsBO;
import lk.ijse.dep10.app.dto.StudentsDTO;
import org.apache.catalina.LifecycleState;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/students")
public class StudentHttpController {

    private final StudentsBO studentsBO;


    public StudentHttpController(StudentsBO studentsBO) {
        this.studentsBO = studentsBO;
    }

    @GetMapping
    public List<StudentsDTO> getAllStudents() throws Exception {
        return studentsBO.getAllStudents();
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudents(@RequestBody @Valid StudentsDTO studentsDTO) throws Exception {
        studentsBO.saveStudnets(studentsDTO);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping
    public void deleteStudents(@PathVariable("id") Integer id) throws Exception {
        studentsBO.deleteStudents(id);
    }

}
