package pl.mgrzybowski.wordsList.model;

import lombok.Data;

@Data
public class ListWordsDto {
    private Long listId;
    private String listName;
    private Long ownerId;
}
