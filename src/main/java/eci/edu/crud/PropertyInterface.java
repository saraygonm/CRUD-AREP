package eci.edu.crud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyInterface extends JpaRepository<Properties, Long> {
}
