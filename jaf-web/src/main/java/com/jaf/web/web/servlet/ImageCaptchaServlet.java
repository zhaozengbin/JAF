/**
 * 项目名：jaf-web <br>
 * 包名：com.jaf.web.web.servlet <br>
 * 文件名：ImageCaptchaServlet.java <br>
 * 版本信息：TODO <br>
 * 作者：赵增斌 E-mail：zhaozengbin@gmail.com QQ:4415599 weibo:http://weibo.com/zhaozengbin<br>
 * 日期：2013-11-5-下午5:24:49<br>
 * Copyright (c) 2013 赵增斌-版权所有<br>
 *
 */
package com.jaf.web.web.servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jaf.web.ingleton.CaptchaServiceSingleton;
import com.octo.captcha.service.CaptchaServiceException;

/**
 * 
 * 类名称：ImageCaptchaServlet <br>
 * 类描述：TODO <br>
 * 创建人：赵增斌 <br>
 * 修改人：赵增斌 <br>
 * 修改时间：2013-11-5 下午5:24:49 <br>
 * 修改备注：TODO <br>
 * 
 */
public class ImageCaptchaServlet extends HttpServlet {

	/**  */
	private static final long serialVersionUID = 1L;

	/**
	 * 方法：init <br>
	 * 描述：TODO <br>
	 * 
	 * @param servletConfig
	 * @throws ServletException
	 * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
	 */
	public void init(ServletConfig servletConfig) throws ServletException {
		super.init(servletConfig);
	}

	/**
	 * 方法：doGet <br>
	 * 描述：TODO <br>
	 * 
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @throws ServletException
	 * @throws IOException
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws ServletException,
			IOException {
		genernateCaptchaImage(httpServletRequest, httpServletResponse);
		// System.out.println("DO GET....");
		// byte[] captchaChallengeAsJpeg = null;
		// // the output stream to render the captcha image as jpeg into
		// ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
		// try {
		// // get the session id that will identify the generated captcha.
		// // the same id must be used to validate the response, the session id
		// // is a good candidate!
		// String captchaId = httpServletRequest.getSession().getId();
		// // call the ImageCaptchaService getChallenge method
		// BufferedImage challenge = CaptchaServiceSingleton.getInstance()
		// .getImageChallengeForID(captchaId,
		// httpServletRequest.getLocale());
		//
		// // a jpeg encoder
		// JPEGImageEncoder jpegEncoder = JPEGCodec
		// .createJPEGEncoder(jpegOutputStream);
		// jpegEncoder.encode(challenge);
		// } catch (IllegalArgumentException e) {
		// httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
		// return;
		// } catch (CaptchaServiceException e) {
		// httpServletResponse
		// .sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		// return;
		// }
		// captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
		// // flush it in the response
		// httpServletResponse.setHeader("Cache-Control", "no-store");
		// httpServletResponse.setHeader("Pragma", "no-cache");
		// httpServletResponse.setDateHeader("Expires", 0);
		// httpServletResponse.setContentType("image/jpeg");
		// ServletOutputStream responseOutputStream = httpServletResponse
		// .getOutputStream();
		// responseOutputStream.write(captchaChallengeAsJpeg);
		//
		// responseOutputStream.flush();
		// responseOutputStream.close();
	}

	/**
	 * 方法：genernateCaptchaImage <br>
	 * 描述：生成验证码图片. <br>
	 * 作者：赵增斌 E-mail:zhaozengbin@gmail.com QQ:4415599
	 * weibo:http://weibo.com/zhaozengbin <br>
	 * 日期： 2013-11-5 下午5:27:01 <br>
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void genernateCaptchaImage(final HttpServletRequest request,
			final HttpServletResponse response) throws IOException {
		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");
		ServletOutputStream out = response.getOutputStream();
		try {
			String captchaId = request.getSession(true).getId();
			BufferedImage challenge = (BufferedImage) CaptchaServiceSingleton
					.getInstance().getChallengeForID(captchaId,
							request.getLocale());
			ImageIO.write(challenge, "jpg", out);
			out.flush();
		} catch (CaptchaServiceException e) {
		} finally {
			out.close();
		}
	}
}
