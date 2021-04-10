package serialization;

import java.io.ObjectOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.io.Serializable;
import java.time.LocalDateTime;

public class CustomSerialization {

    private static Logger logger = Logger.getLogger("CustomSerialization");

    private static class Product implements Serializable {
        private String title;
        private double price;
        private transient String hash; //this field won't be serialized!
        public Product(String title, double price) {
            this.title = title;
            this.price = price;
        }

        @Override public String toString() {return title + ", " + price + "," + hash;}

        //customize serialization
        private void writeObject(ObjectOutputStream oos) throws IOException {
            logger.info("Call custom serialization...");
            oos.defaultWriteObject(); //call the default writeObject method
            oos.writeObject(LocalDateTime.now()); // then add the instant information too
        }

        //customize deserialization
        private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
            logger.info("Call custom deserialization...");
            ois.defaultReadObject(); //call the default readObject method
            hash = "sakfjawwjwlj"; //recalculate the non serialized fields 
        }
    }

    private static void serializeProductTo(Product product, String filePath) {
        logger.info("Serialize product: " + product);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(product);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error!", e);
        }
    } 

    private static Product deserializeProductFrom(String filePath) {
        logger.info("local date: " + LocalDateTime.now());
        logger.info("Deserialize product from: " + filePath);
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (Product) ois.readObject();
        } catch (FileNotFoundException | ClassNotFoundException | ClassCastException e) {
            logger.log(Level.SEVERE, "Error!", e);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "IOError!", e);
        }
        return null;
    }

    public static void main (String... args) {
        Product cake = new Product("cake", 5.9);

        serializeProductTo(cake, "product.txt");

        cake = null;

        cake = deserializeProductFrom("product.txt");

        logger.info("Deserialized prdocut: " + cake);
    }
}