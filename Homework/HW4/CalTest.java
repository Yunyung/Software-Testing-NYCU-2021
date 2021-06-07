import org.junit.Assert;
import org.junit.Test;


public class CalTest {
    @Test
    public void test1() {
        Assert.assertEquals(62, Cal.cal(1, 2, 3, 4, 2012));
    }

    @Test
    public void test2() {
        Assert.assertEquals(90, Cal.cal(1, 1, 3, 31, 396));
    }

    @Test
    public void test3() {
        Assert.assertEquals(89, Cal.cal(1, 1, 3, 31, 1700));
    }

    @Test
    public void test4() {
        Assert.assertEquals(90, Cal.cal(1, 1, 3, 31, 1600));
    }

    @Test
    public void test5() {
        // same month
        Assert.assertEquals(30, Cal.cal(1, 1, 1, 31, 1600));
    }

    @Test
    public void test6() {
        // kill AOIS_46
        Assert.assertEquals(29, Cal.cal(2, 2, 3, 2, 1600));
    }

    @Test
    public void test7() {
        // zero day
        Assert.assertEquals(0, Cal.cal(1, 1, 1, 1, 1600));
    }

    @Test
    public void test8() {
        Assert.assertEquals(29, Cal.cal(4, 4, 3, 3, 1600));
    }

    @Test
    public void test9() {
        Assert.assertEquals(219, Cal.cal(2, 2, 9, 9, 2021));
    }

    @Test
    public void test10() {
        // kill ROR_8
        Assert.assertEquals(219, Cal.cal(2, 2, 9, 9, -1));
    }

    @Test
    public void test11() {
        // kill ROR_22
        Assert.assertEquals(219, Cal.cal(2, 2, 9, 9, -500));
    }

    @Test
    public void test12() {
        // kill ROR_18
        Assert.assertEquals(219, Cal.cal(2, 2, 9, 9, -4));
    }


}