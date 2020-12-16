package com.codedifferently.phone;

import com.codedifferently.exceptions.InvalidPhoneNumberFormatException;
import com.codedifferently.tools.RandomNumberFactory;

import java.util.logging.Logger;

public final class PhoneNumberFactory {
    private static final Logger logger = Logger.getGlobal();

    private PhoneNumberFactory() {
        /** This constructor is private
         *  This class is uninstantiable */
    }

    /**
     * @param phoneNumberCount - number of PhoneNumber objects to instantiate
     * @return array of randomly generated PhoneNumber objects
     */ //TODO - Implement logic
    public static PhoneNumber[] createRandomPhoneNumberArray(int phoneNumberCount) {
        PhoneNumber[] phoneNumbers = new PhoneNumber[phoneNumberCount];
        for(int i = 0; i< phoneNumbers.length; i++){
            phoneNumbers[i] = createRandomPhoneNumber();
        }
        return phoneNumbers;
    }

    /**
     * @return an instance of PhoneNumber with randomly generated phone number value
     */ //TODO - Implement logic
    public static PhoneNumber createRandomPhoneNumber() {
        Integer areaCode = RandomNumberFactory.createInteger(100, 999);
        Integer centralOfficeCode = RandomNumberFactory.createInteger(100, 999);
        Integer phoneLineCode = RandomNumberFactory.createInteger(1000, 9999);

        return createPhoneNumberSafely(areaCode, centralOfficeCode, phoneLineCode);

    }


    /**
     * @param areaCode          - 3 digit code
     * @param centralOfficeCode - 3 digit code
     * @param phoneLineCode     - 4 digit code
     * @return a new phone number object
     */ //TODO - if input is valid, return respective PhoneNumber object, else return null
    public static PhoneNumber createPhoneNumberSafely(int areaCode, int centralOfficeCode, int phoneLineCode) {
            // (###)-###-####
            String phoneNumber = "";
            try{
               phoneNumber = String.format("(%d)-%d-%d", areaCode, centralOfficeCode, phoneLineCode);

                return createPhoneNumber(phoneNumber);
            } catch (InvalidPhoneNumberFormatException e){
                logger.warning(phoneNumber + " is not a valid phone number");
                return null;
            }
    }

    /**
     * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
     */ // TODO - Add throws statement to method signature
    public static PhoneNumber createPhoneNumber(String phoneNumberString) throws InvalidPhoneNumberFormatException {
        logger.warning("Attempting to create a new PhoneNumber object with a value of " +phoneNumberString);
        PhoneNumber phoneNumber = new PhoneNumber(phoneNumberString);
        return phoneNumber;
    }
}
