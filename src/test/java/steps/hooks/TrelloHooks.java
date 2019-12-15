package steps.hooks;

import io.cucumber.java.Before;
import utils.TrelloRequests;

public class TrelloHooks {

    public static TrelloRequests trello;

    @Before
    public void abc(){
         trello=new TrelloRequests();
    }

}
