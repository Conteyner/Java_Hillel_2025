package org.lessons.lesson31.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.lessons.lesson31.dao.GenericDao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "student")
public class Student{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Homework> homeworks = new HashSet<>();

    public void addHomework(final Homework homework) {
        homework.setStudent(this);
        homeworks.add(homework);
    }

    public void removeHomework(final Homework homework) {
        homeworks.remove(homework);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\n' +
                ", lastName='" + lastName + '\n' +
                ", email='" + email + '\n' +
                '}';
    }

}
