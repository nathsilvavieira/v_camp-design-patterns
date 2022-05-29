package builder.model;

public class ProductB extends Product{

    private String categoryFood;
    private String subCategoryFood;

    public ProductB(String name, String sku, double price, double weight, String categoryFood, String subCategoryFood) {
        super(name, sku, price, weight);
        this.categoryFood = categoryFood;
        this.subCategoryFood = subCategoryFood;
    }

    public String getCategoryFood() {
        return categoryFood;
    }

    public void setCategoryFood(String categoryFood) {
        this.categoryFood = categoryFood;
    }

    public String getSubCategoryFood() {
        return subCategoryFood;
    }

    public void setSubCategoryFood(String subCategoryFood) {
        this.subCategoryFood = subCategoryFood;
    }


    @Override
    public String toString() {
        return "Product description { name = '" +getName()+"', SKU = '"+getSku()+"', price $ "+getPrice()+", weight "+getWeight()+
                ", category = '" + categoryFood + '\'' +
                ", subCategory = '" + subCategoryFood + '\'' +
                '}';
    }
}
