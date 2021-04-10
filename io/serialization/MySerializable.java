package serialization;

import java.io.Serializable;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.ArrayList;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

//in order to serialiaze that class and prevent 'SerializationException' You must implement Serializable interface
public class MySerializable implements Serializable {
    private static Logger logger = Logger.getLogger("MySerializable");

    //All instance variables must be serializable in order to serialize the parent object correctly. 
    //Otherwise use 'transient' access modifier to skip instance variables during serialization
    private static class Product implements Serializable {
        private String title;
        private double price;
        public Product(String title, double price) {
            this.title = title;
            this.price = price;
        }
        @Override public String toString() {
            return title + ", " + price;
        }
    }

    private static void serializeObject(Object obj) {
        logger.log(Level.INFO, "Start serialization of [" + obj + "]...");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("swap.txt"));) {
            oos.writeObject(obj);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ooops! something went wrong.", e);
        }
        logger.log(Level.INFO, "Finished serialization.");
    }

    private static Object deserializeFile(String filePath) {
        logger.info("Start deserialization...");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            List<Product> products = (List<Product>) ois.readObject();
            logger.info("List of products successfully deserialized. Size: " + products.size());
            return products;
        } catch (FileNotFoundException | ClassCastException | ClassNotFoundException e) {
            logger.log(Level.SEVERE, "Ooops! something went wrong:", e);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "IOException:", e);
        }
        logger.info("Finished deserialization.");
        return null;
    }

    public static void main(String... args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Cake", 5.8));
        products.add(new Product("Tea", 1.5));
        serializeObject(products);

        products = null;

        try {
            products = (List<Product>) deserializeFile("swap.txt");
            logger.info("Done! size:" + products.size());
        } catch (ClassCastException e) {
            logger.info("Failed!");
        }
    }
}