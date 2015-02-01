package com.sloydev.jsonadapters;

public class JsonConverter {

    private final JsonAdapter jsonAdapter;

    public JsonConverter(JsonAdapter jsonAdapter) {
        this.jsonAdapter = jsonAdapter;
    }

    public String toJson(Object object) {
        return this.jsonAdapter.toJson(object);
    }

    public <T> T fromJson(String json, Class<T> type) {
        return this.jsonAdapter.fromJson(json, type);
    }

}
