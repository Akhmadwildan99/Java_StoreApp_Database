package StoreApp.Database.inplementation.entities;

import java.util.Objects;

public class Sell {
    private Integer id;
    private Integer productId;
    private Integer total_sell;

    public Sell() {
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

    public Integer getTotal_sell() {
        return total_sell;
    }

    public void setTotal_sell(Integer total_sell) {
        this.total_sell = total_sell;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sell sell = (Sell) o;
        return Objects.equals(id, sell.id) && Objects.equals(productId, sell.productId) && Objects.equals(total_sell, sell.total_sell);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productId, total_sell);
    }

    @Override
    public String toString() {
        return "Sell{" +
                "id=" + id +
                ", productId=" + productId +
                ", total_sell=" + total_sell +
                '}';
    }
}
