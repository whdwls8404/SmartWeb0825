package com.koreait.ex04.domain;

public class Product {
	
	// field
	private String modelName;
	private int price;
	
	// getter
	public String getModelName() {
		return modelName;
	}
	public int getPrice() {
		return price;
	}
	
	// constructor
	private Product(Builder builder) {
		this.modelName = builder.modelName;
		this.price = builder.price;
	}
	
	// Builder 내부클래스
	public static class Builder {
		
		// field
		private String modelName;
		private int price;
		
		// constructor
		public Builder() {
			
		}
		
		// setter
		public Builder setModelName(String modelName) {
			this.modelName = modelName;
			return this;
		}
		public Builder setPrice(int price) {
			this.price = price;
			return this;
		}
		
		// build() : Product를 반환함
		public Product build() {
			return new Product(this);
		}
		
	}

}
