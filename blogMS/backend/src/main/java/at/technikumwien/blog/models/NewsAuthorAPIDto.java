package at.technikumwien.blog.models;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonDeserialize
public class NewsAuthorAPIDto {
    public List<Long> authorIds;
    public String attractionName;
    public String newsTitle;
    public String newsText;
}
