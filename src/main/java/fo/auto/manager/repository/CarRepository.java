package fo.auto.manager.repository;

import fo.auto.manager.dto.CarDTO;
import fo.auto.manager.entity.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends
        PagingAndSortingRepository<Car,Long>
//        JpaRepository<Car,Long>
{

//    @Query("SELECT c FROM Car ")
//    Page<CarDTO> findPagebleCars(Pageable pageable);
}
