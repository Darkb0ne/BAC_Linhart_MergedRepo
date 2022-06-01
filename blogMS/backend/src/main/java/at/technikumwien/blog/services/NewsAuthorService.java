package at.technikumwien.blog.services;

import at.technikumwien.blog.models.NewsAuthor;
import at.technikumwien.blog.repositories.NewsAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NewsAuthorService {

    @Autowired
    private NewsAuthorRepository newsAuthorRepository;

    public Map<Long, Integer> sumUpViewCountsOfAuthors(){
        //List<Author> allAuthors = authorRepository.findAll();
        Map<Long, Integer> authorCommissionsMap = new HashMap<>();
        newsAuthorRepository.findAll().forEach(newsAuthor -> {
            int viewCountOfNews = newsAuthor.getNews().getViewCount();
            long authorId = newsAuthor.getAuthor().getId();
            if(authorCommissionsMap.containsKey(authorId)){
                authorCommissionsMap.replace(authorId, authorCommissionsMap.get(authorId) + viewCountOfNews);
            }
            else{
                authorCommissionsMap.put(authorId,viewCountOfNews);
            }
            System.out.println("NewsAuthorId: " + authorId + " And they have " + authorCommissionsMap.get(authorId)+ " views");
        });

        return authorCommissionsMap;
    }

    public List<NewsAuthor> findAllByNewsId(Long newsId){
       return newsAuthorRepository.findNewsAuthorByNewsId(newsId);
    }

    public void saveNewsAuthor(NewsAuthor newsAuthor){
        newsAuthorRepository.save(newsAuthor);
    }


}
