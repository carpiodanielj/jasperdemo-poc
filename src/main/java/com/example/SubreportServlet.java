package com.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		parameters.put("nombreClienteRansa", "GENERIC FRIO RANSA");
		logger.info(parameters);

		try {
			InputStream is = this.getClass().getClassLoader().getResourceAsStream("ReporteCalidad_ES.jrxml");
			
			BeanItemsReporteCalidad itemBean1 = new BeanItemsReporteCalidad();
			itemBean1.setSkuCod("1234567890123");
			itemBean1.setSkuVendor("123456789012");
			BeanItemsReporteCalidad itemBean2 = new BeanItemsReporteCalidad();
			itemBean2.setSkuCod("012345678901");
			itemBean2.setSkuVendor("012345678901");
			BeanReporteCalidad bean = new BeanReporteCalidad();
			bean.setNumOC("OC-999555");
			bean.setItemList(Arrays.asList(itemBean1, itemBean2));

			BeanItemsReporteCalidad itemBean3 = new BeanItemsReporteCalidad();
			itemBean3.setSkuCod("666666666666");
			itemBean3.setSkuVendor("888888888888");
			BeanItemsReporteCalidad itemBean4 = new BeanItemsReporteCalidad();
			itemBean4.setSkuCod("999999999999");
			itemBean4.setSkuVendor("111111111111");
			BeanReporteCalidad bean2 = new BeanReporteCalidad();
			bean2.setNumOC("OC-888666");
			bean2.setItemList(Arrays.asList(itemBean3, itemBean4));
			
			List<BeanReporteCalidad> listaDetalle = new ArrayList<BeanReporteCalidad>();
			listaDetalle.add(bean);
			listaDetalle.add(bean2);
			
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
