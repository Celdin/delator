package generator;

import generator.npc.NPC;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Generator {
	public static String jaccuse() throws IOException {
		if(new Random().nextInt(100)!=0) {
			Integer credit = (new Random().nextInt(20) + 1) * 5;
			List<Target> targets = new ArrayList<>();
			for (Target target : Target.values()) {
				for (int i = 0; i < target.getProba(); i++) {
					targets.add(target);
				}
			}
			Collections.shuffle(targets);
			Target target = targets.stream().findAny().get();
			List<Charge> charges = new ArrayList<>();
			for (Charge charge : target.getCharges()) {
				for (int i = 0; i < charge.getProba(); i++) {
					charges.add(charge);
				}
			}
			Collections.shuffle(charges);
			Charge charge = charges.stream().findAny().get();
			List<Reason> reasons = new ArrayList<>();
			for(Reason reason : target.getReasons() ){
				for (int i = 0; i < reason.getProba(); i++) {
					reasons.add(reason);
				}
			}
			Collections.shuffle(reasons);
			Reason reason = reasons.stream().findAny().get();
			NPC source = new NPC();
			NPC cible = new NPC();
			source.generate();
			String result = source.getNom() + "[" + source.getRace().getNom() + "] (" + source.getMetier().getNom() + ")" + " accuse ";
			switch (target) {
				case GROUPE:
				case LIEU:
				case ANIMALE:
				case PHENOMENE:
					result += target.getName(false);
					break;
				case ETRANGER:
					cible.generate();
					result += target.getName(cible.getSexe().equals(NPC.Sexe.Female));
					break;
				case CONJOINT:
					cible.setSexe(source.getSexe().equals(NPC.Sexe.Female)?NPC.Sexe.Male:NPC.Sexe.Female);
					cible.generate();
					result += target.getName(source.getSexe().equals(NPC.Sexe.Female)) + " " + cible.getNom() + "[" + cible.getRace().getNom() + "] (" + cible.getMetier().getNom() + ")";
					break;
				default:
					cible.generate();
					result += target.getName(source.getSexe().equals(NPC.Sexe.Female)) + " " + cible.getNom() + "[" + cible.getRace().getNom() + "] (" + cible.getMetier().getNom() + ")";
					break;
			}
			result += " " + charge.getName() + '\n';
			result += "à cause " + reason.getTexte() + ".\n";
			result += "Credibilité : " + credit + '%';
			return result;
		}else{
			return "Un inconnu accuse Aryanne(Inquisitrice) d'avoir trop la classe\nCredibilité : 110%";
		}
	}
}
