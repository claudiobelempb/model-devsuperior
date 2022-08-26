package br.sub.com.projectmodel.modules.product.usecase.ProductCategory.ProductCategoryDelete;

import br.sub.com.projectmodel.modules.product.infra.repositories.ProductCategoryRepository;
import br.sub.com.projectmodel.shared.constants.AppExceptionConstants;
import br.sub.com.projectmodel.shared.exeptions.services.AppDataBaseException;
import br.sub.com.projectmodel.shared.exeptions.services.AppEntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class ProductCategoryDeleteService {

  @Autowired
  private ProductCategoryRepository repository;

  @DeleteMapping(value = "/{id}")
  public void execute(@PathVariable Long id) {
    try {
      repository.deleteById(id);
    } catch (EmptyResultDataAccessException e) {
      throw new AppEntityNotFoundException(AppExceptionConstants.ID_NOT_FOUND + id);
    } catch (DataIntegrityViolationException e) {
      throw new AppDataBaseException(AppExceptionConstants.INTEGRITY_VIOLATION);
    }
  }
}
