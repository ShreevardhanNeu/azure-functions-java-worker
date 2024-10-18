package example.hello;

import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.microsoft.azure.functions.annotation.TimerTrigger;
import example.hello.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class HelloHandler {

    @Autowired
    private Hello hello;

    @FunctionName("hello")
    public void execute(
            @TimerTrigger(name = "timerInfo", schedule = "0 */30 * * * *") String timerInfo,
            ExecutionContext context) {
        context.getLogger().info("Greeting user name: " +timerInfo);
        hello.apply(timerInfo);
    }
}
