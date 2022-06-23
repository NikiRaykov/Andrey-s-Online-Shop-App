package bg.softuni.andrey.service;

import bg.softuni.andrey.model.entity.service.ItemServiceModel;
import bg.softuni.andrey.model.entity.view.ItemViewModel;

import java.util.List;

public interface ItemService {
    void addItem(ItemServiceModel itemServiceModel);

    List<ItemViewModel> findAllItems();

    ItemViewModel findById(Long id);

    void delete(Long id);
}
