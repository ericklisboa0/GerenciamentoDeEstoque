package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Entities.Client;
import Entities.OrderItem;
import Entities.Product;
import Entities.order;
import Entities.Enum.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat var = new SimpleDateFormat("dd/MM/yyyy"); 

		Date y = new Date();
		
		System.out.println("Entre com os dados do cliente");
		System.out.print("Nome do cliente ");
		String nomeCliente = sc.nextLine();
		System.out.print("Email do client ");
		String emailCliente = sc.nextLine();
		System.out.print("Data de Nascimento do cliente ");
		Date dateCliente = var.parse(sc.next());
		sc.nextLine();
		
		Client clientDados = new Client(nomeCliente, emailCliente, dateCliente);
		
		System.out.println("Entre com os dados do pedido");
		System.out.print("Status do pedido: ");
		String orderStatus = sc.nextLine();
		while(! orderStatus.equals("PENDING_PAYMENT") && ! orderStatus.equals("PROCESSING") && ! orderStatus.equals("SHIPPED") && ! orderStatus.equals("DELIVERED"))
		{
			System.out.print("Status desconhecido, tente novamente: ");
			orderStatus = sc.nextLine();
		}
		System.out.print("Quantos items? ");
		Integer n = sc.nextInt();
		
		order result2 = new order(y, OrderStatus.valueOf(orderStatus), clientDados);
		
		for(int i = 0; i<n; i++) {
			
			sc.nextLine();
			System.out.print("Nome do Produto: ");
			String productName = sc.nextLine();
			System.out.print("Digite o preço: ");
			Double productPrice = sc.nextDouble();
			System.out.print("quantidade: ");
			Integer productQuantity = sc.nextInt();
			
			Product produto = new Product(productName, productPrice);
			
			OrderItem pedidoF = new OrderItem(productQuantity, productPrice, produto);
			
			result2.addOrderItem(pedidoF);
			
		}	
		
		System.out.println(result2.toString().replace("[","").replace("]",""));		
		
		sc.close();
	}

}
