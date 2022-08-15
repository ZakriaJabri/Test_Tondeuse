import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import test.entites.Params;
import test.exception.ExceptionTondeuse;
import test.parser.ParserTondeuse;
import test.traitement.FormaterLigne;
import test.traitement.TraitementTondeuse;



public class Principal {

	protected static List<String> listResultats;

	public static void main(String... args) throws ExceptionTondeuse, IOException {
		if (args.length == 1) {
			File file = new File(args[0]);
			Principal instance = new Principal();
			listResultats = instance.lancerTraitementsTondeuses(file);
		} else {
			throw new IllegalArgumentException();
		}
	}

	
	private List<String> lancerTraitementsTondeuses(File fichier)
			throws ExceptionTondeuse, IOException {
		if (!fichier.isFile()) {
			throw new ExceptionTondeuse(Params.ERREUR_FICHIER_INEXISTANT);
		} else {
			ParserTondeuse parser = new ParserTondeuse();
			Scanner scanner = new Scanner(fichier);
			try {
				traiterPremiereLigne(parser, scanner);
				return traiterLignesSuivantes(parser, scanner);
			} finally {
				if (scanner != null) {
					scanner.close();
				}
			}
		}
	}

	
	protected void traiterPremiereLigne(ParserTondeuse parser, Scanner scanner)
			throws ExceptionTondeuse {
		if (scanner.hasNext()) {
			parser.setPelouse(scanner.nextLine());
		}
		if (!scanner.hasNext()) {
			throw new ExceptionTondeuse(
					Params.ERREUR_DONNEES_INCORRECTES);
		}
	}

	
	private List<String> traiterLignesSuivantes(ParserTondeuse parser,
			Scanner scanner) throws ExceptionTondeuse {
		List<String> listePositions = new ArrayList<String>();
		while (scanner.hasNext()) {
			parser.setTondeuse(scanner.nextLine());

			if (scanner.hasNext()) {
				parser.setInstructions(scanner.nextLine());
				listePositions.add(parserEtLancerTraitement(parser));
			} else {
				throw new ExceptionTondeuse(Params.ERREUR_DONNEES_INCORRECTES);
			}
		}
		return listePositions;
	}

	
	private String parserEtLancerTraitement(ParserTondeuse parser)
			throws ExceptionTondeuse {
		if (!parser.executeParse()) {
			throw new ExceptionTondeuse(Params.ERREUR_DONNEES_INCORRECTES);
		} else {
			TraitementTondeuse traitement = new TraitementTondeuse();
			traitement.setPelouse(FormaterLigne
					.formaterLignePelouse(parser.getPelouse()));
			traitement.setPositionTondeuse(FormaterLigne
					.formaterLigneTondeuse(parser.getTondeuse()));
			traitement.setListeInstruction(FormaterLigne
					.formaterLigneInstruction(parser.getInstructions()));
			traitement.executerInstructions();
			System.out.println(traitement);
			return traitement.toString();
		}
	}
}