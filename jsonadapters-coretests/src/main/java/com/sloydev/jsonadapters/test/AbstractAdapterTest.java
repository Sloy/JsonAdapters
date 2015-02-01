package com.sloydev.jsonadapters.test;

import com.sloydev.jsonadapters.JsonAdapter;
import com.sloydev.jsonadapters.test.json.JSONObject;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public abstract class AbstractAdapterTest {
    protected abstract JsonAdapter getAdapter();

    @Test
    public void testConvertsBasicParametersToJson() throws Exception {
        BasicTypesProperties basicProperties = basicProperties();
        String json = getAdapter().toJson(basicProperties);
        verifyBasicParameters(json);
    }

    @Test
    public void testConvertJsonToBasicParameters() throws Exception {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("string", "string");
        jsonObject.put("aDouble", 1.0);
        jsonObject.put("aLong", 1L);
        jsonObject.put("integer", 1);
        String json = jsonObject.toString();

        BasicTypesProperties basicProperties = getAdapter().fromJson(json, BasicTypesProperties.class);

        assertThat(basicProperties.string).isEqualTo("string");
        assertThat(basicProperties.aDouble).isEqualTo(1.0);
        assertThat(basicProperties.integer).isEqualTo(1);
        assertThat(basicProperties.aLong).isEqualTo(1L);
    }

    private void verifyBasicParameters(String json) {
        JSONObject jsonObject = new JSONObject(json);
        assertThat(jsonObject.getString("string")).isEqualTo("string");
        assertThat(jsonObject.getDouble("aDouble")).isEqualTo(1.0);
        assertThat(jsonObject.getInt("integer")).isEqualTo(1);
        assertThat(jsonObject.getLong("aLong")).isEqualTo(1L);
    }

    private BasicTypesProperties basicProperties() {
        BasicTypesProperties basicProperties = new BasicTypesProperties();
        basicProperties.aDouble = 1.0;
        basicProperties.aFloat = 1f;
        basicProperties.string = "string";
        basicProperties.aLong = 1L;
        basicProperties.integer = 1;
        return basicProperties;
    }
}
