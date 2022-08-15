package test.traitement;

import java.util.ArrayList;
import java.util.List;

import test.entites.Coordonnees;
import test.entites.Params.InstructionTondeuse;
import test.entites.Params.Orientation;
import test.entites.Pelouse;
import test.entites.PositionTondeuse;

public class FormaterLigne {

	private static final String CHAINE_ESPACE = " ";

	private FormaterLigne(){

	}

	
	public static PositionTondeuse formaterLigneTondeuse(String ligneTondeuse){
		String[] elts = ligneTondeuse.split(CHAINE_ESPACE);
		Coordonnees pCoordonneesTondeuse = new Coordonnees(Integer.valueOf(elts[0]), Integer.valueOf(elts[1]));
		Orientation orientationTondeuse = getOrientation(elts[2].charAt(0));
		return new PositionTondeuse(pCoordonneesTondeuse, orientationTondeuse);
	}


	public static Pelouse formaterLignePelouse(String lignePelouse){
		String[] elts = lignePelouse.split(CHAINE_ESPACE);
		return new Pelouse(new Coordonnees(Integer.valueOf(elts[0]), Integer.valueOf(elts[1])));
	}

	
	public static List<InstructionTondeuse> formaterLigneInstruction(String ligneInstruction){
		List<InstructionTondeuse> listInstruction = new ArrayList<InstructionTondeuse>();
		for(char instruction :ligneInstruction.toCharArray()){
			listInstruction.add(getInstruction(instruction));
		}
		return listInstruction;
	}


	public static Orientation getOrientation(char cOrientation){
		for(Orientation orientation : Orientation.values()) {
			if (orientation.getCodeOrientation() == cOrientation){
				return orientation;
			}
		}
		return null;
	}


	public static InstructionTondeuse getInstruction(char cInstruction){
		for(InstructionTondeuse instruction : InstructionTondeuse.values()) {
			if (instruction.getCodeInstruction() == cInstruction) {
				return instruction;
			}
		}
		return null;
	}
}
