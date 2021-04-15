package se.lexicon.olv_formbinding_practice.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class CustomerDetails {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String detailsId;

    @Column(nullable = false, length = 50)
    private String street;

    @Column(nullable = false, length = 5)
    private String zipCode;

    @Column(nullable = false, length = 30)
    private String city;

    @Column(nullable = false, length = 15)
    private String homePhone;

    @Column(nullable = false, length = 15)
    private String cellPhone;

}
