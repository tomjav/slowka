package pl.mgrzybowski.wordsList.model;

import lombok.Data;
import pl.mgrzybowski.user.model.UserEnity;

import javax.persistence.*;

@Data
@Entity
@Table(name = "G_WORD_LIST")
public class WordListEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long wordListId;

    private String NameList;

    @ManyToOne
    private UserEnity owner;
}
