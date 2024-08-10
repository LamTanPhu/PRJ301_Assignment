/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Tony
 */
public class Cart {
    private Integer cartId;
    private String userId;
    private String mobileId;
    private Integer quantity;

    public Cart(Integer cartId, String userId, String mobileId, Integer quantity) {
        this.cartId = cartId;
        this.userId = userId;
        this.mobileId = mobileId;
        this.quantity = quantity;
    }
    
    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMobileId() {
        return mobileId;
    }

    public void setMobileId(String mobileId) {
        this.mobileId = mobileId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
