package ShoppingCartProject.ShoppingCart;
import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor

@Table(name = "customer_shopping_cart")
public class Customer {
    @Id
    @Column(name = "custId")
    private String custId;

    @Column(name="productId")
    private String productId;

    @Column(name="custName")
    private String productName;

    @Column(name = "productQuantity")
    private String productQuantity;

    @Column(name = "custName")
    private String custName;

    @Column(name = "custEmail")
    private String custEmail;

    @Column(name = "custMobile")
    private String custMobile;

    @Column(name = "totalCostOfProducts")
    private float totalCostOfProducts;
}

