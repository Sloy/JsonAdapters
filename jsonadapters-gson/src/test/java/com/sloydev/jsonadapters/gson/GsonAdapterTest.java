package com.sloydev.jsonadapters.gson;

import com.sloydev.jsonadapters.JsonAdapter;
import com.sloydev.jsonadapters.test.AbstractAdapterTest;

public class GsonAdapterTest extends AbstractAdapterTest{
    @Override
    protected JsonAdapter getAdapter() {
        return new GsonAdapter();
    }
}
