package sbs.security;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.security.Key;
import java.util.Objects;
import java.util.Properties;

public final class MacAddress {
    private static final String ALGO = "AES";
    /**
     * Encrypt a string with AES algorithm.
     *
     * @param data is a string
     * @return the encrypted string
     */
    private static String encrypt(String data) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(data.getBytes());
        return new BASE64Encoder().encode(encVal);
    }

    /**
     * Decrypt a string with AES algorithm.
     *
     * @param encryptedData is a string
     * @return the decrypted string
     */
    public static String decrypt(String encryptedData) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
        byte[] decValue = c.doFinal(decordedValue);
        return new String(decValue);
    }

    /**
     * Generate a new encryption key.
     */
    private static Key generateKey() {
        return new SecretKeySpec(NetworkInterface.class.getSimpleName().getBytes(), ALGO);
    }

    public static boolean checkStartUp() {
        try {
            if (Objects.equals(MAC_ADDRESS(), decrypt(getAppVersion()))) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Faild Startup no Access Here");
            return false;
        }
        return false;
    }

    private static String getAppVersion() throws IOException {
        String versionString = null;
        //to load application's properties, we use this class
        Properties mainProperties = new Properties();
        FileInputStream file;
        //the base folder is ./, the root of the main.properties file
        String path = "C:\\Windows\\System32\\dongle.properties";
        //load the file handle for main.properties
        file = new FileInputStream(path);
        //load all the properties from this file
        mainProperties.load(file);
        //we have loaded the properties, so close the file handle
        file.close();
        //retrieve the property we are intrested, the app.version
        versionString = mainProperties.getProperty("app.version");
        return versionString;
    }

    private final static String MAC_ADDRESS() {
        InetAddress ip;
        try {
            ip = InetAddress.getLocalHost();
            System.out.println("Current IP address : " + ip.getHostAddress());
            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            byte[] mac = network.getHardwareAddress();
            System.out.print("Current MAC address : ");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            return sb.toString();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return null;
    }
}
