package be.solodoukhin.repository;

import be.solodoukhin.model.HotWord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotWordRepository extends JpaRepository<HotWord, Integer> {
}
