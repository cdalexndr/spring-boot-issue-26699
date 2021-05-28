package example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import java.util.concurrent.ExecutionException;

@SpringBootTest
public class Test extends AbstractTestNGSpringContextTests {
    @Autowired
    SomeService someService;

    @org.testng.annotations.Test
    public void test() throws ExecutionException, InterruptedException {
        someService.asyncTask().get();
    }
}
