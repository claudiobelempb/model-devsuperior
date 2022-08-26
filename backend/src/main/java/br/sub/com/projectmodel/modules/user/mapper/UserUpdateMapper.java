package br.sub.com.projectmodel.modules.user.mapper;

import br.sub.com.projectmodel.modules.role.dto.RoleDTO;
import br.sub.com.projectmodel.modules.role.infra.entities.Role;
import br.sub.com.projectmodel.modules.role.infra.repositories.RoleRepository;
import br.sub.com.projectmodel.modules.user.dto.UserUpdateDTO;
import br.sub.com.projectmodel.modules.user.infra.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserUpdateMapper {

  @Autowired
  private RoleRepository roleRepository;

  public void userUpdateMapper(UserUpdateDTO dto, User entity) {
    entity.setFirstName(dto.getFirstName());
    entity.setLastName(dto.getLastName());
    entity.setBirth(dto.getBirth());
    entity.setEmail(dto.getEmail());

    entity.getRoles().clear();

    for(RoleDTO roleDTO : dto.getRoles()){
      Role obj = roleRepository.getReferenceById(roleDTO.getId());
      entity.getRoles().add(obj);
    }

  }

}
