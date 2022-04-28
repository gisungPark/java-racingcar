package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    private Car car1;
    private Car car2;
    private Car car3;

    @BeforeEach
    void init() {
        car1 = new Car();
        car2 = new Car();
        car3 = new Car();
    }

    @Test
    @DisplayName("자동차가 최초에 생성되면 거리가 0이다.")
    void racing_start() {
        Assertions.assertThat(car1.getDistance()).isEqualTo(0);
        Assertions.assertThat(car2.getDistance()).isEqualTo(0);
        Assertions.assertThat(car3.getDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차의 속도가 4이상이면 이동거리가 1씩 증가한다. (1회)")
    void racing_once() {
        move(4, 3, 5);

        Assertions.assertThat(car1.getDistance()).isEqualTo(1);
        Assertions.assertThat(car2.getDistance()).isEqualTo(0);
        Assertions.assertThat(car3.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차의 속도가 4이상이면 이동거리가 1씩 증가한다. (3회)")
    void racing_multiple() {
        int round = 3;

        while (round-- > 0) {
            move(8, 9, 1);
        }

        Assertions.assertThat(car1.getDistance()).isEqualTo(3);
        Assertions.assertThat(car2.getDistance()).isEqualTo(3);
        Assertions.assertThat(car3.getDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차의 속도가 음수이면 예외가 발생한다.")
    void racing_minus() {
        assertThatThrownBy(() -> {
            move(8, 9, -1);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("속도는 음수값을 입력할 수 없습니다.");
    }

    private void move(int speed1, int speed2, int speed3) {
        car1.move(speed1);
        car2.move(speed2);
        car3.move(speed3);
    }
}