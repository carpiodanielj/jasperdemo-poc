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
 * Servlet implementation class ExportServlet
 */
public class ExportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ExportServlet.class);

	private void exportPDF(HttpServletResponse response) {
//		String nomArchivo = "D:\\Users\\dcarpioc\\AppData\\Local\\Temp\\20190806_inbalnor\\CertificadoCalidad_ES";

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("TITULO", "PAISES");
		parameters.put("FECHA", new java.util.Date());
		parameters.put("logo1", "" /* imgLogo */);
		parameters.put("firma", "" /* imgFirma */);
		logger.info("parameters...");

		try {
			InputStream is = this.getClass().getClassLoader().getResourceAsStream("CertificadoCalidad_ES.jrxml");
			
			BeanDetalleCertificadoCalidad bean = new BeanDetalleCertificadoCalidad();
			bean.setCantidad(1.0d);
			List<BeanDetalleCertificadoCalidad> listaDetalle = new ArrayList<BeanDetalleCertificadoCalidad>();
			listaDetalle.add(bean);
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		exportPDF(response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
