package fo.auto.manager.controller;

import fo.auto.manager.dto.CarDTO;
import fo.auto.manager.dto.RestMessageDTO;
import fo.auto.manager.entity.Car;
import fo.auto.manager.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @RequestMapping(value="/",method = RequestMethod.POST)
    @ResponseBody
    public RestMessageDTO createCar(@RequestBody CarDTO carDto){
        return carService.saveCar(carDto);
    }

    @RequestMapping(value="/cars/{id}",method=RequestMethod.GET)
    @ResponseBody
    public RestMessageDTO<CarDTO> getOneCarById(@PathVariable("id")Long carId){
        return carService.getCarById(carId);
    }

    @RequestMapping(value="/cars/update",method=RequestMethod.PATCH)
    public RestMessageDTO<CarDTO> updateCar(@RequestBody CarDTO carDto){
        return carService.updateCar(carDto);
    }

    @RequestMapping(value="/cars/{id}",method=RequestMethod.DELETE)
    @ResponseBody
    public RestMessageDTO deleteCar(@PathVariable("id")Long carId){
        return carService.deleteCar(carId);
    }

    @RequestMapping(value="/cars",method=RequestMethod.GET)
    @ResponseBody
    public List<CarDTO> getAllCars(){
        return carService.listOfCars();
    }

    @RequestMapping(value="/cars/list/",method=RequestMethod.GET)
    public Page<CarDTO> getPaginatedCar(
//            @RequestParam("limit")int limit,
//        @RequestParam("page") int pageNumber,
        Pageable pageable
    ){
        return carService.getPagebleCars(pageable);
    }
}
