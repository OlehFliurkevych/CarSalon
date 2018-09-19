package fo.auto.manager.dto;

import fo.auto.manager.entity.Car;
import lombok.*;

@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CarDTO {

    private long id;
    private String brand;
    private String model;
    private long userId;

}
