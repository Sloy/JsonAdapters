package com.sloydev.jsonadapters.gson;

import com.google.gson.Gson;
import com.sloydev.jsonadapters.JsonAdapter;

public class GsonAdapter implements JsonAdapter{

    private final Gson gson;

    public GsonAdapter() {
        this(new Gson());
    }

    public GsonAdapter(Gson gson) {
        this.gson = gson;
    }

    @Override
    public String toJson(Object object) {
        return gson.toJson(object);
    }

    @Override
    public <T> T fromJson(String json, Class<T> type) {
        return gson.fromJson(json, type);
    }
}
