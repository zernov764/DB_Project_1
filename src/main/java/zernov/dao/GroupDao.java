package zernov.dao;

import zernov.domain.Group;

import java.util.List;

public interface GroupDao {

    void insert(Group group);

    List<Group> getAll();
}
