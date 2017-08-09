package seph.wrable.fractal;

public class GenFractal {
	private String aksjomat, regula, buildervalue;

	public GenFractal(String aksjomat, String regula) {
		super();
		this.aksjomat = aksjomat;
		this.regula = regula;
		this.buildervalue = null;
	}

	public GenFractal() {
		this(null, null);
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

	public String getbuildervalue() {
		return buildervalue;
	}

	public void setbuildervalue(String value) {
		this.buildervalue = value;
	}

	public String FGenFractal() {
		String bUildNewString = new String();
		if (getbuildervalue() == null) {
			setbuildervalue(this.aksjomat);
		}
		for (char ch : this.buildervalue.toCharArray()) {
			if (ch == 'F') {
				bUildNewString += getRegula();
			} else {
				bUildNewString += ch;
			}
		}
		setbuildervalue(bUildNewString);
		return bUildNewString;
	}

	// aksjomat: F+F+F
	// regu³a: F: F+F-F-F+F
	// k¹t: 120 stopni

	 public static void main(String[] args) {
	 GenFractal fractal = new GenFractal("F+F+F", "F+F+F+F+F+F+F");
	 System.out.println(fractal.getAksjomat());
	 System.out.println(fractal.FGenFractal());
	 System.out.println(fractal.FGenFractal());
	 System.out.println(fractal.FGenFractal());
	 }

}
