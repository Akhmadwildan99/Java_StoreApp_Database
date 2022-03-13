package StoreApp.Database.inplementation.entities;

import java.util.Objects;

public class ProductExist {
    private Integer id;
    private Integer productId;
    private Integer productExist;

    public ProductExist() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductExist() {
        return productExist;
    }

    public void setProductExist(Integer productExist) {
        this.productExist = productExist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductExist that = (ProductExist) o;
        return Objects.equals(id, that.id) && Objects.equals(productId, that.productId) && Objects.equals(productExist, that.productExist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productId, productExist);
    }

    @Override
    public String toString() {
        return "UpdateTotal{" +
                "id=" + id +
                ", productId=" + productId +
                ", TotalUpdate=" + productExist +
                '}';
    }
}
