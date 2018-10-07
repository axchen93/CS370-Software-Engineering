package edu.qc.seclass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class MyCustomStringTest {

    private MyCustomStringInterface mycustomstring;

    @Before
    public void setUp() {
        mycustomstring = new MyCustomString();
    }

    @After
    public void tearDown() {
        mycustomstring = null;
    }

    @Test
    public void testCountNumbers1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals(7, mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers2() {
        //literally smashed my keyboard for randomness
        mycustomstring.setString("vjehqip 8g28f oi30t r3r89489y 8fei");
        assertEquals( 6, mycustomstring.countNumbers());
    }

    @Test(expected = NullPointerException.class​)
    public void testCountNumbers3() {
        mycustomstring.countNumbers();
    }

    @Test
    public void testCountNumbers4() {
        mycustomstring.setString("Not yet implemented");
        assertEquals(0, mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers5() {
        mycustomstring.setString("934 34 432 43 434 4fes");
        assertEquals(6, mycustomstring.countNumbers());
    }

    @Test
    public void testCountNumbers6() {
        mycustomstring.setString("fdksa9ff888 ksdakk98fds9");
        assertEquals(4, mycustomstring.countNumbers());
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("d33p md1  i51,it", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd2() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        assertEquals("'bt t0 6snh r6rh", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true));
    }

    @Test(expected = NullPointerException.class​)
    public void testGetEveryNthCharacterFromBeginningOrEnd3() {
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true);
    }

    @Test(expected = IllegalArgumentException.class​)
    public void testGetEveryNthCharacterFromBeginningOrEnd4() {
        mycustomstring.getEveryNthCharacterFromBeginningOrEnd(-1, true);
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd5() {
        mycustomstring.setString("Idontknow");
        assertEquals("okw", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd6() {
        mycustomstring.setString("Idontknow");
        assertEquals("Inn", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd7() {
        mycustomstring.setString("rtrsypohlspifkit");
        assertEquals("shit", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(4, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd8() {
        mycustomstring.setString("rtrsypohlspifkit");
        assertEquals("rylf", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(4, true));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd9() {
        mycustomstring.setString("44If5 g6Nb4eb2ebrdgt g5Ah7 kkJ89odfbgg");
        assertEquals("I Need A Job", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, true));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd10() {
        mycustomstring.setString("44If5 g6Nb4eb2ebrdgt g5Ah7 kkJ89odfbgg");
        assertEquals("I Need A Job", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(3, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd11() {
        mycustomstring.setString("dt8h4Ffghj8odfwr5rcvbnknf56hii1234dt67yhke,l;p0");
        assertEquals("Fornite", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(6, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd12() {
        mycustomstring.setString("dt8h4Ffghj8odfwr5rcvbnknf56hii1234dt67yhke,l;p");
        assertEquals("485kidk", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(6, true));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd13() {
        mycustomstring.setString("djsko Id02 9j fj 9 8sdjsof8ufj098kcdj j80k");
        assertEquals("I suck", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(7, false));
    }

    @Test
    public void testGetEveryNthCharacterFromBeginningOrEnd14() {
        mycustomstring.setString("djsko Id02 9j fj 9 8sdjsof8ufj098kcdj j80k");
        assertEquals("ddfdfd", mycustomstring.getEveryNthCharacterFromBeginningOrEnd(7, true));
    }

    @Test
    public void testConvertDigitsToNamesInSubstring1() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(17, 23);
        assertEquals("I'd b3tt3r put sZerome dOneSix1ts in this 5tr1n6, right?", mycustomstring.getString());
    }

    @Test(expected = IllegalArgumentException.class​)
    public void testConvertDigitsToNamesInSubstring2() {
        mycustomstring.convertDigitsToNamesInSubstring(50, 23);
    }

    @Test(expected = NullPointerException.class​)
    public void testConvertDigitsToNamesInSubstring3() {
        mycustomstring.convertDigitsToNamesInSubstring(17, 23);
    }

    @Test(expected = MyIndexOutOfBoundsException.class​)
    public void testConvertDigitsToNamesInSubstring4() {
        mycustomstring.setString("I'd b3tt3r put s0me d161ts in this 5tr1n6, right?");
        mycustomstring.convertDigitsToNamesInSubstring(-2, 23);
    }

    @Test
    public void testConvertDigitsToNamesInSubstring5() {
        mycustomstring.setString("I have 2 birds");
        mycustomstring.convertDigitsToNamesInSubstring(5, 10);
        assertEquals("I have Two birds", mycustomstring.getString());
    }

    @Test
    public void testConvertDigitsToNamesInSubstring6() {
        mycustomstring.setString("7th Hokage");
        mycustomstring.convertDigitsToNamesInSubstring(1, 3);
        assertEquals("Seventh Hokage", mycustomstring.getString());
    }

    @Test
    public void testConvertDigitsToNamesInSubstring7() {
        mycustomstring.setString("Super Saiyan 3");
        mycustomstring.convertDigitsToNamesInSubstring(10, 14);
        assertEquals("Super Saiyan Three", mycustomstring.getString());
    }

    @Test
    public void testConvertDigitsToNamesInSubstring8() {
        mycustomstring.setString("Java 1 0");
        mycustomstring.convertDigitsToNamesInSubstring(1, 8);
        assertEquals("Java One Zero", mycustomstring.getString());
    }

}
