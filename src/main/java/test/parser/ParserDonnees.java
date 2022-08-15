package test.parser;

public class ParserDonnees {

	private ParserDonnees(){

	}


	public static boolean parseTondeuse(String tondeuse){
		StringBuilder stringBuilder = new StringBuilder("");
		stringBuilder.append(test.entites.Params.Orientation.NORTH.getCodeOrientation())
			.append("|").append(test.entites.Params.Orientation.SOUTH.getCodeOrientation())
			.append("|").append(test.entites.Params.Orientation.EAST.getCodeOrientation())
			.append("|").append(test.entites.Params.Orientation.WEST.getCodeOrientation());
		return tondeuse.matches("(\\d+) (\\d+) (" + stringBuilder.toString()+")");
	}
	

	public static boolean parseListInstruction(String instructions){
		StringBuilder stringBuilder = new StringBuilder("");
		stringBuilder.append("(").append(test.entites.Params.InstructionTondeuse.AVANCER.getCodeInstruction())
		.append("|").append(test.entites.Params.InstructionTondeuse.DROITE.getCodeInstruction())
		.append("|").append(test.entites.Params.InstructionTondeuse.GAUCHE.getCodeInstruction())
		.append(")+");

		return instructions.matches(stringBuilder.toString());
	}


	public static boolean parsePelouse(String pelouse){
		return pelouse.matches("(\\d+) (\\d+)");
	}
}
