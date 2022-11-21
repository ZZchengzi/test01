package test.demo16; 

import demo16.EquationGenerator;
import demo16.EquationRangeChecker;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* EquationGenerator Tester. 
* 
* @author 202018123钟勇成
* @since <pre>11/21/2022</pre> 
* @version 1.0 
*/ 
public class EquationGeneratorTest
{
    EquationRangeChecker checker = null;
    int n = 0;

    @Before
    public void before() throws Exception {
        checker = new EquationRangeChecker(0,100);
        n = 10;
    }

    @After
    public void after() throws Exception {
        System.out.println(EquationGenerator.equations);
    }

    /**
    *
    * Method: generate(int n, EquationRangeChecker checker)
    *
    */
    @Test
    public void testGenerate() throws Exception {
    //TODO: Test goes here...
        EquationGenerator.generate(n,checker);
        for (var x : EquationGenerator.equations) {
            Assert.assertEquals(checker.check(x),true);
        }

    }

} 
