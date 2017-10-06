package com.example.ugphonevalidator;

import android.util.Log;

import java.lang.String;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Arnold on 10/4/2017.
 */

public class PhoneValidator {
    private String msisdn; // Mobile Station International Subscriber Directory Number
    private String countryCode = "256";
    private String prefix;

    // Values can not be reassigned
    private static final Set<String> MTNPrefixes = new HashSet<>(Arrays.asList(new String[]{"77", "78"}));
    private static final Set<String> AirtelPrefixes = new HashSet<>(Arrays.asList(new String[]{"70", "75"}));

    private static final String AfricellPrefixes = "79";
    private static final String VodafonePrefixes = "72";
    private static final String UTLPrefixes = "71";

    private String getPrefix() {
        if (this.prefix == null) {
            this.prefix = this.msisdn.substring(0, 2);
        }
        Log.i("PV", "boo " + this.prefix);
        return this.prefix;
    }

    public PhoneValidator(String msisdn) {
        this.msisdn = msisdn;
        clean();
        getPrefix();
        Log.i("PV", "cleaned = " + this.msisdn);
    }

    public String getOperator() {
        if (MTNPrefixes.contains(getPrefix())) {
            return "MTN";
        } else if (AirtelPrefixes.contains(getPrefix())) {
            return "AIRTEL";
        } else if (AfricellPrefixes.contains(getPrefix())) {
            return "AFRICELL";
        } else if (VodafonePrefixes.contains(getPrefix())) {
            return "VODAFONE";
        } else if (UTLPrefixes.contains(getPrefix())) {
            return "AFRICELL";
        } else {
            return "UNKNOWN";
        }
    }

    public String getPhoneNumber() {
        return countryCode + this.msisdn;
    }

    private String clean(String msisdn) {
        msisdn = msisdn.replaceAll("[^0-9]", " ");
        if (msisdn.substring(0, 1).equals("0")) {
            msisdn = msisdn.substring(1, msisdn.length());
        } else if (msisdn.substring(0, this.countryCode.length()).equals(this.countryCode)) {
            msisdn = msisdn.substring(3, msisdn.length());
        }
        return msisdn;
    }

    private void clean() {
        this.msisdn = this.msisdn.replaceAll("[^0-9]", " ");
        if (this.msisdn.substring(0, 1).equals("0")) {
            this.msisdn = this.msisdn.substring(1, this.msisdn.length());
        } else if (this.msisdn.substring(0, 3).equals(this.countryCode)) {
            this.msisdn = this.msisdn.substring(3, this.msisdn.length());
        }
    }

    public boolean validate(String msisdn) {
        String cleanNumber = clean(msisdn);
        return ((cleanNumber.length() == 9) && (!cleanNumber.isEmpty()));
    }
}

