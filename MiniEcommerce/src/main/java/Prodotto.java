public class Prodotto {

    //attributi

    private String idUnivoco,nome,descrizione;
    private int quantita;
    private double prezzo;

    //Costruttore

    public Prodotto(String idUnivoco, String nome, String descrizione, int quantita, double prezzo) {
        this.idUnivoco = idUnivoco;
        this.nome = nome;
        this.descrizione = descrizione;
        this.quantita = quantita;
        this.prezzo = prezzo;
    }

    //Getter e Setter

    public String getIdUnivoco() {
        return idUnivoco;
    }

    public void setIdUnivoco(String idUnivoco) {
        this.idUnivoco = idUnivoco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita += quantita;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }


    @Override
    public String toString() {
        return "Prodotto{" +
                "idUnivoco='" + idUnivoco + '\'' +
                ", nome='" + nome + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", quantita=" + quantita +
                ", prezzo=" + prezzo +
                '}'+ "\n";
    }
}
