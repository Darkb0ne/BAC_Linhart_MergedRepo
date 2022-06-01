package at.technikumwien.blog.models;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor

@Getter
@Setter

@Entity
@Table(name = "t_news")
@Builder
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 1000)
    private String text;

    @Column(nullable = false)
    private LocalDate publicationDate;

    @Column(nullable=false)
    private int viewCount;

    @Column(nullable = false)
    private boolean topNews;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "attractionid")
    private Attraction attraction;

    /*
    @ManyToMany(mappedBy = "news",cascade = CascadeType.MERGE)
    @JoinTable(
            name = "t_news_author",
            joinColumns = @JoinColumn(name = "newsid"),
            inverseJoinColumns = @JoinColumn(name = "authorid")
    )
    private List<Author> authors;*/

    @OneToMany(mappedBy="news")
    private Set<NewsAuthor> newsAuthors = new HashSet<>();

}
