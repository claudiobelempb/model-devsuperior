package br.sub.com.projectmodel.modules.client.usecase.ClientCreate;

import br.sub.com.projectmodel.modules.client.dto.ClientDTO;
import br.sub.com.projectmodel.modules.client.infra.entities.Client;
import br.sub.com.projectmodel.modules.client.infra.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientCreateService {

  @Autowired
  private ClientRepository repository;

  @Transactional
  public ClientDTO execute(ClientDTO dto){
    Client client = new Client();
    client.setSeat(dto.getSeat());
    client.setName(dto.getName());
    client = repository.save(client);
    return new ClientDTO(client);
  }
}
