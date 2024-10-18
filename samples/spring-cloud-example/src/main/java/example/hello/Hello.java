package example.hello;

import example.hello.model.*;
import example.hello.repositories.PaymentDao;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class Hello implements Function<User, Greeting> {

    private PaymentDao paymentDao;
    private PaymentClient client;

    @Override
    public Greeting apply(User user) {
        List<Payment> payments = client.getPayments();
        paymentDao.saveAll(payments);
        return new Greeting("Hello, " + user.getName() + "!\n");
    }
}
