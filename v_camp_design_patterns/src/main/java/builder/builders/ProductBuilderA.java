package builder.builders;

import builder.model.Product;

public class ProductBuilderA implements IProductBuilder{

    protected Product productA;
    private String categoryBeauty;
    private String subCategorybeauty;


    public ProductBuilderA getProductA() {
       productA = new Product();
       this.categoryBeauty = categoryBeauty;
       this.subCategorybeauty = subCategorybeauty;
       return new ProductBuilderA();


    }

    @Override
    public void buildweight() {

    }

    @Override
    public void buildprice() {

    }

    @Override
    public void buildsku() {

    }

    @Override
    public void buildname() {

    }



    @Override
    public String toString() {
        return "ProductBuilderA{" +
                "productA=" + productA +
                ", categoryBeauty='" + categoryBeauty + '\'' +
                ", subCategorybeauty='" + subCategorybeauty + '\'' +
                '}';
    }
}


