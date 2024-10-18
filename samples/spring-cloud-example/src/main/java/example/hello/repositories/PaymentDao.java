package example.hello.repositories;

import example.hello.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PaymentDao extends JpaRepository<Payment, Long> {

}
