package test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import com.ui.Select;

public class SelectTest {

	String[][] data ={
			{"600556.SH","A", "5.045", "25.4",  "10.2",  "--",  "--"},
			{"000025.SZ","B", "5.296", "19.88", "10.5",  "8.5", "10.5"},
			{"000697.SZ","C", "5.443", "37.19", "15.5",  "5.8", "10.5"},
			{"002044.SZ","D", "5.061", "55.63", "20.75", "5.58","20.5"},
			{"600433.SH","E", "5.118", "18.69", "25.5",  "25.8","2.5"},
			{"300399.SZ","F", "5.075", "300.0", "50.5",  "25.8","1"},
			{"600094.SH","G", "5.274", "19.96", "40.5",  "30.5","2.5"},
			{"600654.SH","H", "5.328", "22.93", "41.2",   "--", "25.05"}};
	@Test
	public void fluctuation_test() {

		String[] command = new String[]{"5.0","5.1","","","","","","","",""};
		Select s = new Select();
		String[][] result=s.MySort(command, data);	
		String[][] expected = {
				{"300399.SZ", "F", "5.075","300.0","50.5", "25.8","1"},
				{"002044.SZ", "D","5.061","55.63" ,"20.75","5.58","20.5"},
				{"600556.SH","A","5.045","25.4", "10.2", "--","--"}};
		Assert.assertArrayEquals(expected[0], result[0]);
		Assert.assertArrayEquals(expected[1], result[1]);
		Assert.assertArrayEquals(expected[2], result[2]);
	}
	
	@Test
	public void price_test() {
		String[] command = new String[]{"","","19","23","","","","","",""};
		Select s = new Select();
		String[][] result=s.MySort(command, data);	
		String[][] expected = {
				{"600654.SH","H", "5.328", "22.93", "41.2",   "--", "25.05"},
				{"000025.SZ","B", "5.296", "19.88", "10.5",  "8.5", "10.5"},
				{"600094.SH", "G", "5.274","19.96","40.5","30.5","2.5"}};
		Assert.assertArrayEquals(expected[0], result[0]);
		Assert.assertArrayEquals(expected[1], result[1]);
		Assert.assertArrayEquals(expected[2], result[2]);
	}
	
	@Test
	public void pe_test() {
		String[] command = new String[]{"","","","","40","50","","","",""};
		Select s = new Select();
		String[][] result=s.MySort(command, data);	
		String[][] expected = {
				{"600654.SH","H", "5.328", "22.93", "41.2",   "--", "25.05"},
				{"600094.SH","G", "5.274", "19.96", "40.5",  "30.5","2.5"}};
		Assert.assertArrayEquals(expected[0], result[0]);
		Assert.assertArrayEquals(expected[1], result[1]);
	}

	@Test
	public void predictedpe_test() {
		String[] command = new String[]{"","","","","","","5.0","6.0","",""};
		Select s = new Select();
		String[][] result=s.MySort(command, data);	
		String[][] expected = {
				{"000697.SZ","C", "5.443", "37.19", "15.5",  "5.8", "10.5"},
				{"002044.SZ","D", "5.061", "55.63", "20.75", "5.58","20.5"}};
		Assert.assertArrayEquals(expected[0], result[0]);
		Assert.assertArrayEquals(expected[1], result[1]);
	}
	
	
	@Test
	public void pb_test() {
		String[] command = new String[]{"","","","","","","","","20","30"};
		Select s = new Select();
		String[][] result=s.MySort(command, data);	
		String[][] expected = {
				{"600654.SH","H", "5.328", "22.93", "41.2",   "--", "25.05"},
				{"002044.SZ","D", "5.061", "55.63", "20.75", "5.58","20.5"}};
		Assert.assertArrayEquals(expected[0], result[0]);
		Assert.assertArrayEquals(expected[1], result[1]);
	}
	
	@Test
	public void pb2_test() {
		String[] command = new String[]{"","","","","","","","","","10"};
		Select s = new Select();
		String[][] result=s.MySort(command, data);	
		String[][] expected = {
				{"600094.SH","G", "5.274", "19.96", "40.5",  "30.5","2.5"},
				{"600433.SH","E", "5.118", "18.69", "25.5",  "25.8","2.5"},
				{"300399.SZ","F", "5.075", "300.0", "50.5",  "25.8","1"}};
		Assert.assertArrayEquals(expected[0], result[0]);
		Assert.assertArrayEquals(expected[1], result[1]);
		Assert.assertArrayEquals(expected[2], result[2]);
	}
	
	@Test
	public void All_test() {
		String[] command = new String[]{"5.118","5.2","18.69","19.5","25.5","30","2.58","25.8","2.5","10"};
		Select s = new Select();
		String[][] result=s.MySort(command, data);	
		String[][] expected = {
				{"600433.SH","E", "5.118", "18.69", "25.5",  "25.8","2.5"}};
		Assert.assertArrayEquals(expected[0], result[0]);
	}
}