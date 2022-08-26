package br.sub.com.projectmodel.modules.user.usecase.UserFindAllPage;

import br.sub.com.projectmodel.modules.user.dto.UserDTO;
import br.sub.com.projectmodel.modules.user.infra.entities.User;
import br.sub.com.projectmodel.modules.user.infra.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserFindAllPageService {

  @Autowired
  private UserRepository repository;

  @Transactional(readOnly = true)
  public Page<UserDTO> execute(Pageable pageable){
    Page<User> entity = repository.findAll(pageable);
    return entity.map(obj -> new UserDTO(obj));
  }
}
