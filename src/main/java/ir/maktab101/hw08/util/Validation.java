package ir.maktab101.hw08.util;

import java.util.regex.Pattern;

public class Validation {
    public static boolean isValidPasswordWithRegex(String password) {
        Pattern pattern =
                Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
        return password.matches(pattern.pattern());
    }
    public static boolean isValidEmailWithRegex(String email) {
        Pattern pattern =
                Pattern.compile("/^((?!\\.)[\\w\\-_.]*[^.])(@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])$/gm");
        return email.matches(pattern.pattern());
    }
    public static boolean isValidWebsiteWithRegex(String website) {
        Pattern pattern =
                Pattern.compile("^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]");
        return website.matches(pattern.pattern());
    }
    public static boolean isValidNationalCodeWithRegex(String nationalCode) {
        Pattern pattern =
                Pattern.compile("/^[0-9]{10}$/g");
        return nationalCode.matches(pattern.pattern());
    }
    public static boolean isValidPhoneNumberWithRegex(String phoneNumber) {
        Pattern pattern =
                Pattern.compile("^(00989|\\+989|09)(\\d{9})$");
        return phoneNumber.matches(pattern.pattern());
    }
}
