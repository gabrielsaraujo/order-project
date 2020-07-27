package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private Date moment;
	private OrderStatus status;
	private Client client;
	
	private List<OrderItem> list = new ArrayList<>();
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
	SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
	
	public Order() {
	}
	
	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getList() {
		return list;
	}

	
	public void addItem(OrderItem item) {
		list.add(item);
	}
	
	public void removeItem(OrderItem item) {
		list.remove(item);
	}
	
	public Double totalValue() {
		Double total = 0.0;
		for(OrderItem x : list) {
			total += x.subTotal();
		}
		
		return total;
	}
	
	@Override
	public String toString() {
		StringBuilder items = new StringBuilder();
		for(OrderItem x : list) {
			items.append("\n" + x.getProduct().getName() + ", $" + String.format("%.2f", x.getPrice()) + ", Quantity: " + x.getQuantity());
			items.append(", Subtotal: $" + String.format("%.2f", x.subTotal()));
		}
		
		StringBuilder summary = new StringBuilder(); 
			summary.append("\nORDER SUMMARY: " );
			summary.append("\nOrder moment: " + sdf.format(moment) );
			summary.append("\nOrder status: " + status );
			summary.append("\nClient: " + client.getName() + " (" + sdf1.format(client.getBirthDate()) + ") - " + client.getEmail() );
			summary.append("\nOrder items: " );
			summary.append(items);
			summary.append("\nTotal price: $" + String.format("%.2f", totalValue()) );
			
		return summary.toString();
	
	}
	

}
