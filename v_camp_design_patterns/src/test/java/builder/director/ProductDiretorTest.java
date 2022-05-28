package builder.director;

import builder.builders.ProductBuilderA;
import builder.model.Product;
import org.junit.Assert;
import org.junit.Test;

public class ProductDiretorTest {
    @Test
    public void constructProductTest(){
        ProductDiretor director = new ProductDiretor(new ProductBuilderA());
        Product product = director.constructProduct();
        Assert.assertNotNull(product);
    }

}