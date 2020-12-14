package by.devincubator.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Literature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer literatureId;
    private String description;

    public Integer getLiteratureId() {
        return literatureId;
    }

    public void setLiteratureId(Integer literatureId) {
        this.literatureId = literatureId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Link getLink() {
        return link;
    }

    public Question getQuestion() {
        return question;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @OneToOne(mappedBy = "literature", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Link link;

    @ManyToOne
    @JoinColumn(name = "questionId", updatable = false)
    private Question question;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Literature that = (Literature) o;
        return literatureId.equals(that.literatureId) &&
                description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(literatureId, description);
    }

    @Override
    public String toString() {
        return "Literature{" +
                "literatureId=" + literatureId +
                ", description='" + description +
                '}';
    }
}
