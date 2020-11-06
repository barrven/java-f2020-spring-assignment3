package ca.gbc.comp3095.assignment2.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class TestItem {
    @Id //identifies this field as the pk for the entity
    @GeneratedValue(strategy = GenerationType.AUTO) //tells hibernate that this pk should be auto-generated
    private Long id;
    private String info;

    public TestItem(String info) {
        this.info = info;
    }

    public TestItem() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestItem item = (TestItem) o;
        return Objects.equals(id, item.id);
    }

    //Mechanism to create hash value for this entity. If we pass in same attributes to an entity, then the hash code will be the same
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", info='" + info + '\'' +
                '}';
    }
}
