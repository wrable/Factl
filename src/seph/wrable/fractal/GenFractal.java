package seph.wrable.fractal;
public class GenFractal {
	private String aksjomat,regula,value;

	public GenFractal(String aksjomat, String regula) {
		super();
		this.aksjomat = aksjomat;
		this.regula = regula;
		this.value = aksjomat;
	}

	public String getAksjomat() {
		return aksjomat;
	}

	public void setAksjomat(String aksjomat) {
		this.aksjomat = aksjomat;
	}

	public String getRegula() {
		return regula;
	}

	public void setRegula(String regula) {
		this.regula = regula;
	}	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String FGenFractal() {
		String bUildNewString = new String();
		for (char ch : this.value.toCharArray())
		{
			if (ch == 'F')
			{
				bUildNewString+=getRegula();
			}
			else 
			{
				bUildNewString+=ch;
			}
		}
		setValue(bUildNewString);
		return bUildNewString;
	}

//	aksjomat: F+F+F
//	regu³a: F: F+F-F-F+F
//	k¹t: 120 stopni	
	
	public static void main(String[] args) {
		GenFractal fractal = new GenFractal("F+F+F", "F+F-F-F+F");
		System.out.println(fractal.getAksjomat());
		System.out.println(fractal.FGenFractal());
		System.out.println(fractal.FGenFractal());
		System.out.println(fractal.FGenFractal());
	}
	
}
