package com.example.fis.mapper;

import com.example.fis.entity.Order;
import com.example.fis.entity.OrderDetail;
import com.example.fis.entity.Product;
import com.example.fis.model.request.orderdetail.OrderDetailSaveRq;
import com.example.fis.model.response.OrderDetailResponse;
import com.example.fis.repository.OrderRepo;
import com.example.fis.repository.ProductRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class OrderDetailMapper {
    private final OrderRepo orderRepo;

    private final ProductRepo productRepo;

    public OrderDetail toOrderDetail(OrderDetailSaveRq detailSaveRq) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setId(detailSaveRq.getId());
        orderDetail.setOrder(orderRepo.findById(detailSaveRq.getId()).get());
        orderDetail.setProduct(productRepo.findById(detailSaveRq.getId()).get());
        orderDetail.setQuantity(detailSaveRq.getQuantity());
        orderDetail.setPrice(detailSaveRq.getPrice());
        orderDetail.setCreateDate(detailSaveRq.getCreateDate());
        orderDetail.setNote(detailSaveRq.getNote());
        return orderDetail;
    }

    public OrderDetailResponse toOrderDetailResponse(OrderDetail orderDetail){
        OrderDetailResponse orderDetailResponse = new OrderDetailResponse();
        orderDetailResponse.setId(orderDetail.getId());
        orderDetailResponse.setOrder(orderDetail.getOrder());
        orderDetailResponse.setProduct(orderDetail.getProduct());
        orderDetailResponse.setQuantity(orderDetail.getQuantity());
        orderDetailResponse.setPrice(orderDetail.getPrice());
        orderDetailResponse.setCreateDate(orderDetail.getCreateDate());
        orderDetailResponse.setUpdatedDate(orderDetail.getUpdatedDate());
        orderDetailResponse.setNote(orderDetail.getNote());
        return orderDetailResponse;
    }
}