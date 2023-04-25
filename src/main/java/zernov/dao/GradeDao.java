package zernov.dao;

import zernov.domain.Grade;

import java.util.List;

public interface GradeDao {

    void insert(Grade grade);

    List<Grade> getAll();
}
