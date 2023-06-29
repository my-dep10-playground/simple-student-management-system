package lk.ijse.dep10.app.dao.impl;

import lk.ijse.dep10.app.dao.custom.StudentsDAO;
import lk.ijse.dep10.app.entity.Students;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


import static lk.ijse.dep10.app.dao.util.Mappers.*;
@Repository
public class StudentsDAOImpl implements StudentsDAO {
    private final JdbcTemplate jdbcTemplate;

    public StudentsDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public long count() throws Exception {
        return 0;
    }

    @Override
    public Students save(Students entity) throws Exception {
        jdbcTemplate.update("INSERT INTO student (name, address) VALUES (?,?)",entity.getName(),entity.getAddress());
        return entity;
    }

    @Override
    public void update(Students entity) throws Exception {

    }

    @Override
    public void deleteById(Integer pk) throws Exception {
                jdbcTemplate.update("DELETE FROM student WHERE id=?",pk);
    }

    @Override
    public Optional<Students> findById(Integer pk) throws Exception {
        return Optional.empty();
    }

    @Override
    public List<Students> findAll() throws Exception {
        return jdbcTemplate.query("SELECT * FROM student",STUDENT_ROW_MAPPER);
    }

    @Override
    public boolean existsById(Integer pk) throws Exception {
        return false;
    }
}
