package java8features;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPractice {
    public static void main(String[] args) {
        List<Product> productsList = new ArrayList<Product>();
        productsList.add(new Product(1,"HP Laptop",25000f));
        productsList.add(new Product(2,"Dell Laptop",30000f));
        productsList.add(new Product(3,"Lenevo Laptop",28000f));
        productsList.add(new Product(4,"Sony Laptop",28000f));
        productsList.add(new Product(5,"Apple Laptop",90000f));
        //Before Stream we are using a normal for loop to filter the element
        List<Float> productPriceList=new ArrayList<>();
        for(Product product:productsList){
            productPriceList.add(product.getPrice());
        }
        System.out.println(productPriceList);

        //After Introduction of Stream
        productsList.stream().forEach(System.out::println);
        //Map
        //IT will map the object into different type of object and return the object
        List<Product> increasedProducts = productsList.stream()
                .map(StreamPractice::increasedProduct)
                .collect(Collectors.toList());
        System.out.println(increasedProducts);
        List<Product> filteredList=increasedProducts
                .stream().filter(StreamPractice::isPriceAboveThreshold)
                .map(StreamPractice::increasedProduct)
                .collect(Collectors.toList());
        System.out.println(filteredList);
       Product findFirstProduct=filteredList
                .stream().findFirst()
               .orElse(null);
       System.out.println(findFirstProduct);
       //flatMap
       //shortcircuit
        List<Product> shortCircuitProduct= productsList.stream()
                .skip(1)
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(shortCircuitProduct);

    }
    public static Product increasedProduct(Product product){
        product.setPrice(product.getPrice()*2);
        return product;
    }
    public static boolean isPriceAboveThreshold(Product product){
        return product.getPrice()>50000?true:false;
    }


}
class Product{
    int id;
    String name;
    float price;

    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
