package xyz.victorl.scrontch.shoppinglist.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.victorl.scrontch.common.service.UserService;
import xyz.victorl.scrontch.shoppinglist.dto.IngredientitemDto;
import xyz.victorl.scrontch.shoppinglist.dto.NonfooditemDto;
import xyz.victorl.scrontch.shoppinglist.dto.ShoppinglistDto;
import xyz.victorl.scrontch.shoppinglist.entity.Ingredientitem;
import xyz.victorl.scrontch.shoppinglist.entity.Nonfooditem;
import xyz.victorl.scrontch.shoppinglist.entity.Shoppinglist;
import xyz.victorl.scrontch.shoppinglist.exception.DefaultListDeletionException;
import xyz.victorl.scrontch.shoppinglist.mapper.IngredientitemMapper;
import xyz.victorl.scrontch.shoppinglist.mapper.NonfooditemMapper;
import xyz.victorl.scrontch.shoppinglist.mapper.ShoppinglistMapper;
import xyz.victorl.scrontch.shoppinglist.repository.IngredientitemRepository;
import xyz.victorl.scrontch.shoppinglist.repository.NonfooditemRepository;
import xyz.victorl.scrontch.shoppinglist.repository.ShoppinglistRepository;
import xyz.victorl.scrontch.shoppinglist.service.ShoppinglistService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ShoppinglistServiceImpl implements ShoppinglistService {

    private final ShoppinglistRepository shoppinglistRepository;
    private final ShoppinglistMapper shoppinglistMapper;
    private final IngredientitemMapper ingredientitemMapper;
    private final NonfooditemMapper nonfooditemMapper;
    private final IngredientitemRepository ingredientitemRepository;
    private final NonfooditemRepository nonfooditemRepository;
    private final UserService userService;

    @Override
    public List<ShoppinglistDto> findAll() {
        return shoppinglistRepository.findAll()
                .stream()
                .map(shoppinglistMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ShoppinglistDto findById(Integer id) {
        Shoppinglist shoppinglist = shoppinglistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shoppinglist not found"));
        return shoppinglistMapper.toDto(shoppinglist);
    }

    @Override
    public ShoppinglistDto create(ShoppinglistDto shoppinglistDto) {
        Shoppinglist shoppinglist = shoppinglistMapper.toEntity(shoppinglistDto);

        if (shoppinglist.getIngredientitems() != null) {
            shoppinglist.getIngredientitems().forEach(item ->
                    item.setShoppinglistid(shoppinglist));
        }

        return shoppinglistMapper.toDto(shoppinglistRepository.save(shoppinglist));
    }


    @Override
    public ShoppinglistDto update(Integer id, ShoppinglistDto shoppinglistDto) {
        Shoppinglist shoppinglist = shoppinglistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shoppinglist not found"));

        shoppinglistMapper.partialUpdate(shoppinglistDto, shoppinglist);
        return shoppinglistMapper.toDto(shoppinglistRepository.save(shoppinglist));
    }

    @Override
    public void delete(Integer id) {
        if (!shoppinglistRepository.existsById(id)) {
            throw new RuntimeException("Shoppinglist not found");
        }
        shoppinglistRepository.deleteById(id);
    }

    @Override
    public List<ShoppinglistDto> findByUserId(Integer userid) {
        List<Shoppinglist> shoppinglists = shoppinglistRepository.findByUserid(userid);
        return shoppinglists.stream()
                .map(shoppinglistMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public IngredientitemDto addIngredientToShoppinglist(Integer shoppinglistId, IngredientitemDto ingredientitemDto) {
        Shoppinglist shoppinglist = shoppinglistRepository.findById(shoppinglistId)
                .orElseThrow(() -> new RuntimeException("Shoppinglist not found"));
        Ingredientitem ingredientitem = ingredientitemMapper.toEntity(ingredientitemDto);
        ingredientitem.setShoppinglistid(shoppinglist);
        Ingredientitem savedItem = ingredientitemRepository.save(ingredientitem);

        return ingredientitemMapper.toDto(savedItem);
    }

    @Override
    public NonfooditemDto addNonFoodItemToShoppinglist(Integer shoppinglistId, NonfooditemDto nonfooditemDto) {
        Shoppinglist shoppinglist = shoppinglistRepository.findById(shoppinglistId)
                .orElseThrow(() -> new RuntimeException("Shoppinglist not found"));
        Nonfooditem nonfooditem = nonfooditemMapper.toEntity(nonfooditemDto);
        nonfooditem.setShoppinglistid(shoppinglist);
        Nonfooditem savedItem = nonfooditemRepository.save(nonfooditem);

        return nonfooditemMapper.toDto(savedItem);
    }

    @Override
    public void deleteShoppingList(Integer listId) {
        Shoppinglist list = shoppinglistRepository.findById(listId)
                .orElseThrow(() -> new RuntimeException("Shopping list not found"));

        if (list.getName().equals(Shoppinglist.DEFAULT_LIST_NAME)) {
            throw new DefaultListDeletionException("Cannot delete the default shopping list");
        }

        shoppinglistRepository.delete(list);
    }

    @Transactional
    public void createDefaultListIfNotExists(Integer userId) {
        if (!userService.existsById(userId)) {
            throw new IllegalArgumentException("User does not exist");
        }
        boolean hasDefaultList = shoppinglistRepository.existsByUseridAndName(
                userId,
                "Liste de courses"
        );

        if (!hasDefaultList) {
            Shoppinglist defaultList = new Shoppinglist();
            defaultList.setUserid(userId);
            defaultList.setName("Liste de courses");
            shoppinglistRepository.save(defaultList);
        }
    }

}
