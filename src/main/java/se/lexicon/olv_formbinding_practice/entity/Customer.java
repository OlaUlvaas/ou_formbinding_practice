package se.lexicon.olv_formbinding_practice.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Entity
public class Customer {



    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(nullable = false, updatable = false)
    private String customerId;

    @Email(message = "not an email")
    @Size(min = 2, max = 60, message = "Must be between 2 and 20")
    @Column(nullable = false, length = 60)
    private String email;

    @CreationTimestamp
    @Column(nullable = false, columnDefinition = "TIMESTAMP default CURRENT_TIMESTAMP")
    private LocalDate regDate;

    @Column(nullable = false, columnDefinition = "tinyint(1) default 1")
    private boolean active;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private CustomerDetails details;
}
