package bg.softuni.andrey.repository;

import bg.softuni.andrey.model.entity.Item;
import bg.softuni.andrey.model.entity.view.ItemViewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
