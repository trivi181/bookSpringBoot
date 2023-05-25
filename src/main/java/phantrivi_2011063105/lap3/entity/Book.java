package phantrivi_2011063105.lap3.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import phantrivi_2011063105.lap3.Validator.annotation.ValidCategoryId;

@Data
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    @NotEmpty(message = "Title must not be empty")
    @Size(max = 50,min = 1,message = "Title must be less than 50 characters")
    private String title;
    @Column(name = "author")
    private String author;
    @Column(name = "price")
    @NotNull(message = "Price is required")
    private Double price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    @ValidCategoryId
    private Category category;
}
