package br.sub.com.projectmodel.modules.reply.infra.entities;

import br.sub.com.projectmodel.modules.topic.infra.entities.Topic;
import br.sub.com.projectmodel.modules.user.infra.entities.User;
import br.sub.com.projectmodel.shared.enums.TypeStatus;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;

@Entity
@Table(name = "tb_reply")
public class Reply implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String code;
  @Column(columnDefinition = "TEXT")
  private String body;
  private TypeStatus status;
  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant createdAt;
  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant updatedAt;

  @ManyToOne
  @JoinColumn(name = "topic_id")
  private Topic topic;

  @ManyToOne
  @JoinColumn(name = "author_id")
  private User author;

  @ManyToMany
  @JoinTable(name = "tb_reply_likes_association",
    joinColumns = @JoinColumn(name = "reply_id"),
    inverseJoinColumns = @JoinColumn(name = "user_id"))
  private final Set<User> likes = new HashSet<>();

  public Reply(){}

  public Reply(Long id, String code, String body, TypeStatus status, Instant createdAt, Instant updatedAt,
               Topic topic, User author) {
    this.id = id;
    this.code = code;
    this.body = body;
    this.status = status;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.topic = topic;
    this.author = author;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public TypeStatus getStatus() {
    return status;
  }

  public void setStatus(TypeStatus status) {
    this.status = status;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }

  public void setUpdatedAt(Instant updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Topic getTopic() {
    return topic;
  }

  public void setTopic(Topic topic) {
    this.topic = topic;
  }

  public User getAuthor() {
    return author;
  }

  public void setAuthor(User author) {
    this.author = author;
  }

  public Set<User> getLikes() {
    return likes;
  }

  @PrePersist
  public void prePersist(){
    code = UUID.randomUUID().toString();
    createdAt = Instant.now();
    status = TypeStatus.ENABLED;
  }

  @PreUpdate
  public void preUpdate(){
    updatedAt = Instant.now();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Reply reply = (Reply) o;

    return id.equals(reply.id);
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }
}
