package br.sub.com.projectmodel.modules.product.usecase.Product.ProductFindAllPage;

import br.sub.com.projectmodel.modules.product.dto.ProductDTO;
import br.sub.com.projectmodel.modules.product.infra.entities.Product;
import br.sub.com.projectmodel.modules.product.infra.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductFindAllPageService {

  @Autowired
  private ProductRepository repository;

  @Transactional(readOnly = true)
  public Page<ProductDTO> execute(Pageable pageable){
    Page<Product> entity = repository.findAll(pageable);
    return entity.map(dto -> new ProductDTO(dto));
  }

}
