package lk.ijse.dep10.app.dao.util;

import lk.ijse.dep10.app.entity.Students;
import org.springframework.data.annotation.Id;
import org.springframework.jdbc.core.RowMapper;




public class Mappers {

    public static final RowMapper<Students> STUDENT_ROW_MAPPER = (rs, rowNum) -> new Students(rs.getInt("id"), rs.getString("name"),rs.getString("address"));
}
