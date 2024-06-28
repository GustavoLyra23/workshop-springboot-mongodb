package org.example.workshopmongodb.dto;

import org.example.workshopmongodb.domain.User;

public class AuthorDto {

  private String authorId;
  private String authorName;

  public AuthorDto() {
  }

  public AuthorDto(User user){
      authorId = user.getId();
      authorName = user.getName();
  }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
