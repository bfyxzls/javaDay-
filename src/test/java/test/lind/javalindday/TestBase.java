package test.lind.javalindday;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


@SpringBootTest
@ActiveProfiles("integTest")//指定profile环境
public abstract class TestBase {

}
