package com.crm.action;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VerifyCodeServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建对象
		VerifyCode vc=new VerifyCode();
		//获取图片对象
		BufferedImage img=vc.getImg();
		//获取图片的文本内容
		String text=vc.getText();
		//将系统生成的文本内容保存到session中
		request.getSession().setAttribute("text", text);
		//想浏览器输出图片
		VerifyCode.output(img, response.getOutputStream());
    }

}

class VerifyCode
{
	private int w=70;//宽度
	private int h=35;//高度
	private Random r=new Random();//随机数r
	private String[] fontNames={"宋体", "华文楷体", "黑体", "微软雅黑", "楷体_GB2312"};//字体数组
	private String codes="abcdefghijklmnopqrstuvwxyz0123456789";
	private Color bgColor=new Color(255,255,0);//背景色
	private String text;
	
	//生成随机的颜色
	private Color randomColor()
	{
		int red=r.nextInt(150);
		int green=r.nextInt(150);
		int blue=r.nextInt(150);
		return new Color(red,green,blue);
	}
	
	//生成随机的字体
	private Font randomFont()
	{
		int i=r.nextInt(fontNames.length);
		String fontName=fontNames[i];
		int style=r.nextInt(4);//生成随机的样式, 0(无样式), 1(粗体), 2(斜体), 3(粗体+斜体)
		int size=r.nextInt(5)+24;//随即字号，24-28
		return new Font(fontName, style, size);
	}
	
	//绘制干扰线
	private void drawLine(BufferedImage img)
	{
		int num=3;//干扰线条数
		Graphics2D g2=(Graphics2D)img.getGraphics();
		for(int i=0;i<num;i++)
		{
			int x1 = r.nextInt(w);
            int y1 = r.nextInt(h);
            int x2 = r.nextInt(w);
            int y2 = r.nextInt(h);
            g2.setStroke(new BasicStroke(1.5F)); 
            g2.setColor(Color.BLUE); //干扰线是蓝色
            g2.drawLine(x1, y1, x2, y2);//画线
		}
	}
	
	//随机生成一个字符
	private char randomChar()
	{
		int i=r.nextInt(codes.length());
		return codes.charAt(i);
	}
	
	//创建BufferedImage
	private BufferedImage createImg()
	{
		BufferedImage img=new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2 = (Graphics2D)img.getGraphics(); 
        g2.setColor(this.bgColor);
        g2.fillRect(0, 0, w, h);
		return img;
	}
	
	//调用这个方法得到验证码
	public BufferedImage getImg()
	{
		BufferedImage image = createImg();//创建图片缓冲区 
        Graphics2D g2 = (Graphics2D)image.getGraphics();//得到绘制环境
        StringBuilder sb = new StringBuilder();//用来装载生成的验证码文本
        // 向图片中画4个字符
        for(int i = 0; i < 4; i++)  {//循环四次，每次生成一个字符
            String s = randomChar() + "";//随机生成一个字母 
            sb.append(s); //把字母添加到sb中
            float x = i * 1.0F * w / 4; //设置当前字符的x轴坐标
            g2.setFont(randomFont()); //设置随机字体
            g2.setColor(randomColor()); //设置随机颜色
            g2.drawString(s, x, h-5); //画图
        }
        this.text = sb.toString(); //把生成的字符串赋给了this.text
        drawLine(image); //添加干扰线
        return image;   
	}
	
	//返回验证码图片上的文本
	public String getText ()
	{
        return text;
    }
	
	// 保存图片到指定的输出流
    public static void output (BufferedImage image, OutputStream out) 
                throws IOException {
        ImageIO.write(image, "JPEG", out);
    } 
}