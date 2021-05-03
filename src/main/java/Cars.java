import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Cars {

    private List<Car> carList;

    private final int STANDARD_NUM = 4;

    public Cars(List<Car> carList){
        this.carList = carList;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void moveCars(){
        for(Car car : carList){
            car.moveCar(car,randomNumber());
        }
    }

    public int randomNumber() {
        Random rn = new Random();
        return rn.nextInt(10);
    }

    public void printCarRacer() {
        StringBuffer sb = new StringBuffer();
        for(Car car : carList){
            sb.append(car.getCarName());
            sb.append(drawDistance(car.getDistance()));
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private String drawDistance(int distance) {
        StringBuffer sb = new StringBuffer();
        for(int i= 0; i < distance; i++){
            sb.append("-");
        }

        return sb.toString();
    }

    public int getLongestDistance(){
        carList.sort(Comparator.comparing(Car::getDistance));
        Collections.reverse(carList);
        return carList.get(0).getDistance();
    }


}
