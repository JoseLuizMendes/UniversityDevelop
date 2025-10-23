import java.util.ArrayList;

import Classes.Automovel;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList <Automovel> carro = new  ArrayList<>(); 
        
        cadastra(carro);
    }

    private static void cadastra(ArrayList<Automovel> carro) {
        //automovel 
        carro.add(new Automovel("Gol", "Branco", Automovel.GAS));
        carro.add(new Automovel("Celta", "Preto", Automovel.GASOLINA));
        //basico
        carro.add(new Classes.AutomovelBasico("Corsa", "Prata", Automovel.FLEX, true, true, true));
        carro.add(new Classes.AutomovelBasico("Palio", "Vermelho", Automovel.DIESEL, true, false, true));
        //luxo
        carro.add(new Classes.AutomovelLuxo("BMW", "Preto", Automovel.GASOLINA, true, true, true, true, true, true));
        carro.add(new Classes.AutomovelLuxo("Audi", "Branco", Automovel.FLEX, true, true, true, true, false, true));
    }
}
