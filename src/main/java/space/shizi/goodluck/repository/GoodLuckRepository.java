package space.shizi.goodluck.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import space.shizi.goodluck.entity.GoodLuck;

@Repository
public interface GoodLuckRepository extends JpaRepository<GoodLuck, Long>, JpaSpecificationExecutor<GoodLuck> {

    GoodLuck findFirstByOrderByCodeDesc();
}