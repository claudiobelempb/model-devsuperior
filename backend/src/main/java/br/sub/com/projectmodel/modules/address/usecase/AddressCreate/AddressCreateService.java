package br.sub.com.projectmodel.modules.address.usecase.AddressCreate;

import br.sub.com.projectmodel.modules.address.dto.AddressDTO;
import br.sub.com.projectmodel.modules.address.infra.entities.Address;
import br.sub.com.projectmodel.modules.address.infra.repositories.AddressRepository;
import br.sub.com.projectmodel.modules.address.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddressCreateService {

  @Autowired
  private AddressRepository addressRepository;

  @Transactional
  public AddressDTO execute(AddressDTO addressDTO){
    Address entity = new Address();
    AddressMapper.mapper(entity, addressDTO);
    entity = addressRepository.save(entity);
    return new AddressDTO(entity);
  }


}
