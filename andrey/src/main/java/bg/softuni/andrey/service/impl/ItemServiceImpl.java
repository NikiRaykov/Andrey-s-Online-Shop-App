package bg.softuni.andrey.service.impl;

import bg.softuni.andrey.model.entity.Item;
import bg.softuni.andrey.model.entity.service.CategoryServiceModel;
import bg.softuni.andrey.model.entity.service.ItemServiceModel;
import bg.softuni.andrey.model.entity.view.ItemViewModel;
import bg.softuni.andrey.repository.ItemRepository;
import bg.softuni.andrey.service.CategoryService;
import bg.softuni.andrey.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    private final ModelMapper modelMapper;
    private final CategoryService categoryService;
    private final ItemRepository itemRepository;

    public ItemServiceImpl(ModelMapper modelMapper, CategoryService categoryService, ItemRepository itemRepository) {
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
        this.itemRepository = itemRepository;
    }

    @Override
    public void addItem(ItemServiceModel itemServiceModel) {
        CategoryServiceModel categoryServiceModel = this.categoryService
                .findByCategoryNameEnum(itemServiceModel.getCategory().getName());

        itemServiceModel.setCategory(categoryServiceModel);

        this.itemRepository.save(this.modelMapper.map(itemServiceModel, Item.class));

    }

    @Override
    public List<ItemViewModel> findAllItems() {
        return itemRepository
                .findAll().stream()
                .map(item -> {
                    ItemViewModel itemViewModel = this.modelMapper
                            .map(item, ItemViewModel.class);

                    itemViewModel.setImgUrl(String
                            .format("/img/%s-%s.jpg", item.getGender(), item.getCategory().getName().name()));


                    return itemViewModel;
                }).collect(Collectors.toList());
    }

    @Override
    public ItemViewModel findById(Long id) {
        return itemRepository.findById(id)
                .map(item -> {
                            ItemViewModel itemViewModel = this.modelMapper
                                    .map(item, ItemViewModel.class);

                            itemViewModel.setImgUrl(String
                                    .format("/img/%s-%s.jpg", item.getGender(), item.getCategory().getName().name()));


                            return itemViewModel;
                        }
                ).orElse(null);
    }

    @Override
    public void delete(Long id) {
        itemRepository.deleteById(id);
    }
}
