package br.sub.com.projectmodel.modules.lesson.infra.entities;

import br.sub.com.projectmodel.modules.section.infra.entities.Section;
import br.sub.com.projectmodel.shared.enums.TypeStatus;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "tb_content")
public class Content extends Lesson implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  private String textContent;
  private String videoUrl;

  public Content(){}

  public Content(Long id, String code, String title, Integer position, TypeStatus status, Instant createdAt,
                 Instant updatedAt, Section section, String textContent, String videoUrl) {
    super(id, code, title, position, status, createdAt, updatedAt, section);
    this.textContent = textContent;
    this.videoUrl = videoUrl;
  }

  public String getTextContent() {
    return textContent;
  }

  public void setTextContent(String textContent) {
    this.textContent = textContent;
  }

  public String getVideoUrl() {
    return videoUrl;
  }

  public void setVideoUrl(String videoUrl) {
    this.videoUrl = videoUrl;
  }
}
