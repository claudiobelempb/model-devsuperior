package br.sub.com.projectmodel.modules.user.usecase.UserCreate;

import br.sub.com.projectmodel.modules.user.dto.UserCreateDTO;
import br.sub.com.projectmodel.modules.user.dto.UserDTO;
import br.sub.com.projectmodel.modules.user.infra.entities.User;
import br.sub.com.projectmodel.modules.user.infra.repositories.UserRepository;
import br.sub.com.projectmodel.modules.user.mapper.UserCreateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserCreateService {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private UserCreateMapper mapper;

  @Transactional
  public UserDTO execute(UserCreateDTO dto){
    User entity = new User();
    mapper.userCreateMapper(dto, entity);
    entity = userRepository.save(entity);
    return new UserDTO(entity);
  }

}
