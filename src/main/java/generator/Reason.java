package generator;

public enum Reason {
    Relation("de relation �trange", 1),
    Visuel("d'�l�ment vue", 1),
    Auditif("d'�l�ment entendus", 1),
    Pocession("d'une possession louche", 1),
    Comportement("d'un comportement suspect", 1);

    String texte;
    Integer proba;

    Reason(String texte, Integer proba) {
        this.texte = texte;
        this.proba = proba;
    }

    public String getTexte() {
        return texte;
    }

    public Integer getProba() {
        return proba;
    }
}
