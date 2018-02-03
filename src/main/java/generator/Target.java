package generator;

public enum Target {
	CONJOINT("conjoint", "son", "sa", "e", 1, new Charge[]{Charge.MESSIANISME, Charge.JURIANISTE, Charge.MORT, Charge.SORCELLERIE, Charge.HERESIE, Charge.ESCLAVAGE, Charge.CHARLATANISME, Charge.COMPLOT}),
	VOISIN("voisin", "son", "sa", "e", 1, new Charge[]{Charge.MESSIANISME, Charge.JURIANISTE, Charge.MORT, Charge.SORCELLERIE, Charge.HERESIE, Charge.ESCLAVAGE, Charge.CHARLATANISME, Charge.COMPLOT}),
	CONNAISSANCE("connaissance", "une", "une", "", 1, new Charge[]{Charge.MESSIANISME, Charge.JURIANISTE, Charge.MORT, Charge.SORCELLERIE, Charge.HERESIE, Charge.ESCLAVAGE, Charge.CHARLATANISME, Charge.COMPLOT}),
	CONCURRENCE("concurrent", "un", "une", "e", 1, new Charge[]{Charge.MESSIANISME, Charge.JURIANISTE, Charge.MORT, Charge.SORCELLERIE, Charge.HERESIE, Charge.ESCLAVAGE, Charge.CHARLATANISME, Charge.COMPLOT}),
	FAMILLE("un memebre de sa famille", "", "", "", 1, new Charge[]{Charge.MESSIANISME, Charge.JURIANISTE, Charge.MORT, Charge.SORCELLERIE, Charge.HERESIE, Charge.ESCLAVAGE, Charge.CHARLATANISME, Charge.COMPLOT}),
	ETRANGER("étranger", "un", "une", "e", 1, new Charge[]{Charge.MESSIANISME, Charge.JURIANISTE, Charge.MORT, Charge.SORCELLERIE, Charge.HERESIE, Charge.ESCLAVAGE, Charge.CHARLATANISME, Charge.COMPLOT}),
	PHENOMENE("phenomene", "un", "un", "", 1, new Charge[]{Charge.MESSIANISME, Charge.JURIANISTE, Charge.MORT, Charge.SORCELLERIE, Charge.HERESIE}),
	ANIMALE("animale", "un", "un", "", 1, new Charge[]{Charge.MESSIANISME, Charge.JURIANISTE, Charge.MORT, Charge.SORCELLERIE, Charge.HERESIE}),
	LIEU("lieu", "un", "un", "", 1, new Charge[]{Charge.MESSIANISME, Charge.JURIANISTE, Charge.MORT, Charge.SORCELLERIE, Charge.HERESIE}),
	GROUPE("groupe", "un", "un", "", 1, new Charge[]{Charge.MESSIANISME, Charge.JURIANISTE, Charge.MORT, Charge.SORCELLERIE, Charge.HERESIE, Charge.ESCLAVAGE, Charge.CHARLATANISME, Charge.COMPLOT});

	private String name;
	private String prefixM;
	private String prefixF;
	private String feminin;
	private Integer proba;
	private Charge[] charges;

	Target(String name, String prefixM, String prefixF, String feminin, Integer proba, Charge[] charges) {
		this.name = name;
		this.prefixM = prefixM;
		this.prefixF = prefixF;
		this.feminin = feminin;
		this.proba = proba;
		this.charges = charges;
	}

	public String getName(boolean isFemale) {
		return String.format("%s %s%s", isFemale?prefixF:prefixM, name, isFemale?feminin:"");
	}

	public Integer getProba() {
		return proba;
	}

	public Charge[] getCharges() {
		return charges;
	}
}
