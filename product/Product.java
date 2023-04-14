package product;

public class Product {
        //atributos
        private String ProductName;
        private double price;
        //construtos
        public Product(String ProductName, double price){
            this.ProductName = ProductName;
            this.price = price;
        }

        //getters
        public String getProductName(){
            return ProductName;
        }

        public double getProductPrice(){
            return price;
        }
}
