package ro.mindit.forum.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import ro.mindit.forum.domain.User;

/**
 * @author adrian.dafinoiu
 * @since 1/5/2018
 */
@Repository
public class UserDAOImpl implements UserDAO {

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public UserDAOImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public User findOne(Long userId) {
        String SQL = "SELECT * FROM USERS WHERE ID = :userID ";

        SqlParameterSource namedParameters = new MapSqlParameterSource("userID", userId);

        return namedParameterJdbcTemplate.queryForObject(SQL, namedParameters, (resultSet, i) ->
                new User(resultSet.getInt("ID"),
                        resultSet.getString("USER_NAME"),
                        resultSet.getString("EMAIL"),
                        resultSet.getString("PASSWORD"),
                        resultSet.getString("FIRST_NAME"),
                        resultSet.getString("LAST_NAME"),
                        resultSet.getString("DOB"),
                        resultSet.getString("SEX"),
                        resultSet.getString("CITY"),
                        resultSet.getString("REGISTER_DATE"),
                        resultSet.getInt("ID_TYPE")
                ));
    }

    @Override
    public User findOneByUserName(String userName) {
        String SQL = "SELECT * FROM USERS WHERE USER_NAME = :userName ";

        SqlParameterSource namedParameters = new MapSqlParameterSource("userName", userName);



        return namedParameterJdbcTemplate.queryForObject(SQL, namedParameters, (resultSet, i) ->
                new User(
                        resultSet.getInt("ID"),
                        resultSet.getString("USER_NAME"),
                        resultSet.getString("EMAIL"),
                        resultSet.getString("PASSWORD"),
                        resultSet.getString("FIRST_NAME"),
                        resultSet.getString("LAST_NAME"),
                        resultSet.getString("DOB"),
                        resultSet.getString("SEX"),
                        resultSet.getString("CITY"),
                        resultSet.getString("REGISTER_DATE"),
                        resultSet.getInt("ID_TYPE")
                        ));
    }

    @Override
    public void registerUser(User user) {

        String sqlInsert = "" +
                "INSERT INTO USERS(ID, USER_NAME, FIRST_NAME, LAST_NAME, PASSWORD, DOB, EMAIL, SEX, CITY, REGISTER_DATE, ID_TYPE) VALUES( " +
                "    :id, " +
                "    :userName, " +
                "    :firstName, " +
                "    :lastName, " +
                "    :password, " +
                "    :dob, " +
                "    :email, " +
                "    :sex, " +
                "    :city, " +
                "    :registerDate, " +
                "    :idType, " +
                ")";

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();

        namedParameters.addValue("id", user.getId());
        namedParameters.addValue("userName", user.getUserName());
        namedParameters.addValue("email", user.getEmail());
        namedParameters.addValue("password", user.getPassword());
        namedParameters.addValue("firstName", user.getFirstName());
        namedParameters.addValue("lastName", user.getLastName());
        namedParameters.addValue("dob", user.getDob());
        namedParameters.addValue("sex", user.getSex());
        namedParameters.addValue("city", user.getCity());
        namedParameters.addValue("registerDate", user.getRegisterDate());
        namedParameters.addValue("idType", user.getUser_role_id());

        jdbcTemplate.update(sqlInsert, namedParameters);
    }

}
