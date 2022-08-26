package br.sub.com.projectmodel.modules.address.usecase.AddressFindAllPage;

import br.sub.com.projectmodel.modules.address.dto.AddressDTO;
import br.sub.com.projectmodel.modules.address.infra.entities.Address;
import br.sub.com.projectmodel.modules.address.infra.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddressFindAllPageService {

  @Autowired
  private AddressRepository addressRepository;

  @Transactional(readOnly = true)
  public Page<AddressDTO> execute(Pageable pageable){
    Page<Address> entity = addressRepository.findAll(pageable);
    return entity.map(dto -> new AddressDTO(dto));
  }
}
