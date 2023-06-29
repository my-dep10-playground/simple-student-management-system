package lk.ijse.dep10.app.dto;


import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentsDTO {


    private int id;
     @NotBlank(message = "name can not be empty")
    private String name;
    @NotBlank(message = "address can not be empty")
    private  String address;
}
