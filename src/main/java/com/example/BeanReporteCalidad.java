package com.example;

import java.io.Serializable;
import java.util.List;

public class BeanReporteCalidad implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5684636644206712492L;

	/** ZCSERIE Codigo de Serie */
	private String numOC;
	/** ZNDCOFI Numero de Documento Sunat */
	private String descProveedor;
	/** ZCODPED Documento de ventas */
	private String fechaOC;
	/** ZNUMPOS Posicion documento ventas */
	private String estadoOC;
	/** ZCODPRO Numero de material */
	private Long storageLocation;
	private List<BeanItemsReporteCalidad> itemList;

	public String getNumOC() {
		return numOC;
	}

	public void setNumOC(String numOC) {
		this.numOC = numOC;
	}

	public String getDescProveedor() {
		return descProveedor;
	}

	public void setDescProveedor(String descProveedor) {
		this.descProveedor = descProveedor;
	}

	public String getFechaOC() {
		return fechaOC;
	}

	public void setFechaOC(String fechaOC) {
		this.fechaOC = fechaOC;
	}

	public String getEstadoOC() {
		return estadoOC;
	}

	public void setEstadoOC(String estadoOC) {
		this.estadoOC = estadoOC;
	}

	public Long getStorageLocation() {
		return storageLocation;
	}

	public void setStorageLocation(Long storageLocation) {
		this.storageLocation = storageLocation;
	}

	public List<BeanItemsReporteCalidad> getItemList() {
		return itemList;
	}

	public void setItemList(List<BeanItemsReporteCalidad> itemList) {
		this.itemList = itemList;
	}

}
