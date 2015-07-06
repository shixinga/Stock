package test;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import com.ui.StockSift;

public class stockSifttest {
	String[][] stockdata;
	int total,stotal;
	StockSift stocksift=new StockSift();
    int[] num;
    double[] max,min;
    Vector<Double> MaxMin;
	@Before
	public void Beforetest() {
	   stockdata =new String[][]{{"600556.SH","\u6167\u7403\u79d1\u6280","5.045","25.4", "2032.0494740903", "--","--"},
				{"000025.SZ","\u7279\u529bA","5.296","19.88","1874.9435079651","454.61216984615","454.61216984615"},
				{"000697.SZ", "\u70bc\u77f3\u6709\u8272" ,"5.443" ,"37.19", "1331.9164658834", "247.93333436698","454.61216984615"},
				{"002044.SZ", "\u6c5f\u82cf\u4e09\u53cb","5.061","55.63" ,"1038.4996140286","86.025031677484","454.61216984615"},
				{"600433.SH", "\u51a0\u8c6a\u9ad8\u65b0", "5.118", "18.69", "559.03003158299", "145.54290504742","454.61216984615"},
				{"300399.SZ", "\u4eac\u5929\u5229", "5.075","300.0","552.29684919535", "474.30830039526","474.30830039526"},
				{"600094.SH", "\u5927\u540d\u57ce", "5.274","19.96","459.11422134825","64.395632016552","474.30830039526"},
				{"600654.SH","\u4e2d\u5b89\u6d88", "5.328", "22.93", "428.6409733926", "--","474.30830039526"}
	   };
	   total=stockdata.length;
	   num =new int[6];
	   max=new double[6];
	   min=new double[6];
	   num[0] = 0;
		max[0] = 5.4;
		min[0] = 5.1;
		stotal = 1;
	   
	   
	}
	
	@Test
	public void findMAxMinTest()
	{
		MaxMin = stocksift.findMinmax(stockdata, total);
		double d =5.045;
		if(d == MaxMin.get(1)) System.out.println(true);
	}

}
