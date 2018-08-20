package generator;

public enum Target {
	CONJOINT("conjoint", "son", "sa", "", "e", 1,
			new Charge[]{Charge.MESSIANISME, Charge.DEZIANISME, Charge.JURIANISTE, Charge.MORT, Charge.SORCELLERIE, Charge.HERESIE, Charge.ESCLAVAGE, Charge.CHARLATANISME, Charge.COMPLOT},
			new Reason[]{Reason.Relation, Reason.Visuel, Reason.Auditif, Reason.Pocession, Reason.Comportement}),
	VOISIN("voisin", "son", "sa", "", "e", 1,
			new Charge[]{Charge.MESSIANISME, Charge.DEZIANISME, Charge.JURIANISTE, Charge.MORT, Charge.SORCELLERIE, Charge.HERESIE, Charge.ESCLAVAGE, Charge.CHARLATANISME, Charge.COMPLOT},
			new Reason[]{Reason.Relation, Reason.Visuel, Reason.Auditif, Reason.Pocession, Reason.Comportement}),
	CONNAISSANCE("connaissance", "une", "une", "", "", 1,
			new Charge[]{Charge.MESSIANISME, Charge.DEZIANISME, Charge.JURIANISTE, Charge.MORT, Charge.SORCELLERIE, Charge.HERESIE, Charge.ESCLAVAGE, Charge.CHARLATANISME, Charge.COMPLOT},
			new Reason[]{Reason.Relation, Reason.Visuel, Reason.Auditif, Reason.Pocession, Reason.Comportement}),
	CONCURRENCE("concurrent", "un", "une", "", "e", 1,
			new Charge[]{Charge.MESSIANISME, Charge.DEZIANISME, Charge.JURIANISTE, Charge.MORT, Charge.SORCELLERIE, Charge.HERESIE, Charge.ESCLAVAGE, Charge.CHARLATANISME, Charge.COMPLOT},
					new Reason[]{Reason.Relation, Reason.Visuel, Reason.Auditif, Reason.Pocession, Reason.Comportement}),
	FAMILLE("un membre de sa famille", "", "", "", "", 1,
			new Charge[]{Charge.MESSIANISME, Charge.DEZIANISME, Charge.JURIANISTE, Charge.MORT, Charge.SORCELLERIE, Charge.HERESIE, Charge.ESCLAVAGE, Charge.CHARLATANISME, Charge.COMPLOT},
			new Reason[]{Reason.Relation, Reason.Visuel, Reason.Auditif, Reason.Pocession, Reason.Comportement}),
	ETRANGER("étrang", "un", "une", "er", "ère", 1,
			new Charge[]{Charge.MESSIANISME, Charge.DEZIANISME, Charge.JURIANISTE, Charge.MORT, Charge.SORCELLERIE, Charge.HERESIE, Charge.ESCLAVAGE, Charge.CHARLATANISME, Charge.COMPLOT},
			new Reason[]{Reason.Relation, Reason.Visuel, Reason.Auditif, Reason.Pocession, Reason.Comportement}),
	PHENOMENE("phenoméne", "un", "un", "", "", 1,
			new Charge[]{Charge.MESSIANISME, Charge.DEZIANISME, Charge.JURIANISTE, Charge.MORT, Charge.SORCELLERIE, Charge.HERESIE},
			new Reason[]{Reason.Visuel, Reason.Auditif, Reason.Comportement}),
	ANIMALE("animale", "un", "un", "", "", 1,
			new Charge[]{Charge.MESSIANISME, Charge.DEZIANISME, Charge.JURIANISTE, Charge.MORT, Charge.SORCELLERIE, Charge.HERESIE},
			new Reason[]{Reason.Visuel, Reason.Auditif, Reason.Pocession, Reason.Comportement}),
	LIEU("lieu", "un", "un", "", "", 1,
			new Charge[]{Charge.MESSIANISME, Charge.DEZIANISME, Charge.JURIANISTE, Charge.MORT, Charge.SORCELLERIE, Charge.HERESIE},
			new Reason[]{Reason.Relation, Reason.Visuel, Reason.Auditif, Reason.Pocession}),
	GROUPE("groupe", "un", "un", "", "", 1,
			new Charge[]{Charge.MESSIANISME, Charge.DEZIANISME, Charge.JURIANISTE, Charge.MORT, Charge.SORCELLERIE, Charge.HERESIE, Charge.ESCLAVAGE, Charge.CHARLATANISME, Charge.COMPLOT},
			new Reason[]{Reason.Relation, Reason.Visuel, Reason.Auditif, Reason.Pocession, Reason.Comportement});

	private String name;
	private String prefixM;
	private String prefixF;
	private String masculin;
	private String feminin;
	private Integer proba;
	private Charge[] charges;
	private Reason[] reasons;

	Target(String name, String prefixM, String prefixF, String masculin, String feminin, Integer proba, Charge[] charges, Reason[] reasons) {
		this.name = name;
		this.prefixM = prefixM;
		this.prefixF = prefixF;
		this.masculin = masculin;
		this.feminin = feminin;
		this.proba = proba;
		this.charges = charges;
		this.reasons = reasons;
	}

	public String getName(boolean isFemale) {
		return String.format("%s %s%s", isFemale?prefixF:prefixM, name, isFemale?feminin:masculin);
	}

	public Integer getProba() {
		return proba;
	}

	public Charge[] getCharges() {
		return charges;
	}

	public Reason[] getReasons() {
		return reasons;
	}
}
