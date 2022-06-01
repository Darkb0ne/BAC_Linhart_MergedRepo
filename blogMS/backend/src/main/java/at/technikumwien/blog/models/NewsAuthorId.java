package at.technikumwien.blog.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor @NoArgsConstructor
@Embeddable
@Getter
@Setter
public class NewsAuthorId implements Serializable {
    @Column(name = "news_id")
    private Long newsId;

    @Column(name = "author_id")
    private Long authorId;
}
