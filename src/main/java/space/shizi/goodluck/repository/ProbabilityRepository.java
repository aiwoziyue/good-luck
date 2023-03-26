package space.shizi.goodluck.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import space.shizi.goodluck.entity.Probability;

@Repository
public interface ProbabilityRepository extends JpaRepository<Probability, Long>, JpaSpecificationExecutor<Probability> {
    Probability findFirstByTypeAndDateDesc(String type);
}