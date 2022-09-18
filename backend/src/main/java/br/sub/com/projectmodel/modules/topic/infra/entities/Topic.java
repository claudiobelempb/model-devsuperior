package br.sub.com.projectmodel.modules.topic.infra.entities;

import br.sub.com.projectmodel.modules.lesson.infra.entities.Lesson;
import br.sub.com.projectmodel.modules.offer.infra.entities.Offer;
import br.sub.com.projectmodel.modules.reply.infra.entities.Reply;
import br.sub.com.projectmodel.modules.user.infra.entities.User;
import br.sub.com.projectmodel.shared.enums.TypeStatus;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.*;

@Entity
@Table(name = "tb_topic")
public class Topic implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String code;
  private String title;
  @Column(columnDefinition = "TEXT")
  private String body;
  private TypeStatus status;
  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant createdAt;
  @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
  private Instant updatedAt;

  @ManyToOne
  @JoinColumn(name = "author_id")
  private User author;

  @ManyToOne
  @JoinColumn(name = "offer_id")
  private Offer offer;

  @ManyToOne
  @JoinColumn(name = "lesson_id")
  private Lesson lesson;

  @ManyToOne
  @JoinColumn(name = "reply_id")
  private Reply answer;

  @ManyToMany
  @JoinTable(name = "tb_topic_likes_association",
    joinColumns = @JoinColumn(name = "topic_id"),
    inverseJoinColumns = @JoinColumn(name = "user_id"))
  private final Set<User> likes = new HashSet<>();

  @OneToMany(mappedBy = "topic")
  private final List<Reply> replies = new ArrayList<>();

  public Topic(){}

  public Topic(Long id, String code, String title, String body, TypeStatus status, Instant createdAt,
               Instant updatedAt, Lesson lesson, User author, Offer offer, Reply answer) {
    this.id = id;
    this.code = code;
    this.title = title;
    this.body = body;
    this.status = status;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.lesson = lesson;
    this.author = author;
    this.offer = offer;
    this.answer = answer;
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

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
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

  public Lesson getLesson() {
    return lesson;
  }

  public void setLesson(Lesson lesson) {
    this.lesson = lesson;
  }

  public User getAuthor() {
    return author;
  }

  public void setAuthor(User author) {
    this.author = author;
  }

  public Offer getOffer() {
    return offer;
  }

  public void setOffer(Offer offer) {
    this.offer = offer;
  }

  public Reply getAnswer() {
    return answer;
  }

  public void setAnswer(Reply answer) {
    this.answer = answer;
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

    Topic topic = (Topic) o;

    return id.equals(topic.id);
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }
}
