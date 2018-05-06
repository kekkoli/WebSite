/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unica.fpw;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author kekko
 */
public class NewsFactory {
    
     
    private static NewsFactory instance;
    private ArrayList<News> listNews = new ArrayList<>();
    
    
    
    private NewsFactory()   {
        UserFactory userFactory = UserFactory.getInstance();

        News news1 = new News();
        news1.setId(0);
        news1.setCategory("Prove");
        news1.setDescrizione("Molto belloMolto");
        news1.setUrlImagine("img/dovizioso.jpeg");
        news1.setTitle("BEllo");
        news1.setDate(LocalDate.of(2000,10,3));
        news1.setUser(userFactory.getUserById(0));
        news1.setTesto("Abbandonati nel tronco cavo di un albero. E' questo il "
                + "terribile destino a cui è andata incontro una cucciolata di "
                + "gatti «indesiderata», lasciata a morire di fame e freddo, a "
                + "poche ore dalla nascita, vicino ad un centro commerciale di "
                + "Kansas City.");
        
        
        
        News news2 = new News();
        news2.setId(1);
        news2.setCategory("Piloti");
        news2.setDescrizione("crosticinocrosticinocrosticinocrosticino");
        news2.setUrlImagine("img/dovizioso.jpeg");
        news2.setTitle("crosta");
        news2.setDate(LocalDate.of(2018,11,30));    
        news2.setUser(userFactory.getUserById(1));
        news2.setTesto("Nessuno pensava sarebbe sopravvissuta. E invece questa"
                + " gattina randagia trovata tutta sola a West Covina"
                + ", in California, dopo essere stata abbandonata dalla madre, "
                + "ha sorpreso tutti. ");
        
        News news3 = new News();
        news3.setId(2);
        news3.setCategory("Piloti");
        news3.setDescrizione("grattastinchiksjefhkshfziszhfsofzmsoa");
        news3.setUrlImagine("img/dovizioso.jpeg");
        news3.setTitle("gatto");
        news3.setDate(LocalDate.of(1904,10,6));
        news3.setUser(userFactory.getUserById(2));
        news3.setTesto("Nel segno della Honda, ma non quella che ti aspetti: in "
                + "pole a Jerez, sede del GP di Spagna, c'è infatti Crutchlow "
                + "che fa esultare ancora una volta il suo team manager Lucio"
                + " Cecchinello. L'inglese del team Lcr firma l'1'37\"653 con "
                + "cui mette tutti in riga in qualifica, precedendo Dani Pedrosa,"
                + " 2° a +0\"259, e la Yamaha di Zarco: il francese , l'unico che"
                + " è riuscito a fara andare forte la M1, che però è quella del team Tech3.");
        
        News news4 = new News();
        news4.setId(4);
        news4.setCategory("Prove");
        news4.setDescrizione("Molto belloMolto belloMolto belloMolto belloMolto bello");
        news4.setUrlImagine("img/dovizioso.jpeg");
        news4.setTitle("BEllo");
        news4.setDate(LocalDate.of(2000,10,15));
        news4.setUser(userFactory.getUserById(0));
        news4.setTesto("Nelle Libere4, che non concorrono all'accesso alla "
                + "qualifica, brillante prestazione della Suzuki, che conferma"
                + " il buon feeling con questa pista e che piazza le sue due moto"
                + " davanti a tutti. Miglior tempo per Andrea Iannone in 1'38\"444,"
                + " con Rins staccato di 0\"376 e Marquez terzo a 0\"392. Poi 4° Crutchlow,"
                + " 5° Pedrosa, 6° Dovizioso, 7° Rabat, 8° Petrucci, "
                + "9° Viñales e 10° Pol Espargaro. solo 14° Rossi,"
                + " in grossa difficoltà. ");
        
        
        listNews.add(news1);
        listNews.add(news2);
        listNews.add(news3);
        listNews.add(news4);
}
    
    public static NewsFactory getInstance()
    {
        if (instance == null)
            instance = new NewsFactory();
        
        return instance;
    }
     public ArrayList<News> getNews(){
         Collections.sort(listNews);
         return listNews;
    }
     
    public News getNewsById(int id){
        for(News news : listNews){
            if(news.getId() == id)
                return news;
        }
        return null;
    }
    public ArrayList<News> getNewsByCategory(String category){
        ArrayList<News> listNewsCategory = new ArrayList<>();
        for(News news : listNews)
            if(news.getCategory().equals(category))
                listNewsCategory.add(news);
        Collections.sort(listNewsCategory);
        return listNewsCategory;
    }
    
    public ArrayList<News> getNewsByUser(User user){
        ArrayList<News> listNewsByUser = new ArrayList<>();
        for(News news : listNews)
            if(news.getUser().getId() == user.getId())
                listNewsByUser.add(news);
        return listNewsByUser;
    }
}
     
     

