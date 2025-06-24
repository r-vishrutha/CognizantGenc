public class SearchAlgorithms {

    // Linear Search
    public static Product linearSearch(Product[] products, String targetName) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }
    //Binary Search
    public static Product binarySearch(Product[] products, String targetName) {
        int low = 0;
        int high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int comparison = products[mid].getProductName().compareToIgnoreCase(targetName);

            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return null;
    }
}

//product class
public class Product {
    private int productId;
    private String productName;
    private String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }
}

//Main class
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Product[] products = {
                new Product(1, "Laptop", "Electronics"),
                new Product(2, "Shoes", "Footwear"),
                new Product(3, "Mobile", "Electronics"),
                new Product(4, "Shirt", "Apparel")
        };

        Product linearResult = SearchAlgorithms.linearSearch(products, "Shoes");
        System.out.println(linearResult != null ? "Found with Linear: " + linearResult.getProductName() : "Not Found with Linear");

        Arrays.sort(products, Comparator.comparing(Product::getProductName));
        Product binaryResult = SearchAlgorithms.binarySearch(products, "Shoes");
        System.out.println(binaryResult != null ? "Found with Binary: " + binaryResult.getProductName() : "Not Found with Binary");
    }
}
