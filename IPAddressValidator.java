package Day_4;
public class IPAddressValidator {
    public static boolean isValidIPv4(String ip) {
        String[] parts = ip.split("\\.");
        if (parts.length != 4) return false; // Must have exactly 4 parts

        for (String part : parts) {
            if (!part.matches("\\d+") || part.length() > 1 && part.startsWith("0")) return false;
            
            int num = Integer.parseInt(part);
            if (num < 0 || num > 255) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isValidIPv4("222.111.111.111")); // true
        System.out.println(isValidIPv4("5555..555"));       // false
        System.out.println(isValidIPv4("0.0.0.255"));       // true
        System.out.println(isValidIPv4("0.0.0.0255"));      // false
    }
}
