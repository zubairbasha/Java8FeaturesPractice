package java8features;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;

public class StreamPractice {
    public static void main(String[] args) {
        List<Product> productsList = new ArrayList<Product>();
        productsList.add(new Product(1,"HP Laptop",25000f, Arrays.asList("Hardware","Software")));
        productsList.add(new Product(2,"Dell Laptop",30000f,Arrays.asList("Hardware","Software")));
        productsList.add(new Product(3,"Lenevo Laptop",28000f,Arrays.asList("Hardware","Software")));
        productsList.add(new Product(4,"Sony Laptop",28000f,Arrays.asList("Software")));
        productsList.add(new Product(5,"Apple Laptop",90000f,Arrays.asList("Harware","Software")));
        productsList.add(new Product(6,"Apple Laptop",90000f,Arrays.asList("Harware","Software")));
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
       String categories= productsList.stream()
                .map(product -> product.getCategories())
                .flatMap(Collection::stream)
                .collect(Collectors.joining(","));
       System.out.println(categories);
       //shortcircuit
        List<Product> shortCircuitProduct= productsList.stream()
                .skip(1)
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(shortCircuitProduct);
        //IntStream
       List<Integer> intStream=productsList.stream()
                .mapToInt(product->(int)product.getPrice())
               .boxed()
               .collect(Collectors.toList());
       System.out.println(intStream);
       //sum the price of all product
        IntBinaryOperator result=(x,y)->x+y;
        OptionalInt sum=productsList.stream()
                .mapToInt(product->(int)product.getPrice())
                .reduce(result);
        List<Product> distinctList=  productsList.stream().filter(StreamPractice::isPriceAboveThreshold)
                        .distinct()
                                .collect(Collectors.toList());
        System.out.println(distinctList);

        System.out.println(sum);
        //Sorting
       List<Product> sortedProduct= productsList.stream()
                .sorted(Comparator.comparing(Product::getName))
                .collect(Collectors.toList());
       System.out.println(sortedProduct);
       productsList.stream()
               .peek(System.out::print)
               .max(Comparator.comparing(Product::getPrice))
               .orElseThrow(NoSuchElementException::new);
        productsList.stream()
                .forEachOrdered(System.out::println);
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

// Sequential stream: Operations will be processed sequentially in a single thread
        long sequentialCount = numbers.stream()
                .filter(num -> num % 2 == 0)
                .count();
        System.out.println("Sequential count: " + sequentialCount);

// Parallel stream: Operations will be processed concurrently across multiple threads
        long parallelCount = numbers.parallelStream()
                .filter(num -> num % 2 == 0)
                .count();
        System.out.println("Parallel count: " + parallelCount);


    }

    public static Product increasedProduct(Product product){
        product.setPrice(product.getPrice()*2);
        return product;
    }
    public static boolean isPriceAboveThreshold(Product product){
        return product.getPrice()>50000?true:false;
    }


}
class Product implements   Comparable<Product>{
    int id;
    String name;
    float price;
    List<String> categories;

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public Product(int id, String name, float price, List<String> categories) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.categories = categories;
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
                ", categories=" + categories +
                '}';
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Product o) {
        return this.getName().compareTo(o.getName());
    }
}
