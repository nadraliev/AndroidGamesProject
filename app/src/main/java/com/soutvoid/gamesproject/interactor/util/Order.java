package com.soutvoid.gamesproject.interactor.util;


import io.realm.RealmObject;
import io.realm.annotations.Ignore;

/**
 * помогает строить строку order для использования в запросе
 */
public class Order extends RealmObject {

    public Order(String field, String orderDirection) {
        this.field = field;
        this.orderDirection = orderDirection;
    }

    public Order() {
    }

    public static OrderBuilder builder() {
        return new OrderBuilder();
    }

    public String getFIELDS_ORDER_SEPARATOR() {
        return this.FIELDS_ORDER_SEPARATOR;
    }

    public String getFIELDS_SEPARATOR() {
        return this.FIELDS_SEPARATOR;
    }

    public String getField() {
        return this.field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Order)) return false;
        final Order other = (Order) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$FIELDS_ORDER_SEPARATOR = this.getFIELDS_ORDER_SEPARATOR();
        final Object other$FIELDS_ORDER_SEPARATOR = other.getFIELDS_ORDER_SEPARATOR();
        if (this$FIELDS_ORDER_SEPARATOR == null ? other$FIELDS_ORDER_SEPARATOR != null : !this$FIELDS_ORDER_SEPARATOR.equals(other$FIELDS_ORDER_SEPARATOR))
            return false;
        final Object this$FIELDS_SEPARATOR = this.getFIELDS_SEPARATOR();
        final Object other$FIELDS_SEPARATOR = other.getFIELDS_SEPARATOR();
        if (this$FIELDS_SEPARATOR == null ? other$FIELDS_SEPARATOR != null : !this$FIELDS_SEPARATOR.equals(other$FIELDS_SEPARATOR))
            return false;
        final Object this$field = this.getField();
        final Object other$field = other.getField();
        if (this$field == null ? other$field != null : !this$field.equals(other$field))
            return false;
        final Object this$orderDirection = this.getOrderDirection();
        final Object other$orderDirection = other.getOrderDirection();
        if (this$orderDirection == null ? other$orderDirection != null : !this$orderDirection.equals(other$orderDirection))
            return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $FIELDS_ORDER_SEPARATOR = this.getFIELDS_ORDER_SEPARATOR();
        result = result * PRIME + ($FIELDS_ORDER_SEPARATOR == null ? 43 : $FIELDS_ORDER_SEPARATOR.hashCode());
        final Object $FIELDS_SEPARATOR = this.getFIELDS_SEPARATOR();
        result = result * PRIME + ($FIELDS_SEPARATOR == null ? 43 : $FIELDS_SEPARATOR.hashCode());
        final Object $field = this.getField();
        result = result * PRIME + ($field == null ? 43 : $field.hashCode());
        final Object $orderDirection = this.getOrderDirection();
        result = result * PRIME + ($orderDirection == null ? 43 : $orderDirection.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof Order;
    }

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
        if (getField() != null)
            return getField() + FIELDS_ORDER_SEPARATOR + getOrderDirection().toString();
        else
            return null;
    }

    public static class OrderBuilder {
        private String field;
        private String orderDirection;

        OrderBuilder() {
        }

        public Order.OrderBuilder field(String field) {
            this.field = field;
            return this;
        }

        public Order.OrderBuilder orderDirection(String orderDirection) {
            this.orderDirection = orderDirection;
            return this;
        }

        public Order build() {
            return new Order(field, orderDirection);
        }

        public String toString() {
            return "com.soutvoid.gamesproject.interactor.util.Order.OrderBuilder(field=" + this.field + ", orderDirection=" + this.orderDirection + ")";
        }
    }
}
