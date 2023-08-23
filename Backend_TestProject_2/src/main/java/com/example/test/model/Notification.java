package com.example.test.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="notifications", schema = "TMS")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long   id;
//    private User   recipient;
    private String        message;
    private LocalDateTime timestamp;

    public Notification(Long id,
//            User recipient,
            String message, LocalDateTime timestamp) {
        this.id = id;
//        this.recipient = recipient;
        this.message = message;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id=" + id +
//                ", recipient=" + recipient +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
