package at.technikumwien.blog.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Data
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_news_author")
public class NewsAuthor {
    @EmbeddedId
    private NewsAuthorId id;

    @ManyToOne
    @MapsId("authorId")
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne
    @MapsId("newsId")
    @JoinColumn(name = "news_id")
    private News news;


    public NewsAuthor(News news, Author author) {
        this.id = new NewsAuthorId(news.getId(), author.getId());
        this.news = news;
        this.author = author;
    }
}
