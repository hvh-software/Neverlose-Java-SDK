package cn.fluxhvh.neverlose.response.impl;

import cn.fluxhvh.neverlose.response.BaseResponse;
import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
public class GetProductPriceResponse extends BaseResponse {
    @JSONField(name = "prices")
    private PricesDTO prices;

    @Setter
    @Getter
    @ToString(callSuper = true)
    @NoArgsConstructor
    public static class PricesDTO {
        @JSONField(name = "30")
        private PriceDTO _30_Days;
        @JSONField(name = "90")
        private PriceDTO _90_Days;
        @JSONField(name = "180")
        private PriceDTO _180_Days;
        @JSONField(name = "365")
        private PriceDTO _365_Days;

        @Setter
        @Getter
        @ToString(callSuper = true)
        @NoArgsConstructor
        public static class PriceDTO {
            @JSONField(name = "cnt")
            private Integer cnt;
            @JSONField(name = "eur")
            private Double eur;
            @JSONField(name = "rub")
            private Integer rub;
        }
    }
}
