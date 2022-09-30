import java.net.*;
import java.util.Scanner;


/**
 * The objective of this exercise is to get you familiar with
 * the types used in Java to handle IP addresses.
 *
 * @author Bryce Ellis
 * @author Kaliyah Fisher
 * @version 1.0
 * @since August-23-2022
 */
public class MyInetAddressExample {
    public static void main(String[] args) {
        try {
            // Handles the user input for the host name
            System.out.print("Please enter a host name: ");
            Scanner hostNameScanner = new Scanner(System.in);
            String hostName = hostNameScanner.nextLine();
            InetAddress hostNameAddress = InetAddress.getByName(hostName);

            // Print the host name
            System.out.println("\tHost Name: " + hostNameAddress.getHostName());

            // Handles and prints the binary formatting of the host
            StringBuilder binaryNumber = new StringBuilder();
            String ipNumberString = hostNameAddress.getHostAddress();
            String[] ipAddressString = ipNumberString.split("\\.");
            for (String element : ipAddressString) {
                int convertedIntegerNumber = Integer.parseInt(element);
                binaryNumber.append(Integer.toBinaryString(convertedIntegerNumber));
            }
            System.out.println("\tBinary format: " + binaryNumber);

            // Handles and prints the hexadecimal dotted-quad formatting of the host
            StringBuilder hexNumber = new StringBuilder();
            for (String decimalString : ipAddressString) {
               int decimalNumber = Integer.parseInt(decimalString);
               hexNumber.append(Integer.toHexString(decimalNumber));
               hexNumber.append(".");
            }
            hexNumber.delete(hexNumber.length() - 1,hexNumber.length());
            System.out.println("\tHexadecimal dotted-quad format: " + hexNumber);

            // Prints the Decimal dotted-quad format
            System.out.println("\tDecimal dotted-quad format: " + hostNameAddress.getHostAddress());

            // Closes the scanner
            hostNameScanner.close();
        } catch (UnknownHostException e) {
            System.out.println("Unable to get host information!");
            e.printStackTrace();
        }

    }
}