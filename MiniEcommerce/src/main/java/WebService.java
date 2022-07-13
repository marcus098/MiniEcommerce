import java.util.ArrayList;

public class WebService {

    //attributi
    private ArrayList<Prodotto> prodotto = new ArrayList<>();

    //getter e setter
    public ArrayList<Prodotto> getProdotto() {
        return prodotto;
    }

    public void setProdotto(ArrayList<Prodotto> prodotto) {
        this.prodotto = prodotto;
    }

    public void aggiungiProdotto(Prodotto prodotto) {
        if (this.prodotto.contains(prodotto)) {
            for (int i = 0; i < this.prodotto.size(); i++) {
                if (this.prodotto.get(i).equals(prodotto)){
                    this.prodotto.get(i).setQuantita(prodotto.getQuantita());
                }
            }
        }else
            this.prodotto.add(prodotto);
    }

    public void rimuoviProdottoById(String idProdotto) {
        for(int i = 0; i< this.prodotto.size(); i++)
        {
            if(this.prodotto.get(i).getIdUnivoco().equals(idProdotto))
            {
                this.prodotto.remove(this.prodotto.get(i));
                break;
            }
        }
    }

    public void buyProdotto(String idProdotto, int quantita)
    {
        for(int i = 0; i< this.prodotto.size(); i++)
        {
            if(this.prodotto.get(i).getIdUnivoco().equals(idProdotto))
            {
                if(this.prodotto.get(i).getQuantita() >= quantita)
                {
                    this.prodotto.get(i).setQuantita(-quantita);
                    if(this.prodotto.get(i).getQuantita() <= 0)
                    {
                        this.prodotto.remove(this.prodotto.get(i));
                    }
                    break;
                }

            }
        }
    }

    public ArrayList<Prodotto> listaProdotto() {
        return getProdotto();
    }


}
