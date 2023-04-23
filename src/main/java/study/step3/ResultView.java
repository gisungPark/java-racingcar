package study.step3;

public class ResultView {

    public void printStateBoard(Cars cars) {
        for (Car car : cars.asList()) {
            System.out.println(car.getName() + " : " + printCarPosition(car.getPosition()));
        }
        System.out.println();
    }

    String printCarPosition(Position position) {
        return "-".repeat(position.getPosition());
    }

    public void printWinner(String winners) {
        System.out.println(winners + "가 최종 우승했습니다.");
    }


}
