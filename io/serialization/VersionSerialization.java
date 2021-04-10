
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
import java.io.File;

public class VersionSerialization {

    private static Logger logger = Logger.getLogger("VersionSerialization");

    private static class Product implements Serializable {
        private static final long serialVersionUID = 2L;
        private String title;
        private double price;
        private transient String hash; //this field won't be serialized!
        public Product(String title, double price) {
            this.title = title;
            this.price = price;
        }

        @Override public String toString() {return title + ", " + price + ", " + hash + ", " +  serialVersionUID;}
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

        if (!new File("product2.txt").exists()) {
            serializeProductTo(cake, "product2.txt");
            //Serialize the cake product when serialVersionUID=1L
            //Then increment change the serialVersionUID, and try to deserialize the product => InvalidClassException
        }

        cake = null;

        cake = deserializeProductFrom("product2.txt");

        logger.info("Deserialized prdocut: " + cake);

        //If you change the serialVersionUID and try to rerun the program you will get the following exception:
        //SEVERE: IOError!
        //java.io.InvalidClassException: serialization.VersionSerialization$Product; local class incompatible: stream classdesc serialVersionUID = 1, local class serialVersionUID = 2
    }
}