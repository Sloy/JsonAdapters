import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sloydev.jsonadapters.JacksonAdapter;
import com.sloydev.jsonadapters.JsonAdapter;
import org.junit.Before;

public class JacksonAdapterTest extends AbstractAdapterTest {

    private JacksonAdapter jacksonAdapter;

    @Before
    public void setUp() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        jacksonAdapter = new JacksonAdapter(objectMapper);
    }

    @Override
    protected JsonAdapter getAdapter() {
        return jacksonAdapter;
    }

}
