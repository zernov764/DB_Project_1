package zernov.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import zernov.domain.Group;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class GroupDaoJdbc implements GroupDao {
    private final NamedParameterJdbcOperations jdbc;

    public GroupDaoJdbc(NamedParameterJdbcOperations jdbcOperations) {
        this.jdbc = jdbcOperations;
    }

    @Override
    public void insert(Group group) {
        jdbc.update("INSERT INTO groups (ID, NUMBER, ENTRANCE) VALUES (:id, :number, :entrance)",
                Map.of("id", group.getId(), "number", group.getNumber(),"entrance", group.getEntrance()));
    }
    @Override
    public List<Group> getAll() {
        return jdbc.query("SELECT * FROM groups", new GroupMapper());
    }


    private static class GroupMapper implements RowMapper<Group> {
        @Override
        public Group mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = resultSet.getLong("id");
            String number = resultSet.getString("number");
            String entrance = resultSet.getString("entrance");
            return new Group(id, number, entrance);
        }
    }
}
