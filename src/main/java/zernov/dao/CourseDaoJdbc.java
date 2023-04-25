package zernov.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import zernov.domain.Course;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class CourseDaoJdbc implements CourseDao {
    private final NamedParameterJdbcOperations jdbc;

    public CourseDaoJdbc(NamedParameterJdbcOperations jdbcOperations) {
        this.jdbc = jdbcOperations;
    }

    @Override
    public void insert(Course course) {
        jdbc.update("INSERT INTO courses (ID, NAME) VALUES (:id, :name)",
                Map.of("id", course.getId(), "name", course.getName()));
    }
    @Override
    public List<Course> getAll() {
        return jdbc.query("SELECT * FROM courses", new CourseMapper());
    }


    private static class CourseMapper implements RowMapper<Course> {
        @Override
        public Course mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = resultSet.getLong("id");
            String name = resultSet.getString("name");
            return new Course(id, name);
        }
    }
}
