package ro.mindit.forum.repository;

import ro.mindit.forum.domain.Posts;
import java.util.List;

public interface PostsDAO {

    List<Posts> getAllPosts();

    List<Posts> getAllPostsByUserID(int userID);

    void registerPost(Posts post);


}
