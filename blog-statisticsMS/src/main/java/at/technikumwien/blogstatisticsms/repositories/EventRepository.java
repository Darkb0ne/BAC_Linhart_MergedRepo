package at.technikumwien.blogstatisticsms.repositories;

import at.technikumwien.blogstatisticsms.models.Event;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Order(1)
@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    List<Event> findAllByCreatedAtAfter(java.util.Date createdAt);


}
