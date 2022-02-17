package testframe.application.premier.pages;

public class Tobedeleted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sValue,temp ;
		int fValue;
		int iValue;
		sValue = "$5,000.00";
		sValue = sValue.replace("$", "");
		sValue = sValue.replace(",", "");
		System.out.println(sValue);
		//fValue = Integer.parseInt(sValue);
		//fValue = Integer.valueOf(sValue);
		fValue = (int) Double.parseDouble(sValue);
		System.out.println(fValue);
		if (fValue>0) {
			System.out.println("True");		
		}else {
			System.out.println("false");
		}
	}



}
