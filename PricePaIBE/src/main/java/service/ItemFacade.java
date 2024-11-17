package service;

import dto.ItemDTO;
import org.springframework.stereotype.Service;
import repository.ItemRepository;
import mapper.ItemMapper;

import java.util.List;

@Service
public class ItemFacade {

    private final ItemRepository itemRepository;

    private final ItemMapper itemMapper;

    public ItemFacade(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    public List<ItemDTO> fetchAllitems() {
           return this.itemRepository.findAll().stream().map(itemMapper::itemToItemDTO).toList();
    }
}
