package generator;

public enum Reason {
    Relation("de relation étrange", 1),
    Visuel("d'élément vue", 1),
    Auditif("d'élément entendue", 1),
    Pocession("de possession louche", 1),
    Comportement("de comportement suspect", 1);

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
