package com.example.test.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="comments", schema = "TMS")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long          id;
    private String        content;
//    private User          author;
//    private LocalDateTime timestamp;

    public Comment(Long id, String content
//            , User author, LocalDateTime timestamp
            ) {
        this.id = id;
        this.content = content;
//        this.author = author;
//        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
//                ", author=" + author +
//                ", timestamp=" + timestamp +
                '}';
    }
}
