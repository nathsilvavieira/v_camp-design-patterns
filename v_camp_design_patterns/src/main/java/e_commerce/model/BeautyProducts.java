package e_commerce.model;

public class BeautyProducts extends Product {

    private String categoryBeauty;
    private String subCategoryBeauty;

    public BeautyProducts(String name, String sku, double price, double weight, String categoryBeauty, String subCategoryBeauty) {
        super(name, sku, price, weight);
        this.categoryBeauty = categoryBeauty;
        this.subCategoryBeauty = subCategoryBeauty;
    }

    public String getCategoryBeauty() {
        return categoryBeauty;
    }

    public void setCategoryBeauty(String categoryBeauty) {
        this.categoryBeauty = categoryBeauty;
    }

    public String getSubCategoryBeauty() {
        return subCategoryBeauty;
    }

    public void setSubCategoryBeauty(String subCategoryBeauty) {
        this.subCategoryBeauty = subCategoryBeauty;
    }


    @Override
    public String toString() {
        return "Product description { name = '" +getName()+"', SKU = '"+getSku()+"', price $ "+getPrice()+", weight "+getWeight()+
                ", category = '" + categoryBeauty + '\'' +
                ", subCategory = '" + subCategoryBeauty + '\'' +
                '}';
    }
}
