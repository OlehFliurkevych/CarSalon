package fo.auto.manager.service.impl;

import com.mysql.jdbc.StringUtils;
import fo.auto.manager.dto.CarDTO;
import fo.auto.manager.dto.RestMessageDTO;
import fo.auto.manager.entity.Car;
import fo.auto.manager.repository.CarRepository;
import fo.auto.manager.service.CarService;
import fo.auto.manager.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;
    private ObjectMapperUtils modelMapper;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, ObjectMapperUtils modelMapper) {
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public RestMessageDTO saveCar(CarDTO carDto) {
        if (StringUtils.isNullOrEmpty(carDto.getBrand()) ||
                StringUtils.isNullOrEmpty(carDto.getModel()) ||
                carDto.getId() <= 0 ||
                carDto.getUserId() <= 0
        ) {
            throw new RuntimeException("Invalid data");
        }
        Car car = modelMapper.map(carDto, Car.class);
        carRepository.save(car);
        return RestMessageDTO.createCorrectMessage("Car saved");
    }

    @Override
    public RestMessageDTO<CarDTO> getCarById(Long id) {
        if (id <= 0) {
            throw new RuntimeException("Invalid data");
        }
        Optional<Car> entity = carRepository.findById(id);
        if (!entity.isPresent()) {
            throw new RuntimeException("Invalid data");
        }
        CarDTO carDTO = modelMapper.map(entity.get(), CarDTO.class);
        return new RestMessageDTO<>(carDTO, true);
    }

    @Override
    public List<CarDTO> listOfCars() {
//        List<Car> carEntities = carRepository.findAll();
//        List<CarDTO> carDTOs = modelMapper.mapAll(carEntities, CarDTO.class);
//        return carDTOs;
        return null;
    }

    @Override
    public RestMessageDTO deleteCar(Long id) {
        carRepository.deleteById(id);
        return RestMessageDTO.createCorrectMessage("Car with id = " + id + " deleted");
    }

    @Override
    public RestMessageDTO updateCar(CarDTO carDto) {
        if(carDto.getId() <= 0 ) {
            throw new RuntimeException("Invalid data");
        }
        Optional<Car> entity = carRepository.findById(carDto.getId());
        Car car;
        if(!entity.isPresent()){
            throw new RuntimeException("Invalid data");
        }else{
            car=entity.get();
        }
        if(!StringUtils.isNullOrEmpty(carDto.getBrand())){
            car.setBrand(carDto.getBrand());
        }
        if(!StringUtils.isNullOrEmpty(carDto.getModel())){
            car.setModel(carDto.getModel());
        }
        if(carDto.getUserId() <= 0){
            throw new RuntimeException("Invalid data");
        }

        carRepository.save(entity.get());
        return RestMessageDTO.createCorrectMessage("Succes update");
    }

    @Override
    public Page<CarDTO> getPagebleCars(Pageable pageable) {
        List<Car> carList = carRepository.findAll(pageable).getContent();
        List<CarDTO> carDtoList=modelMapper.mapAll(carList,CarDTO.class);
        Page<CarDTO> cars = new PageImpl<>(carDtoList);
        return cars;
    }


//    @Override
//    public Page<CarDTO> getPegableCars(int pageNumber, int pageSize
// //           , String sort, String sortByField
//    ) {
//        PageRequest request=new PageRequest(
//                pageNumber-1,
//                pageSize
////                ,sort.toUpperCase().equals("ASC")? Sort.Direction.ASC:Sort.Direction.DESC,
////                sortByField
//        );
//        return carRepository.findPagebleCars(request);
//}
}
