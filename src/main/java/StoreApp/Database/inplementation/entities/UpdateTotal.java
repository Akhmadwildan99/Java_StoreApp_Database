package StoreApp.Database.inplementation.entities;

import java.util.Objects;

public class UpdateTotal {
    private Integer id;
    private Integer productId;
    private Integer totalUpdate;

    public UpdateTotal() {
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

    public Integer getTotalUpdate() {
        return totalUpdate;
    }

    public void setTotalUpdate(Integer totalUpdate) {
        this.totalUpdate = totalUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UpdateTotal that = (UpdateTotal) o;
        return Objects.equals(id, that.id) && Objects.equals(productId, that.productId) && Objects.equals(totalUpdate, that.totalUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productId, totalUpdate);
    }

    @Override
    public String toString() {
        return "UpdateTotal{" +
                "id=" + id +
                ", productId=" + productId +
                ", TotalUpdate=" + totalUpdate +
                '}';
    }
}
