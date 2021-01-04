package pl.jjd.jjd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Question")
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "question", unique = true, length = 1000)
    private String question;

    @Column(name = "answer", unique = true, length = 1500)
    private String answer;

    @Column
    private String category;

}
