package test.parser;

public class ParserTondeuse {

	private String pelouse ;
	private String tondeuse ;
	private String instructions ;

	public ParserTondeuse(){
		this.pelouse = "";
		this.tondeuse = "";
		this.instructions = "";
	}
	
	
	public boolean executeParse(){
		return ParserDonnees.parseTondeuse(tondeuse)
				&& ParserDonnees.parsePelouse(pelouse)
				&& ParserDonnees.parseListInstruction(instructions);
	}
	
	public String getPelouse() {
		return pelouse;
	}

	public void setPelouse(String pelouse) {
		this.pelouse = pelouse;
	}

	public String getTondeuse() {
		return tondeuse;
	}

	public void setTondeuse(String tondeuse) {
		this.tondeuse = tondeuse;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
}
