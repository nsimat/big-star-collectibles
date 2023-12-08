package nsimat.edu.collectibles.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Getter
@Setter
public class User {

    @Id
    private long id;

    @DateTimeFormat(pattern = "YYYY-MM-dd")
    @NotNull(message = "Date of birth cannot be empty")
    @Past(message = "Date of birth cannot be a future date")
    private Date dateOfBirth;

    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Should be a well-formed email address")
    private String email;

    @NotEmpty(message = "Select at least one favorite character")
    private String favoriteCollection;

    @NotEmpty(message = "Gender cannot be empty")
    private String gender;
    private String message;

    @NotEmpty(message = "Name cannot be empty.")
    @Size(min = 1, max = 20, message = "Size must be between 1 and 20")
    private String name;
    private boolean newsLetter;
}
