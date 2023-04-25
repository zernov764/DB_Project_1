package zernov.dao;

import zernov.domain.Student;

import java.util.List;

public interface StudentDao {

    void insert(Student student);

    String getGradeById(long id);

    List<Student> getAll();

    double getCourseMarksInGroup(long courseId, long groupId);
}
