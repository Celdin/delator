package generator;

import generator.npc.NPC;

import java.io.IOException;
import java.util.*;

import com.sun.org.apache.bcel.internal.generic.RETURN;

public class Generator {
	public static String jaccuse() throws IOException {
		Random random = new Random();
		if(random.nextInt(100)!=0) {
			Integer credit = (random.nextInt(20) + 1) * 5;
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
					List<NPC.Race> races = new ArrayList<>();
					races.add(NPC.Race.Human);
					races.add(source.getRace());
					races.add(source.getRace());
					races.add(source.getRace());
					if(NPC.Race.Orc.equals(source.getRace())){
						races.add(NPC.Race.Half_Orc);
					}else if(NPC.Race.Half_Orc.equals(source.getRace())){
						races.add(NPC.Race.Orc);
					}else if(NPC.Race.Elf.equals(source.getRace())){
						races.add(NPC.Race.Half_Elf);
					}else if(NPC.Race.Half_Elf.equals(source.getRace())){
						races.add(NPC.Race.Elf);
					}else if(NPC.Race.Halfling.equals(source.getRace())){
						races.add(NPC.Race.Gnome);
					}else if(NPC.Race.Gnome.equals(source.getRace())){
						races.add(NPC.Race.Halfling);
					}else if(NPC.Race.Human.equals(source.getRace())){
						races.addAll(Arrays.asList(NPC.Race.values()));
					}
					Collections.shuffle(races);
					cible.setRace(races.get(0));
					cible.generate();
					result += target.getName(NPC.Sexe.Female.equals(source.getSexe())) + " " + cible.getNom() + "[" + cible.getRace().getNom() + "] (" + cible.getMetier().getNom() + ")";
					break;
				case CONCURRENCE:
					if(!(NPC.Metier.Esclave.equals(source.getMetier()) || NPC.Metier.Serviteur.equals(source.getMetier()))) {
						cible.setMetier(source.getMetier());
					}
				default:
					cible.generate();
					result += target.getName(NPC.Sexe.Female.equals(source.getSexe())) + " " + cible.getNom() + "[" + cible.getRace().getNom() + "] (" + cible.getMetier().getNom() + ")";
					break;
			}
			result += " " + charge.getName() + '\n';
			result += "à cause " + reason.getTexte() + ".\n";
			result += "Crédibilité : " + credit + '%';
			return result;
		}else{
			switch (random.nextInt(3)) {
			case 0:
				return "Un inconnu accuse Aryanne Lindórie[Elfe] (Inquisitrice) d'avoir trop la classe\nCrédibilité : 110%";
			case 1:
				return "Un inconnu accuse Milo[Humain] (Chef Inquisiteur) de... [*la suite du message est indéchiffrable*]\nCrédibilité : 0%";
			case 2:
				return "Darda'in Drakharthe alias Dédé accuse Aryanne Lindórie[Elfe] (Inquisitrice) et Ka'al En'feyn [Elfe] (Inquisitrice) de l'avoir privé d'un ragout de zombie\nCrédibilité : 80%";
			default:
				return "";
			}
		}
	}
}
