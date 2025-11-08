package dev.khukhuna.untoldthings.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.khukhuna.untoldthings.dto.BoughtProduct;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.List;

@Converter
public class BoughtProductsConverter implements AttributeConverter<List<BoughtProduct>, String> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(List<BoughtProduct> boughtProducts) {
        try {
            return objectMapper.writeValueAsString(boughtProducts);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error converting BoughtProducts to JSON", e);
        }
    }

    @Override
    public List<BoughtProduct> convertToEntityAttribute(String json) {
        try {
            if (json == null || json.isEmpty()) return List.of();
            return objectMapper.readValue(json, new TypeReference<>() {});
        } catch (Exception e) {
            throw new IllegalArgumentException("Error reading BoughtProducts JSON", e);
        }
    }
}
