package lk.ijse.dep10.app.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Students implements SuperEntity {
    private Integer id;
    private String name;
    private String address;
}
