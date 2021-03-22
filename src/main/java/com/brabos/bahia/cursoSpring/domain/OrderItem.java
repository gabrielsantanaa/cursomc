package com.brabos.bahia.cursoSpring.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class OrderItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    @JsonIgnore
    private OrderItemPK id = new OrderItemPK();

    private Double discount;
    private Integer quantidade;
    private Double price;

    public OrderItem(){

    }

    public OrderItem(ClientOrder clientOrder, Product product, Double discount, Integer quantidade, Double price) {
        super();
        id.setClientOrder(clientOrder);
        id.setProduct(product);
        this.discount = discount;
        this.quantidade = quantidade;
        this.price = price;
    }

    @JsonIgnore
    public ClientOrder getClientOrder(){
        return this.id.getClientOrder();
    }

    public Product getProduct(){
        return this.id.getProduct();
    }

    public OrderItemPK getId() {
        return id;
    }

    public void setId(OrderItemPK id) {
        this.id = id;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}