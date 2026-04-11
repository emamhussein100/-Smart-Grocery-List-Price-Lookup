package org.example.smartgrocery.service.implemention;

import org.example.smartgrocery.dto.AddToListRequest;
import org.example.smartgrocery.dto.ShoppingItemForProduct;
import org.example.smartgrocery.dto.ShoppingListDto;
import org.example.smartgrocery.dto.UserDto;
import org.example.smartgrocery.entity.Product;
import org.example.smartgrocery.entity.ShoppingList;
import org.example.smartgrocery.entity.ShoppingListItem;
import org.example.smartgrocery.entity.User;
import org.example.smartgrocery.mapper.ShoppingListMapper;
import org.example.smartgrocery.repository.ProductRepository;
import org.example.smartgrocery.repository.ShoppingListRepository;
import org.example.smartgrocery.repository.UserRepository;
import org.example.smartgrocery.service.ShoppingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingListImpl implements ShoppingListService {
    private final ShoppingListRepository shoppingListRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private ShoppingListMapper shoppingListMapper;

    @Autowired
    public ShoppingListImpl(ShoppingListRepository shoppingListRepository, UserRepository userRepository, ProductRepository productRepository, ShoppingListMapper shoppingListMapper) {
        this.shoppingListRepository = shoppingListRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.shoppingListMapper = shoppingListMapper;
    }

    @Override
    @Transactional
    public ShoppingListDto createList(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        ShoppingList shoppingList = new ShoppingList();
        shoppingList.setUser(user);
        ShoppingList savedShoppingList = shoppingListRepository.save(shoppingList);
        return shoppingListMapper.toShoppingListDto(savedShoppingList);
    }

    @Override
    @Transactional
    public ShoppingListDto addProduct(AddToListRequest addToListRequest) {
        ShoppingList list = shoppingListRepository.findById(addToListRequest.getListId())
                .orElseThrow();

        Product product = productRepository.findById(addToListRequest.getProductId())
                .orElseThrow();
        User user = userRepository.findById(addToListRequest.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));

        Optional<ShoppingListItem> existing = list.getItems()
                .stream()
                .filter(i -> i.getProduct().getId().equals(addToListRequest.getProductId()))
                .findFirst();

        list.setUser(user);
        if (existing.isPresent()) {
            existing.get().setQuantity(existing.get().getQuantity() + addToListRequest.getQuantity());
        } else {
            ShoppingListItem item = new ShoppingListItem();
            item.setShoppingList(list);
            item.setProduct(product);
            item.setQuantity(addToListRequest.getQuantity());
            list.getItems().add(item);
        }

        return shoppingListMapper.toShoppingListDto(shoppingListRepository.save(list));
    }

    @Override
    public List<ShoppingListDto> getUserLists(Long userId) {
        return shoppingListRepository.findByUserId(userId)
                .stream()
                .map(shoppingListMapper::toShoppingListDto)
                .toList();
    }
}
