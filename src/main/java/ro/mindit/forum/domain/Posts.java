package ro.mindit.forum.domain;

public class Posts {

    private String title;
    private int user_id;
    private int id;

    public Posts() {
    }

    public Posts(String title, int user_id, int id, String post) {
        this.title = title;
        this.user_id = user_id;
        this.id = id;
        this.post = post;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String post;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
