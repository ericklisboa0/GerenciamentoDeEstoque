package Entities;

public class OrderItem {
	private Integer Quantity;
	private Double Price;
	private Product product;
	
	public OrderItem(Integer productQuantity, Double productPrice, Product produto) {
		this.Quantity = productQuantity;
		this.Price = productPrice;
		this.product = produto;
	}

	public Integer getQuantity() {
		return Quantity;
	}

	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}

	public Double getPrice() {
		return Price;
	}

	public void setPrice(Double price) {
		Price = price;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double SubTotal()
	{
		return Quantity * Price;
	}

	@Override
	public String toString() {
		return  " Produto: " + product + 
				", Quantidade: " + Quantity + 
				", Subtotal: " + String.format("%.2f", SubTotal()) + "\n";

	
	}
}

