package generator;

public enum Charge {
	MESSIANISME("de messianisme", 1),
	JURIANISTE("de jurianiste", 1),
	MORT("de mort", 1),
	SORCELLERIE("de sorcellerie", 1),
	HERESIE("de simple hérésie", 1),
	ESCLAVAGE("d'esclavagisme illégale", 1),
	CHARLATANISME("de charlatanisme", 1),
	COMPLOT("de complot", 1);

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
