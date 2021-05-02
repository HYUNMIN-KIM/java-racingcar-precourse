import vo.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingCar {

    private static Scanner scanner = new Scanner(System.in);



    public String getCarNamesByDistance(Car car, int distance){
        if(car.getDistance() == distance){
            return car.getCarName();
        }

        return "";
    }

    public List<Car> createCarList() {
        String cars = scanner.next();
        String[] carArray = cars.split(",");
        List<Car> carList = new ArrayList<>();

        for(String carName : carArray) {
            carList.add(createCar(carName));
        }
        carList.removeIf(n -> n.getCarName().length() == 0);
        return carList;

    }

    public Car createCar(String carName) {
        return Car.builder()
                .carName(carName)
                .distance(0)
                .build();
    }

}
