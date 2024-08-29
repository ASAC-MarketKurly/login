package ASAC8._SpringPractice.banner.repository;

import ASAC8._SpringPractice.banner.entity.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository // extends JpaRepository = Query Method => Query 변환
public interface BannerRepository extends JpaRepository<Banner, Integer> {
    Optional<Banner> findById(Integer id);
    List<Banner> findAll();
    Banner save(Banner banner);
    void deleteById(Integer integer);
    void deleteAll();
}
