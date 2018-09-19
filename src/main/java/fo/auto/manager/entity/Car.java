package fo.auto.manager.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter@Getter
@Data
@EqualsAndHashCode
@Entity
@Table(name="cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    private String brand;
    private String model;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
