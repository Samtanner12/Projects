import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyDeckOfCards implements DeckADT {
    ArrayList<String> cardDeck = new ArrayList<String>();

    public void initialize(){
        for(int i =1; i<14; i++){
            if(i==11){
                for(int j =0; j<4; j++){
                    if(j == 0){
                        cardDeck.add("J" + "S");
                    }
                    if(j == 1){
                        cardDeck.add("J" + "D");
                    }
                    if(j == 2){
                        cardDeck.add("J" + "C");
                    }
                    if(j == 3){
                        cardDeck.add("J"+ "H");
                    }
                }
            }
            else if(i==12){
                for(int j =0; j<4; j++){
                    if(j == 0){
                        cardDeck.add("Q" + "S");
                    }
                    if(j == 1){
                        cardDeck.add("Q"  + "D");
                    }
                    if(j == 2){
                        cardDeck.add("Q"  + "C");
                    }
                    if(j == 3){
                        cardDeck.add("Q"  + "H");
                    }
                }
            }
            else if(i==13){
                for(int j =0; j<4; j++){
                    if(j == 0){
                        cardDeck.add("K"  + "S");
                    }
                    if(j == 1){
                        cardDeck.add("K" + "D");
                    }
                    if(j == 2){
                        cardDeck.add("K" + "C");
                    }
                    if(j == 3){
                        cardDeck.add("K" + "H");
                    }
                }
            }
            else if(i==1){
                for(int j =0; j<4; j++){
                    if(j == 0){
                        cardDeck.add("A"+ "S");
                    }
                    if(j == 1){
                        cardDeck.add("A" + "D");
                    }
                    if(j == 2){
                        cardDeck.add("A" + "C");
                    }
                    if(j == 3){
                        cardDeck.add("A" + "H");
                    }
                }
            }
            else{
                for(int j =0; j<4; j++){
                    if(j == 0){
                        cardDeck.add(i + "S");
                    }
                    if(j == 1){
                        cardDeck.add(i + "D");
                    }
                    if(j == 2){
                        cardDeck.add(i + "C");
                    }
                    if(j == 3){
                        cardDeck.add(i + "H");
                    }
                }
            }

        }
    }
    public ArrayList<String> deckReturn(){
        return cardDeck;
    }
    public String drawRandomCard(){
        Random cardRand = new Random();
        int randy = cardRand.nextInt(52);
        return cardDeck.get(randy);

    }
    public String drawTopCardFromDeck()
    {
        return cardDeck.get(0);

    }

    @Override
    public void pushCardOnTopOfDeck() {

    }


    public void pushCardOnTopOfDeck(int place) {
        String card = cardDeck.get(place);
        for(int i = place-1; i>=0;i--){
            String card2 =cardDeck.get(i);
            cardDeck.set(i+1, card2);

        }
        cardDeck.set(0,card);
    }


    public static void main(String[] args){
        MyDeckOfCards deck1 = new MyDeckOfCards();
        deck1.initialize();
        System.out.println(deck1.deckReturn());
        System.out.println(deck1.drawRandomCard());
        System.out.println(deck1.drawTopCardFromDeck());
        System.out.println(deck1.deckReturn());
        deck1.pushCardOnTopOfDeck(17);
        System.out.println(deck1.deckReturn());




    }
}
