package com.example.bookstore_ordersapi.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderDTO {
    Long userId;
    Long bookId;
    int orderQuantity;
}
