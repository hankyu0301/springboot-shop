package janghankyu.springbootshop.repository;

import janghankyu.springbootshop.dto.item.ItemSearchDto;
import janghankyu.springbootshop.dto.item.MainItemDto;
import janghankyu.springbootshop.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ItemCustomRepository {

    Page<Item> getAdminItemPage(ItemSearchDto itemSearchDto, Pageable pageable);

    Page<MainItemDto> getMainItemPage(ItemSearchDto itemSearchDto, Pageable pageable);
}
