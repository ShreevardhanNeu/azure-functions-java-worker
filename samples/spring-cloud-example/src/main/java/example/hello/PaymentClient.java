package example.hello;

import example.hello.model.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@FeignClient(name = "paymentClient", url = "http://localhost:8080")
public interface PaymentClient {

    @GetMapping("/hello/payments")
    public List<Payment> getPayments();
}
