package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;

/**
 * Created by orlando.sosa on 1/10/2017.
 */
@Entity
public class Post extends Model {

    public String title;
    public Date postedAt;
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    public List<Comment> comments;


    //esta annotation es avisar a la db que use large text database to store en content.
    @Lob
    public String content;

    @ManyToOne
    public User author;

    public Post(User author, String title, String content){
        this.comments = new ArrayList<Comment>();
        this.author = author;
        this.title = title;
        this.content = content;
        this.postedAt = new Date();
    }

    public Post addComment(String author, String content) {
        Comment newComment = new Comment(this, author, content).save();
        this.comments.add(newComment);
        this.save();
        return this;
    }
}
