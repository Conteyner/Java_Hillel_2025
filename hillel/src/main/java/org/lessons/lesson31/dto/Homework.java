package org.lessons.lesson31.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "homework")
public class Homework {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private LocalDate deadline;
    private int mark;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Override
    public String toString() {
        return "Homework{" +
                "id=" + id +
                ", description='" + description + '\n' +
                ", deadline=" + deadline +
                ", mark=" + mark +
                '}';
    }
}
