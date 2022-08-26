package br.sub.com.projectmodel.modules.address.dto;

import br.sub.com.projectmodel.modules.address.infra.entities.Address;
import br.sub.com.projectmodel.shared.enums.EnumStatus;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

public class AddressDTO implements Serializable {
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

  public AddressDTO(){}

  public AddressDTO(Long id, String code, String cep, String street, String number, String district, String city,
                    String uf, String phone, EnumStatus status, Instant createdAt, Instant updatedAt) {
    this.id = id;
    this.code = code;
    this.cep = cep;
    this.street = street;
    this.number = number;
    this.district = district;
    this.city = city;
    this.uf = uf;
    this.phone = phone;
    this.status = status;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public AddressDTO(Address entity) {
    id = entity.getId();
    code = entity.getCode();
    cep = entity.getCep();
    street = entity.getStreet();
    number = entity.getNumber();
    district = entity.getDistrict();
    city = entity.getCity();
    uf = entity.getUf();
    phone = entity.getPhone();
    status = entity.getStatus();
    createdAt = entity.getCreatedAt();
    updatedAt = entity.getUpdatedAt();
  }


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

  public Instant getCreatedAt() {
    return createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

}
