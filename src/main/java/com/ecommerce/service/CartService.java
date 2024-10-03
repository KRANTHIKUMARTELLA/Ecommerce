package com.ecommerce.service;

import com.ecommerce.exception.ProductNotFoundException;
import com.ecommerce.model.Cart;
import com.ecommerce.model.CartItem;
import com.ecommerce.model.Product;
import com.ecommerce.repository.CartItemRepository;
import com.ecommerce.repository.CartRepository;
import com.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    @Autowired
    private final CartRepository cartRepository;
    @Autowired
    private final CartItemRepository cartItemRepository;
    @Autowired
    private final ProductRepository productRepository;

    public CartService(CartRepository cartRepository ,CartItemRepository cartItemRepository , ProductRepository productRepository) {
        super();
        this.cartRepository=cartRepository;
        this.cartItemRepository=cartItemRepository;
        this.productRepository=productRepository;
    }

    public Cart getCartByUserId(Integer userId) {
        return cartRepository.findById(userId).get();
    }

    public Cart addProductToCart(Integer userId, Integer productId, Integer quantity) {
        Cart cart = getCartByUserId(userId);
        Product product = productRepository.findById(productId).get();


        // Check if item is already in cart
        CartItem cartItem = cart.getItems().stream()
                .filter(item -> item.getProduct().getProductId().equals(productId))
                .findFirst()
                .orElse(new CartItem(null, product, quantity, cart));

        if (cartItem.getId() == null) {
            cart.getItems().add(cartItem);
        } else {
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
        }

        cart.calculateTotalPrice();
        cartRepository.save(cart);

        return cart;
    }

    public Cart removeProductFromCart(Integer userId, Integer productId) {

        Cart cart = getCartByUserId(userId);

        cart.getItems().removeIf(item -> item.getProduct().getProductId().equals(productId));

        cart.calculateTotalPrice();
        cartRepository.save(cart);
        return cart;
    }

    public Cart updateProductQuantity(Integer userId, Integer productId, Integer quantity) {
        Cart cart = getCartByUserId(userId);

        CartItem cartItem = cart.getItems().stream()
                .filter(item -> item.getProduct().getProductId().equals(productId))
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException("Product not in cart"));

        cartItem.setQuantity(quantity);
        cart.calculateTotalPrice();
        cartRepository.save(cart);
        return cart;
    }

    public void clearCart(Integer userId) {
        Cart cart = getCartByUserId(userId);
        cart.getItems().clear();
        cart.setTotalPrice(0.0);
        cartRepository.save(cart);
    }
}
