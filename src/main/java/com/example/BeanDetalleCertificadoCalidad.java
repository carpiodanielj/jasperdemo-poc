package com.example;

import java.io.Serializable;

public class BeanDetalleCertificadoCalidad implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5684636644206712492L;

	/** ZCSERIE Codigo de Serie */
	private String codigoSerie;
	/** ZNDCOFI Numero de Documento Sunat */
	private String numeroDocumentoSunat;
	/** ZCODPED Documento de ventas */
	private String codigoPedido;
	/** ZNUMPOS Posicion documento ventas */
	private String numeroPosicion;
	/** ZCODPRO Numero de material */
	private Long codigoProducto;
	/** ZDESPRO Descripcion */
	private String descripcion;
	/** ZNUMLOT Numero de lote */
	private String numeroLote;
	/** ZCAN Cantidad prevista en unidad de medida de venta */
	private Double cantidad;
	/** ZUND */
	private String unidadMedida;
	/** ZFECPRO */
	private String fehPro;
	/** ZFECVEN */
	private String fecVen;

	public String getCodigoSerie() {
		return codigoSerie;
	}

	public void setCodigoSerie(String codigoSerie) {
		this.codigoSerie = codigoSerie;
	}

	public String getNumeroDocumentoSunat() {
		return numeroDocumentoSunat;
	}

	public void setNumeroDocumentoSunat(String numeroDocumentoSunat) {
		this.numeroDocumentoSunat = numeroDocumentoSunat;
	}

	public String getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido(String codigoPedido) {
		this.codigoPedido = codigoPedido;
	}

	public String getNumeroPosicion() {
		return numeroPosicion;
	}

	public void setNumeroPosicion(String numeroPosicion) {
		this.numeroPosicion = numeroPosicion;
	}

	public Long getCodigoProducto() {
		return codigoProducto;
	}

	public void setCodigoProducto(Long codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNumeroLote() {
		return numeroLote;
	}

	public void setNumeroLote(String numeroLote) {
		this.numeroLote = numeroLote;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	public String getUnidadMedida() {
		return unidadMedida;
	}

	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}

	public String getFehPro() {
		return fehPro;
	}

	public void setFehPro(String fehPro) {
		this.fehPro = fehPro;
	}

	public String getFecVen() {
		return fecVen;
	}

	public void setFecVen(String fecVen) {
		this.fecVen = fecVen;
	}

}
