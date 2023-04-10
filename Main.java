import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args){

            //banco de usuários e senhas
            String username = "admin";
            String password = "password";
            //banco de produtos e preços
            String[] products = {"Espresso", "Latte", "Cappuccino", "Americano"};
            double[] prices = {6.99, 8.99, 12.49, 6.99};

            //registradora de vendas
            ArrayList<String> sales = new ArrayList<>();
            double totalPrice = 0;

            //sistema de login
            Scanner input = new Scanner(System.in);
            System.out.println("------ ------ ------ ------ ------ ------ ");
            System.out.println("\tSeja bem-vindo ao Cafezito!");
            System.out.println("------ ------ ------ ------ ------ ------ ");
            System.out.print("\tInsira seu nome de usuário: ");
            String inputUserName = input.nextLine();
            System.out.print("\tInsira seu password: ");
            String inputPassword = input.nextLine();

            //auth user
            if (inputUserName.equals(username) && inputPassword.equals(password)) {
                System.out.println("------ ------ ------ ------ ------ ------ ");
                System.out.println("\t<< Login realizado com sucesso! >>");
                System.out.println("------ ------ ------ ------ ------ ------ ");             
            } else {
                System.out.println("\tCredenciais invalidas. System exit.");
                System.exit(0);
            }
            

            //produtos e preços window. 
            System.out.println("\nEstes são nossos produtos e preços:");
            
            for (int i = 0; i < products.length; i++) {
                System.out.printf("%-15s $%.2f\n", products[i], prices[i]);
            }

            //interface registro de vendas
            System.out.println("****** ****** ****** ****** ****** ******  ");
            System.out.println("\nRegistre o pedido (insira 'finalizado' para concluir):");
            String order = input.nextLine();

            while (!order.equals("finalizado")) {

                boolean isProductTrue = false;
                //loop de controle de registro dos items um a um.
                for (int i = 0; i < products.length; i++) {
                    if (order.equalsIgnoreCase(products[i])) {
                        sales.add(order);
                        totalPrice += prices[i];
                        isProductTrue = true;
                        break;
                    }
                }

                if (!isProductTrue) {
                    System.out.println("Produto não encontrado. Tente novamente.");
                }
                order = input.nextLine();
            }

            System.out.println("****** ****** ****** ****** ****** ******  ");
            // final do processo de vendas, mostrar a lista de items e o total vendido.
            System.out.println("\n\tEsta é a ordem de venda completa:");
            for (String sale : sales) {
                System.out.println("\n\t- " + sale);
            }
            System.out.printf("\n\tTotal da venda: $%.2f\n", totalPrice);

            System.out.println("\n****** ****** ****** ****** ****** ******  ");    
    }


}