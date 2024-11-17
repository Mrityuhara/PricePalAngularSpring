package mapper;

import dto.ItemDTO;
import entity.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface ItemMapper {


    ItemDTO itemToItemDTO(Item item);


    Item itemDTOToItem(ItemDTO itemDTO);
}