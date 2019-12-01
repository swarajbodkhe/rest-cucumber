package steps.hooks;

import io.cucumber.java.Before;
import utils.IEXRequests;

public class IEXHooks {

    private IEXRequests iex;

    @Before
    public void abc(){
        IEXRequests iex=new IEXRequests();
    }

}
