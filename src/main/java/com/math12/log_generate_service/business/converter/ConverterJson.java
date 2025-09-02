package com.math12.log_generate_service.business.converter;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConverterJson {
    private final ObjectMapper objectMapper;

    public String convertToJson(Object dto){
        try {
            return objectMapper.writeValueAsString(dto);
        }catch (Exception e){
            return "error while convert to json: " + e.getMessage();
        }
    }

    public <T> T readJson(String jsonString, Class<T> classConverter){
        try {
            return objectMapper.readValue(jsonString,classConverter);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
