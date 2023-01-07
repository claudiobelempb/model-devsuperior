package br.sub.com.projectmodel.modules.notification.infra.repositories;

import br.sub.com.projectmodel.modules.notification.infra.entities.Notification;
import br.sub.com.projectmodel.modules.user.infra.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
  /*Page<Notification> findByUser(User user, Pageable pageable);*/

  /*Mostrar todas ou mostrar todas não lida*/
  String jpqlFilterUnreadOnly =
    "SELECT n FROM Notification n " +
    "WHERE (n.user = :user) AND (:unreadOnly = false OR n.read = false) " +
    "ORDER BY n.createdAt DESC";
  @Query(jpqlFilterUnreadOnly)
  Page<Notification> filterUnreadOnly(User user, boolean unreadOnly, Pageable pageable);
}
