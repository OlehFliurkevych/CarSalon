package fo.auto.manager.dto;

import fo.auto.manager.enums.UserRole;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class UserDTO {

    private Long id;
    private String firstName;
    private String secondName;
    private UserRole userROLE;
    private List<CarDTO> listCars;
}
