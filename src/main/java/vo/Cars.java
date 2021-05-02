package vo;

import java.util.List;
import java.util.Random;

public class Cars {

    private List<Car> carList;

    public Cars(List<Car> carList){
        this.carList = carList;
    }

    public void moveCars(){
        for(Car car : carList){
            int distance = car.getDistance();
            distance = distance + addDistance(randomNumber());
            car.setDistance(distance);
        }
    }

    private int randomNumber() {
        Random rn = new Random();
        return rn.nextInt(10);
    }

    private int addDistance(int random) {
        if(random >= 4) {
            return 1;
        }

        return 0;
    }
}
