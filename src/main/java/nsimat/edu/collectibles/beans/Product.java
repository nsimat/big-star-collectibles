package nsimat.edu.collectibles.beans;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Product {

    @Id
    private int id;
    private String name;
    private int categoryId;
    private int robotId;
    private String color;
    private String imagePath;
    private int rating;
    private int noOfReviews;
    private String description;
    private int price;
}
