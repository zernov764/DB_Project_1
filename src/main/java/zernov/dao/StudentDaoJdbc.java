package zernov.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import zernov.dao.relations.CourseMarksIdInGroup;
import zernov.domain.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class StudentDaoJdbc implements StudentDao {
    private final NamedParameterJdbcOperations jdbc;

    public StudentDaoJdbc(NamedParameterJdbcOperations jdbcOperations) {
        this.jdbc = jdbcOperations;
    }

    @Override
    public void insert(Student student) {
        jdbc.update("INSERT INTO students (ID, SURNAME, NAME, MIDDLENAME) VALUES (:id, :surname, :name, :middlename)",
                Map.of("id", student.getId(), "surname", student.getSurname(), "name", student.getName(), "middlename", student.getMiddleName()));
    }

    @Override
    public List<Student> getAll() {
        return jdbc.query("SELECT * FROM students", new StudentMapper());
    }

    @Override
    public String getGradeById(long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        return jdbc.queryForObject(
                "select grade from grades where id = :id", params, new GradeMapper()
        );
    }

    @Override
    public double getCourseMarksInGroup(long courseId, long groupId) {

        Map<String, Object> params = new java.util.HashMap<>(Collections.singletonMap("course_id", courseId));
        params.put("group_id", groupId);

        List<CourseMarksIdInGroup> courseMarksIdInGroups = jdbc.query("SELECT GRADE_ID FROM student_courses_grade WHERE COURSE_ID = :course_id AND STUDENT_ID IN " +
                        "(SELECT STUDENT_ID FROM group_students WHERE GROUP_ID = :group_id)", params,
                new MarksMapper());

        List<String> courseMarksInGroups = new ArrayList<>();

        for(int i = 0; i< courseMarksIdInGroups.size(); i++){
            courseMarksInGroups.add(getGradeById(courseMarksIdInGroups.get(i).getGradeId()));
        }

        long sum = 0;
        for (int i=0; i<courseMarksInGroups.size(); i++){
            sum += Long.parseLong(courseMarksInGroups.get(i));
        }

        return (double) sum/courseMarksInGroups.size();
    }

    private static class StudentMapper implements RowMapper<Student> {
        @Override
        public Student mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = resultSet.getLong("id");
            String surname = resultSet.getString("surname");
            String name = resultSet.getString("name");
            String middleName = resultSet.getString("name");
            return new Student(id, surname, name, middleName);
        }
    }

    private static class MarksMapper implements RowMapper<CourseMarksIdInGroup> {
        @Override
        public CourseMarksIdInGroup mapRow(ResultSet resultSet, int i) throws SQLException {
            long grade_id = resultSet.getLong("grade_id");
            return new CourseMarksIdInGroup(grade_id);
        }
    }

    static class GradeMapper implements RowMapper<String> {
        @Override
        public String mapRow(ResultSet resultSet, int i) throws SQLException {
            String grade = resultSet.getString("grade");
            return grade;
        }
    }

}
