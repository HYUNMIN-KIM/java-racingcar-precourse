import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Car {

    String carName;
    int distance;

    private final int STANDARD_NUM = 4;

    public void moveCar(Car car, int num){
        int distance = car.getDistance();
        distance = distance + addDistance(num);
        car.setDistance(distance);

    }

    public int addDistance(int random) {
        if(random >= STANDARD_NUM) {
            return 1;
        }

        return 0;
    }

}
