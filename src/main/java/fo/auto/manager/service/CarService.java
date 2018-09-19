package fo.auto.manager.service;

import fo.auto.manager.dto.CarDTO;
import fo.auto.manager.dto.RestMessageDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CarService {

    RestMessageDTO saveCar(CarDTO carDto);
    RestMessageDTO<CarDTO> getCarById(Long id);
    List<CarDTO> listOfCars();
    RestMessageDTO deleteCar(Long id);
    RestMessageDTO<CarDTO> updateCar(CarDTO carDto);
    Page<CarDTO> getPagebleCars(Pageable pageable);
//    Page<CarDTO> getPegableCars(int pageNumber,
//                                int pageSize
////                                ,String sort,
////                                String sortByField
//    );
}
