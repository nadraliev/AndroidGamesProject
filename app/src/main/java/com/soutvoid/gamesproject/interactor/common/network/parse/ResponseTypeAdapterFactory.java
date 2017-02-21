package com.soutvoid.gamesproject.interactor.common.network.parse;

import com.agna.ferro.mvp.component.scope.PerApplication;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.soutvoid.gamesproject.app.log.Logger;
import com.soutvoid.gamesproject.interactor.common.network.error.ConversionException;
import com.soutvoid.gamesproject.interactor.common.network.parse.safe.SafeConverter;
import com.soutvoid.gamesproject.interactor.common.network.response.BaseResponse;

import java.io.IOException;

import javax.inject.Inject;


/**
 * ResponseTypeAdapterFactory - кроме парсинга ответа выполняет 3 дополнительные функции:
 * Логгирование ошибок парсинга в RemoteLogger
 * Конвертирование JsonSyntaxException -> ConversionException
 * Выбрасывание ApiServiceException - ошибки сервиса, приходящие в теле ответа
 */
@PerApplication
public class ResponseTypeAdapterFactory implements TypeAdapterFactory {

    public static final String PARSE_ERROR_MESSAGE_FORMAT = "Error when parse body: %s";
    private SafeConverterFactory safeConverterFactory;

    @Inject
    public ResponseTypeAdapterFactory(SafeConverterFactory safeConverterFactory) {
        this.safeConverterFactory = safeConverterFactory;
    }

    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        final TypeAdapter<T> delegate = gson.getDelegateAdapter(this, type);
        final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);
        return new TypeAdapter<T>() {

            public void write(JsonWriter out, T value) throws IOException {
                delegate.write(out, value);
            }

            public T read(JsonReader in) throws IOException {
                JsonElement jsonElement = elementAdapter.read(in);
                //пытаемся применить безопасный парсинг для известных нарушений структуры Json
                SafeConverter<T> safeConverter = safeConverterFactory.getSafeConverter(type);
                if (safeConverter != null) {
                    return safeConverter.convert(ResponseTypeAdapterFactory.this, gson, jsonElement);
                }
                //если пытаемся распарсить элемент, производный от {@link BaseResponse} то в
                // случае ошибки эмитим ConversionException с текстом ответа
                if (BaseResponse.class.isAssignableFrom(type.getRawType())) {
                    try {
                        return parseElement(jsonElement, true);
                    } catch (JsonSyntaxException e) {
                        String body = jsonElement != null ? jsonElement.toString() : "";
                        String errorMessage = String.format(PARSE_ERROR_MESSAGE_FORMAT, body);
                        ConversionException conversionException = new ConversionException(errorMessage, e);
                        Logger.e(e, "parse error");
                        throw conversionException;

                    }
                }
                return parseElement(jsonElement, false);
            }


            private T parseElement(JsonElement jsonElement, boolean isBaseResponse) {
                T result = delegate.fromJsonTree(jsonElement);
                if (isBaseResponse) {
                    BaseResponse baseResponse = (BaseResponse) result;
                }
                return result;
            }
        }.nullSafe();
    }
}

