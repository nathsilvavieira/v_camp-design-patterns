package builder.model;

public class ProdutoA extends Product {

    private String categoryBeauty;
    private String subCategorybeauty;

    public ProdutoA(String name) {
        super(name);
        this.categoryBeauty = categoryBeauty;
        this.subCategorybeauty = subCategorybeauty;
    }

    public String getCategoryBeauty() {
        return categoryBeauty;
    }

    public void setCategoryBeauty(String categoryBeauty) {
        this.categoryBeauty = categoryBeauty;
    }

    public String getSubCategorybeauty() {
        return subCategorybeauty;
    }

    public void setSubCategorybeauty(String subCategorybeauty) {
        this.subCategorybeauty = subCategorybeauty;
    }


    @Override
    public String toString() {
        return "ProdutoA{" +getName()+
                ", categoryBeauty='" + categoryBeauty + '\'' +
                ", subCategorybeauty='" + subCategorybeauty + '\'' +
                '}';
    }
}
