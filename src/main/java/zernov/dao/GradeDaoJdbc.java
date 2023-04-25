package zernov.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import zernov.domain.Grade;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class GradeDaoJdbc implements GradeDao {
    private final NamedParameterJdbcOperations jdbc;

    public GradeDaoJdbc(NamedParameterJdbcOperations jdbcOperations) {
        this.jdbc = jdbcOperations;
    }


    @Override
    public void insert(Grade grade) {
        jdbc.update("INSERT INTO grades (ID, GRADE) VALUES (:id, :grade)",
                Map.of("id", grade.getId(), "grade", grade.getGrade()));
    }
    @Override
    public List<Grade> getAll() {
        return jdbc.query("SELECT * FROM grades", new GradeMapper());
    }


    static class GradeMapper implements RowMapper<Grade> {
        @Override
        public Grade mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = resultSet.getLong("id");
            String grade = resultSet.getString("grade");
            return new Grade(id, grade);
        }
    }
}
