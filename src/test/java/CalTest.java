import static org.junit.jupiter.api.Assertions.*;

class CalTest {

    @org.junit.jupiter.api.Test
    void sum() {

        int a=10;
        int b=20;
        assertEquals(30, Cal.sum(a,b));
    }
}