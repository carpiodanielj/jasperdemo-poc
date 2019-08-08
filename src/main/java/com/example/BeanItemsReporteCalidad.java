package com.example;

import java.io.Serializable;

public class BeanItemsReporteCalidad implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8084649518545361110L;

	private String numItem;
	private String skuCod;
	private String skuDesc;
	private String skuVendor;
	private String uom;
	private String cantOC;
	private String cantRecibida;

	public String getNumItem() {
		return numItem;
	}

	public void setNumItem(String numItem) {
		this.numItem = numItem;
	}

	public String getSkuCod() {
		return skuCod;
	}

	public void setSkuCod(String skuCod) {
		this.skuCod = skuCod;
	}

	public String getSkuDesc() {
		return skuDesc;
	}

	public void setSkuDesc(String skuDesc) {
		this.skuDesc = skuDesc;
	}

	public String getSkuVendor() {
		return skuVendor;
	}

	public void setSkuVendor(String skuVendor) {
		this.skuVendor = skuVendor;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	public String getCantOC() {
		return cantOC;
	}

	public void setCantOC(String cantOC) {
		this.cantOC = cantOC;
	}

	public String getCantRecibida() {
		return cantRecibida;
	}

	public void setCantRecibida(String cantRecibida) {
		this.cantRecibida = cantRecibida;
	}

}
