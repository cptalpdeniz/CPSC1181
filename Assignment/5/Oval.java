/**
* Assignment 5
* @author Alp Deniz Senyurt
* Student ID: 100342433
* Self explanatory variables and parameters will not be documented as they are, "self-explanatory".
*/
class Oval extends GeometricShape
{
	private int hR;
	private int vR;
	public Oval(int x, int y, int hR, int vR)
	{
		super(x,y);
		this.hR=hR;
		this.vR=vR;
	}
	final public int gethR()
	{
		return hR;
	}
	final public int getvR()
	{
		return vR;
	}
	final public void sethR(int hR)
	{
		this.hR = hR;
	}
	final public void setvR(int vR)
	{
		this.vR = vR;
	}
	public double getArea()
	{
		return Math.round(Math.PI*hR*vR);
	}
	public String toString()
	{
		return "Oval: [x:"+getX()+", y:"+getY()+", h_radius:"+hR+", v_radius:"+vR+", area:"+getArea()+"]";
	}
	public int getRadius()
	{
		return hR;
	}

}