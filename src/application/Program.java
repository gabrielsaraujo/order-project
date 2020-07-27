package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import com.sun.source.doctree.AttributeTree.ValueKind;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;


public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter client data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.nextLine());
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.nextLine().toUpperCase());
		
		Order order = new Order(new Date(), status, new Client(name, email, birthDate));
		
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			System.out.println("Enter #" + (i + 1) + " item data: ");
			System.out.print("Product name: ");
			sc.nextLine();
			String pName = sc.nextLine();
			System.out.print("Product price: ");
			double pPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int pQuantity = sc.nextInt();
			
			order.addItem(new OrderItem(pQuantity, pPrice, new Product(pName, pPrice)));
		}
		
		System.out.println(order);
		
		sc.close();
	}

}
