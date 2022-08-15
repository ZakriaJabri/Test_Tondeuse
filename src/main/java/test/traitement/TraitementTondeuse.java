package test.traitement;

import java.util.ArrayList;
import java.util.List;

import test.entites.Params;
import test.entites.Params.InstructionTondeuse;
import test.entites.Pelouse;
import test.entites.PositionTondeuse;
import test.exception.ExceptionTondeuse;


public class TraitementTondeuse {

	private Pelouse pelouse;
	private PositionTondeuse positionTondeuse;
	private List<Params.InstructionTondeuse> listeInstruction;
	
	public void setPelouse(Pelouse pelouse) {
		this.pelouse = pelouse;
	}
	
	public void setPositionTondeuse(PositionTondeuse positionTondeuse) {
		this.positionTondeuse = positionTondeuse;
	}

	public void setListeInstruction(
			List<Params.InstructionTondeuse> pListeInstruction) {
		this.listeInstruction = pListeInstruction;
		if(pListeInstruction == null){
			listeInstruction = new ArrayList<InstructionTondeuse>();
		}
	}

	public void executerInstructions() throws ExceptionTondeuse{
		for(InstructionTondeuse instruction : listeInstruction){
			TraitementInstruction.executerInstruction(positionTondeuse,
					instruction, this.pelouse.getPositionMax());
		}
	}

	public String toString(){
		return 	positionTondeuse.getCoordonneesTondeuse().getX() 
				+ " " 
				+ positionTondeuse.getCoordonneesTondeuse().getY()
				+ " " 
				+ positionTondeuse.getOrientationTondeuse().getCodeOrientation() ;
	}
}
