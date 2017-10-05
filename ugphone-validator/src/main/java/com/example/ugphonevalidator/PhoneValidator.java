package com.example.ugphonevalidator;

import java.lang.String;

/**
 * Created by Arnold on 10/4/2017.
 */

public class PhoneValidator {
    private String prefix = null;
    private String operator = null;
    private String countryCode;
//    protected String countryPrefix = "+" + countryCode;

    private String getPrefix(String phone_number) {
        if (phone_number != null) {
            this.prefix = phone_number.substring(0, 2);
        }
        return this.prefix;
    }

    private String getOperator(String phone_number) {

        String prefix = this.getPrefix(phone_number);

        if (prefix.equals("77") && prefix.equals("78")) {
            return "MTN NETWORK";

        } else if (prefix.equals("70") && prefix.equals("75")) {
            return "AIRTEL NETWORK";

        } else if (prefix.equals("72")) {
            return "VODAFONE NETWORK";

        } else if (prefix.equals("79")) {
            return "AFRICELL NETWORK";

        } else if (prefix.equals("71")) {
            return "UTL NETWORK";

        } else {
            return "UNKNOWN NETWORK";
        }
    }

    private String getCountryCode(String countryCode) {
        this.countryCode = countryCode;
        if (countryCode.equals("256")) {
            return "Uganda";
        } else
            return "UNKNOWN COUNTRY";
    }

    private String PhoneNumber(String countryCode, String phone_number) {
        String mobileNumber = countryCode + phone_number;
        if (countryCode.equals("256") && (phone_number.equals("782459681"))) {
            return countryCode + phone_number;
        }
        return mobileNumber;
    }

    public static void main(String args[]) {
        PhoneValidator validator = new PhoneValidator();
        validator.PhoneNumber("256", "782459681");
        validator.getOperator("782459681");
        validator.getCountryCode("256");
    }
}

