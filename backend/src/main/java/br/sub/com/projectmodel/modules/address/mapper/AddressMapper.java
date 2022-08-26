package br.sub.com.projectmodel.modules.address.mapper;

import br.sub.com.projectmodel.modules.address.dto.AddressDTO;
import br.sub.com.projectmodel.modules.address.infra.entities.Address;

public class AddressMapper {

  public static void mapper(Address entity, AddressDTO dto){
    entity.setCep(dto.getCep());
    entity.setCity(dto.getCity());
    entity.setStreet(dto.getStreet());
    entity.setNumber(dto.getNumber());
    entity.setDistrict(dto.getDistrict());
    entity.setCity(dto.getCity());
    entity.setUf(dto.getUf());
    entity.setPhone(dto.getPhone());
  }
}
