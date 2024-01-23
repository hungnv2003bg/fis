package com.example.fis.service.impl;

import com.example.fis.entity.*;
import com.example.fis.enums.StatusOrder;
import com.example.fis.exception.BusinessException;
import com.example.fis.exception.ErrorCode;
import com.example.fis.mapper.CartMapper;
import com.example.fis.mapper.OrderDetailMapper;
import com.example.fis.mapper.OrderMapper;
import com.example.fis.model.request.order.OrderSaveRequest;
import com.example.fis.model.response.*;
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

    private final UserRepo userRepo;

    private final CartMapper cartMapper;

    @Override
    public CheckOut getDataPay(Long userId) {
        Optional<User> userOptional = userRepo.findById(userId);
        if (userOptional.isEmpty()) {
            throw new BusinessException(ErrorCode.USER_NOT_FOUD);
        }

        List<CartResponse> listCartResponses = CartResponse.fromCollection(cartRepo.findCartsByCustomer(userOptional.get()));
        List<AddressResponse> addressResponseList = AddressResponse.fromCollection(addressRepo.findAddresssByUser(userOptional.get()));
        List<PayResponse> payResponseList = PayResponse.fromCollection(payRepo.findAll());
        List<ShipResponse> shipResponses = ShipResponse.fromCollection(shipRepo.findAll());

        return new CheckOut(listCartResponses, addressResponseList, payResponseList, shipResponses);
    }

    private void updateQuantity(long orderId) {
        Order order = orderRepo.findById(orderId).get();
        var detail = orderDetailRepo.findOrderDetailsByOrder(order);
        for (var item : detail) {
            Product pr = item.getProduct();
            pr.setSoLuongTon(pr.getSoLuongTon() - item.getQuantity());
            pr.setSoLuongDaBan(pr.getSoLuongDaBan() + item.getQuantity());
            productRepo.save(pr);
        }
    }

    @Override
    public OrderResponse addOrder(OrderSaveRequest orderSaveRequest) {
        Order order = orderMapper.toOrder(orderSaveRequest);

        Address address = addressRepo.findById(orderSaveRequest.getAddressId())
                .orElseThrow(() -> new BusinessException(ErrorCode.ADDRESS_NOT_FOUD));
        order.setAddress(address);

        Pay pay = payRepo.findById(orderSaveRequest.getPayId())
                .orElseThrow(() -> new BusinessException(ErrorCode.PAY_NOT_FOUD));
        order.setPay(pay);

        Ship ship = shipRepo.findById(orderSaveRequest.getShipId())
                .orElseThrow(() -> new BusinessException(ErrorCode.SHIP_NOT_FOUD));
        order.setShip(ship);

        User customer = address.getUser();
        order.setStatusOrder(orderSaveRequest.getStatusOrder());
        order.setCreateDate(LocalDateTime.now());

        List<Cart> cartList = cartRepo.findCartsByCustomer(customer);
        Double orderValue = cartList.stream()
                .mapToDouble(cart -> {
                    Product product = productRepo.findById(cart.getProduct().getId())
                            .orElseThrow(() -> new BusinessException(ErrorCode.PRODUCT_NOT_FOUD));
                    return product.getPriceOutput() * cart.getQuantity();
                })
                .sum();
        order.setOrderValue(orderValue + orderSaveRequest.getFeeShip());
        order.setFeeShip(orderSaveRequest.getFeeShip());
        orderRepo.save(order);
        order.setCodeOrder("Order" + order.getId());
        order.setOrderDetailList(createOrderDetail(cartList, order.getId()));
        orderRepo.save(order);

        return orderMapper.toOrderResponse(order);
    }

    @Override
    public OrderResponse addOrderVnPay(OrderSaveRequest orderSaveRequest) {
        Order order = orderMapper.toOrder(orderSaveRequest);

        Address address = addressRepo.findById(orderSaveRequest.getAddressId())
                .orElseThrow(() -> new BusinessException(ErrorCode.ADDRESS_NOT_FOUD));
        order.setAddress(address);

        Pay pay = payRepo.findById(orderSaveRequest.getPayId())
                .orElseThrow(() -> new BusinessException(ErrorCode.PAY_NOT_FOUD));
        order.setPay(pay);

        Ship ship = shipRepo.findById(orderSaveRequest.getShipId())
                .orElseThrow(() -> new BusinessException(ErrorCode.SHIP_NOT_FOUD));
        order.setShip(ship);

        User customer = address.getUser();
        order.setStatusOrder(StatusOrder.CHOTHANHTOANBANKING);
        order.setCreateDate(LocalDateTime.now());

        List<Cart> cartList = cartRepo.findCartsByCustomer(customer);
        Double orderValue = cartList.stream()
                .mapToDouble(cart -> {
                    Product product = productRepo.findById(cart.getProduct().getId())
                            .orElseThrow(() -> new BusinessException(ErrorCode.PRODUCT_NOT_FOUD));
                    return product.getPriceOutput() * cart.getQuantity();
                })
                .sum();
        Double feeShip = orderSaveRequest.getOrderValue() != null ? orderSaveRequest.getFeeShip() : 0.0;

        order.setOrderValue(orderValue + feeShip);
        orderRepo.save(order);
        order.setCodeOrder("Order" + order.getId());
        order.setOrderDetailList(createOrderDetail(cartList, order.getId()));
        orderRepo.save(order);

        return orderMapper.toOrderResponse(order);
    }

    @Override
    public void checkPayVNPay(Long id, Long statusOrder) {
        Optional<Order> orderOptional = orderRepo.findById(id);
        if (orderOptional.isEmpty()) {
            throw new BusinessException(ErrorCode.ORDER_NOT_FOUD);
        }
        if (statusOrder == 4) {
            List<Cart> cartList = cartRepo.findCartsByCustomer(orderOptional.get().getCustomer());
            cartRepo.deleteAll(cartList);
            updateQuantity(orderOptional.get().getId());
            orderOptional.get().setDatePay(LocalDateTime.now());
            orderOptional.get().setStatusOrder(StatusOrder.CHOXACNHAN);
            orderRepo.save(orderOptional.get());
        } else {
            orderOptional.get().setStatusOrder(StatusOrder.CANCEL);
            orderRepo.save(orderOptional.get());
        }
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
