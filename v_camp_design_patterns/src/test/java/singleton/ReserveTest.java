package singleton;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReserveTest {



    @Test
    public boolean isDateExpired(){
        return getExpiredDate().isAfter(getNowDate());
    }

}