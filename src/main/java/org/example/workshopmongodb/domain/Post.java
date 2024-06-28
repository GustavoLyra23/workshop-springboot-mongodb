package org.example.workshopmongodb.domain;

import org.example.workshopmongodb.dto.AuthorDto;
import org.example.workshopmongodb.dto.CommentDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Document
public class Post implements Serializable {

    @Id
    private String id;
    private Date date;
    private String title;
    private String body;
    private AuthorDto authorDto;
    private List<CommentDto> commentDtoList = new ArrayList<>();

    public Post() {
    }

    public AuthorDto getAuthorDto() {
        return authorDto;
    }

    public void setAuthorDto(AuthorDto authorDto) {
        this.authorDto = authorDto;
    }

    public List<CommentDto> getCommentDtoList() {
        return commentDtoList;
    }

    public void setCommentDtoList(List<CommentDto> commentDtoList) {
        this.commentDtoList = commentDtoList;
    }

    public Post(String id, Date date, String title, String body, AuthorDto authorDto) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.authorDto = authorDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public AuthorDto getAuthor() {
        return authorDto;
    }

    public void setAuthor(AuthorDto authorDto) {
        this.authorDto = authorDto;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
