package e_commerce.model;

public class EletronicProducts extends Product {

    private String categoryAuto;
    private String subCategoryAuto;

    public EletronicProducts(String name, String sku, double price, double weight, String categoryAuto, String subCategoryAuto) {
        super(name, sku, price, weight);
        this.categoryAuto = categoryAuto;
        this.subCategoryAuto = subCategoryAuto;
    }

    public String getCategoryAuto() {
        return categoryAuto;
    }

    public void setCategoryAuto(String categoryAuto) {
        this.categoryAuto = categoryAuto;
    }

    public String getSubCategoryAuto() {
        return subCategoryAuto;
    }

    public void setSubCategoryAuto(String subCategoryAuto) {
        this.subCategoryAuto = subCategoryAuto;
    }


    @Override
    public String toString() {
        return "Product description { name = '" +getName()+"', SKU = '"+getSku()+"', price $ "+getPrice()+", weight "+getWeight()+
                ", category = '" + categoryAuto + '\'' +
                ", subCategory = '" + subCategoryAuto + '\'' +
                '}';
    }
}
