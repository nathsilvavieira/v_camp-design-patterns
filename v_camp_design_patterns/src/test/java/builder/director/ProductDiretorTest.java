package builder.director;

import builder.builders.ProductBuilderA;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductDiretorTest {
    @Test
    public void constructProductAtest(){
        ProductDiretor  director = new  ProductDiretor(new ProductBuilderA());
        director.constructProductA();
        Assert.assertNotNull(director);
    }




}