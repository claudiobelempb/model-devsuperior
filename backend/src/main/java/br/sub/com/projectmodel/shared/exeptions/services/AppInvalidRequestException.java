package br.sub.com.projectmodel.shared.exeptions.services;


import br.sub.com.projectmodel.shared.validator.ValidationErrors;

public class AppInvalidRequestException extends RuntimeException {

  private final ValidationErrors validationErrors;

  public AppInvalidRequestException(ValidationErrors validationErrors) {
    super(validationErrors.toString());
    this.validationErrors = validationErrors;
  }

  public ValidationErrors getValidationErrors() {
    return validationErrors;
  }
}
