package com.example.jingleski.smartlapp;

import org.junit.Assert;
import org.junit.Test;
import com.example.jingleski.midtier.operations.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        Operation add1 = new Addition();
        Assert.assertTrue(add1.process(new int[]{1,2}, 3));
    }

    @Test
    public void addition_isWrong() throws Exception{
        Operation add2 = new Addition();
        Assert.assertFalse(add2.process(new int[]{1,3}, 3));
    }

    @Test
    public void subtraction_isCorrect() throws Exception {
        Operation sub1 = new Subtraction();
        Assert.assertTrue(sub1.process(new int[]{7,5,1}, 1));
    }

    @Test
    public void subtraction_isWrong() throws Exception{
        Operation sub2 = new Subtraction();
        Assert.assertFalse(sub2.process(new int[]{7,5,2},1));
    }

    @Test
    public void SplitTest() throws Exception{
        for(int i=0;i<10;i++) {
            System.out.println(SplitResponder.handleResponse("+"));
        }
    }

}