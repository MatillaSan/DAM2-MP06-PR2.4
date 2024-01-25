
package com.project;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name = "Item")
public class Item implements Serializable {

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO) // L'id es genera automàticament
	private long itemId;

	@Column(name = "name")
	private String name;

	@ManyToOne
    @JoinColumn(name = "cartId", insertable = false, updatable = false)
    private Cart cart;

	public Item() { }

	public Item(String name) {
		this.name = name;
	}

	public long getItemId() {
		return this.itemId;
	}

	public void setItemId(long id) {
		this.itemId = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCart (Cart cart) {
		this.cart = cart;
	}

	public Cart getCart () {
		return this.cart;
	}

	@Override
    public String toString () {
      	return this.getItemId() + ": " + this.getName();
    }
}