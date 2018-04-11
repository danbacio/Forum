package ro.mindit.forum.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import ro.mindit.forum.domain.Posts;
import ro.mindit.forum.domain.User;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PostsDAOImpl implements PostsDAO{

    @Autowired
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public PostsDAOImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Posts> getAllPostsByUserID(int userID) {
        String sqlSelect = "" +
                "SELECT " +
                "    * " +
                "FROM USERS users1 " +
                "INNER JOIN POSTS posts1 " +
                "   ON users1.ID = posts1.USER_ID " +
                "WHERE posts1.USER_ID = :userID ";

        return jdbcTemplate.execute(sqlSelect, preparedStatement -> {
            ResultSet rs = preparedStatement.executeQuery();
            List<Posts> results = new ArrayList<>();

            while(rs.next()) {
                Posts post = new Posts();
                post.setUser_id(rs.getInt("USER_ID"));
                post.setId(rs.getInt("ID"));
                post.setTitle(rs.getString("TITLE"));
                post.setPost(rs.getString("POST"));
                results.add(post);
            }
            return results;
        });
    }

    @Override
    public List <Posts> getAllPosts() {
        String sqlSelect = " SELECT * FROM POSTS " ;

        return jdbcTemplate.execute(sqlSelect, preparedStatement -> {
            ResultSet rs = preparedStatement.executeQuery();
            List<Posts> results = new ArrayList<>();

            while(rs.next()) {
                Posts post = new Posts();
                post.setUser_id(rs.getInt("USER_ID"));
                post.setId(rs.getInt("ID"));
                post.setTitle(rs.getString("TITLE"));
                post.setPost(rs.getString("POST"));
                results.add(post);
            }
            return results;
        });
    }

    public void registerPost(Posts post) {

        String sqlInsert = "" +
                "INSERT INTO POSTS(ID, USER_ID, TITLE, POST) VALUES( " +
                "    :id, " +
                "    :user_id, " +
                "    :title, " +
                "    :post, " +
                ")";

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id", post.getId());
        namedParameters.addValue("user_id", post.getUser_id());
        namedParameters.addValue("title", post.getTitle());
        namedParameters.addValue("post", post.getPost());

        jdbcTemplate.update(sqlInsert, namedParameters);
    }

}
