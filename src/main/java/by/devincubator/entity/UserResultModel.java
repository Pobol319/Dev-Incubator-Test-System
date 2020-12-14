package by.devincubator.entity;


import java.util.List;

public class UserResultModel {

    String description;
    String isCorrect;
    List<String> literatureList;
    List<String> linkList;

    public UserResultModel(String description, String isCorrect, List<String> literature, List<String> link) {
        this.description = description;
        this.isCorrect = isCorrect;
        this.literatureList = literature;
        this.linkList = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(String isCorrect) {
        this.isCorrect = isCorrect;
    }

    public List<String> getLiteratureList() {
        return literatureList;
    }

    public void setLiteratureList(List<String> literatureList) {
        this.literatureList = literatureList;
    }

    public List<String> getLinkList() {
        return linkList;
    }

    public void setLinkList(List<String> linkList) {
        this.linkList = linkList;
    }
}
