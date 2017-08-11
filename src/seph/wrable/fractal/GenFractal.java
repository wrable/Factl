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
		StringBuilder bS = new StringBuilder();
		if (getbuildervalue() == null) {
			setbuildervalue(this.aksjomat);
			bS.append(getbuildervalue());
		}
		bS.setLength(0); // ZEROWANIE STRING BUILDERA 
		for (char ch : this.buildervalue.toCharArray()) {
			if (ch == 'F') {
				//bUildNewString += getRegula();
				bS.append(getRegula());
			} else {
				//bUildNewString += ch;
				bS.append(ch);
			}
		}
		bUildNewString = bS.toString();
		setbuildervalue(bUildNewString);
		bS.setLength(0);
		return bUildNewString;
	}

	// aksjomat: F+F+F
	// regu³a: F: F+F-F-F+F
	// k¹t: 120 stopni
	// F+F+F
	// F+F-F-F+F+F+F-F-F+F+F+F-F-F+F

	public static void main(String[] args) {
		GenFractal fractal = new GenFractal("F+F+F", "F+F-F-F+F");
		System.out.println(fractal.getAksjomat());
		System.out.println(fractal.FGenFractal());
		//System.out.println(fractal.FGenFractal());
		//System.out.println(fractal.FGenFractal());
		//System.out.println(fractal.FGenFractal());
		// System.out.println(fractal.FGenFractal());
		// System.out.println(fractal.FGenFractal());
	}

}
