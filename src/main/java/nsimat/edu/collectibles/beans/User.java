package nsimat.edu.collectibles.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @DateTimeFormat(pattern = "YYYY-MM-dd")
    @NotNull(message = "Date of birth cannot be empty.")
    @Past(message = "User's date of birth cannot be a future date.")
    private Date dateOfBirth;

    @NotEmpty(message = "User's email cannot be empty.")
    @Email(message = "Should be a well-formed email address.")
    private String email;

    @NotEmpty(message = "Select at least one favorite character.")
    private String favoriteCollection;

    @NotEmpty(message = "User's gender cannot be empty.")
    private String gender;

    private String message;

    @NotEmpty(message = "User's name cannot be empty.")
    @Size(min = 1, max = 20, message = "Size must be between 1 and 20.")
    private String name;

    private boolean newsLetter;
}
