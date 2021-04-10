package serialization;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;

public class SecureSerialization implements Serializable {
    private static Logger logger = Logger.getLogger("SecureSerialization");

    private static String generateHash(Object obj) {
        String hash = "";
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(obj);
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            hash = new BigInteger(1, md.digest(baos.toByteArray())).toString(16);

        } catch (NoSuchAlgorithmException | IOException e) {
            logger.log(Level.SEVERE, "Error!", e);
        }
        return hash;
    }
    
    private static void serializeObjectTo(Object obj, String filePath) {
        logger.info("Start serialization of: " + obj + " into: " + filePath);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(obj);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Ooops!", e);
        }
    }

    private static Object deserializeObjectFrom(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return ois.readObject();
        } catch (FileNotFoundException | ClassNotFoundException e) {
            logger.log(Level.SEVERE, "Error!", e);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "IOException!", e);
        }
        return null;
    }

    public static void main(String... args) {
        String password = "12345678";
        String hashedPassword = generateHash(password);
        serializeObjectTo(hashedPassword, "secure.txt");

        password = null;

        try {
            password = (String) deserializeObjectFrom("secure.txt");
            logger.info("Deserialized encoded password: " + password);
        } catch (ClassCastException e) {
            logger.log(Level.SEVERE, "Error!", e);
        }
    }

}