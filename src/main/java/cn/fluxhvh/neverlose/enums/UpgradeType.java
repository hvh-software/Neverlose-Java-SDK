package cn.fluxhvh.neverlose.enums;

import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.writer.ObjectWriter;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.lang.reflect.Type;

@Getter
@AllArgsConstructor
public enum UpgradeType {
    _30_DAYS(0), _90_DAYS(1), _180_DAYS(2), _365_DAYS(3);

    private final int value;

    public static class UpgradeTypeSerializer implements ObjectWriter<UpgradeType> {
        @Override
        public void write(JSONWriter serializer, Object object, Object fieldName, Type fieldType, long features) {
            if (object instanceof UpgradeType) {
                serializer.writeInt32(((UpgradeType) object).getValue());
            }
        }
    }
}
