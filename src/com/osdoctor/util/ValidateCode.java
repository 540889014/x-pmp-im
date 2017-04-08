package com.osdoctor.util;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.patchca.color.GradientColorFactory;
import org.patchca.filter.predefined.CurvesRippleFilterFactory;
import org.patchca.filter.predefined.DiffuseRippleFilterFactory;
import org.patchca.filter.predefined.DoubleRippleFilterFactory;
import org.patchca.filter.predefined.MarbleRippleFilterFactory;
import org.patchca.filter.predefined.RippleFilterFactory;
import org.patchca.filter.predefined.WobbleRippleFilterFactory;
import org.patchca.service.Captcha;
import org.patchca.service.ConfigurableCaptchaService;
import org.patchca.word.RandomWordFactory;

public class ValidateCode extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("image/png");
		ValidateEntry ve = new ValidateEntry();
		
		HttpSession session = request.getSession();
		session.setAttribute(session.getId(), ve.getCode()); 
		
		ServletOutputStream out = response.getOutputStream();
		BufferedImage img = ve.getImage();
		ImageIO.write(img, "png", out);
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}
	
	protected class ValidateEntry{
		String code;
		BufferedImage image;
		
		public ValidateEntry() {
			createEntry();
		}
		
		public String getCode() {
			return code;
		}

		public BufferedImage getImage() {
			return image;
		}
		
		private void createEntry() {
			ConfigurableCaptchaService cs = new ConfigurableCaptchaService();
			cs.setColorFactory(new GradientColorFactory());
			cs.setWordFactory(new MyWordFactory());
			switch ((int) (System.currentTimeMillis() % 6)) {
			case 0:
				cs.setFilterFactory(new CurvesRippleFilterFactory(cs
						.getColorFactory()));
				break;
			case 1:
				cs.setFilterFactory(new MarbleRippleFilterFactory());
				break;
			case 2:
				cs.setFilterFactory(new DoubleRippleFilterFactory());
				break;
			case 3:
				cs.setFilterFactory(new WobbleRippleFilterFactory());
				break;
			case 4:
				cs.setFilterFactory(new DiffuseRippleFilterFactory());
				break;
			case 5:
				cs.setFilterFactory(new RippleFilterFactory());
				break;
			}

			Captcha captcha = cs.getCaptcha();
			code = captcha.getChallenge();
			image = captcha.getImage();
		}
		
	}
	
	protected class MyWordFactory extends RandomWordFactory {
		public MyWordFactory(){
			characters = "0123456789";
			minLength = 4;
			maxLength = 4;
		}
	}

}
