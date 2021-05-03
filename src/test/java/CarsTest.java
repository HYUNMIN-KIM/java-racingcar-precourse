import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class CarTest {

    private List<Car> carList = new ArrayList<>();
    private Cars cars;
    @BeforeEach
    public void setUp(){
        carList.add(
                Car.builder().carName("a").distance(0)
                        .build());
        carList.add(
                Car.builder().carName("b").distance(0)
                        .build());
        carList.add(
                Car.builder().carName("c").distance(0)
                        .build());
        cars = new Cars(carList);

    }

    @Test
    void getCarList() {


    }

    @Test
    void moveCar() {
        Car car = carList.get(0);
        car.moveCar(car,4);
        assertThat(car.getDistance() == 1);

        Car car1 = carList.get(1);
        car.moveCar(car1,3);
        assertThat(car.getDistance() != 1);
    }


    @Test
    void getLongestDistance() {
        Car car = carList.get(0);
        car.moveCar(car,5);
        assertThat(cars.getLongestDistance() != 0);

    }
}