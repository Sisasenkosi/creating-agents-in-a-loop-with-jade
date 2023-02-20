import jade.core.Agent;

public class TheAgent extends Agent
{
    @Override
    protected void setup()
    { System.out.println("I am agent " +getLocalName());

    }
}