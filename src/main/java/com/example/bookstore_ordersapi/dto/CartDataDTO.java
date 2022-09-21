package com.example.bookstore_ordersapi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CartDataDTO {
    Long cartId;
    Long userId;
    Long bookId;
    int quantity;
}
