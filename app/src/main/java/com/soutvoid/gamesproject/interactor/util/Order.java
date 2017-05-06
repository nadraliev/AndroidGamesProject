package com.soutvoid.gamesproject.interactor.util;


import lombok.Builder;
import lombok.Data;

/**
 * помогает строить строку order для использования в запросе
 */
@Data
@Builder
public class Order {

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

    private final String FIELDS_ORDER_SEPARATOR = ":";
    private final String FIELDS_SEPARATOR = ",";

    private String field;
    private OrderDirection orderDirection;

    public OrderDirection getOrderDirection() {
        return orderDirection == null ? OrderDirection.DESC : orderDirection;
    }

    @Override
    public String toString() {
        return getField() + FIELDS_ORDER_SEPARATOR + getOrderDirection().toString();
    }
}
