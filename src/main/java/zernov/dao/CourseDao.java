package zernov.dao;

import zernov.domain.Course;

import java.util.List;

public interface CourseDao {

    void insert(Course course);

    List<Course> getAll();
}
