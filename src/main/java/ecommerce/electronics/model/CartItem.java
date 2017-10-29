package ecommerce.electronics.model;

public class CartItem {
	
	private Long productId;
	private String name;
	private String color;
	private int totalQuantity;
	private Double totalPrice;
	
	public CartItem(Long productId, String name, String color, int totalQuantity, Double totalPrice) {
		super();
		this.productId = productId;
		this.name = name;
		this.color = color;
		this.totalQuantity = totalQuantity;
		this.totalPrice = totalPrice;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "ShoppingCart [productId=" + productId + ", name=" + name + ", color=" + color + ", totalQuantity="
				+ totalQuantity + ", totalPrice=" + totalPrice + "]";
	}
}
