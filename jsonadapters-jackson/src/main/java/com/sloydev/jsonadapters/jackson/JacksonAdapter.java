package com.sloydev.jsonadapters.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sloydev.jsonadapters.JsonAdapter;

import java.io.IOException;

public class JacksonAdapter implements JsonAdapter {

    private final ObjectMapper objectMapper;

    public JacksonAdapter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public <Type> Type fromJson(String json, Class<Type> type) {
        try {
            return objectMapper.readValue(json, type);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
