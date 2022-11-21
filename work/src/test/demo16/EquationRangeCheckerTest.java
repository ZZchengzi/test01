package test.demo16; 

import demo16.Equation;
import demo16.EquationRangeChecker;
import demo16.SubEquation;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* EquationRangeChecker Tester. 
* 
* @author <Authors name> 
* @since <pre>11/21/2022</pre> 
* @version 1.0 
*/ 
public class EquationRangeCheckerTest { 
    Equation equation = null;
    EquationRangeChecker checker = null;

    @Before
    public void before() throws Exception {
        equation = new SubEquation.SubEquationBuilder().operand((short)10,(short) 10, '-').build();
        checker = new EquationRangeChecker(0,11);
    }

    /**
    *
    * Method: check(Equation equation)
    *
    */
    @Test
    public void testCheck() throws Exception {
    //TODO: Test goes here...
        Assert.assertEquals(checker.check(equation),true);
    }


} 
