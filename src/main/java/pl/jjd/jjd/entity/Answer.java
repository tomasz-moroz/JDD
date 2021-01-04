package pl.jjd.jjd.entity;

import lombok.Data;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;


@Entity(name = "Answer")
@Table(name = "answer")
@Data
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String answer;

    @OneToOne(mappedBy = "answer",fetch = FetchType.LAZY, optional = false)
    private Question question;
}
