import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MainTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    void mockList() {
        List mockList = mock(List.class);
        when(mockList.size()).thenReturn(2);
        assertEquals(2, mockList.size());
    }

}
