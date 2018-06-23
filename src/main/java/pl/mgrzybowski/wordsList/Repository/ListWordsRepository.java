package pl.mgrzybowski.wordsList.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mgrzybowski.wordsList.model.WordListEntity;

@Repository
public interface ListWordsRepository extends JpaRepository<WordListEntity, Long> {


}
