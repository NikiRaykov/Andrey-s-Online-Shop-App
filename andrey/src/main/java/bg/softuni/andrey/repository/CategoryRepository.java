package bg.softuni.andrey.repository;

import bg.softuni.andrey.model.entity.Category;
import bg.softuni.andrey.model.entity.enums.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByName(CategoryNameEnum categoryNameEnum);
}
