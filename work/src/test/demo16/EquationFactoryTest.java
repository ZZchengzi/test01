package test.demo16; 

import demo16.Equation;
import demo16.EquationFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* EquationFactory Tester. 
* 
* @author 202018123钟勇成
* @since <pre>11/21/2022</pre> 
* @version 1.0 
*/ 
public class EquationFactoryTest {
    Equation equation = null;

    @After
    public void after() throws Exception {
        System.out.println(equation);
    }

    /**
    *
    * Method: getEquation(String type)
    *
    */

    @Test
    public void testSub() throws Exception {
        //TODO: Test goes here...
        equation = EquationFactory.getEquation("sub");
        Assert.assertEquals(equation.getOperator(),'-');
    }

    @Test
    public void testAdd() throws Exception {
    //TODO: Test goes here...
        equation = EquationFactory.getEquation("add");
        Assert.assertEquals(equation.getOperator(),'+');
    }


} 
