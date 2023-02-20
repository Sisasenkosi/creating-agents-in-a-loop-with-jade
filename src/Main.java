//program of creating agents in a loop with arguments set up in the lines of code

import jade.core.Agent;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.ContainerController;
import jade.wrapper.StaleProxyException;
import jade.wrapper.AgentController;
import java.util.Scanner;


public class Main extends Agent
{
    protected void setup() {
        System.out.println("I am an Agent  "+getLocalName());
    }

    public static void main(String[] args) {
        //Runtime structure so that it knows how to execute our code provided by jade
        Runtime rt=Runtime.instance();

        //profile class so that we can pass arguments, its abstract, so we call its child
        Profile p=new ProfileImpl();
        Profile p2 =new ProfileImpl();

        //main container has address of local host
        p.setParameter(Profile.MAIN_HOST , "localhost");
        p.setParameter(Profile.GUI, "true");
        ContainerController cc=rt.createMainContainer(p);
        ContainerController c2=rt.createAgentContainer(p2);

        Scanner enterUser = new Scanner(System.in);
        System.out.println("Enter a number of agents :");
        int n = enterUser.nextInt();

        for(int i=1; i<=n; i++)
        {
            AgentController ac;
            try {
                ac = c2.createNewAgent(" "+i, "TheAgent", null);

                ac.start();
            }
            catch(StaleProxyException e) {
                e.printStackTrace();
            }


        }
    }}


