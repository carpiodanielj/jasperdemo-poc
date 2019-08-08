package com.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 * Servlet implementation class SubreportServlet
 */
public class SubreportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(SubreportServlet.class);

	private void exportPDF(HttpServletResponse response) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("nombreClienteRansa", "RANSA COMERCIAL S.A.");
		logger.info(parameters);

		try {
			InputStream is = this.getClass().getClassLoader().getResourceAsStream("ReporteCalidad_ES.jrxml");
			
			List<BeanReporteCalidad> listaDetalle = new ArrayList<BeanReporteCalidad>();
			listaDetalle.add(getBean("OC-111222"));
			listaDetalle.add(getBean("OC-333444"));
			listaDetalle.add(getBean("OC-555666"));
			
			JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(listaDetalle);

			// Reading the PDF
//			JasperDesign jd = JRXmlLoader.load(nomArchivo + ".jrxml");
			JasperDesign jd = JRXmlLoader.load(is);
			JasperReport report = JasperCompileManager.compileReport(jd);
			JasperPrint print = JasperFillManager.fillReport(report, parameters, ds);

			// Writing to output
			ServletOutputStream out = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(print, out);

			response.setContentType("application/pdf");
			response.setHeader("Content-disposition", "inline; filename=exported.pdf");
			response.setHeader("Cache-Control", "max-age=30");
			response.setHeader("Pragma", "No-cache");
			response.setDateHeader("Expires", 0);

			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private BeanReporteCalidad getBean(String numOC) {
		List<BeanItemsReporteCalidad> itemList = new ArrayList<BeanItemsReporteCalidad>();
		for (int i = 0; i < 8; i++) {
			BeanItemsReporteCalidad itemBean = new BeanItemsReporteCalidad();
			itemBean.setNumItem("" + (i + 1));
			itemBean.setSkuCod(RandomStringUtils.randomNumeric(15));
			itemBean.setSkuVendor(RandomStringUtils.randomNumeric(12));
			itemList.add(itemBean);
		}
		BeanReporteCalidad bean = new BeanReporteCalidad();
		bean.setNumOC(numOC);
		bean.setItemList(itemList);
		return bean;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		exportPDF(response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
