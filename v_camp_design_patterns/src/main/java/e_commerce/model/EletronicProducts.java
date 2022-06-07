package e_commerce.model;

public class EletronicProducts extends Product {

    private String categoryEletronic;
    private String subCategoryEletronic;

    public EletronicProducts(String name, String sku, double price, double weight, String categoryEletronic, String subCategoryEletronic) {
        super(name, sku, price, weight);
        this.categoryEletronic = categoryEletronic;
        this.subCategoryEletronic = subCategoryEletronic;
    }

    public String getCategoryEletronic() {
        return categoryEletronic;
    }

    public void setCategoryEletronic(String categoryEletronic) {
        this.categoryEletronic = categoryEletronic;
    }

    public String getSubCategoryEletronic() {
        return subCategoryEletronic;
    }

    public void setSubCategoryEletronic(String subCategoryEletronic) {
        this.subCategoryEletronic = subCategoryEletronic;
    }


    @Override
    public String toString() {
        return "Product description { name = '" +getName()+"', SKU = '"+getSku()+"', price $ "+getPrice()+", weight "+getWeight()+
                ", category = '" + categoryEletronic + '\'' +
                ", subCategory = '" + subCategoryEletronic + '\'' +
                '}';
    }
}
