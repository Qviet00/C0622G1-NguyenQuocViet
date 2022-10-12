package validation;

public class HouseRegex {
    public static final String NAME_HOUSE_REGEX = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$";
    public static final String PHONE_HOUSE_REGEX = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$";
}
