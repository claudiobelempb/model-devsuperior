package br.sub.com.projectmodel.modules.address.filter;

import br.sub.com.projectmodel.shared.enums.EnumStatus;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

public class AddressFilter implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  private Long id;
  private String code;
  private String cep;
  private String street;
  private String number;
  private String district;
  private String city;
  private String uf;
  private String phone;
  private EnumStatus status;
  private Instant createdAt;
  private Instant updatedAt;

  public AddressFilter(){}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getCep() {
    return cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getDistrict() {
    return district;
  }

  public void setDistrict(String district) {
    this.district = district;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getUf() {
    return uf;
  }

  public void setUf(String uf) {
    this.uf = uf;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public EnumStatus getStatus() {
    return status;
  }

  public void setStatus(EnumStatus status) {
    this.status = status;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

}
