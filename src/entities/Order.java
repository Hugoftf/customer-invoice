package entities; 

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date moment;
	private OrderStatus orderStatus;
	
	private Client client;
	private List<OrderItem> items = new ArrayList<>();
	
	public Order(Date moment, OrderStatus orderStatus, Client client) {
		this.moment = moment;
		this.orderStatus = orderStatus;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public double total() {
		double sum = 0.0;
		for (OrderItem item : items) {
			sum += item.subTotal();
		}
		return sum;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMMARY" + "\n");
		sb.append("Order moment: " );
		sb.append(moment + "\n");
		sb.append("Order status: ");
		sb.append(orderStatus + "\n");
		sb.append("Client: ");
		sb.append(client.getName()  + " (" + sdf.format(client.getBithrDate()) + ")" + " - " + client.getEmail() + "\n");
		sb.append("ORDEM ITEMS: ");
		for (OrderItem item : items) {
			sb.append("Name: " + item.getProduct().getName() +  " Price: " + String.format("%.2f",item.getProduct().getPrice()) + "  Quantity: " + item.getQuantity() + " Subtotal:" + String.format("%.2f", item.subTotal()) + "\n");
		}
		sb.append(total());
		return sb.toString();
	}
}
