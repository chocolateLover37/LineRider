public class ReturnCollision {

	// ATTRIBUTS
	public Ligne lignecoli;
	public boolean bolcoli;
	
	public ReturnCollision (Ligne l, boolean b){
		lignecoli = l;
		bolcoli = b;
	}
	//GETTER & SETTERS
	public Ligne getLigne() {
		return lignecoli;
	}
	public void setLigne(Ligne value) {
		this.lignecoli = value;
	}
	public boolean getBol() {
		return bolcoli;
	}
	public void setBol(boolean index) {
		this.bolcoli = index;
	}
}
