package com.soutvoid.gamesproject.interactor.util;


import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * помогает строить строку order для использования в запросе
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order extends RealmObject {

    /**
     * доступные направления сортировки
     */
    public enum OrderDirection {
        /**
         * по убыванию
         */
        DESC,
        /**
         * по возрастанию
         */
        ASC;


        @Override
        public String toString() {
            return super.toString().toLowerCase();
        }
    }

    @Ignore
    private final String FIELDS_ORDER_SEPARATOR = ":";
    @Ignore
    private final String FIELDS_SEPARATOR = ",";

    private String field;
    private String orderDirection;

    public OrderDirection getOrderDirection() {
        return orderDirection == null ? OrderDirection.DESC : OrderDirection.valueOf(orderDirection);
    }

    public void setOrderDirection(OrderDirection orderDirection) {
        this.orderDirection = orderDirection.toString();
    }

    @Override
    public String toString() {
        return getField() + FIELDS_ORDER_SEPARATOR + getOrderDirection().toString();
    }
}
