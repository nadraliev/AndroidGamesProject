package com.soutvoid.gamesproject.interactor.util;

/**
 * Created by andrew on 2/23/17.
 */

/**
 * помогает строить строку order для использования в запросе
 */
public class OrderBuilder {

    /**
     * доступные направления сортировки
     */
    public enum Order {
        /**
         * по убыванию
         */
        DESC,
        /**
         * по возрастанию
         */
        ASC
    }

    private String fieldsOrderSeparator = ":";

    protected String fields = "";
    protected String fieldsSeparator = ",";

    /**
     * добавить поле для сортировки
     *
     * @param field
     * @return возвращает текущий экземпляр для простоты построения (цепочкой)
     */
    public OrderBuilder addField(String field) {
        if (!fields.equals(""))
            fields += fieldsSeparator;
        fields += field;
        return this;
    }

    /**
     * то же, что и {@link #addField(String)}, но принимает элемент enum
     */
    public <T extends Enum> OrderBuilder addField(T field) {
        return addField(field.toString().toLowerCase());
    }

    /**
     * сбрасывает текущий фильтр и добавляет все поля
     */
    public OrderBuilder addAllFields() {
        fields = "*";
        return this;
    }

    /**
     * очищает текущий фильтр
     */
    public OrderBuilder clear() {
        fields = "";
        return this;
    }

    /**
     * по умолчанию сортировать по убыванию
     */
    public String build() {
        return build(Order.DESC);
    }


    /**
     * Заканчивает строить строку и добавляет в конце направление сортировки
     *
     * @param order напраление сортировки
     * @return возвращает готовую строку для использования в запросе
     */
    public String build(Order order) {
        fields += fieldsOrderSeparator + order.toString().toLowerCase();
        return fields;
    }

}
