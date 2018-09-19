package fo.auto.manager.entity;

import fo.auto.manager.enums.UserRole;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode
@Data
@Entity
@Table(name="users")
@DynamicUpdate
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="second_name")
    private String secondName;
    @Enumerated(EnumType.STRING)
    @Column(name="user_role")
    private UserRole userRole;
    @OneToMany(mappedBy ="user" )
    private List<Car> listCars;

}
