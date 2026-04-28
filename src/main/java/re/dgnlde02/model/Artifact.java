package re.dgnlde02.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "artifacts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Artifact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Name khong duoc bo trong")
    @Size(min = 5, max = 150,message = "Tu 5 - 150 ky tu")
    private String name;

    @NotBlank(message = "Origin khong duoc bo trong")
    private String origin;

    @PastOrPresent(message = "Date khong duoc la ngay trong tuong lai")
    private LocalDate date;
}
