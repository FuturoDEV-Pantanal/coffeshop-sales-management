import java.util.Scanner;
import java.util.ArrayList;
import user.Usuario;
import product.Product;
import cashier.Cashier;

public class Main {

    public static void main(String[] args){

            //instanciamento de usuário
            Usuario user1 = new Usuario("admin","123");

            //Arraylist Produtos
            ArrayList<Product> produtos = new ArrayList<>();
            //instanciar nossos produtos
            Product espresso = new Product("Espresso", 6.99);
            Product latte = new Product("Latte", 8.99);
            Product cappuccino = new Product("Cappuccino", 12.49);
            Product americano = new Product("Americano", 6.99);
            produtos.add(espresso);
            produtos.add(latte);
            produtos.add(cappuccino);
            produtos.add(americano);
        
            
            //registradora de vendas
            Cashier cashier = new Cashier();

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
            Usuario.userAuth(user1,inputUserName, inputPassword);
          

            //produtos e preços window. 
            System.out.println("\nEstes são nossos produtos e preços:");
            
            for (int i = 0; i < produtos.size(); i++) {
                Product product = produtos.get(i);
                System.out.printf("%-15s $%.2f\n", product.getProductName(), product.getProductPrice());
            }

            //interface registro de vendas
            System.out.println("****** ****** ****** ****** ****** ******  ");
            System.out.println("\nRegistre o pedido (insira 'finalizado' para concluir):");
            String order = input.nextLine();

            while (!order.equals("finalizado")) {
                double totalPrice = cashier.getTotalPrice();
                boolean isProductTrue = false;
                //loop de controle de registro dos items um a um.
                for (int i = 0; i < produtos.size(); i++) {
                    Product produto = produtos.get(i);
                    if (order.equalsIgnoreCase(produto.getProductName())) {
                        Cashier.addOrder(cashier,order);
                        System.out.println("!! ! ! !Total Price at NOW!"+totalPrice);
                        totalPrice = totalPrice + produto.getProductPrice();
                        cashier.setTotalPrice(totalPrice);
                        System.out.println("!! ! ! !Total Price at NOW!"+totalPrice);
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
            for (String sale : cashier.getSales()) {
                System.out.println("\n\t- " + sale);
            }
            System.out.printf("\n\tTotal da venda: $%.2f\n", cashier.getTotalPrice());

            System.out.println("\n****** ****** ****** ****** ****** ******  ");    
    }


}