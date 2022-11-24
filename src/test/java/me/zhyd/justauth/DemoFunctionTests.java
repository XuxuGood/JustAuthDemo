package me.zhyd.justauth;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author xiaoxuxuy
 * @date 2022/3/27 12:31 下午
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoFunctionTests {

    @Test
    public void function() {
        // Function函数的使用
        Integer addResult = compute(3, value -> value + value);
        System.out.println("加法结果：" + addResult);

        Integer subResult = compute(3, value -> value - 1);
        System.out.println("减法结果：" + subResult);

        Integer multiplicationResult = compute(3, value -> value * value);
        System.out.println("乘法结果：" + multiplicationResult);

        Integer divisionResult = compute(6, value -> value / 3);
        System.out.println("除法结果：" + divisionResult);

        // 使用compose场景, 从右向左处理, 这里就是 (6 * 6) + 10 = 46
        Integer composeResult = computeForCompose(6,
                value -> value + 10,
                value -> value * value);
        System.out.println("Function compose 结果：" + composeResult);

        // 使用andThen场景, 从左向右处理, 这里就是(3 + 20) - 10 = 13
        Integer andThenResult = computeForAndThen(3,
                value -> value + 20,
                value -> value - 10);
        System.out.println("Function andThen 结果：" + andThenResult);

        // 使用 BiFunction场景, 这里是 2 + 3 = 5
        Integer biFuncResult = computeForBiFunction(2, 3,
                (v1, v2) -> v1 + v2);
        System.out.println("BiFunction 结果：" + biFuncResult);

        // 使用 BiFunction andThen场景, 这里是 (2 * 3) + 6 = 12
        Integer biFuncAndThenResult = computeForBiFunctionAndThen(2, 3,
                (v1, v2) -> v1 * v2, v1 -> v1 + 6);
        System.out.println("BiFunction andThen 结果：" + biFuncAndThenResult);
    }

    /**
     * 使用Function函数
     *
     * @param num
     * @param function
     * @return
     */
    private Integer compute(Integer num, Function<Integer, Integer> function) {
        return function.apply(num);
    }

    /**
     * 使用compose函数，简单的说，就是从右向左处理。
     *
     * @param num
     * @param function1
     * @param function2
     * @return
     */
    private Integer computeForCompose(Integer num,
                                      Function<Integer, Integer> function1,
                                      Function<Integer, Integer> function2) {
        return function1.compose(function2).apply(num);
    }

    /**
     * 使用andThen函数，简单的说，就是从左向右处理。
     *
     * @param num
     * @param function1
     * @param function2
     * @return
     */
    private Integer computeForAndThen(Integer num,
                                      Function<Integer, Integer> function1,
                                      Function<Integer, Integer> function2) {
        return function1.andThen(function2).apply(num);
    }

    /**
     * 使用BiFunction函数
     *
     * @param num1
     * @param num2
     * @param biFunction
     * @return
     */
    private Integer computeForBiFunction(Integer num1, Integer num2,
                                         BiFunction<Integer, Integer, Integer> biFunction) {
        return biFunction.apply(num1, num2);
    }

    /**
     * 使用BiFunction andThen方法
     *
     * @param num1
     * @param num2
     * @param biFunction
     * @param function
     * @return
     */
    private Integer computeForBiFunctionAndThen(Integer num1, Integer num2,
                                                BiFunction<Integer, Integer, Integer> biFunction,
                                                Function<Integer, Integer> function) {
        return biFunction.andThen(function).apply(num1, num2);
    }

}
