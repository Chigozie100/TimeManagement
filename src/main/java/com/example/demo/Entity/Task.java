package com.example.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "Task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdDate;
    private String createdTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate updatedDate;
    private String updatedTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate completedDate;
    private String completedTime;

    private String status;

}
