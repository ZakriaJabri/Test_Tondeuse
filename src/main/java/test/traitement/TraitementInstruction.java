package test.traitement;

import test.entites.Coordonnees;
import test.entites.Params;
import test.entites.Params.InstructionTondeuse;
import test.entites.Params.Orientation;
import test.entites.PositionTondeuse;
import test.exception.ExceptionTondeuse;

public  class TraitementInstruction {

	private TraitementInstruction(){

	}

	public static Coordonnees avancerTondeuse(PositionTondeuse positionTondeuse, Coordonnees coordonnesMax) throws ExceptionTondeuse{
		Coordonnees coordonneesSuivantes = null;
		int x, y;
		switch (positionTondeuse.getOrientationTondeuse()) {
		case NORTH:
			x = positionTondeuse.getCoordonneesTondeuse().getX();
			y = positionTondeuse.getCoordonneesTondeuse().getY() + 1;
			break;
		case EAST:
			x = positionTondeuse.getCoordonneesTondeuse().getX() + 1;
			y = positionTondeuse.getCoordonneesTondeuse().getY();
			break;
		case SOUTH:
			x = positionTondeuse.getCoordonneesTondeuse().getX();
			y = positionTondeuse.getCoordonneesTondeuse().getY() - 1;
			break;
		case WEST:
			x = positionTondeuse.getCoordonneesTondeuse().getX() - 1;
			y = positionTondeuse.getCoordonneesTondeuse().getY();
			break;
		default:
			throw new ExceptionTondeuse(Params.POSITION_INCORRECTE);
		}
		coordonneesSuivantes = new Coordonnees(x, y);
		if (coordonneesSuivantes != null
				&& coordonnesMax.isHorsCoordonnesMax(coordonneesSuivantes)) {
			return coordonneesSuivantes;
		} else {
			return positionTondeuse.getCoordonneesTondeuse();
		}
	}
	

	
	public static Orientation pivoterDroite(Orientation orientation) throws ExceptionTondeuse{
		Orientation orientationSuivante = null ;
		switch (orientation){
			case NORTH : 
				orientationSuivante =  Orientation.EAST;
				break;
			case EAST : 
				orientationSuivante =  Orientation.SOUTH;
				break;
			case SOUTH : 
				orientationSuivante =  Orientation.WEST;
				break;
			case WEST : 
				orientationSuivante =  Orientation.NORTH;
				break;
			default : 
				throw new ExceptionTondeuse(Params.ORIENTATION_INCORRECTE);
		}
		return orientationSuivante;		
	}
	

	public static Orientation pivoterGauche(Orientation orientation) throws ExceptionTondeuse{
		Orientation orientationSuivante = null ;
		switch (orientation){
			case NORTH : 
				orientationSuivante =  Orientation.WEST; 
				break;
			case EAST : 
				orientationSuivante =  Orientation.NORTH; 
				break;
			case SOUTH : 
				orientationSuivante =  Orientation.EAST; 
				break;
			case WEST : 
				orientationSuivante =  Orientation.SOUTH; 
				break;
			default : 
				throw new ExceptionTondeuse(Params.ORIENTATION_INCORRECTE);
		}
		return orientationSuivante;		
	}


	public static void executerInstruction(PositionTondeuse positionTondeuse, InstructionTondeuse instruction,Coordonnees coordonnesMax) throws ExceptionTondeuse{
		
		switch (instruction){
			case AVANCER : 
				positionTondeuse.setCoordonneesTondeuse(TraitementInstruction.avancerTondeuse(positionTondeuse, coordonnesMax)); 
				break;
			case DROITE : 
				positionTondeuse.setOrientationTondeuse(TraitementInstruction.pivoterDroite(positionTondeuse.getOrientationTondeuse())); 
				break;
			case GAUCHE : 
				positionTondeuse.setOrientationTondeuse(TraitementInstruction.pivoterGauche(positionTondeuse.getOrientationTondeuse())); 
				break;
			default: throw new ExceptionTondeuse(Params.INSTRUCTION_INCORRECTE);
		}
	}
}
