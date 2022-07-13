import com.google.gson.Gson;

import static spark.Spark.*;

public class main {
    public static void main(String[] args) {
        WebService web = new WebService();
        Gson gson = new Gson();

        System.out.println(web.getProdotto());
        post("/add", (req, res) -> {
            Prodotto prodotto = gson.fromJson(req.body(), Prodotto.class);

            for (int i = 0; i < web.getProdotto().size(); i++)
            {
                if(web.getProdotto().get(i).getIdUnivoco().equals(prodotto.getIdUnivoco()))
                {
                    res.status(400);
                    return "è già presente";
                }
            }
            web.getProdotto().add(prodotto);
            System.out.println(prodotto);
            res.status(200);
            return "ok";
        });
        get("/print", (req, res) -> web.getProdotto());
        delete("/remove", (req, res) -> {
            System.out.println(web.getProdotto());
            Prodotto prodotto = gson.fromJson(req.body(), Prodotto.class);
            for (int i = 0; i < web.getProdotto().size(); i++)
            {
                if(web.getProdotto().get(i).getIdUnivoco().equals(prodotto.getIdUnivoco()))
                {
                    web.rimuoviProdottoById(prodotto.getIdUnivoco());
                    res.status(200);
                    return "rimosso";
                }
            }
            res.status(400);
            return "non è presente";
        });
        put("/sell", (req, res) -> {
            System.out.println(web.getProdotto());
            Prodotto prodotto = gson.fromJson(req.body(), Prodotto.class);
            System.out.println(req.body());
            for (int i = 0; i < web.getProdotto().size(); i++)
            {
                if(web.getProdotto().get(i).getIdUnivoco().equals(prodotto.getIdUnivoco()))
                {
                    web.buyProdotto(prodotto.getIdUnivoco(), prodotto.getQuantita());
                    res.status(200);
                    return "venduto";
                }
            }
            res.status(400);
            return "non è disponibile";
        });

    }
}
