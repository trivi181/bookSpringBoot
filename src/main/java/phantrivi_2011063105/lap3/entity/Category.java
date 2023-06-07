package phantrivi_2011063105.lap3.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "category")
public class Category {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Book> books;
    @Override
    public boolean equals(Object o){
        if (this==o) return true;
        if (o==null || Hibernate.getClass(this)!=Hibernate.getClass(o)) return false;
        Category category = (Category) o;
        return getId()!= null && Objects.equals(getId(),category.getId());
    }
    @Override
    public int hashCode(){
        return getClass().hashCode();
    }
}
