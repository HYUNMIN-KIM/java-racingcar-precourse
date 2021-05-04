import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingCar {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        RacingCar rc = new RacingCar();
        System.out.println("자동차 생성 : ");
        Cars cars = new Cars(rc.createCarList());
        System.out.println("횟수 입력 : ");
        int count = scanner.nextInt();

        for(int i = 0;i < count; i++){
            cars.moveCars();
            cars.printCarRacer();
        }

        int longestDistance = cars.getLongestDistance();
        for(Car car : cars.getCarList()){
            System.out.println(rc.getCarNamesByDistance(car, longestDistance) + " ");
        }

        System.out.println("승리하였습니다.");

    }




    public String getCarNamesByDistance(Car car, int distance){
        if(car.getDistance() == distance){
            return car.getCarName();
        }

        return "";
    }

    public List<Car> createCarList() {
        String cars = scanner.next();
        validationArray(cars);
        String[] carArray = cars.split(",");

        List<Car> carList = new ArrayList<>();

        for(String carName : carArray) {
            validationName(carName);
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

    public Exception validationArray(String cars){
        if(!cars.contains(",")){
            return new Exception("이름 나열을 다시 해주세요.");
        }
        return null;
    }

    public Exception validationName(String carName){
        if(carName.equals("")){
            return new Exception("이름 나열을 다시 해주세요.");
        }
        return null;
    }

}
