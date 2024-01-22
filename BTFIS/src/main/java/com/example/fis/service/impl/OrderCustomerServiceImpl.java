package com.example.fis.service.impl;

import com.example.fis.entity.*;
import com.example.fis.enums.StatusOrder;
import com.example.fis.exception.BusinessException;
import com.example.fis.exception.ErrorCode;
import com.example.fis.mapper.OrderDetailMapper;
import com.example.fis.mapper.OrderMapper;
import com.example.fis.model.request.order.OrderSaveRequest;
import com.example.fis.model.response.OrderResponse;
import com.example.fis.repository.*;
import com.example.fis.service.OrderCustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderCustomerServiceImpl implements OrderCustomerService {
    private final PayRepo payRepo;

    private final ShipRepo shipRepo;

    private final OrderRepo orderRepo;

    private final OrderMapper orderMapper;

    private final AddressRepo addressRepo;

    private final CartRepo cartRepo;

    private final ProductRepo productRepo;

    private final OrderDetailMapper orderDetailMapper;

    private final OrderDetailRepo orderDetailRepo;


    @Override
    public OrderResponse addOrder(OrderSaveRequest orderSaveRequest) {
        Order order = orderMapper.toOrder(orderSaveRequest);
        Optional<Address> addressOptional = addressRepo.findById(orderSaveRequest.getAddressId());
        if (addressOptional.isEmpty()) {
            throw new BusinessException(ErrorCode.ADDRESS_NOT_FOUD);
        }
        Optional<Pay> payOptional = payRepo.findById(orderSaveRequest.getPayId());
        if (payOptional.isEmpty()) {
            throw new BusinessException(ErrorCode.PAY_NOT_FOUD);
        }
        Optional<Ship> shipOptional = shipRepo.findById(orderSaveRequest.getShipId());
        if (shipOptional.isEmpty()) {
            throw new BusinessException(ErrorCode.SHIP_NOT_FOUD);
        }
        User customer = addressOptional.get().getUser();
        order.setStatusOrder(StatusOrder.CHOXACNHAN);
        order.setCreateDate(LocalDateTime.now());
        order.setAddress(addressOptional.get());
        order.setPay(payOptional.get());
        order.setShip(shipOptional.get());
        List<Cart> cartList = cartRepo.findCartsByCustomer(customer);
        Double value = 0d;
        for (Cart cart : cartList) {
            Product product = productRepo.findById(cart.getProduct().getId()).get();
            value += product.getPriceOutput() * cart.getQuantity();
        }
        order.setOrderValue(value + orderSaveRequest.getFeeShip());
        orderRepo.save(order);
        order.setCodeOrder("Order" + order.getId());
        order.setOrderDetailList(createOrderDetail(cartList, order.getId()));
        orderRepo.save(order);
        return orderMapper.toOrderResponse(order);

    }


    private List<OrderDetail> createOrderDetail(List<Cart> cartList, Long orderId) {
        List<OrderDetail> orderDetailList = new ArrayList<>();
        Order order = orderRepo.findById(orderId).get();
        for (Cart cart : cartList) {
            Product product = productRepo.findById(cart.getProduct().getId()).get();
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setCreateDate(LocalDateTime.now());
            orderDetail.setProduct(product);
            orderDetail.setQuantity(cart.getQuantity());
            orderDetail.setPrice(cart.getProduct().getPriceOutput());
            orderDetail.setOrder(order);
            orderDetailRepo.save(orderDetail);
            orderDetailList.add(orderDetail);
            productRepo.save(product);
        }
        return orderDetailList;
    }

}
