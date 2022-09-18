package br.sub.com.projectmodel.modules.deliver.usecase.DeliverRevisionUpdate;

import br.sub.com.projectmodel.modules.deliver.dto.DeliverRevisionUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/deliveries")
public class DeliverRevisionUpdateResource {

  @Autowired
  private DeliverRevisionUpdateService service;

  /*@PutMapping(value = "/{id}")
  public ResponseEntity<DeliverRevisionUpdateDTO> handle(@PathVariable Long id,
                                                         @RequestBody DeliverRevisionUpdateDTO dto){
    dto = service.execute(id, dto);
    return ResponseEntity.ok().body(dto);
  }*/

  @PutMapping(value = "/{id}")
  public ResponseEntity<Void> handle(@PathVariable Long id,
                                                         @RequestBody DeliverRevisionUpdateDTO dto){
    service.execute(id, dto);
    return ResponseEntity.noContent().build();
  }
}
