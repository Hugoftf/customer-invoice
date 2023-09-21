package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.println("Enter Client Data: ");
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Email: ");
			String email = sc.nextLine();
			System.out.print("Birth Date (DD/MM/YYYY): ");
			Date birthDate = sdf.parse(sc.next());
			Client client = new Client(name, email, birthDate);
			
			System.out.println("Enter order data: ");
			System.out.print("Status: ");
			OrderStatus status = OrderStatus.valueOf(sc.next());
			System.out.print("How many item data: ");
			int n = sc.nextInt();
			Order order = new Order(new Date(), status, new Client(name, email, birthDate));

			for (int i = 1; i <= n; i++) {
				System.out.println("Enter #" + i + " item data: ");
				sc.nextLine();
				System.out.print("Product Name: ");
				String productName = sc.nextLine();
				System.out.print("Product Price: ");
				double priceProduct = sc.nextDouble();
				System.out.print("Quantity: ");
				int quantityproduct = sc.nextInt();

				OrderItem item = new OrderItem(quantityproduct, priceProduct, new Product(productName, priceProduct));
				order.addItem(item);
				
			}
			
			System.out.println();
			System.out.println(order.toString());
			
		} catch (ParseException e) {
			System.out.println();
			System.out.println("Error: ");
			e.printStackTrace();
		}
		catch (IllegalArgumentException e) {
			System.out.println();
			System.out.println("Error: ");
			e.printStackTrace();
		}
		
		System.out.println("End of Program");
		
		sc.close();

	}

}
