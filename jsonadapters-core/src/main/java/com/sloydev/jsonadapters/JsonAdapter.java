package com.sloydev.jsonadapters;

public interface JsonAdapter {
    String toJson(Object object);

    <T> T fromJson(String json, Class<T> type);
}
