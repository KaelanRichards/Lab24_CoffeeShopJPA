package com.CoffeeShopHibernate.CoffeeShopHibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Products {
	
	// Mark the ID, and designate that it is auto-generated
		@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
		private int id;
		private String name;
		// The @Column annotation can be used to adjust many things about the SQL column
		// associated with a property.
		@Column(length=40)
		private String description;
		private String price;
		
		
		// With Hibernate, you'll generally want to make sure you have a no-arg constructor
		public Products() {
			
		}


		public Products(int id, String name, String description, String price) {
			super();
			this.id = id;
			this.name = name;
			this.description = description;
			
			this.price = price;
		}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}


		


		public String getPrice() {
			return price;
		}


		public void setPrice(String price) {
			this.price = price;
		}


		@Override
		public String toString() {
			return "Products [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + "]";
		}
	
}
