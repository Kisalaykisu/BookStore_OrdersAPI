package com.example.bookstore_ordersapi.service;

import com.example.bookstore_ordersapi.dto.OrderDTO;
import com.example.bookstore_ordersapi.model.BookOrders;

import java.util.List;

public interface IBookOrderService {
    String addOrderDetails(OrderDTO orderDTO);

    List<BookOrders> getOrderDetailsByToken(String token);

    String editOrderByOrderId(Long orderId, OrderDTO orderDTO);

    String deleteOrderByOrderId(Long userId, Long orderId);
}
