package by.devincubator.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer linkId;
    private String link;

    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @OneToOne
    @JoinColumn(name = "literatureId", updatable = false)
    private Literature literature;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Link link1 = (Link) o;
        return linkId.equals(link1.linkId) &&
                link.equals(link1.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(linkId, link);
    }

    @Override
    public String toString() {
        return "Link{" +
                "linkId=" + linkId +
                ", link='" + link + '\'' +
                '}';
    }
}
