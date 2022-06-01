package at.technikumwien.blog.models;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Getter
@Setter
public class AuthorDto implements Serializable {

  private Long id;
  private String name;
  private String email;
}