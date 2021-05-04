import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarTest {

    private List<Car> carList = new ArrayList<>();
    private Cars cars;
    private RacingCar racingCar = new RacingCar();
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
    void getCarNamesByDistance() {
        Car car = carList.get(0);
        car.moveCar(car, 5);
        assertThat(racingCar.getCarNamesByDistance(car,1).equals("a"));
    }



    @Test
    void createCar() {
        Car car = racingCar.createCar("ab");
        assertThat(car.getDistance() == 0);
    }

    @Test
    void validationArray() {
        Exception exception = racingCar.validationArray("ab");
        String expectedMessage = "이름 나열을 다시 해주세요.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void validationName() {
        Exception exception = racingCar.validationName("");
        String expectedMessage = "이름 나열을 다시 해주세요.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}