package br.sub.com.projectmodel.shared.utils;


import static br.sub.com.projectmodel.shared.constants.ValidatorConstants.*;
import static java.util.Objects.isNull;
import static org.apache.logging.log4j.util.Strings.isBlank;

import br.sub.com.projectmodel.shared.exeptions.services.AppInvalidRequestException;
import br.sub.com.projectmodel.shared.validator.ValidationErrors;

public final class ValidatorUtils {

  private ValidatorUtils(){}

  public static void throwOnError(ValidationErrors validationErrors) {
    if(validationErrors.hasErrors()){
      throw new AppInvalidRequestException(validationErrors);
    }
  }

  public static boolean validateRequired(String field, String fieldName, ValidationErrors validationErrors) {
    if(isBlank(field)) {
      validationErrors.addErrors(fieldName, fieldName + MISSING);
      return false;
    }
    return true;
  }

  public static boolean validateRequired(Object field, String fieldName, ValidationErrors validationErrors) {
    if(isNull(field)) {
      validationErrors.addErrors(fieldName, fieldName + MISSING);
      return false;
    }
    return true;
  }

  public static boolean validateMaxLength(String field, String fieldName,
                                          int maxLength, ValidationErrors validationErrors) {
    if(!isBlank(field) && field.trim().length() > maxLength) {
      validationErrors.addErrors(fieldName, fieldName + EXCEEDS_MAX_LENGTH);
      return false;
    }
    return true;
  }

  public static boolean validateMaxValue(Integer field, String fieldName,
                                          int maxValue, ValidationErrors validationErrors) {
    if(!isNull(field) && field > maxValue) {
      validationErrors.addErrors(fieldName, fieldName + EXCEEDS_MAX_VALUE);
      return false;
    }
    return true;
  }

  public static boolean validateMinValue(Integer field, String fieldName,
                                         int minValue, ValidationErrors validationErrors) {
    if(!isNull(field) && field < minValue) {
      validationErrors.addErrors(fieldName, fieldName + BELOW_MIN_VALUE);
      return false;
    }
    return true;
  }

}
