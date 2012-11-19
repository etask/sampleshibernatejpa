#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Product 
{	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long productId;
	@Column
	private String productName;	
	@Column
	private String productDescription;
	@Column(nullable=false)
	private Long price;	
	@OneToMany(mappedBy="products")
	private Set<Order> orders = new HashSet<Order>();
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	
	public String toString()
	{
		return "id: "+productId+"${symbol_escape}nname: "+productName+"${symbol_escape}ndesc: "+productDescription;
	}
	
	
}
