package generator;

public enum Charge {
	MESSIANISME("de messianisme", 5),
	DEZIANISME("de dezianisMe", 1),
	JURIANISTE("de jurianiste", 5),
	MORT("de mort", 5),
	SORCELLERIE("de sorcellerie", 5),
	HERESIE("de simple hérésie", 5),
	ESCLAVAGE("d'esclavagisme illégale", 5),
	CHARLATANISME("de charlatanisme", 5),
	COMPLOT("de complot", 5);

	private String name;
	private Integer proba;

	Charge(String name, Integer proba) {
		this.name = name;
		this.proba = proba;
	}

	public String getName() {
		return name;
	}

	public Integer getProba() {
		return proba;
	}
}
