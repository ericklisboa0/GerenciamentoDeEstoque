package Entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import Entities.Enum.OrderStatus;

public class order {
	private Date Moment;
	private OrderStatus Status;
	
	private Client client;
	private List<OrderItem> OrderItems = new ArrayList<>();
	
	public order () {	
	}
	
	public order(Date Moment, OrderStatus Status, Client client)
	{
		this.Moment = Moment;
		this.Status = Status;
		this.client = client;
	}

	public Date getMoment() {
		return Moment;
	}
	public void setMoment(Date moment) {
		Moment = moment;
	}
	public OrderStatus getStatus() {
		return Status;
	}
	public void setStatus(OrderStatus status) {
		Status = status;
	}
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client cliente) {
		client = cliente;
	}
	
	public List<OrderItem> getOrderItem() {
		return OrderItems;
	}
	
	public void addOrderItem(OrderItem Items)
	{
		OrderItems.add(Items);
	}
	
	public void removeOrderItem(OrderItem Items)
	{
		OrderItems.remove(Items);
	}
	
	public double total() {
		double sum = 0.0;
		for (OrderItem item : OrderItems) {
			sum += item.SubTotal(); 
		}
		return sum;
	}

	@Override
	public String toString() {
		return  "Momento do pedido: " + Moment + 
				"\nStatus do Pedido: " + Status + 
				"\nCliente: " + client + 
				"\nItem:" +OrderItems+ 
				"\nTotal:" + String.format("%.2f",  total()) +"";
	}
	
	
}
