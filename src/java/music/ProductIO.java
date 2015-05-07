
import java.io.*;
import java.util.*;

public class ProductIO {

    private static ArrayList<Product> products = null;

    public static ArrayList<Product> getProducts(String path) {
        products = new ArrayList<>();
        File file = new File(path);
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));

            String line = in.readLine();
            while (line != null) {
                StringTokenizer t = new StringTokenizer(line, "|");
                if (t.countTokens() >= 3) {
                    String code = t.nextToken();
                    String description = t.nextToken();
                    String priceAsString = t.nextToken();
                    double price = Double.parseDouble(priceAsString);

                    Product p = new Product();
                    p.setCode(code);
                    p.setDescription(description);
                    p.setPrice(price);

                    products.add(p);
                }
                line = in.readLine();
            }
            in.close();
            return products;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Product getProduct(String productCode, String path) {
        products = getProducts(path);
        for (Product p : products) {
            if (productCode != null
                    && productCode.equalsIgnoreCase(p.getCode())) {
                return p;
            }
        }
        return null;
    }

    public static boolean exists(String productCode, String path) {
        products = getProducts(path);
        for (Product p : products) {
            if (productCode != null
                    && productCode.equalsIgnoreCase(p.getCode())) {
                return true;
            }
        }
        return false;
    }

    private static void saveProducts(ArrayList<Product> products,
            String path) {
        try {
            File file = new File(path);
            PrintWriter out
                    = new PrintWriter(
                            new FileWriter(file));

            for (Product p : products) {
                out.println(p.getCode() + "|"
                        + p.getDescription() + "|"
                        + p.getPrice());
            }

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void insert(Product product, String path) {
        products = getProducts(path);
        products.add(product);
        saveProducts(products, path);
    }

    public static void update(Product product, String path) {
        products = getProducts(path);
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            if (product.getCode() != null
                    && product.getCode().equalsIgnoreCase(p.getCode())) {
                products.set(i, product);
            }
        }
        saveProducts(products, path);
    }

    public static void delete(Product product, String path) {
        products = getProducts(path);
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            if (product != null
                    && product.getCode().equalsIgnoreCase(p.getCode())) {
                products.remove(i);
            }
        }
        saveProducts(products, path);
    }
}
