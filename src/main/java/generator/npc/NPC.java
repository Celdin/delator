package generator.npc;

import generator.client.Donjon;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class NPC {

	public enum Race {
		Human("Human", "Humain"),
		Dwarf("Dwarf", "Nain"),
		Elf("Elf", "Elfe"),
		Half_Elf("Half-elf", "Demi-elfe"),
		Orc("Orc", "Orc"),
		Half_Orc("Half-orc", "Demi-orc"),
		Halfling("Halfling", "Hobbit"),
		Gnome("Gnome", "Gnome");

		private String name;
		private String nom;

		Race(String name, String nom) {
			this.name = name;
			this.nom = nom;
		}

		public String getName() {
			return name;
		}

		public String getNom() {
			return nom;
		}
	}

	public enum Classe {
		Barbare,
		Barde,
		Prêtre,
		Paladin,
		Rôdeur,
		Roublard,
		Ensorceleur,
		Magicien;
	}

	public enum Metier {
		Esclave("Esclave"),
		Mendiant("Mendiant"),
		Paysan("Paysan"),
		Serviteur("Serviteur"),
		Apprenti("Apprenti"),
		Commercant("Commerçant"),
		Artisant("Artisant"),
		Petit_Proprietaire("petit propriétaire terrien"),
		Bourgmestre("Bourgmestre"),
		Gros_Commercant("gros commerçant"),
		Gros_Proprietaire("grand propriétaire terrien"),
		Pretre("Prêtre"),
		Chevalier("Chevalier"),
		Eveque("Évéque"),
		Banneret("Banneret"),
		Baron("Baron"),
		Compte("Compte");


		private String nom;

		Metier(String nom) {
			this.nom = nom;
		}

		public String getNom() {
			return nom;
		}
	}

	public enum Sexe {Male, Female}

	private String nom;
	private Sexe sexe;
	private Race race;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Sexe getSexe() {
		return sexe;
	}

	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public Metier getMetier() {
		return metier;
	}

	public void setMetier(Metier metier) {
		this.metier = metier;
	}

	private Classe classe;
	private Metier metier;

	private Random random;

	public NPC() {
		random = new Random();
	}

	public void generate() throws IOException {
		if (metier == null) {
			addMetier();
		}
		if (race == null) {
			addRace();
		}
		if (sexe == null) {
			sexe = random.nextBoolean() ? Sexe.Male : Sexe.Female;
		}
		if (nom == null) {
			addNom();
		}
	}

	private void addNom() throws IOException {
		if (random.nextInt(20) == 0) {
			nom = Donjon.getName(race.getName(), sexe);
		} else {
			if (race.equals(Race.Orc) || Classe.Barbare.equals(classe) || (race.equals(Race.Half_Orc) && random.nextBoolean())) {
				nom = Donjon.getName(Donjon.Type.Slavic.name(), sexe);
			} else if (race.equals(Race.Dwarf)) {
				nom = Donjon.getName(Donjon.Type.Japanese.name(), sexe);
			} else {
				if (random.nextInt(10) == 0) {
					Integer index = Arrays.asList(Metier.values()).indexOf(metier);
					Integer probaIta = ((Metier.values().length - index) + 3) * 3;
					Integer probaFra = (index + 3) * 3;
					Integer probaGer = 100 - probaIta - probaFra;
					Integer rng = random.nextInt(100);
					if (rng < probaIta) {
						nom = Donjon.getName(Donjon.Type.Italian.name(), sexe);
					} else if (rng < probaIta + probaGer) {
						nom = Donjon.getName(Donjon.Type.German.name(), sexe);
					} else {
						nom = Donjon.getName(Donjon.Type.French.name(), sexe);
					}
				} else {
					nom = Donjon.getName(Donjon.Type.English.name(), sexe);
				}
			}
		}
		if(nom == null || nom.isEmpty()){
			addNom();
		}
	}

	private void addRace() {
		Integer rng = random.nextInt(100);
		switch (metier) {
			case Esclave:
			case Pretre:
				if (rng < 19) {
					race = Race.Orc;
				} else if (rng < 38) {
					race = Race.Human;
				} else if (rng < 57) {
					race = Race.Elf;
				} else if (rng < 76) {
					race = Race.Halfling;
				} else if (rng < 95) {
					race = Race.Gnome;
				} else if (rng < 97) {
					race = Race.Half_Elf;
				} else if (rng < 99) {
					race = Race.Half_Orc;
				} else {
					race = Race.Dwarf;
				}
				break;
			case Mendiant:
			case Paysan:
			case Serviteur:
				if (rng < 25) {
					race = Race.Orc;
				} else if (rng < 70) {
					race = Race.Human;
				} else if (rng < 80) {
					race = Race.Halfling;
				} else if (rng < 90) {
					race = Race.Gnome;
				} else if (rng < 95) {
					race = Race.Elf;
				} else if (rng < 97) {
					race = Race.Half_Elf;
				} else if (rng < 99) {
					race = Race.Half_Orc;
				} else {
					race = Race.Dwarf;
				}
				break;
			case Commercant:
			case Artisant:
			case Petit_Proprietaire:
			case Apprenti:
				if (rng < 5) {
					race = Race.Orc;
				} else if (rng < 60) {
					race = Race.Human;
				} else if (rng < 75) {
					race = Race.Halfling;
				} else if (rng < 90) {
					race = Race.Gnome;
				} else if (rng < 95) {
					race = Race.Elf;
				} else if (rng < 97) {
					race = Race.Half_Elf;
				} else if (rng < 99) {
					race = Race.Half_Orc;
				} else {
					race = Race.Dwarf;
				}
				break;
			case Bourgmestre:
			case Gros_Commercant:
			case Gros_Proprietaire:
				if (rng < 1) {
					race = Race.Orc;
				} else if (rng < 40) {
					race = Race.Human;
				} else if (rng < 55) {
					race = Race.Halfling;
				} else if (rng < 70) {
					race = Race.Gnome;
				} else if (rng < 99) {
					race = Race.Elf;
				} else {
					Integer rng2 = random.nextInt(3);
					if (rng2 == 0) {
						race = Race.Half_Orc;
					} else if (rng2 == 1) {
						race = Race.Half_Elf;
					} else if (rng2 == 2) {
						race = Race.Dwarf;
					}
				}
				break;
			case Eveque:
				if (rng < 45) {
					race = Race.Human;
				} else if (rng < 95) {
					race = Race.Elf;
				} else {
					Integer rng2 = random.nextInt(6);
					if (rng2 == 0) {
						race = Race.Orc;
					} else if (rng2 == 1) {
						race = Race.Halfling;
					} else if (rng2 == 2) {
						race = Race.Gnome;
					} else if (rng2 == 3) {
						race = Race.Half_Elf;
					} else if (rng2 == 4) {
						race = Race.Half_Orc;
					} else if (rng2 == 5) {
						race = Race.Dwarf;
					}
				}
				break;
			case Chevalier:
			case Banneret:
				if (rng < 5) {
					race = Race.Orc;
				} else if (rng < 60) {
					race = Race.Human;
				} else if (rng < 68) {
					race = Race.Halfling;
				} else if (rng < 75) {
					race = Race.Gnome;
				} else if (rng < 95) {
					race = Race.Elf;
				} else if (rng < 97) {
					race = Race.Half_Elf;
				} else if (rng < 99) {
					race = Race.Half_Orc;
				} else {
					race = Race.Dwarf;
				}
				break;
			case Baron:
			case Compte:
				if (rng < 45) {
					race = Race.Human;
				} else if (rng < 95) {
					race = Race.Elf;
				} else {
					Integer rng2 = random.nextInt(6);
					if (rng2 == 0) {
						race = Race.Orc;
					} else if (rng2 == 1) {
						race = Race.Halfling;
					} else if (rng2 == 2) {
						race = Race.Gnome;
					} else if (rng2 == 3) {
						race = Race.Half_Elf;
					} else if (rng2 == 4) {
						race = Race.Half_Orc;
					} else if (rng2 == 5) {
						race = Race.Dwarf;
					}
				}
				break;
		}
	}

	private void addMetier() {
		Integer rng1 = random.nextInt(100);
		if (rng1 < 5) {
			metier = Metier.Esclave;
		} else if (rng1 < 55) {
			Integer rng2 = random.nextInt(4);
			if (rng2 == 0) {
				metier = Metier.Mendiant;
			} else if (rng2 == 1) {
				metier = Metier.Paysan;
			} else if (rng2 == 2) {
				metier = Metier.Serviteur;
			} else if (rng2 == 3) {
				metier = Metier.Apprenti;
			}
		} else if (rng1 < 85) {
			Integer rng2 = random.nextInt(3);
			if (rng2 == 0) {
				metier = Metier.Commercant;
			} else if (rng2 == 1) {
				metier = Metier.Artisant;
			} else if (rng2 == 2) {
				metier = Metier.Petit_Proprietaire;
			}
		} else if (rng1 < 90) {
			Integer rng2 = random.nextInt(3);
			if (rng2 == 0) {
				metier = Metier.Bourgmestre;
			} else if (rng2 == 1) {
				metier = Metier.Gros_Commercant;
			} else if (rng2 == 2) {
				metier = Metier.Gros_Proprietaire;
			}
		} else if (rng1 < 96) {
			metier = Metier.Pretre;
		} else if (rng1 < 97) {
			metier = Metier.Eveque;
		} else if (rng1 < 99) {
			if (random.nextBoolean()) {
				metier = Metier.Chevalier;
			} else {
				metier = Metier.Banneret;
			}
		} else {
			if (random.nextBoolean()) {
				metier = Metier.Baron;
			} else {
				metier = Metier.Compte;
			}
		}
	}
}
