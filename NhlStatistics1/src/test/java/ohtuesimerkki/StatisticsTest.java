package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
public class StatisticsTest {
    
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            List<Player> players = new ArrayList<Player>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }
    
    @Test
    public void playerIsFound() {
        assertEquals("EDM", stats.search("Semenko").getTeam());
    }
    
    @Test
    public void playerIsNotFound() {
        assertEquals(null, stats.search("Sofia"));
    }
    
    @Test
    public void teamIsFound() {
        assertEquals(3, stats.team("EDM").size());
    }
    
    @Test
    public void topScorersAreFound() {
        assertEquals(3, stats.topScorers(3).size());
    }
}
