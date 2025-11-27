package utez.edu.mx.gmuback.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;

public class PasswordUtils {
    private static  String encodePassword(String row){
        return  new BCryptPasswordEncoder().encode(row);
    }

    public boolean matchPassword (String row, String encoded){
        return  new BCryptPasswordEncoder().matches(row, encoded);
    }

    public static String generateEncodePassword(String username, String fullname){
        String raw = fullname.charAt(0) + username + LocalDate.now().getYear();
        System.out.println(raw);

        return encodePassword(raw);
    }
}
