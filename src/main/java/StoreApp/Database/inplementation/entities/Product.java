package StoreApp.Database.inplementation.entities;

import java.util.Objects;

public class Product {
    private Integer id;
    private String name;
    private Integer total;
    private Integer totalCurrent;
    private Integer price;

    public Product() {
    }

    public Integer getTotalCurrent() {
        return totalCurrent;
    }

    public void setTotalCurrent(Integer totalCurrent) {
        this.totalCurrent = totalCurrent;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) && Objects.equals(name, product.name) && Objects.equals(total, product.total) && Objects.equals(totalCurrent, product.totalCurrent) && Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, total, totalCurrent, price);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", total=" + total +
                ", totalCurrent=" + totalCurrent +
                ", price=" + price +
                '}';
    }
}
