package pl.mgrzybowski.wordsList;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.mgrzybowski.user.model.UserEnity;
import pl.mgrzybowski.user.repository.UserRepository;
import pl.mgrzybowski.wordsList.Repository.ListWordsRepository;
import pl.mgrzybowski.wordsList.model.ListWordsDto;
import pl.mgrzybowski.wordsList.model.WordListEntity;

import java.util.Optional;


@Slf4j
@RestController
public class WordListController {
    @Autowired
    private ListWordsRepository listWordsRepository;

    @Autowired
    private UserRepository userRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = " /listwords")
    public Long addListWord(ListWordsDto listWordsDto) {

        Long userId = listWordsDto.getOwnerId();

        Optional<UserEnity> userOpt = userRepository.findById(userId);
        UserEnity user = userOpt.orElseThrow(() -> new RuntimeException("Nie ma takiego user"));

        WordListEntity entity = new WordListEntity();
        entity.setNameList(listWordsDto.getListName());
        entity.setOwner(user);

        return listWordsRepository.save(entity).getWordListId();
    }


}
