package pl.mgrzybowski.user.model;

import lombok.*;
import pl.mgrzybowski.wordsList.model.WordListEntity;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "G_USER")
public class UserEnity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String name;
    private String surname;

    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "owner")
    private Set<WordListEntity> wordListSet;
}
