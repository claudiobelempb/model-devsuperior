package br.sub.com.projectmodel.modules.client.dto;

import br.sub.com.projectmodel.modules.client.infra.entities.Client;
import br.sub.com.projectmodel.modules.seat.infra.entities.Seat;

import java.io.Serial;
import java.io.Serializable;

public class ClientDTO implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  private Long id;

  private String name;

  private Seat seat;

  public ClientDTO() {
  }

  public ClientDTO(Long id, String name, Seat seat) {
    this.id = id;
    this.name = name;
    this.seat = seat;
  }

  public ClientDTO(Client entity) {
    id = entity.getId();
    name = entity.getName();
    seat = entity.getSeat();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Seat getSeat() {
    return seat;
  }

  public void setSeat(Seat seat) {
    this.seat = seat;
  }
}
