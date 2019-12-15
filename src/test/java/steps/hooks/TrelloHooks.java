package steps.hooks;

import io.cucumber.java.Before;
import utils.TrelloUtils;

public class TrelloHooks {

    public static TrelloUtils trello;

    @Before
    public void abc(){
         trello=new TrelloUtils();
    }

}
