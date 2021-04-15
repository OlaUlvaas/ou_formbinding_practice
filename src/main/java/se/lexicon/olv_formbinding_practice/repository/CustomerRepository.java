package se.lexicon.olv_formbinding_practice.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.olv_formbinding_practice.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, String> {

}
