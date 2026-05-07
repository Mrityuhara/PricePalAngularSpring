package service;

import dto.ItemDTO;
import entity.Item;
import org.springframework.stereotype.Service;
import repository.ItemRepository;
import mapper.ItemMapper;
import java.util.Optional;

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
        return this.itemRepository.findAll().stream().map(item -> {
            ItemDTO dto = new ItemDTO();
            dto.setId(item.getId());
            dto.setName(item.getName());
            dto.setPrice(item.getPrice());
            dto.setSupermarket(item.getSupermarket());
            dto.setNotes(item.getNotes());
            return dto;
        }).toList();
    }

    public ItemDTO createItem(ItemDTO itemDto){
        Item item = new Item();
        item.setName(itemDto.getName());
        item.setPrice(itemDto.getPrice());
        item.setSupermarket(itemDto.getSupermarket());
        item.setNotes(itemDto.getNotes());
        return toDTO(itemRepository.save(item));

    }

    public ItemDTO updateItem(Long id, ItemDTO itemDTO) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item non trovato"));

        item.setName(itemDTO.getName());
        item.setPrice(itemDTO.getPrice());
        item.setSupermarket(itemDTO.getSupermarket());
        item.setNotes(itemDTO.getNotes());
        return toDTO(itemRepository.save(item));
    }


    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }


    private ItemDTO toDTO(Item item) {
        ItemDTO dto = new ItemDTO();
        dto.setId(item.getId());
        dto.setName(item.getName());
        dto.setPrice(item.getPrice());
        dto.setSupermarket(item.getSupermarket());
        dto.setNotes(item.getNotes());
        return dto;
    }
}
