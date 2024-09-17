package cn.fluxhvh.neverlose.enums;

import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.writer.ObjectWriter;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.lang.reflect.Type;

@Getter
@AllArgsConstructor
public enum Products {
    CSGO("csgo"), CS2("cs2");

    private final String product;

    public static class ProductsSerializer implements ObjectWriter<Products> {
        @Override
        public void write(JSONWriter jsonWriter, Object object, Object fieldName, Type fieldType, long features) {
            if (object instanceof Products) {
                jsonWriter.writeString(((Products) object).getProduct());
            }
        }
    }
}
